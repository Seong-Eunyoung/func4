package com.restapi.emp.runner;

import com.restapi.emp.entity.Department;
import com.restapi.emp.entity.Employee;
import com.restapi.emp.entity.User;
import com.restapi.emp.entity.Follow;
import com.restapi.emp.repository.FollowRepository;
import com.restapi.emp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Profile("test")
@RequiredArgsConstructor
public class UserFollowInsertRunner implements ApplicationRunner {
    final UserRepository userRepository;

    final FollowRepository followRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        User user1 = new User();
        user1.setId("amy");
        user1.setUserName("에이미");
        user1.setEmail("test@a.com");
        user1.setPassword("0000");

        User user2 = new User();
        user2.setId("john");
        user2.setUserName("존");
        user2.setEmail("test2@a.com");
        user2.setPassword("0000");

        userRepository.saveAll(List.of(user1, user2));

        Follow follow1 = new Follow();
        follow1.setFollowerId("amy");
        follow1.setFollowingId("john");

        followRepository.saveAll(List.of(follow1));
    }
}
