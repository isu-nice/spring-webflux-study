package webflux_basic.example;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

// 리액티브 프로그래밍 기본 구조
public class HelloReactiveExample02 {
    public static void main(String[] args) throws InterruptedException {
        Flux
                .just("Hello, Reactive") // Publisher 역할
                .map(message -> message.toUpperCase())
                .publishOn(Schedulers.parallel())
                .subscribe(System.out::println,                          // publisher 가 emit한 데이터를 전달받아 처리
                        error -> System.out.println(error.getMessage()), // sequence 상에서 에러가 발생할 경우 처리
                        () -> System.out.println("# onComplete"));       // sequence가 종료된 후, 후처리

        // Scheduler가 별도의 스레드를 하나 더 만든다.(모두 데몬 스레드임)
        // 주 스레드인 main이 종료되면 데몬 스레드도 종료되기 때문에
        // main을 0.1초 sleep 시켜서 Scheduler로 지정한 데몬 스레드를 정상 동작 하게 함
        Thread.sleep(100L);
    }
}
