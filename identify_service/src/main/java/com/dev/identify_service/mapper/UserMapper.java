package com.dev.identify_service.mapper;

import com.dev.identify_service.dto.request.UserCreateRequest;
import com.dev.identify_service.dto.request.UserUpdateRequest;
import com.dev.identify_service.dto.response.UserResponse;
import com.dev.identify_service.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserCreateRequest request);

//    @Mapping(source = "firstName",target = "lastName")
//    @Mapping(target = "lastName", ignore = true)
    UserResponse toUserResponse(User user);
    void updateUser(@MappingTarget User user, UserUpdateRequest request);
}
