package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class OutputMessage {
    private String from;
    private String text;
    private String time;
}
