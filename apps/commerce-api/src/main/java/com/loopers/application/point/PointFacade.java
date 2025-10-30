package com.loopers.application.point;

import com.loopers.domain.point.Point;
import com.loopers.domain.point.PointService;
import com.loopers.domain.user.UserService;
import com.loopers.interfaces.api.point.PointV1Dto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class PointFacade {
    private final PointService pointService;
    private final UserService userService;

    @Transactional(readOnly = true)
    public PointInfo getPoint(Long userId) {
        /*
        - [ ] 사용자 존재 여부 확인
        - [ ] 포인트 잔액 조회
         */
        userService.checkUserExists(userId);

        Point point = pointService.getPointBalanceByUserId(userId);

        return PointInfo.from(point);

    }

}
