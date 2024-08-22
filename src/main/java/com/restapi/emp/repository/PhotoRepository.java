package com.restapi.emp.repository;

import com.restapi.emp.entity.Photo;
import com.restapi.emp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PhotoRepository extends JpaRepository<Photo, User> {
    List<Photo> findByUserId(User userId);
}
