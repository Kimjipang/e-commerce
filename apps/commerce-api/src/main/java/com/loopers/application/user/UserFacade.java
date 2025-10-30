package com.loopers.application.user;

import com.loopers.domain.user.UserEntity;
import com.loopers.domain.user.UserService;
import com.loopers.interfaces.api.user.UserV1Dto;
import com.loopers.support.error.CoreException;
import com.loopers.support.error.ErrorType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class UserFacade {

    private final UserService userService;

    @Transactional
    public UserInfo signUp(UserV1Dto.SignUpRequest request) {
        boolean isExist = userService.existsByLoginId(request.loginId());

        if (isExist) {
            throw new CoreException(ErrorType.BAD_REQUEST, "이미 존재하는 유저입니다.");
        }

        UserEntity savedUser = userService.save(request.toEntity());
        return UserInfo.from(savedUser);
    }
}
