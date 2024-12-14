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

public class Smoothie extends Beverage {

    static final double FRUIT_FEE = 0.50; // Cost per additional fruit
    static final double PROTEIN_FEE = 1.50; // Cost for adding protein

    private int numOfFruits; // Number of fruits added to the smoothie
    private boolean addProtein; // Whether protein is added

    /**
     * Constructor to initialize a Smoothie object with specified attributes.
     * 
     * @param bevName    The name of the smoothie
     * @param size       The size of the smoothie (SMALL, MEDIUM, LARGE)
     * @param numOfFruits The number of fruits added
     * @param addProtein Whether protein is added to the smoothie
     */
    public Smoothie(String bevName, SIZE size, int numOfFruits, boolean addProtein) {
        super(bevName, TYPE.SMOOTHIE, size);
        this.addProtein = addProtein;
        this.numOfFruits = numOfFruits;
    }

    /**
     * Retrieves the number of fruits in the smoothie.
     * 
     * @return The number of fruits
     */
    public int getNumOfFruits() {
        return numOfFruits;
    }

    /**
     * Sets the number of fruits in the smoothie.
     * 
     * @param numOfFruits The new number of fruits
     */
    public void setNumOfFruits(int numOfFruits) {
        this.numOfFruits = numOfFruits;
    }

    /**
     * Checks if protein is added to the smoothie.
     * 
     * @return True if protein is added, false otherwise
     */
    public boolean getAddProtein() {
        return addProtein;
    }

    /**
     * Updates whether protein is added to the smoothie.
     * 
     * @param addProtein True to add protein, false to remove it
     */
    public void setAddProtein(boolean addProtein) {
        this.addProtein = addProtein;
    }

    /**
     * Compares this Smoothie object to another beverage to determine equality.
     * 
     * @param anotherBev The other beverage to compare with
     * @return True if the beverages are identical, false otherwise
     */
    @Override
    public boolean equals(Object anotherBev) {
        if (anotherBev instanceof Smoothie) {
            Smoothie otherSmoothie = (Smoothie) anotherBev;
            return super.equals(otherSmoothie) &&
                   this.numOfFruits == otherSmoothie.numOfFruits &&
                   this.addProtein == otherSmoothie.addProtein;
        }
        return false;
    }

    /**
     * Calculates the price of the smoothie based on its size, number of fruits, and
     * whether protein is added.
     * 
     * @return The total price of the smoothie
     */
    @Override
    public double calcPrice() {
        double basePrice = super.addSizePrice();
        double fruitCost = FRUIT_FEE * this.numOfFruits;
        double proteinCost = this.addProtein ? PROTEIN_FEE : 0.0;
        return basePrice + fruitCost + proteinCost;
    }

    /**
     * Returns a string representation of the smoothie, detailing its attributes.
     * 
     * @return A string describing the smoothie
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append("\n Number of Fruits: ").append(this.numOfFruits);
        if (this.addProtein) {
            sb.append("\n Protein added");
        }
        sb.append("\n Price: ").append(calcPrice());
        return sb.toString();
    }
}
