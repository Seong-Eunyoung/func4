package com.restapi.emp.controller;

import com.restapi.emp.dto.FollowDto;
import com.restapi.emp.service.FollowService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/follow")
public class FollowController {

    private final FollowService followService;

    @PostMapping
    public ResponseEntity<FollowDto> followUser(@RequestBody FollowDto followDto) {
        FollowDto follow = followService.followUser(followDto);
        return new ResponseEntity<>(follow, HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<String> unfollowUser(@RequestBody FollowDto followDto) {
        followService.unfollowUser(followDto);
        return ResponseEntity.ok("unfollowed successfully!.");
    }

    @GetMapping("/{userId}/follower")
    public ResponseEntity<List<FollowDto>> getFollower(@PathVariable String userId) {
        List<FollowDto> followers = followService.getFollower(userId);
        return ResponseEntity.ok(followers);
    }

    @GetMapping("/{userId}/follower_num")
    public ResponseEntity<Long> getFollowerNum(@PathVariable String userId) {
        Long followerNum = followService.getFollowerNum(userId);
        return ResponseEntity.ok(followerNum);
    }

    @GetMapping("/{userId}/following")
    public ResponseEntity<List<FollowDto>> getFollowing(@PathVariable String userId) {
        List<FollowDto> followings = followService.getFollowing(userId);
        return ResponseEntity.ok(followings);
    }

    @GetMapping("/{userId}/following_num")
    public ResponseEntity<Long> getFollowingNum(@PathVariable String userId) {
        Long followingNum = followService.getFollowingNum(userId);
        return ResponseEntity.ok(followingNum);
    }
}