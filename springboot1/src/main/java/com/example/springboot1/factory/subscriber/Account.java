package com.example.springboot1.factory.subscriber;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class Account {
    private String name;
    private double amount;
    private Date date;

    public String getMessage() {
        StringBuilder sb = new StringBuilder();
        sb.append("账户：").append(this.name).append(", ");
        sb.append("金额：").append(amount).append(", ");
        sb.append("日期：").append(date);
        return sb.toString();
    }

}
