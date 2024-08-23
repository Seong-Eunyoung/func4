package com.restapi.emp.service;

import com.restapi.emp.dto.FollowDto;
import com.restapi.emp.dto.PhotoDto;
import com.restapi.emp.dto.UserDto;

import java.util.List;

public interface UserService {

    UserDto getUserById(Long id);

    List<FollowDto> getFollower(Long userid);

    List<FollowDto> getFollowing(Long userid);

    Long getFollowerNum(Long userId);

    Long getFollowingNum(Long userId);

    List<PhotoDto> getPhotoByUserId(Long userId);

    UserDto updateUser(Long userId, UserDto updatedUser);
}
