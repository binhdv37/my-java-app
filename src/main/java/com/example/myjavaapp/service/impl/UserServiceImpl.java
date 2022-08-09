package com.example.myjavaapp.service.impl;

import com.example.myjavaapp.model.User;
import com.example.myjavaapp.model.dto.UserDto;
import com.example.myjavaapp.repository.UserRepository;
import com.example.myjavaapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserDto> findAll() {
        return userRepository.findAll().stream().map(User::toDto).collect(Collectors.toList());
    }

    @Override
    public UserDto saveUser(UserDto userDto) {
        boolean isCreate = userDto.getId() == null;
        if (isCreate) {
            User user = new User();
            user.setId(userDto.getId());
            user.setName(userDto.getName());
            User saved = userRepository.save(user);
            return saved.toDto();
        } else {
            User user = userRepository.findById(userDto.getId()).orElse(null);
            if (user == null) {
                throw new RuntimeException("Can not find user with id : " + userDto.getId());
            }
            user.setName(userDto.getName());
            User saved = userRepository.save(user);
            return saved.toDto();
        }
    }

}
