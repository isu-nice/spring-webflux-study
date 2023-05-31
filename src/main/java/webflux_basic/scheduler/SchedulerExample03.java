package webflux_basic.scheduler;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

// subscribeOn(), publishOn() 추가해서 Scheduler 지정
@Slf4j
public class SchedulerExample03 {
    public static void main(String[] args) throws InterruptedException {
        Flux.range(1, 10)
                .subscribeOn(Schedulers.boundedElastic())
                .doOnSubscribe(subscription -> log.info("# doOnSubscribe"))

                .publishOn(Schedulers.parallel())
                .filter(n -> n % 2 == 0)
                .doOnNext(data -> log.info("# filter doOnNext"))

                .publishOn(Schedulers.parallel())
                .map(n -> n * 2)
                .doOnNext(data -> log.info("# map doOnNext"))

                .subscribe(data -> log.info("# onNext: {}", data));

        Thread.sleep(100L);
    }
}
