package com.restapi.emp.service.impl;

import com.restapi.emp.dto.DepartmentDto;
import com.restapi.emp.dto.FollowDto;
import com.restapi.emp.dto.mapper.DepartmentMapper;
import com.restapi.emp.dto.mapper.FollowMapper;
import com.restapi.emp.entity.Department;
import com.restapi.emp.entity.Follow;
import com.restapi.emp.exception.ResourceNotFoundException;
import com.restapi.emp.repository.DepartmentRepository;
import com.restapi.emp.repository.FollowRepository;
import com.restapi.emp.repository.UserRepository;
import com.restapi.emp.service.DepartmentService;
import com.restapi.emp.service.FollowService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FollowServiceImpl implements FollowService {

    private final FollowRepository followRepository;
    private final UserRepository userRepository;

    @Override
    public FollowDto followUser(FollowDto followDto) {
        Follow follow = FollowMapper.mapToFollow(followDto);
        Follow savedFollow = followRepository.save(follow);
        return FollowMapper.mapToFollowDto(savedFollow);
    }
    @Override
    public void unfollowUser(FollowDto followDto) {
        String followerId = followDto.getFollowerId();
        String followingId = followDto.getFollowingId();
        followRepository.deleteByFollowerIdAndFollowingId(followerId, followingId);
    }

    @Override
    public List<FollowDto> getFollower(String userId) {
        List<Follow> followers = followRepository.findByFollowingId(userId);

        return followers.stream()
                .map(FollowMapper::mapToFollowDto)
                .toList();
    }

    @Override
    public List<FollowDto> getFollowing(String userId) {
        List<Follow> followings = followRepository.findByFollowerId(userId);

        return followings.stream()
                .map(FollowMapper::mapToFollowDto)
                .toList();
    }

}