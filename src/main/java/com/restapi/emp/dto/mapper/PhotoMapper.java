package com.restapi.emp.dto.mapper;

import com.restapi.emp.dto.PhotoDto;
import com.restapi.emp.dto.UserDto;
import com.restapi.emp.entity.Photo;
import com.restapi.emp.entity.User;
import com.restapi.emp.exception.ResourceNotFoundException;
import com.restapi.emp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PhotoMapper {

    private final UserRepository userRepository;

    public static PhotoDto mapToPhotoDto(Photo photo){
        return new PhotoDto(
                photo.getId(),
                photo.getUserId().getId(),
                photo.getImageUrl(),
                photo.getCaption(),
                photo.getCreatedAt()
        );
    }

    public Photo mapToPhoto(PhotoDto photoDto){
        User user = userRepository.findById(photoDto.getUserId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("User not found")
                );

        return new Photo(
                photoDto.getId(),
                user,
                photoDto.getImageUrl(),
                photoDto.getCaption(),
                photoDto.getCreatedAt()
        );
    }
}