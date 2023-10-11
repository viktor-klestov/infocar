package ee.hansab.infocar;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
@SpringBootTest
public class IntegrationTest {
    public static PostgreSQLContainer db = new PostgreSQLContainer("postgres:14")
            .withDatabaseName("infocar")
            .withUsername("infocar")
            .withPassword("pass");

    @DynamicPropertySource
    static void postgresqlProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", db::getJdbcUrl);
    }

    static {
        db.start();
    }
}
