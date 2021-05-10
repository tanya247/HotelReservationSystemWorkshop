import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.io.IOException;
import java.text.ParseException;

public class HotelReservationTest {
    HotelReservationSystem hotelReservationSystem = new HotelReservationSystem();

    @Test
    public void whenNewHotelAdded_ShouldReturnTrue() {
        Assertions.assertTrue(hotelReservationSystem.addHotel("Lakewood", 110));
        Assertions.assertTrue(hotelReservationSystem.addHotel("Bridgewood", 160));
        Assertions.assertTrue(hotelReservationSystem.addHotel("Ridgewood", 220));
    }
    @Test
    public void whenFindCheapestHotelMethodCalled_shouldReturn_nameOfHotelAndMinimumRent() {
        Assertions.assertTrue(hotelReservationSystem.addHotel("Lakewood", 110));
        Assertions.assertTrue(hotelReservationSystem.addHotel("Bridgewood", 160));
        Assertions.assertTrue(hotelReservationSystem.addHotel("Ridgewood", 220));
        Assertions.assertEquals("Lakewood", hotelReservationSystem.findCheapestHotel("10Sep2020", "11Sep2020"));
    }

}

