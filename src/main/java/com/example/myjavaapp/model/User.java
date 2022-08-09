package com.example.myjavaapp.model;

import com.example.myjavaapp.model.dto.UserDto;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "app_user")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    public UserDto toDto() {
        return UserDto.builder()
                .id(id)
                .name(name)
                .build();
    }

}
