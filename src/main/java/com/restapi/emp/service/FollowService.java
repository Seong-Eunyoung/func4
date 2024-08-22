package com.restapi.emp.service;

import com.restapi.emp.dto.FollowDto;

public interface FollowService {
    FollowDto followUser(FollowDto followDto);

    void unfollowUser(FollowDto followDto);


}
