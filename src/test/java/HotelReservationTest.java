import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.io.IOException;
import java.text.ParseException;

public class HotelReservationTest {
    HotelReservationSystem hotelReservationSystem = new HotelReservationSystem();

    @Test
    public void whenNewHotelAdded_shouldReturnTrue() {
        Assertions.assertTrue(hotelReservationSystem.addHotel("Lakewood", 110));
        Assertions.assertTrue(hotelReservationSystem.addHotel("Bridgewood", 160));
        Assertions.assertTrue(hotelReservationSystem.addHotel("Ridgewood", 220));
        hotelReservationSystem.printHotels();
    }
}

