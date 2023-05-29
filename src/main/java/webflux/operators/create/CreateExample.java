package webflux.operators.create;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;

import java.util.Arrays;
import java.util.List;

// create() 기본 예제
@Slf4j
public class CreateExample {
    private static List<Integer> source =
            Arrays.asList(1, 3, 5, 7, 9, 11, 13, 15, 17, 19);

    public static void main(String[] args) {
        // FluxSink: 프로그래밍 방식으로 직접 signal 이벤트 발생시켜서 sequence 진행하도록 하는 기능
        Flux.create((FluxSink<Integer> sink) -> {
            sink.onRequest(n -> {

                for (int i = 0; i < source.size(); i++) {
                    sink.next(source.get(i)); // List source의 원소를 emit
                }
                sink.complete(); // sequence 종료
            });

            // sequence가 완전히 종료되기 직전에 호출 -> 후처리
            sink.onDispose(() -> log.info("# clean up"));
        }).subscribe(data -> log.info(" onNext: {}", data));
    }
}
