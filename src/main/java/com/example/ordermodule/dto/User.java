package com.example.ordermodule.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private long userid;
    private String firstname;
    private String lastname;
    private String address;
    private String email;
    private String password;
}
