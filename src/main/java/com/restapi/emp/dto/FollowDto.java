package com.restapi.emp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FollowDto {
    private Long id;
    private String followingId;
    private String followingUserName;
    private String followerId;
    private String followerUserName;

}

