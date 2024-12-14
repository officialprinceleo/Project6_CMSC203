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

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class OrderTestStudent {

    Order order;
    Customer cust;

    @Before
    public void setUp() throws Exception {
        cust = new Customer("Dwight Schrute", 40); // Updated customer details
        order = new Order(9, DAY.FRIDAY, cust); // Testing a weekday order
    }

    @Test
    public void testConstructorAndGetters() {
        assertTrue(order.getOrderNumber() >= 10000 && order.getOrderNumber() <= 99999); // Valid range
        assertEquals(9, order.getOrderTime());
        assertEquals(DAY.FRIDAY, order.getOrderDay());
        assertEquals("Dwight Schrute", order.getCustomer().getName());
        assertEquals(40, order.getCustomer().getAge());
    }

    @Test
    public void testSettersAndUpdates() {
        order.setOrderTime(22); // Late evening order
        order.setOrderDay(DAY.SUNDAY); // Weekend
        Customer newCust = new Customer("Angela Martin", 35);
        order.setCustomer(newCust);

        assertEquals(22, order.getOrderTime());
        assertEquals(DAY.SUNDAY, order.getOrderDay());
        assertEquals("Angela Martin", order.getCustomer().getName());
        assertEquals(35, order.getCustomer().getAge());
    }

    @Test
    public void testIsWeekend() {
        assertFalse(order.isWeekend()); // Initially a Friday
        order.setOrderDay(DAY.SATURDAY);
        assertTrue(order.isWeekend()); // Now a weekend day
        order.setOrderDay(DAY.SUNDAY);
        assertTrue(order.isWeekend()); // Another weekend day
    }

    @Test
    public void testAddNewBeverageSmoothieWithEdgeValues() {
        order.addNewBeverage("Green Power", SIZE.SMALL, 0, false); // No fruits, no protein
        order.addNewBeverage("Berry Blast", SIZE.LARGE, 10, true); // Maximum fruits, protein added

        assertEquals(2, order.getTotalItems());
        Beverage smallSmoothie = order.getBeverage(0);
        Beverage largeSmoothie = order.getBeverage(1);

        assertTrue(smallSmoothie instanceof Smoothie);
        assertTrue(largeSmoothie instanceof Smoothie);
        assertEquals("Green Power", smallSmoothie.getBevName());
        assertEquals("Berry Blast", largeSmoothie.getBevName());
    }

    @Test
    public void testAddMultipleAlcoholOrders() {
        order.addNewBeverage("Whiskey", SIZE.SMALL);
        order.addNewBeverage("Wine", SIZE.MEDIUM);
        order.addNewBeverage("Beer", SIZE.LARGE);

        assertEquals(3, order.getTotalItems());
        assertTrue(order.getBeverage(0) instanceof Alcohol);
        assertTrue(order.getBeverage(1) instanceof Alcohol);
        assertTrue(order.getBeverage(2) instanceof Alcohol);
    }

    @Test
    public void testCalcOrderTotalWithMixedItems() {
        order.addNewBeverage("Espresso", SIZE.SMALL, true, false); // Coffee: Small + Extra Shot
        order.addNewBeverage("Vodka", SIZE.MEDIUM); // Alcohol
        order.addNewBeverage("Tropical Smoothie", SIZE.LARGE, 3, true); // Smoothie: Large + 3 Fruits + Protein

        double total = order.calcOrderTotal();

        // Assuming example prices:
        // - Espresso: 2.0 (base) + 0.5 (extra shot) = 2.5
        // - Vodka: 3.0 (base) + 1.0 (medium size) = 4.0
        // - Tropical Smoothie: 3.0 (base) + 1.5 (large size) + 1.5 (3 fruits) + 1.5 (protein) = 7.5
        // Total = 2.5 + 4.0 + 7.5 = 14.0
        assertEquals(14.0, total, 0.01); // Adjust based on actual pricing logic
    }

    @Test
    public void testFindNumOfBeveTypeEdgeCases() {
        // Add multiple beverages of different types
        order.addNewBeverage("Mocha", SIZE.MEDIUM, false, true); // Coffee
        order.addNewBeverage("Red Wine", SIZE.SMALL); // Alcohol
        order.addNewBeverage("Strawberry Smoothie", SIZE.SMALL, 1, false); // Smoothie
        order.addNewBeverage("Latte", SIZE.LARGE, true, true); // Another Coffee
        order.addNewBeverage("Beer", SIZE.MEDIUM); // Another Alcohol

        assertEquals(2, order.findNumOfBeveType(TYPE.COFFEE)); // 2 Coffees
        assertEquals(2, order.findNumOfBeveType(TYPE.ALCOHOL)); // 2 Alcohol
        assertEquals(1, order.findNumOfBeveType(TYPE.SMOOTHIE)); // 1 Smoothie
    }

    @Test
    public void testCompareToForOrderNumbers() {
        Customer c2 = new Customer("Stanley Hudson", 58);
        Order order2 = new Order(18, DAY.MONDAY, c2);

        int result = order.compareTo(order2);

        // Depending on the random order number:
        // - If order's number > order2's number, result = 1
        // - If order's number < order2's number, result = -1
        // - If order numbers are the same, result = 0
        assertTrue(result == -1 || result == 0 || result == 1);
    }

    @Test
    public void testToStringWithMultipleBeverages() {
        order.addNewBeverage("Cappuccino", SIZE.SMALL, false, true); // Coffee
        order.addNewBeverage("Chardonnay", SIZE.LARGE); // Alcohol

        String output = order.toString();

        assertTrue(output.contains("Order Number:"));
        assertTrue(output.contains("Order Time: 9"));
        assertTrue(output.contains("Order Day: FRIDAY"));
        assertTrue(output.contains("Dwight Schrute"));
        assertTrue(output.contains("Cappuccino"));
        assertTrue(output.contains("Chardonnay"));
    }
}
