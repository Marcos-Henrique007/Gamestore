package com.GameStore.Model;

import lombok.Data;

@Data
public class User {
    private Integer id;
    private String name;
    private String email;
    private String password;
    private String phone;
    private String address;
    private String cpf;
}