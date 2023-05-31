package webflux_basic.scheduler;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

// Scheduler을 추가하지 않을 경우
@Slf4j
public class SchedulerExample01 {
    public static void main(String[] args) {
        Flux.range(1, 10) // 1부터 10개의 숫자 emit
                .filter(n -> n % 2 == 0) // 짝수 필터링
                .map(n -> n * 2) // (짝수 * 2)해서 Subscriber 에게 전달
                .subscribe(data -> log.info("# onNext: {}", data));
    }
    // Scheduler를 지정하지 않았기 때문에 main 스레드에서 실행됨
}
