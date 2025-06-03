package com.employeeManagmentSystem.api.request;

import com.employeeManagmentSystem.persistance.Role;
import lombok.Data;

@Data
public class RegistrationRequest {
    private String username;
    private String password;
    private Role role;
}
