package HotelReservation;

public class PriceCalculator {
    public static double calculate(Reservation reservation) {
        double beforeDiscount = (reservation.getPricePerDay() * reservation.getSeason().getMultiplier()) * reservation.getNumberOfDays();
        double afterDiscount = beforeDiscount - (beforeDiscount * (reservation.getDiscountType().getDiscount() / 100.0));
        return afterDiscount;
    }
}
