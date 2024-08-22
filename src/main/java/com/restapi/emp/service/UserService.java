package com.restapi.emp.service;

import com.restapi.emp.dto.FollowDto;
import com.restapi.emp.dto.PhotoDto;
import com.restapi.emp.dto.UserDto;

import java.util.List;

public interface UserService {

    UserDto getUserById(String id);

    List<FollowDto> getFollower(String userid);

    List<FollowDto> getFollowing(String userid);

    Long getFollowerNum(String userId);

    Long getFollowingNum(String userId);

    List<PhotoDto> getPhotoByUserId(String userId);

    UserDto updateUser(String userId, UserDto updatedUser);
}
