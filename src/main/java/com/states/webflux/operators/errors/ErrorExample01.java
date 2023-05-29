package com.states.webflux.operators.errors;

import com.states.webflux.operators.sample_data.Coffee;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

// 에러 기본 예제
@Slf4j
public class ErrorExample01 {
    public static void main(String[] args) {
        // 데이터 소스가 null이어도 에러 발생하지 않음
        Mono.justOrEmpty(findVerifiedCoffee())
                // null인 경우의 대체 동작 수행 가능
                .switchIfEmpty(Mono.error(new RuntimeException("Not found coffee")))
                .subscribe(
                        data -> log.info("{}: {}", data.getKorName(), data.getPrice()),
                        error -> log.error("# onError: {}", error.getMessage())
                );
    }

    private static Coffee findVerifiedCoffee() {
        // DB에서 Coffee 정보를 조회할 수 있음
        return null;
    }
}
