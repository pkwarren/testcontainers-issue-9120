package io.pkw.testcontainers.issue9120;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.slf4j.LoggerFactory;
import org.testcontainers.containers.output.Slf4jLogConsumer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.kafka.KafkaContainer;

@Testcontainers
@Execution(ExecutionMode.CONCURRENT)
public class KafkaTest {

    @Container
    public static KafkaContainer KAFKA_CONTAINER = new KafkaContainer("apache/kafka:3.8.0")
            .withLogConsumer(new Slf4jLogConsumer(LoggerFactory.getLogger("kafka"), true));

    @Test
    void testKafka() {
        Assertions.assertTrue(KAFKA_CONTAINER.isRunning());
    }
}
