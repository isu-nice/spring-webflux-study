package webflux_basic.example;

import reactor.core.publisher.Mono;

// 리액티브 프로그래밍 기본 구조
public class HelloReactiveExample01 {
    public static void main(String[] args) {
        // Publisher 역할
        Mono<String> mono = Mono.just("Hello, Reactive");

        // Subscriber 역할
        mono.subscribe(message -> System.out.println(message));
    }
}
