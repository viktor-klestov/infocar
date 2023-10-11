package ee.hansab.infocar;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UserServiceTest extends IntegrationTest {
    @Autowired
    UserService serviceUnderTest;

    @Test
    void findsAll() {
        FindUsersRequest givenRequest = new FindUsersRequest();

        Collection<User> found = serviceUnderTest.find(givenRequest);

        assertThat(found)
                .hasSize(5);
    }

    @Test
    void findsByName() {
        FindUsersRequest givenRequest = new FindUsersRequest();
        givenRequest.setName("Teet");

        Collection<User> found = serviceUnderTest.find(givenRequest);

        assertThat(found)
                .extracting(User::getId)
                .containsExactly(1L, 5L);
    }

    @Test
    void ordersByNameDesc() {
        FindUsersRequest givenRequest = new FindUsersRequest();
        givenRequest.setSort("name:desc");

        Collection<User> found = serviceUnderTest.find(givenRequest);

        assertThat(found)
                .extracting(User::getName)
                .containsExactly(
                        "Teet Kruus",
                        "Teet Järveküla",
                        "Pille Purk",
                        "Mati Kaal",
                        "Külli Kukk"
                );
    }

    @Test
    void ordersByName() {
        FindUsersRequest givenRequest = new FindUsersRequest();
        givenRequest.setSort("name");

        Collection<User> found = serviceUnderTest.find(givenRequest);

        assertThat(found)
                .extracting(User::getName)
                .containsExactly(
                        "Külli Kukk",
                        "Mati Kaal",
                        "Pille Purk",
                        "Teet Järveküla",
                        "Teet Kruus"
                );
    }

    @Test
    void throwsExceptionWhenCarNotFound() {
        assertThatThrownBy(() -> serviceUnderTest.findById(-1));
    }
}