package webflux.operators.transformation;

import webflux.operators.sample_data.SampleData;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

// concat() 기본 예제 2
@Slf4j
public class ConcatExample02 {
    public static void main(String[] args) {
        Flux.concat(
                        Flux.fromIterable(SampleData.salesOfCafeC),
                        Flux.fromIterable(SampleData.salesOfCafeB),
                        Flux.fromIterable(SampleData.salesOfCafeC)
                ).reduce((a, b) -> a + b)
                .subscribe(data -> log.info("# total sales: {}", data));
    }

    // concat() 으로 월별 매출액을 모두 하나의 sequence로 연결한 다음 카페의 전체 매출액의 계산
}
