package com.example.SpringSecurity.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
public class User
{
    @Id
    private String userName;
    private String userPassword;
    private String userRole;
}
