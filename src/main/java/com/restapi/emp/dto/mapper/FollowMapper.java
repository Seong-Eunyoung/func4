package com.restapi.emp.dto.mapper;

import com.restapi.emp.dto.FollowDto;
import com.restapi.emp.entity.Follow;

import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class FollowMapper {

    public static FollowDto mapToFollowDto(Follow follow){
        return new FollowDto(
                follow.getId(),
                follow.getFollowingId(),
                follow.getFollowerId()
        );
    }

    public static Follow mapToFollow(FollowDto followDto){

        return new Follow(
                followDto.getId(),
                followDto.getFollowingId(),
                followDto.getFollowerId()
        );
    }
}