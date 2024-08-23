package com.restapi.emp.dto.mapper;

import com.restapi.emp.dto.UserDto;
import com.restapi.emp.entity.User;

public class UserMapper {

    public static UserDto mapToUserDto(User user){
        return new UserDto(
                user.getId(),
                user.getUserId(),
                user.getUserName(),
                user.getEmail(),
                user.getPassword(),
                user.getProfileImage()
        );
    }

    public static User mapToUser(UserDto userDto){
        return new User(
                userDto.getId(),
                userDto.getUserId(),
                userDto.getUserName(),
                userDto.getEmail(),
                userDto.getPassword(),
                userDto.getProfileImage()
        );
    }
}