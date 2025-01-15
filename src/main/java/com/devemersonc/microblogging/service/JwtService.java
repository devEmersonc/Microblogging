package com.devemersonc.microblogging.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class JwtService {
    @Value("${JWT_SECRET_KEY}")
    private String SECRET_KEY;
}
