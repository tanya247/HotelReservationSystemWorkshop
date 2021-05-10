
import java.time.DayOfWeek;
import java.time.temporal.ChronoField;
import java.util.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.HashMap;
import java.util.Map;

public class HotelReservationSystem {
    private static Map<String, Hotel> hotelMap;

    public HotelReservationSystem() {
        hotelMap = new HashMap<>();
    }

    public boolean addHotel(String name, int HotelRateRegularWeekdays, int HotelRateRegularWeekEnd, int Ratings) {
        Hotel hotelObject = new Hotel(name, HotelRateRegularWeekdays, HotelRateRegularWeekEnd ,Ratings);
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
            System.out.println("Rate of weekends for regular customers: "+entry.getValue().getHotelRateRegularWeekEnd());
            System.out.println("Ratings of the Hotel is: "+entry.getValue().getRatings());
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
        System.out.println("Total Rate : " + minimumRate);
        return rateMap.get(minimumRate).get(0).getHotelName();
    }

    public static Map<Integer, ArrayList<Hotel>> createRateMap(String fromDate, String toDate) {
        HashMap<Integer, ArrayList<Hotel>> rateMap = new HashMap<>();
        int numOfDays = numberOfDays(fromDate, toDate);
        int count = isWeekend(fromDate,numOfDays);
        for (Map.Entry<String, Hotel> entry : hotelMap.entrySet()) {
            int rent = (entry.getValue().getHotelRateRegularWeekEnd() * count)+(entry.getValue().getHotelRateRegularWeekEnd()*(numOfDays-count));
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

    public static int isWeekend(String startDate, int numOfDays) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMMyyyy");
        LocalDate from = LocalDate.parse(startDate, formatter);
        DayOfWeek day1_OfWeek = DayOfWeek.of(from.get(ChronoField.DAY_OF_WEEK));
        int count = 0;
        switch (day1_OfWeek) {
            case SATURDAY:
                count = 2 ;
                break;
            case SUNDAY:
                count = 1 ;
                break;
            default:
                count = 0;
                break;

        }
        return  count;
    }



    public static void main(String[] args) {

        System.out.println("Welcome to Hotel Reservation Program");
    }
}
