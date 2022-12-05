package com.revature.erts.utils;

import io.jsonwebtoken.SignatureAlgorithm;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.io.FileReader;
import java.io.IOException;
import java.security.Key;
import java.util.Properties;

public class JwtConfig {
    private final int expiration = 60 * 60 * 1000; // (1 hour = 60 min * 60 sec * 1000 milliseconds)
    private final SignatureAlgorithm sigAlg = SignatureAlgorithm.HS256;

    private final Key signingKey;
    private final Properties properties = new Properties();

    public JwtConfig() {
        try {
            properties.load(new FileReader("src/main/resources/db.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        byte[] saltyBytes = DatatypeConverter.parseBase64Binary(properties.getProperty("salt"));
        signingKey = new SecretKeySpec(saltyBytes, sigAlg.getJcaName());
    }

    public int getExpiration() {
        return this.expiration;
    }

    public SignatureAlgorithm getSigAlg() {
        return this.sigAlg;
    }

    public Key getSigningKey() {
        return signingKey;
    }
}