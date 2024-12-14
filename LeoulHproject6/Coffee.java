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

public class Coffee extends Beverage {

    static final double EXTRA_COFFEE = 0.5;
    static final double EXTRA_SYRUP = 0.5;

    private boolean extraShot;
    private boolean extraSyrup;

    /**
     * Creates a Coffee object using the given values.
     * 
     * @param bevName
     * @param size
     * @param extraShot
     * @param extraSyrup
     */
    Coffee(String bevName, SIZE size, boolean extraShot, boolean extraSyrup) {
        super(bevName, TYPE.COFFEE, size);
        this.extraSyrup = extraSyrup;
        this.extraShot = extraShot;
    }

    /**
     * Gets value for extra shot.
     * 
     * @return - value for extra shot
     */
    public boolean getExtraShot() {
        return extraShot;
    }

    /**
     * Sets value for extra shot.
     * 
     * @param extraShot
     */
    public void setExtraShot(boolean extraShot) {
        this.extraShot = extraShot;
    }

    /**
     * Gets value for extra syrup.
     * 
     * @return - value for extra syrup
     */
    public boolean getExtraSyrup() {
        return extraSyrup;
    }

    /**
     * Sets value for extra syrup.
     * 
     * @param extraSyrup
     */
    public void setExtraSyrup(boolean extraSyrup) {
        this.extraSyrup = extraSyrup;
    }

    /**
     * Calculates the price based on base price, size, extra coffee shot, and extra
     * syrup.
     * 
     * @return - Price of coffee based on specification
     */
    @Override
    public double calcPrice() {
        int extras = (extraShot ? 1 : 0) + (extraSyrup ? 2 : 0); // Encode options as bit flags
        return switch (extras) {
            case 3 -> super.addSizePrice() + EXTRA_COFFEE + EXTRA_SYRUP; // Both extras
            case 2 -> super.addSizePrice() + EXTRA_SYRUP; // Syrup only
            case 1 -> super.addSizePrice() + EXTRA_COFFEE; // Coffee shot only
            default -> super.addSizePrice(); // No extras
        };
    }

    /**
     * Checks if this Beverage equals to anotherBev.
     * 
     * @return - true if the name, type, size, base price, and whether or not it
     *         contains extra shot and extra syrup, false otherwise
     */
    @Override
    public boolean equals(Object anotherBev) {
        if (anotherBev instanceof Coffee) {
            Coffee test = (Coffee) anotherBev;
            return super.equals(test) && this.extraShot == test.extraShot && this.extraSyrup == test.extraSyrup;
        }
        return false;
    }

    /**
     * Represents a Coffee beverage in the following String format: name, size,
     * whether it contains extra shot, extra syrup, and the price.
     * 
     * @return - String representation of a Coffee
     */
    @Override
    public String toString() {
        int extras = (extraShot ? 1 : 0) + (extraSyrup ? 2 : 0); // Encode options as bit flags
        return switch (extras) {
            case 3 -> super.toString() + "\n Extra shot of Coffee and Syrup added" + "\n Price: " + calcPrice();
            case 2 -> super.toString() + "\n Extra shot of Syrup added" + "\n Price: " + calcPrice();
            case 1 -> super.toString() + "\n Extra shot of Coffee added" + "\n Price: " + calcPrice();
            default -> super.toString() + "\n Price: " + calcPrice();
        };
    }
}
