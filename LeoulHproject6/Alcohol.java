/*
 * Class: CMSC203 
 * Instructor: Prof. Ahmed Tarek
 * Description: This App shows people if they can order certain drinks and shows the total. 
 * Due: 12/12/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently. 
 * I have not copied the code from a student or any source. 
 * I have not given my code to any student.
 * Print your Name here: Leoul Hailu Woldeyes
*/
package LeoulHproject6;

public class Alcohol extends Beverage {

    static final double WEEKEND_PRICE = 0.6;
    private boolean isWeekend;

    /**
     * Creates an Alcohol object using given values
     * 
     * @param bevName
     * @param size
     * @param isWeekend
     */
    public Alcohol(String bevName, SIZE size, boolean isWeekend) {
        super(bevName, TYPE.ALCOHOL, size);
        this.isWeekend = isWeekend;
    }

    /**
     * Calculates the price of the alcohol
     * 
     * @return - the price of an alcohol beverage
     */
    @Override
    public double calcPrice() {
        // Using switch to handle price calculation based on isWeekend
        return switch (isWeekend ? 1 : 0) {
            case 1 -> super.addSizePrice() + WEEKEND_PRICE; // Weekend pricing
            default -> super.addSizePrice(); // Regular pricing
        };
    }

    /**
     * Checks if this Beverage equals to anotherBev
     * 
     * @return - true if the name, type, size, base price, and whether beverage is
     *         offered on weekend are the same, false otherwise
     */
    @Override
    public boolean equals(Object anotherBev) {
        if (anotherBev instanceof Alcohol) {
            Alcohol test = (Alcohol) anotherBev;
            return super.equals(test) && this.isWeekend == test.isWeekend;
        }
        return false;
    }

    /**
     * Checks if it is weekend.
     * 
     * @return - true, if it is weekend
     */
    public boolean isWeekend() {
        return isWeekend;
    }

    public void setWeekend(boolean isWeekend) {
        this.isWeekend = isWeekend;
    }

    /**
     * String representation of Alcohol beverage, includes the name, size, whether
     * or not beverage is offered on weekends, and the price
     * 
     * @return - a string containing the information of an alcohol beverage
     */
    @Override
    public String toString() {
        // Using switch to construct the string based on isWeekend
        return switch (isWeekend ? 1 : 0) {
            case 1 -> super.toString() + "\n Drink is offered on weekends for 0.60$ extra\n Price: " + calcPrice();
            default -> super.toString() + "\n Price: " + calcPrice();
        };
    }
}
