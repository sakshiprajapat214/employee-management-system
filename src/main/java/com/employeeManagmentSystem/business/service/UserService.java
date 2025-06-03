package com.employeeManagmentSystem.business.service;

import com.employeeManagmentSystem.api.dto.UserDto;
import com.employeeManagmentSystem.persistance.entity.User;

public interface UserService {
    User registerUser(UserDto userDto);
}
