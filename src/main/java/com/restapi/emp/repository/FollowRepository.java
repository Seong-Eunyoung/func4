package com.restapi.emp.repository;

import com.restapi.emp.entity.Follow;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FollowRepository extends JpaRepository<Follow, String> {
    // 팔로워 (해당 유저를 팔로우 하는 유저) 목록
    List<Follow> findByFollowingId(String followingId);
    // 팔로잉 (해당 유저가 팔로우하는 유저) 목록
    List<Follow> findByFollowerId(String followerId);
    // 언팔로우
    void deleteByFollowerIdAndFollowingId(String followingId, String followerId);
    // 팔로워 수
    Long countByFollowingId(String followingId);
    // 팔로잉 수
    Long countByFollowerId(String followerId);
}
