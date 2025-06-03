package com.employeeManagmentSystem.business.serviceImpl;

import com.employeeManagmentSystem.api.dto.UserDto;
import com.employeeManagmentSystem.business.service.UserService;
import com.employeeManagmentSystem.persistance.entity.User;
import com.employeeManagmentSystem.persistance.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User registerUser(UserDto userDto) {

            User user = User.builder()
                    .username(userDto.getUsername())
                    .password(userDto.getPassword())
                    .role(userDto.getRole())
                    .build();
            return userRepository.save(user);
        }
    }

