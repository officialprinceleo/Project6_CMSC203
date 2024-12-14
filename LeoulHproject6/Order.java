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

import java.util.ArrayList;
import java.util.Random;

public class Order implements OrderInterface, Comparable<Order> {

    private int orderNumber;
    private int orderTime;
    private DAY orderDay;
    private Customer cust;
    private ArrayList<Beverage> bevList = new ArrayList<>();

    /**
     * Constructor that sets up an order with its details: time, day, and customer.
     * Each order gets a unique identifier generated automatically.
     * 
     * @param orderTime The time when the order was placed
     * @param orderDay  The day when the order was placed
     * @param cust      The customer placing the order
     */
    public Order(int orderTime, DAY orderDay, Customer cust) {
        this.orderTime = orderTime;
        this.orderDay = orderDay;
        this.cust = cust;
        this.orderNumber = generateOrder();
    }

    /**
     * Returns the unique number assigned to this order.
     * 
     * @return The order's unique number
     */
    public int getOrderNumber() {
        return orderNumber;
    }

    /**
     * Alternate method to retrieve the order number, for flexibility in naming.
     * 
     * @return The order's unique number
     */
    public int getOrderNo() {
        return orderNumber;
    }

    /**
     * Manually updates the order's unique number.
     * 
     * @param orderNumber The new order number
     */
    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    /**
     * Retrieves the time when the order was placed.
     * 
     * @return The order time
     */
    public int getOrderTime() {
        return orderTime;
    }

    /**
     * Updates the time associated with this order.
     * 
     * @param orderTime The new time for the order
     */
    public void setOrderTime(int orderTime) {
        this.orderTime = orderTime;
    }

    /**
     * Retrieves the day when the order was placed.
     * 
     * @return The day of the order
     */
    public DAY getOrderDay() {
        return orderDay;
    }

    /**
     * An alternate method to retrieve the order day, offering more intuitive naming.
     * 
     * @return The day of the order
     */
    public DAY getDay() {
        return orderDay;
    }

    /**
     * Updates the day associated with this order.
     * 
     * @param orderDay The new day for the order
     */
    public void setOrderDay(DAY orderDay) {
        this.orderDay = orderDay;
    }

    /**
     * Retrieves the customer linked to this order.
     * 
     * @return The customer who placed the order
     */
    public Customer getCustomer() {
        return cust;
    }

    /**
     * Associates a different customer with this order.
     * 
     * @param cust The customer to be linked with the order
     */
    public void setCustomer(Customer cust) {
        this.cust = cust;
    }

    /**
     * Generates a random unique identifier for the order.
     * This identifier ensures orders can be easily tracked.
     * 
     * @return A random order number within a specified range
     */
    public int generateOrder() {
        Random rand = new Random();
        return rand.nextInt(90000 - 10000 + 1) + 10000;
    }

    /**
     * Compares this order with another based on their unique identifiers.
     * 
     * @param o The other order to compare with
     * @return 1 if this order's number is larger, 0 if equal, -1 if smaller
     */
    @Override
    public int compareTo(Order o) {
        return Integer.compare(this.orderNumber, o.getOrderNumber());
    }

    /**
     * Determines if the order was placed on a weekend.
     * 
     * @return True if the day is Saturday or Sunday, false otherwise
     */
    @Override
    public boolean isWeekend() {
        return (orderDay == DAY.SATURDAY || orderDay == DAY.SUNDAY);
    }

    /**
     * Retrieves a beverage from the order based on its position in the list.
     * 
     * @param itemNo The index of the beverage
     * @return The beverage at the specified index
     */
    @Override
    public Beverage getBeverage(int itemNo) {
        return bevList.get(itemNo);
    }

    /**
     * Adds a coffee beverage to the order with specified options.
     * 
     * @param bevName    The name of the coffee
     * @param size       The size of the coffee
     * @param extraShot  Whether an extra shot is added
     * @param extraSyrup Whether extra syrup is added
     */
    @Override
    public void addNewBeverage(String bevName, SIZE size, boolean extraShot, boolean extraSyrup) {
        bevList.add(new Coffee(bevName, size, extraShot, extraSyrup));
    }

    /**
     * Adds an alcoholic beverage to the order.
     * 
     * @param bevName The name of the alcohol
     * @param size    The size of the alcohol
     */
    @Override
    public void addNewBeverage(String bevName, SIZE size) {
        bevList.add(new Alcohol(bevName, size, isWeekend()));
    }

    /**
     * Adds a smoothie beverage to the order with specified options.
     * 
     * @param bevName     The name of the smoothie
     * @param size        The size of the smoothie
     * @param numOfFruits The number of fruits added
     * @param addProtein  Whether protein is added
     */
    @Override
    public void addNewBeverage(String bevName, SIZE size, int numOfFruits, boolean addProtein) {
        bevList.add(new Smoothie(bevName, size, numOfFruits, addProtein));
    }

    /**
     * Calculates the total cost of the order by summing up the prices of all beverages.
     * 
     * @return The total cost of the order
     */
    @Override
    public double calcOrderTotal() {
        return bevList.stream().mapToDouble(Beverage::calcPrice).sum();
    }

    /**
     * Counts the number of beverages of a specific type in the order.
     * 
     * @param type The type of beverage to count
     * @return The number of beverages of the specified type
     */
    @Override
    public int findNumOfBeveType(TYPE type) {
        return (int) bevList.stream().filter(bev -> bev.getType() == type).count();
    }

    /**
     * Retrieves the total number of items (beverages) in this order.
     * 
     * @return The number of beverages in the order
     */
    public int getTotalItems() {
        return bevList.size();
    }

    /**
     * Returns a string representation of the order, including all beverages and the total cost.
     * 
     * @return A string describing the order details
     */
    @Override
    public String toString() {
        StringBuilder details = new StringBuilder();
        bevList.forEach(bev -> details.append(bev.toString()).append("\n"));

        return String.format("Order Number: %d\nOrder Time: %d\nOrder Day: %s\nCustomer Name: %s\nCustomer Age: %d\n%sOrder Total: %.2f",
                getOrderNumber(), getOrderTime(), getOrderDay(), getCustomer().getName(),
                getCustomer().getAge(), details, calcOrderTotal());
    }
}
