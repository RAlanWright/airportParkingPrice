import java.util.Scanner;

public class AirportParking {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("How many minutes were you parked for?");
        int totalMinutes = input.nextInt(); // Input in minutes
        int dayInMinutes = 1440; // Minutes in a day
        int days = totalMinutes / dayInMinutes; // Total days not including partial days
        int leftoverMinutes = totalMinutes % dayInMinutes; // Partial day in minutes
        int splitBy30Min = leftoverMinutes / 30; // Splits remaining time into 30 minute increments
        int priceTotalDays = days * 24; // Price for the days not including partial days

        int priceForParking;

        // Free or not?
        if ((totalMinutes >= 0) && (totalMinutes <= 30)) {
            System.out.println("The price for parking was: Free!!");
        }

        // Within the first hour not including 30 minute mark
        else if ((totalMinutes >= 31) && (totalMinutes <= 60)){
            priceForParking = 2;
            System.out.println("The price for parking was: $" + priceForParking);
        }

        // Between final rounded up 30 minute mark and first 30 minute mark of following day
        else if ((totalMinutes >= 691) && (totalMinutes <= 1470)) {
            priceForParking = 24;
            System.out.println("The price for parking was: $" + priceForParking);
        }

        // Handle case where minutes exceed a 24.5 hour period
        else if ((totalMinutes % dayInMinutes >= 0) && (totalMinutes % dayInMinutes <= 30)) {
            priceForParking = priceTotalDays; // priceForParking = (input / 1440) * 24
            System.out.println("The price for parking was: $" + priceForParking);
        }

        // Handle remainder above or equal to daily cap
        // Remainder will never exceed 1439
        // This will force flat $24 added to the cap price times number of days parked
        else if (leftoverMinutes >= 691){
            priceForParking = priceTotalDays + 24;
            System.out.println("The price for parking was: $" + priceForParking);
        }

        // Handles rounding up to the next half hour mark
        else if (leftoverMinutes % 30 != 0){
            priceForParking = priceTotalDays + (splitBy30Min + 1);
            System.out.println("The price for parking was: $" + priceForParking);
        }

        // Counts 30 minute increments if below 691 minutes total
        else if ((totalMinutes < 691) && (totalMinutes % 30 == 0)) {
            priceForParking = splitBy30Min;
            System.out.println("The price for parking was: $" + priceForParking);
        }

        // Redundant condition to be removed
        else if ((totalMinutes < 691) && (totalMinutes % 30 != 0)){
            priceForParking = (splitBy30Min / 30) + 1;
            System.out.println("The price for parking was: $" + priceForParking);
        }
    }
}