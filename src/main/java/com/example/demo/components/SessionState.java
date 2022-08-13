package com.example.demo.components;

import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledExecutorService;

@Component
@Getter
public class SessionState {
    private Map<String, ScheduledExecutorService> statusMap = new ConcurrentHashMap<>();
}
