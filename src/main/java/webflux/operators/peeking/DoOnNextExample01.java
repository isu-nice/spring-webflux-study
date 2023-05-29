package webflux.operators.peeking;

import webflux.operators.sample_data.Coffee;
import webflux.operators.sample_data.SampleData;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

// doOnNext() 기본 예제
@Slf4j
public class DoOnNextExample01 {
    public static void main(String[] args) {
        Flux.fromIterable(SampleData.coffeeList)

                // 데이터 emit 시, 트리거되어 부수 효과를 추가할 수 있음 (로그 기록, 출력 등)
                // downstream 의 데이터 값에 영향을 미치지 않음
                .doOnNext(coffee -> validateCoffee(coffee))
                .subscribe(data ->
                        log.info("{}: {}", data.getKorName(), data.getPrice()));
    }

    private static void validateCoffee(Coffee coffee) {
        if (coffee == null) {
            throw new RuntimeException("Not found coffee");
        }
    }
}
