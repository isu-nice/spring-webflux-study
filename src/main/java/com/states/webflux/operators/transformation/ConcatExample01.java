package com.states.webflux.operators.transformation;

import reactor.core.publisher.Flux;

// concat() 기본 예제
public class ConcatExample01 {
    public static void main(String[] args) {
        Flux.concat(
                Flux.just("Monday", "Tuesday", "Thursday", "Friday"),
                Flux.just("Saturday", "Sunday")
        ).subscribe(System.out::println);


        // 이어 붙인 Sequence에서 시간 순서대로, 데이터를 차례대로 emit함
    }
}
