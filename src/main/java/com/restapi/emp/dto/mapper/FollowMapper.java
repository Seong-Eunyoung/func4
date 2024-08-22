package com.restapi.emp.dto.mapper;

import com.restapi.emp.dto.FollowDto;
import com.restapi.emp.entity.Follow;

import com.restapi.emp.entity.User;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FollowMapper {

    public static FollowDto mapToFollowDto(Follow follow){
        return new FollowDto(
                follow.getId(),
                //follow.getFollowingId().getId()
                //follow.getFollowerId().getId()
                follow.getFollowingId(),
                follow.getFollowerId()
        );
    }

    public static Follow mapToFollow(FollowDto followDto){
        //User following = userRepository.findById(followDto.getFollowingId());
        //User follower = userRepository.findById(followDto.getFollowerId());

        return new Follow(
                followDto.getId(),
                followDto.getFollowingId(),
                followDto.getFollowerId()
        );
    }
}