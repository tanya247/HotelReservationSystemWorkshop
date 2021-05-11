
import java.io.IOException;
import java.time.DayOfWeek;
import java.time.temporal.ChronoField;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.*;
import java.util.HashMap;
import java.util.Map;

public class HotelReservationSystem {
    private static Map<String, Hotel> hotelMap;

    public HotelReservationSystem() {
        hotelMap = new HashMap<>();
    }

    public boolean addHotel(String name, int HotelRateRegularWeekdays, int HotelRateRegularWeekEnd, int Ratings, int HotelRewardRegularCustomerWeekdayRate, int HotelRewardRegularCustomerWeekendRate) {
        Hotel hotelObject = new Hotel(name, HotelRateRegularWeekdays, HotelRateRegularWeekEnd ,Ratings, HotelRewardRegularCustomerWeekdayRate, HotelRewardRegularCustomerWeekendRate);
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
    public boolean cheapestBestRatedHotel(String fromDate, String toDate, String Customer_type) {
        Map<Integer, ArrayList<Hotel>> rentMap = null;
        try {
            rentMap = createRateMap(fromDate, toDate, Customer_type);
        } catch (IOException e) {
            e.printStackTrace();
        }
        int minimumRent = Integer.MAX_VALUE;
        for (Map.Entry<Integer, ArrayList<Hotel>> entry : rentMap.entrySet()) {
            if (entry.getKey() < minimumRent)
                minimumRent = entry.getKey();
        }
        ArrayList<Hotel> cheapestHotels = rentMap.get(minimumRent);
        String bestRatedCheapestHotel = "";
        int rating = 0;
        for (Hotel hotel : cheapestHotels) {
            if (hotel.getRatings() > rating) {
                bestRatedCheapestHotel = hotel.getHotelName();
                rating = hotel.getRatings();
            }
        }
        System.out.println("Cheapest Hotel for you is " + bestRatedCheapestHotel + " with Rating " + rating + " Total Rent : "
                + minimumRent + "\n");
        return true;
    }
    public boolean findBestRatedHotelForGivenDates(String fromDate, String toDate) {
        int rating = 0;
        int rate = 0;
        String bestRatedHotel = "";
        for (Map.Entry<String, Hotel> entry : hotelMap.entrySet()) {
            if (entry.getValue().getRatings() > rating) {
                rating = entry.getValue().getRatings();
                bestRatedHotel = entry.getKey();
                rate = calculateRent(fromDate, toDate, entry.getValue().getHotelRateRegularWeekDay(),
                        entry.getValue().getHotelRateRegularWeekEnd());
            }
        }
        System.out.println("Best Rated Hotel : " + bestRatedHotel + ", Rent : " + rate);
        return true;
    }

    private int calculateRent(String fromDate, String toDate, int hotelRateRegularWeekDay, int hotelRateRegularWeekEnd) {
        int p[] = numberOfDays(fromDate, toDate);
        return ((hotelRateRegularWeekDay*p[1] )+ (hotelRateRegularWeekEnd*p[0]));

    }


    public static Map<Integer, ArrayList<Hotel>> createRateMap(String fromDate, String toDate, String Customer_type) throws IOException{
        HashMap<Integer, ArrayList<Hotel>> rateMap = new HashMap<>();
        int count[] = numberOfDays(fromDate, toDate);
        for (Map.Entry<String, Hotel> entry : hotelMap.entrySet()) {
            if(Customer_type == "Regular") {
                int rent = (entry.getValue().getHotelRateRegularWeekEnd() * count[0]) + (entry.getValue().getHotelRateRegularWeekEnd() * count[1]);
                rateMap.computeIfAbsent(rent, k -> new ArrayList<>()).add(entry.getValue());
            }
            else if(Customer_type == "Rewarded"){
                int rent = (entry.getValue().getHotelRateRegularWeekEnd() * count[0]) + (entry.getValue().getHotelRateRegularWeekEnd() * count[1]);
                rateMap.computeIfAbsent(rent, k -> new ArrayList<>()).add(entry.getValue());
            }
        }
        return rateMap;
    }

    public static int[] numberOfDays(String startDate, String endDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMMyyyy");
        LocalDate from = LocalDate.parse(startDate, formatter);
        LocalDate to = LocalDate.parse(endDate, formatter);
        int numOfDays = 0;
        int count =0;
        int m=0;
        int[] c = new int[2];
        for (LocalDate date = from; date.isBefore(to); date = date.plusDays(1)) {
            if (isWeekend(date)) {
                count++;
            } else {
                m++;
            }
        }
        if(isWeekend(to)) {
            count++;
        }
        else{
            m++;
        }
        c[0]=count;
        c[1]=m;
        return c;
    }
    public static boolean isWeekend(LocalDate startDate) {
        DayOfWeek day1_OfWeek = DayOfWeek.of(((TemporalAccessor) startDate).get(ChronoField.DAY_OF_WEEK));
        switch (day1_OfWeek) {
            case SATURDAY:
            case SUNDAY:
                return true;
            default:
                return false;
    
        }

    }



    public static void main(String[] args) {

        System.out.println("Welcome to Hotel Reservation Program");
    }
}
