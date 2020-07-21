package com.example.fjob.security;

public class SecurityConstants {
    public static final String SECRET = "FjobKeyNTN21062020";
    public static final long EXPIRATION_TIME = 864_000_000; // 10 days
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String SIGN_UP_URL = "/fjob/v1/user/sign-up";
    public static final String GET_SKILL_URL = "/fjob/v1/skill";
}
