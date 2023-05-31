package webflux_basic.operators.transformation;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

import java.time.Duration;

// zip() 기본 예제
@Slf4j
public class ZipExample01 {
    public static void main(String[] args) throws InterruptedException {
        // 0.2초에 한 번씩 0부터 1씩 증가하는 숫자를 4번 emit 함
        Flux<Long> source1 = Flux.interval(Duration.ofMillis(200L)).take(4);
        // 0.4초애 한 번씩 0부터 1씩 증가하는 숫자를 7번 emit 함
        Flux<Long> source2 = Flux.interval(Duration.ofMillis(400L)).take(7);

        // emit 시점이 늦은 데이터가 emit될 때까지 대기했다가 두 개의 데이터를 전달받음
        Flux.zip(source1, source2, (data1, data2) -> data1 + data2)
                .subscribe(data -> log.info(" onNext: {}", data));

        Thread.sleep(3000L);

        // 결과는 4개만 출력 -> 결합될 상대가 없는 나머지 3개의 데이터를 폐기됨
    }
}
