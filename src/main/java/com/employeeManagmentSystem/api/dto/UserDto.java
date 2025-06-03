package com.employeeManagmentSystem.api.dto;

import com.employeeManagmentSystem.persistance.Role;
import lombok.Data;

@Data
public class UserDto {
    private String username;
    private String password;
    private Role role;
}
