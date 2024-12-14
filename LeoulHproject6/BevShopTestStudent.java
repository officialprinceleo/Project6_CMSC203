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

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BevShopTestStudent {
    Order orderOne, orderTwo;
    BevShop test;

    @BeforeEach
    void setUp() throws Exception {
        test = new BevShop();
        orderOne = new Order(8, DAY.MONDAY, new Customer("Mary", 22));
        orderTwo = new Order(16, DAY.FRIDAY, new Customer("John", 45)); // Changed time to afternoon
    }

    @AfterEach
    void tearDown() throws Exception {
        orderOne = orderTwo = null;
        test = null;
    }

    @Test
    void testIsValidTime() {
        assertTrue(test.isValidTime(10)); // Morning hours
        assertTrue(test.isValidTime(20)); // Evening hours
        assertFalse(test.isValidTime(2)); // Early morning outside hours
        assertFalse(test.isValidTime(25)); // Invalid time
    }

    @Test
    void testIsMaxFruit() {
        assertFalse(test.isMaxFruit(4)); // Below limit
        assertTrue(test.isMaxFruit(8)); // At limit
    }

    @Test
    void testIsEligibleForMore() {
        test.startNewOrder(12, DAY.WEDNESDAY, "Elliot", 35);
        test.processAlcoholOrder("Whiskey", SIZE.LARGE); // Larger size for testing

        assertTrue(test.isEligibleForMore()); // Still eligible with one drink
        test.processAlcoholOrder("Beer", SIZE.SMALL);
        test.processAlcoholOrder("Wine", SIZE.MEDIUM);

        assertFalse(test.isEligibleForMore()); // Exceeds limit
    }

    @Test
    void testIsValidAge() {
        assertFalse(test.isValidAge(20)); // Borderline invalid
        assertTrue(test.isValidAge(25)); // Valid age
    }

    @Test
    void testStartNewOrder() {
        test.startNewOrder(14, DAY.THURSDAY, "Alice", 30);
        assertEquals("Alice", test.getCurrentOrder().getCustomer().getName());
        assertEquals(DAY.THURSDAY, test.getCurrentOrder().getOrderDay());
    }

    @Test
    void testProcessCoffeeOrder() {
        test.startNewOrder(10, DAY.TUESDAY, "Max", 27);
        test.processCoffeeOrder("Espresso", SIZE.MEDIUM, true, true); // Extra shot and sugar

        assertEquals("Espresso", test.getCurrentOrder().getBeverage(0).getBevName());
        assertEquals(SIZE.MEDIUM, test.getCurrentOrder().getBeverage(0).getSize());
    }

    @Test
    void testProcessAlcoholOrder() {
        test.startNewOrder(13, DAY.FRIDAY, "Emma", 29);
        test.processAlcoholOrder("Champagne", SIZE.LARGE);

        assertEquals(1, test.getNumOfAlcoholDrink());
        assertEquals("Champagne", test.getCurrentOrder().getBeverage(0).getBevName());
        assertEquals(SIZE.LARGE, test.getCurrentOrder().getBeverage(0).getSize());
    }

    @Test
    void testProcessSmoothieOrder() {
        test.startNewOrder(16, DAY.SATURDAY, "Lucas", 40);
        test.processSmoothieOrder("Strawberry Delight", SIZE.MEDIUM, 4, true); // Adding protein powder

        assertEquals("Strawberry Delight", test.getCurrentOrder().getBeverage(0).getBevName());
        assertTrue(((Smoothie) test.getCurrentOrder().getBeverage(0)).getAddProtein());
    }

    @Test
    void testFindOrder() {
        test.startNewOrder(15, DAY.SUNDAY, "Sophia", 34);
        int orderNumber = test.getCurrentOrder().getOrderNumber();
        assertEquals(0, test.findOrder(orderNumber)); // Correct index
    }

    @Test
    void testTotalOrderPrice() {
        test.startNewOrder(9, DAY.MONDAY, "Ella", 25);
        test.processSmoothieOrder("Green Smoothie", SIZE.SMALL, 2, false);
        test.processCoffeeOrder("Cappuccino", SIZE.LARGE, false, true); // Adding sugar

        double expectedPrice = test.getCurrentOrder().calcOrderTotal();
        assertEquals(expectedPrice, test.totalOrderPrice(test.getCurrentOrder().getOrderNumber()), 0.01);
    }

    @Test
    void testTotalMonthlySale() {
        test.startNewOrder(14, DAY.THURSDAY, "Liam", 28);
        test.processCoffeeOrder("Mocha", SIZE.SMALL, true, false);
        test.processSmoothieOrder("Banana Blast", SIZE.LARGE, 5, true);

        double total = test.getCurrentOrder().calcOrderTotal();
        assertEquals(total, test.totalMonthlySale(), 0.01);
    }

    @Test
    void testTotalNumOfMonthlyOrders() {
        test.startNewOrder(10, DAY.MONDAY, "Olivia", 26);
        test.processSmoothieOrder("Mango Tango", SIZE.SMALL, 3, false);

        assertEquals(1, test.totalNumOfMonthlyOrders());
    }

    @Test
    void testGetCurrentOrder() {
        test.startNewOrder(11, DAY.WEDNESDAY, "James", 31);
        test.processSmoothieOrder("Blueberry Blast", SIZE.SMALL, 2, false);

        assertEquals("James", test.getCurrentOrder().getCustomer().getName());
    }

    @Test
    void testGetOrderAtIndex() {
        test.startNewOrder(14, DAY.TUESDAY, "Lily", 29);
        assertEquals(test.getCurrentOrder(), test.getOrderAtIndex(0));
    }

    @Test
    void testSortOrders() {
        test.startNewOrder(11, DAY.SUNDAY, "Alex", 22);
        test.startNewOrder(15, DAY.MONDAY, "Tom", 24);

        test.sortOrders();

        assertTrue(test.getOrderAtIndex(0).getOrderNumber() < test.getOrderAtIndex(1).getOrderNumber());
    }
}
