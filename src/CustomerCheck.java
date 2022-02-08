
import java.util.ArrayList;

public class CustomerCheck
{
    /** The check for a customer or group of customers
     *  Guaranteed to contain at least one MenuItem and all entries are non-null
     */
    private ArrayList<MenuItem> check;

    /* Constructor */
    public CustomerCheck(ArrayList<MenuItem> check)
    {
        this.check = check;
    }

    /** Returns the total of all MenuItem prices on the check,
     *  as described in part (a)
     */
    public double totalPrices()
    {
        /* to be implemented in part (a) */
        double total = 0;
        for (MenuItem i : check){
            total += i.getPrice();
        }
        return total;
    }


    /** Returns true if the restaurant’s coupon offer can be applied to this check and
     *  returns false otherwise, as described in part (b) */
    public boolean couponApplies()
    {
        /* to be implemented in part (b) */
        for (MenuItem i : check){
            if (i.isDailySpecial()){
                return false;
            }
        }
        if (totalPrices() < 40){
            return false;
        }
        return true;
    }


    /** Calculates the final cost of this check, as described in part (c) */
    public double calculateCheck() {
        double tip = 0;
        double discount = 0;
        int customer = 0;

        double finalc =totalPrices();
        for (MenuItem i : check) {
            if (i.isEntree()) {
                customer++;
            }
        }
        if (couponApplies()){
            discount = finalc * 0.25;
        }
        if (customer >= 6){
            tip = finalc * 0.2;
        }
        /* to be implemented in part (c) */
        return finalc - discount + tip;
    }

}