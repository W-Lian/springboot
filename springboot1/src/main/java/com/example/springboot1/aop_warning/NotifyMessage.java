package com.example.springboot1.aop_warning;

import lombok.Data;

@Data
public class NotifyMessage {
    
    private MessageTye messageTye;
    
    private String message;
    
    private String title;
}
