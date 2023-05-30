package webflux_basic.operators.create;

import reactor.core.publisher.Flux;

import java.util.stream.Stream;

// fromStream() 기본 예제
public class FromStreamExample01 {
    public static void main(String[] args) {
        Flux
                // stream 전달 -> stream이 포함하고 있는 데이터를 차례대로 emit
                .fromStream(Stream.of(200, 300, 400, 500, 600))
                .reduce((a, b) -> a + b) // 순차적으로 누적 처리
                .subscribe(System.out::println);

        // [실행 결과] 2000
    }
}
