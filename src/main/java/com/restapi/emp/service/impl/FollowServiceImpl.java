package com.restapi.emp.service.impl;


import com.restapi.emp.dto.FollowDto;
import com.restapi.emp.dto.mapper.FollowMapper;
import com.restapi.emp.entity.Follow;
import com.restapi.emp.entity.User;
import com.restapi.emp.exception.ResourceNotFoundException;
import com.restapi.emp.repository.FollowRepository;
import com.restapi.emp.repository.UserRepository;
import com.restapi.emp.service.FollowService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class FollowServiceImpl implements FollowService {

    private final FollowRepository followRepository;
    private final UserRepository userRepository;
    private final FollowMapper followMapper;

    @Override
    public FollowDto followUser(FollowDto followDto) {
        Follow follow = followMapper.mapToFollow(followDto);

        if (follow.getFollowerId()==follow.getFollowingId())
            throw new ResourceNotFoundException("cannot follow yourself");

        if (followRepository
                .findByFollowerIdAndFollowingId(follow.getFollowerId(), follow.getFollowingId())
                .isPresent())
            throw new ResourceNotFoundException("already followed");

        Follow savedFollow = followRepository.save(follow);
        return FollowMapper.mapToFollowDto(savedFollow);
    }

    @Transactional
    @Override
    public void unfollowUser(FollowDto followDto) {
        Long followerId = followDto.getFollowerId();
        Long followingId = followDto.getFollowingId();
        User follower = userRepository.findById(followerId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("User not found")
                );
        User following = userRepository.findById(followingId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("User not found")
                );
        followRepository.deleteByFollowerIdAndFollowingId(follower, following);
    }



}