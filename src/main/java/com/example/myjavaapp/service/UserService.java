package com.example.myjavaapp.service;

import com.example.myjavaapp.model.dto.UserDto;

import java.util.List;

public interface UserService {

    List<UserDto> findAll();

    UserDto saveUser(UserDto userDto);
}
