import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.io.IOException;
import java.text.ParseException;

public class HotelReservationTest {
    HotelReservationSystem hotelReservationSystem = new HotelReservationSystem();

   /* @Test
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
    @Test
    public void whenWeekendRateAddedInTheHotelRate_ShouldReturnsTrue() {
        Assertions.assertTrue(hotelReservationSystem.addHotel("Lakewood", 110, 90));
        Assertions.assertTrue(hotelReservationSystem.addHotel("Bridgewood", 160, 60));
        Assertions.assertTrue(hotelReservationSystem.addHotel("Ridgewood", 110, 150));

        hotelReservationSystem.printHotels();
    }
    @Test
    public void whenFindCheapestHotelIsCalled_shouldReturn_nameOfHotelWithCheapestRent() {
        Assertions.assertTrue(hotelReservationSystem.addHotel("Lakewood", 110, 90));
        Assertions.assertTrue(hotelReservationSystem.addHotel("Bridgewood", 160, 60));
        Assertions.assertTrue(hotelReservationSystem.addHotel("Ridgewood", 220, 150));

        Assertions.assertEquals("Bridgewood", hotelReservationSystem.findCheapestHotel("10Sep2020", "11Sep2020"));
    }*/
   /*@Test
   public void whenRatingsAddedInTheHotelInformation_ShouldReturnsTrue() {
       Assertions.assertTrue(hotelReservationSystem.addHotel("Lakewood", 110, 90, 3));
       Assertions.assertTrue(hotelReservationSystem.addHotel("Bridgewood", 160, 60, 4));
       Assertions.assertTrue(hotelReservationSystem.addHotel("Ridgewood", 220, 150, 5));
   }*/
    /*@Test
    public void whenCheapestBestRatedCalled_shouldReturn_bestRatedHotel() {
        hotelReservationSystem.addHotel("Lakewood", 110, 90, 3);
        hotelReservationSystem.addHotel("Bridgewood", 150, 60, 4);
        hotelReservationSystem.addHotel("Ridgewood", 220, 150, 5);
        Assertions.assertTrue(hotelReservationSystem.cheapestBestRatedHotel("11Sep2020", "12Sep2020"));
    }
    @Test
    public void whenFindBestRatedMethodCalled_shouldReturn_bestRatedHotel() {
        hotelReservationSystem.addHotel("Lakewood", 110, 90, 3);
        hotelReservationSystem.addHotel("Bridgewood", 150, 50, 4);
        hotelReservationSystem.addHotel("Ridgewood", 220, 150, 5);
        Assertions.assertTrue(hotelReservationSystem.findBestRatedHotelForGivenDates("11Sep2020", "12Sep2020"));
    }*/
    @Test
    public void whenAddedRatesForRewardCustomers_shouldAdd_hotelWithAllRates_InLoyalityProgram() {
        hotelReservationSystem.addHotel("Lakewood", 110, 90, 3, 80, 80);
        hotelReservationSystem.addHotel("Bridgewood", 150, 50, 4, 110, 50);
        hotelReservationSystem.addHotel("Ridgewood", 220, 150, 5, 100, 40);
        hotelReservationSystem.printHotels();
    }

}

