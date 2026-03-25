package com.example.vaccinationsystem.util;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * Minimal .env loader:
 * - reads key=value lines
 * - ignores empty lines and lines starting with '#'
 * - writes to System properties so Spring placeholders can resolve.
 */
public final class DotenvLoader {
    private DotenvLoader() {
    }

    public static void loadIfPresent() {
        Path cwdEnv = Path.of(System.getProperty("user.dir"), ".env");
        Path rootEnv = Path.of(".env");

        Path envPath = Files.exists(cwdEnv) ? cwdEnv : rootEnv;
        if (!Files.exists(envPath)) {
            return;
        }

        try {
            List<String> lines = Files.readAllLines(envPath, StandardCharsets.UTF_8);
            for (String line : lines) {
                if (line == null) continue;
                String trimmed = line.trim();
                if (trimmed.isEmpty()) continue;
                if (trimmed.startsWith("#")) continue;

                int idx = trimmed.indexOf('=');
                if (idx <= 0) continue;

                String key = trimmed.substring(0, idx).trim();
                String value = trimmed.substring(idx + 1).trim();

                // remove optional surrounding quotes
                if ((value.startsWith("\"") && value.endsWith("\"")) || (value.startsWith("'") && value.endsWith("'"))) {
                    value = value.substring(1, value.length() - 1);
                }

                if (!key.isEmpty()) {
                    System.setProperty(key, value);
                }
            }
        } catch (IOException ignored) {
            // If .env can't be read, just continue with defaults/placeholders.
        }
    }
}

