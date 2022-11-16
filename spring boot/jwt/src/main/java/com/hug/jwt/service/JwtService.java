package com.hug.jwt.service;

import com.nimbusds.jose.JWSSigner;
import com.nimbusds.jose.crypto.MACSigner;
import org.springframework.stereotype.Service;

@Service
public class JwtService {
    public static final String USERNAME = "username";
    public static final String SECRET_KEY = "11111111111111111111111111111111";
    public static final int EXPIRE_TIME = 86400000;

    //ok
    public String generateTokenLogin(String username){
        String token=null;
        try {
            JWSSigner signer = new MACSigner(generateShareSecret());
        } catch (Exception e) {
            e.printStackTrace();;
        }
        return token;
    }
    private byte[] generateShareSecret(){
        // Generate 256-bit (32-byte) shared secret
        byte[] sharedSecret = new byte[32];
        sharedSecret = SECRET_KEY.getBytes();
        return sharedSecret;

    }
}
