package com.dev.identify_service.service;

import com.dev.identify_service.dto.request.UserCreateRequest;
import com.dev.identify_service.dto.request.UserUpdateRequest;
import com.dev.identify_service.dto.response.UserResponse;
import com.dev.identify_service.entity.User;
import com.dev.identify_service.exception.AppException;
import com.dev.identify_service.exception.ErrorCode;
import com.dev.identify_service.mapper.UserMapper;
import com.dev.identify_service.repository.UserRepository;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Builder
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserService {
    UserRepository userRepository;
    UserMapper userMapper;

    public User createRequest(UserCreateRequest request) {

        if (userRepository.existsByUserName(request.getUserName()))
            throw new AppException(ErrorCode.USER_EXISTED);
        User user = userMapper.toUser(request);
        return userRepository.save(user);
    }

    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    public UserResponse getUserById(String id) {
        return userMapper.toUserResponse(userRepository.findById(id).orElseThrow(() -> new AppException(ErrorCode.USER_NOT_FOUND)));
    }

    public UserResponse updateUser(String id, UserUpdateRequest request) {
        User user = userRepository.findById(id).orElseThrow(() -> new AppException(ErrorCode.USER_NOT_FOUND));
        userMapper.updateUser(user, request);
        return userMapper.toUserResponse(userRepository.save(user));
    }

    public void deleteUser(String id) {
        if (!userRepository.existsById(id))
            throw new AppException(ErrorCode.USER_NOT_FOUND);
        else {
            userRepository.deleteById(id);
        }
    }
}