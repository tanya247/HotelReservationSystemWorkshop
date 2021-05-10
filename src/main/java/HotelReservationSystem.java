
import java.util.HashMap;
import java.util.Map;

public class HotelReservationSystem {
    private static Map<String, Hotel> hotelMap;

    public HotelReservationSystem() {
        hotelMap = new HashMap<>();
    }

    public boolean addHotel(String name, int HotelRateRegularWeekdays) {
        Hotel hotelObject = new Hotel(name, HotelRateRegularWeekdays);
        hotelMap.put(name, hotelObject);
        return true;
    }

    public void printHotels() {
        System.out.println("********************************************************************************************");
        System.out.println("Welcome in the online reservation of the hotel, you can book your hotel room online");
        System.out.println("********************************************************************************************");
        for (Map.Entry<String, Hotel> entry : hotelMap.entrySet()) {
            System.out.println("Hotel Name : " + entry.getKey());
            System.out.println("Rate on weekdays for regular customers : " + entry.getValue().getHotelRateRegularWeekDay());
        }
    }
    public static void main(String[] args) {

        System.out.println("Welcome to Hotel Reservation Program");
    }
}
