public class Hotel {

    public String hotelName;
    public int HotelRateRegularWeekDay;
    public int HotelRateRegularWeekEnd;
    public int Ratings;

    public int getRatings() {
        return Ratings;
    }

    public void setRatings(int ratings) {
        Ratings = ratings;
    }

    public int getHotelRateRegularWeekEnd() {
        return HotelRateRegularWeekEnd;
    }

    public void setHotelRateRegularWeekEnd(int hotelRateRegularWeekEnd) {
        HotelRateRegularWeekEnd = hotelRateRegularWeekEnd;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public int getHotelRateRegularWeekDay() {
        return HotelRateRegularWeekDay;
    }

    public void setHotelRateRegularWeekDay(int HotelRateRegularWeekDay) {
        this.HotelRateRegularWeekDay = HotelRateRegularWeekDay;
    }

    public Hotel(String hotelName, int HotelRateRegularWeekDay , int HotelRateRegularWeekEnd, int Ratings) {
        super();
        this.hotelName = hotelName;
        this.HotelRateRegularWeekDay = HotelRateRegularWeekDay;
        this.HotelRateRegularWeekEnd = HotelRateRegularWeekEnd;
        this.Ratings = Ratings;

    }
}