package com.loopers.interfaces.api.user;

import com.loopers.application.user.UserInfo;
import com.loopers.domain.user.UserEntity;

public class UserV1Dto {
    public record SignUpRequest(String loginId, String email, String birth, String password) {
        public UserEntity toEntity() {
            return new UserEntity(
                loginId,
                email,
                birth,
                password
            );
        }
    }

}
