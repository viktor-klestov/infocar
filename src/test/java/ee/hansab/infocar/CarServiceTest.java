package ee.hansab.infocar;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarServiceTest extends IntegrationTest {
    @Autowired
    CarService serviceUnderTest;

    @Test
    void findsAll() {
        FindCarsRequest givenRequest = new FindCarsRequest();

        Collection<Car> found = serviceUnderTest.find(givenRequest);

        assertThat(found)
                .hasSize(9);
    }

    @Test
    void findsByMake() {
        FindCarsRequest givenRequest = new FindCarsRequest();
        givenRequest.setMake("BMW");

        Collection<Car> found = serviceUnderTest.find(givenRequest);

        assertThat(found)
                .extracting(Car::getNumberplate)
                .containsExactly("444RRR", "112YUI");
    }

    @Test
    void findsByModel() {
        FindCarsRequest givenRequest = new FindCarsRequest();
        givenRequest.setModel("Sorento");

        Collection<Car> found = serviceUnderTest.find(givenRequest);

        assertThat(found)
                .extracting(Car::getNumberplate)
                .containsExactly("534TTT", "555TFF");
    }


    @Test
    void findsByNumberplate() {
        FindCarsRequest givenRequest = new FindCarsRequest();
        givenRequest.setNumberplate("997HHH");

        Collection<Car> found = serviceUnderTest.find(givenRequest);

        assertThat(found)
                .extracting(Car::getNumberplate)
                .containsExactly("997HHH");
    }

    @Test
    void findsByMakeAndModel() {
        FindCarsRequest givenRequest = new FindCarsRequest();
        givenRequest.setMake("BMW");
        givenRequest.setModel("740");

        Collection<Car> found = serviceUnderTest.find(givenRequest);

        assertThat(found)
                .extracting(Car::getNumberplate)
                .containsExactly("112YUI");
    }

    @Test
    void ordersByNumberplate() {
        FindCarsRequest givenRequest = new FindCarsRequest();
        givenRequest.setSort("numberplate");

        Collection<Car> found = serviceUnderTest.find(givenRequest);

        assertThat(found)
                .extracting(Car::getNumberplate)
                .containsExactly(
                        "112YUI",
                        "123ASD",
                        "444RRR",
                        "445KKK",
                        "534TTT",
                        "555TFF",
                        "876OUI",
                        "997HHH",
                        "999GLF"
                );
    }

    @Test
    void findMatisCars() {

        Collection<Car> found = serviceUnderTest.findByUser(3);

        assertThat(found)
                .extracting(Car::getId)
                .containsExactly(5L, 6L);
    }

    @Test
    void emptyListWhenUserNotFound() {
        Collection<Car> found = serviceUnderTest.findByUser(-1);

        assertThat(found).isEmpty();
    }

    @Test
    void throwsExceptionWhenCarNotFound() {
        assertThatThrownBy(() -> serviceUnderTest.findById(-1));
    }
}