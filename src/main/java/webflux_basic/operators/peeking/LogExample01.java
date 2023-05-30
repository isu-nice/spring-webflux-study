package webflux_basic.operators.peeking;

import reactor.core.publisher.Flux;

import java.util.stream.Stream;

public class LogExample01 {
    public static void main(String[] args) {
        Flux
                .fromStream(Stream.of(200, 300, 400, 500))
                .log()
                .reduce((a, b) -> a + b)
                .log()
                .subscribe(System.out::println);

        // signal 이벤트가 발생할 때마다 로그 기록
    }
}
