package com.example.vaccinationsystem.service;

import com.example.vaccinationsystem.dao.AccountDao;
import com.example.vaccinationsystem.dto.LoginRequest;
import com.example.vaccinationsystem.dto.LoginResponse;
import com.example.vaccinationsystem.util.PasswordUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final AccountDao accountDao;
    private final boolean hashEnabled;

    public AuthService(AccountDao accountDao, @Value("${app.password.hash-enabled:true}") boolean hashEnabled) {
        this.accountDao = accountDao;
        this.hashEnabled = hashEnabled;
    }

    public LoginResponse login(LoginRequest req) {
        LoginResponse res = new LoginResponse();
        var accountOpt = accountDao.findByUsername(req.getUsername());
        if (accountOpt.isEmpty()) {
            res.setSuccess(false);
            res.setMessage("Invalid username or password");
            return res;
        }

        var account = accountOpt.get();
        String storedPassword = account.getPassword();
        String inputPassword = req.getPassword();
        String candidate = hashEnabled ? PasswordUtil.hashPass(inputPassword) : inputPassword;
        boolean ok = storedPassword != null && storedPassword.equals(candidate);

        if (!ok) {
            res.setSuccess(false);
            res.setMessage("Invalid username or password");
            return res;
        }

        res.setSuccess(true);
        res.setMessage("Login success");
        res.setAccountId(account.getAccountId());
        res.setUsername(account.getUsername());
        res.setAuthority(account.getAuthority());
        res.setEmail(account.getEmail());

        res.setDoctorId(accountDao.findDoctorIdByAccountId(account.getAccountId()).orElse(null));
        res.setCashierId(accountDao.findCashierIdByAccountId(account.getAccountId()).orElse(null));
        res.setInventoryManagerId(accountDao.findInventoryManagerIdByAccountId(account.getAccountId()).orElse(null));
        res.setAdministratorId(accountDao.findAdministratorIdByAccountId(account.getAccountId()).orElse(null));
        return res;
    }
}

