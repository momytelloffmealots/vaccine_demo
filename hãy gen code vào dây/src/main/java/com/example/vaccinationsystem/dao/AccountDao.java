package com.example.vaccinationsystem.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class AccountDao {
    private final JdbcTemplate jdbcTemplate;

    public AccountDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static final RowMapper<AccountRow> ACCOUNT_ROW_MAPPER = (rs, rowNum) -> {
        AccountRow row = new AccountRow();
        row.accountId = rs.getString("ACCOUNT_ID");
        row.authority = rs.getString("AUTHORITY");
        row.username = rs.getString("USERNAME");
        row.password = rs.getString("PASSWORD");
        row.email = rs.getString("EMAIL");
        return row;
    };

    public Optional<AccountRow> findByUsername(String username) {
        String sql = """
                SELECT ACCOUNT_ID, AUTHORITY, USERNAME, PASSWORD, EMAIL
                FROM ACCOUNT
                WHERE USERNAME = ?
                """;
        List<AccountRow> rows = jdbcTemplate.query(sql, ACCOUNT_ROW_MAPPER, username);
        if (rows.isEmpty()) return Optional.empty();
        return Optional.of(rows.get(0));
    }

    public Optional<String> findDoctorIdByAccountId(String accountId) {
        String sql = "SELECT DOCTOR_ID FROM DOCTOR WHERE ACCOUNT_ID = ?";
        List<String> rows = jdbcTemplate.query(sql, (rs, rowNum) -> rs.getString(1), accountId);
        return rows.isEmpty() ? Optional.empty() : Optional.of(rows.get(0));
    }

    public Optional<String> findCashierIdByAccountId(String accountId) {
        String sql = "SELECT CASHIER_ID FROM CASHIER WHERE ACCOUNT_ID = ?";
        List<String> rows = jdbcTemplate.query(sql, (rs, rowNum) -> rs.getString(1), accountId);
        return rows.isEmpty() ? Optional.empty() : Optional.of(rows.get(0));
    }

    public Optional<String> findInventoryManagerIdByAccountId(String accountId) {
        String sql = "SELECT INVENTORY_MANAGER_ID FROM INVENTORY_MANAGER WHERE ACCOUNT_ID = ?";
        List<String> rows = jdbcTemplate.query(sql, (rs, rowNum) -> rs.getString(1), accountId);
        return rows.isEmpty() ? Optional.empty() : Optional.of(rows.get(0));
    }

    public Optional<String> findAdministratorIdByAccountId(String accountId) {
        String sql = "SELECT ADMINISTRATOR_ID FROM ADMINISTRATOR WHERE ACCOUNT_ID = ?";
        List<String> rows = jdbcTemplate.query(sql, (rs, rowNum) -> rs.getString(1), accountId);
        return rows.isEmpty() ? Optional.empty() : Optional.of(rows.get(0));
    }

    public static class AccountRow {
        private String accountId;
        private String authority;
        private String username;
        private String password;
        private String email;

        public String getAccountId() {
            return accountId;
        }

        public String getAuthority() {
            return authority;
        }

        public String getUsername() {
            return username;
        }

        public String getPassword() {
            return password;
        }

        public String getEmail() {
            return email;
        }
    }
}

