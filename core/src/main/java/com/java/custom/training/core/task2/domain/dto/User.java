package com.java.custom.training.core.task2.domain.dto;


import lombok.Data;

import java.util.List;

@Data
public class User {

    private int id;
    private String name;
    private int age;
    private List<Account> accounts;

}
