package com.restapi.emp.service.impl;

import com.restapi.emp.dto.FollowDto;
import com.restapi.emp.dto.PhotoDto;
import com.restapi.emp.dto.UserDto;
import com.restapi.emp.dto.mapper.FollowMapper;
import com.restapi.emp.dto.mapper.PhotoMapper;
import com.restapi.emp.dto.mapper.UserMapper;
import com.restapi.emp.entity.Follow;
import com.restapi.emp.entity.Photo;
import com.restapi.emp.entity.User;
import com.restapi.emp.exception.ResourceNotFoundException;
import com.restapi.emp.repository.FollowRepository;
import com.restapi.emp.repository.PhotoRepository;
import com.restapi.emp.repository.UserRepository;
import com.restapi.emp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final FollowRepository followRepository;
    private final PhotoRepository photoRepository;

    @Override
    public UserDto getUserById(String id) {
        User user = userRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("User is not exists with a given id: " + id)
        );
        return UserMapper.mapToUserDto(user);
    }

    @Transactional(readOnly = true)
    @Override
    public List<FollowDto> getFollower(String userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("User is not exists with a given id: " + userId)
                );;
        List<Follow> followers = followRepository.findByFollowingId(user);

        return followers.stream()
                .map(FollowMapper::mapToFollowDto)
                .toList();
    }

    @Transactional(readOnly = true)
    @Override
    public List<FollowDto> getFollowing(String userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("User is not exists with a given id: " + userId)
                );
        List<Follow> followings = followRepository.findByFollowerId(user);

        return followings.stream()
                .map(FollowMapper::mapToFollowDto)
                .toList();
    }

    @Transactional(readOnly = true)
    @Override
    public Long getFollowerNum(String userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("User is not exists with a given id: " + userId)
                );
        return followRepository.countByFollowingId(user);
    }

    @Transactional(readOnly = true)
    @Override
    public Long getFollowingNum(String userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("User is not exists with a given id: " + userId)
                );
        return followRepository.countByFollowerId(user);
    }

    @Transactional(readOnly = true)
    @Override
    public List<PhotoDto> getPhotoByUserId(String userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("User is not exists with a given id: " + userId)
                );
        List<Photo> photos = photoRepository.findByUserId(user);
        return photos.stream()
                .map(PhotoMapper::mapToPhotoDto)
                .toList();
    }

    @Override
    public UserDto updateUser(String userId, UserDto updatedUser) {
        User user = userRepository.findById(userId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("User not exist")
                );
        if (updatedUser.getUserName() != null)
            user.setUserName(updatedUser.getUserName());
        if (updatedUser.getProfileImage() != null)
            user.setProfileImage(updatedUser.getProfileImage());

        User savedUser = userRepository.save(user);
        return UserMapper.mapToUserDto(savedUser);
    }
}