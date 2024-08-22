package com.restapi.emp.service;

import com.restapi.emp.dto.DepartmentDto;
import com.restapi.emp.dto.FollowDto;

import java.util.List;

public interface FollowService {
    FollowDto followUser(FollowDto followDto);

    void unfollowUser(FollowDto followDto);

    List<FollowDto> getFollower(String userid);

    List<FollowDto> getFollowing(String userid);

    Long getFollowerNum(String userId);

    Long getFollowingNum(String userId);
}
