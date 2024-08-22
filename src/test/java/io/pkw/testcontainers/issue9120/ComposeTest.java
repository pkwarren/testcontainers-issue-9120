package io.pkw.testcontainers.issue9120;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.testcontainers.containers.ComposeContainer;
import org.testcontainers.containers.wait.strategy.Wait;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.io.File;

@Testcontainers
@Execution(ExecutionMode.CONCURRENT)
public class ComposeTest {
    @Container
    public static ComposeContainer COMPOSE_CONTAINER = new ComposeContainer(new File("docker-compose.yml"))
            .waitingFor("kafka", Wait.forLogMessage(".*Transitioning from RECOVERY to RUNNING.*", 1));

    @Test
    void testCompose() {
        // Dummy assertion
        Assertions.assertNotNull(COMPOSE_CONTAINER);
    }
}
