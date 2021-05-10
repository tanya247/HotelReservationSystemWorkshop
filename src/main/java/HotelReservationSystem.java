
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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
    public String findCheapestHotel(String fromDate, String toDate) {
        Map<Integer, ArrayList<Hotel>> rateMap = createRateMap(fromDate, toDate);
        int minimumRate = Integer.MAX_VALUE;
        for (Map.Entry<Integer, ArrayList<Hotel>> entry : rateMap.entrySet()) {
            if (entry.getKey() < minimumRate)
                minimumRate = entry.getKey();
        }

        System.out.println(rateMap.get(minimumRate).get(0).getHotelName());
        System.out.println("Total Rate : " + minimumRate*(numberOfDays(fromDate,toDate)+1));
        return rateMap.get(minimumRate).get(0).getHotelName();
    }
    public static Map<Integer, ArrayList<Hotel>>createRateMap(String fromDate, String toDate) {
        HashMap<Integer, ArrayList<Hotel>> rateMap = new HashMap<>();
        int numOfDays = numberOfDays(fromDate, toDate);
        for (Map.Entry<String, Hotel> entry : hotelMap.entrySet()) {
            int rent = (entry.getValue().getHotelRateRegularWeekDay() * numOfDays);
            rateMap.computeIfAbsent(rent, k -> new ArrayList<>()).add(entry.getValue());
        }
        return rateMap;
    }

    public static int numberOfDays(String startDate, String endDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMMyyyy");
        LocalDate from = LocalDate.parse(startDate, formatter);
        LocalDate to = LocalDate.parse(endDate, formatter);
        int numOfDays = 0;
        for (LocalDate date = from; date.isBefore(to); date = date.plusDays(1)) {
            numOfDays++;
        }

        return numOfDays;
    }

    public static void main(String[] args) {

        System.out.println("Welcome to Hotel Reservation Program");
    }
}
