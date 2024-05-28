package com.pigier.gestionStage.security;

public class JWTUtil {
    public static final String prefix = "Bearer ";
    public static final String header = "Authorization";
    public static final Integer expiresIn = 100*60*1000;
    public static final String secret = "delta Developer165";
    public static final Integer expireInRefreshToken = 10*60*1000;
}
