package webflux_basic.scheduler;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

// SubscribeOn() operator를 이용해서 Scheduler를 추가한 경우
@Slf4j
public class SchedulerExample02 {
    public static void main(String[] args) throws InterruptedException {
        Flux.range(1, 10)
                .doOnSubscribe(subscription -> log.info("# doOnSubscribe"))

                // 구독 직후 실행되는 Operator 체인의 실행 스레드를 Scheduler에서 지정한 스레드로 변경
                .subscribeOn(Schedulers.boundedElastic())
                .filter(n -> n % 2 == 0)
                .map(n -> n * 2)
                .subscribe(data -> log.info("# onNext: {}", data));

        Thread.sleep(100L);
    }
}
