package com.states.webflux.operators.transformation;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

// flatMap() 기본 예제
@Slf4j
public class FlatMapExample01 {
    public static void main(String[] args) throws InterruptedException {
        Flux.range(2, 6)
                .flatMap(dan -> Flux
                        .range(1, 9)

                        // Inner Sequence를 처리할 스레드 할당 -> 전체 sequence는 비동기적으로 동작
                        .publishOn(Schedulers.parallel())
                        .map(num -> dan + "x" + num + " = " + dan * num))
                .subscribe(log::info);

        Thread.sleep(100L);

        // 실행 결과 2단부터 7단까지 뒤섞여서 출력됨
        // -> flatMap()에서 추가 스레드를 할당할 경우, 작업의 처리 순서를 보장하지 않음
    }
}
