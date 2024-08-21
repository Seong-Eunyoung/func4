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

    @GetMapping("follower/{userId}")
    public ResponseEntity<List<FollowDto>> getFollower(@PathVariable String userId) {
        List<FollowDto> followers = followService.getFollower(userId);
        return ResponseEntity.ok(followers);
    }

    @GetMapping("following/{userId}")
    public ResponseEntity<List<FollowDto>> getFollowing(@PathVariable String userId) {
        List<FollowDto> followings = followService.getFollowing(userId);
        return ResponseEntity.ok(followings);
    }
}