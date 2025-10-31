package com.loopers.application.user;

import com.loopers.domain.user.UserEntity;

public record UserInfo(Long id, String loginId, String email, String birth) {
    public static UserInfo from(UserEntity userEntity) {
        return new UserInfo(
            userEntity.getId(),
            userEntity.getLoginId(),
            userEntity.getEmail(),
            userEntity.getBirth()
        );
    }

}
