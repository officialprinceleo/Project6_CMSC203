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

class AlcoholTestStudent {
    Alcohol test1, test2, test3, test4; // Added test4 for additional testing

    @BeforeEach
    void setUp() throws Exception {
        test1 = new Alcohol("Beer", SIZE.MEDIUM, true);
        test2 = new Alcohol("Wine", SIZE.MEDIUM, false);
        test3 = new Alcohol("Beer", SIZE.MEDIUM, true);
        test4 = new Alcohol("Cocktail", SIZE.LARGE, true); // New Alcohol instance
    }

    @AfterEach
    void tearDown() throws Exception {
        test1 = test2 = test3 = test4 = null;
    }

    @Test
    void testCalcPrice() {
        assertEquals(3.6, test1.calcPrice());
        assertEquals(5.4, test4.calcPrice()); // Test LARGE size price calculation
    }

    @Test
    void testEquals() {
        assertTrue(test1.equals(test3));
        assertFalse(test2.equals(test1));
        assertFalse(test4.equals(test1)); // Ensure test4 is not equal to test1
    }

    @Test
    void testToString() {
        assertEquals("Beer, MEDIUM\n"
                + " Drink is offered on weekends for 0.60$ extra\n"
                + " Price: 3.6", test1.toString());
        assertEquals("Cocktail, LARGE\n"
                + " Drink is offered on weekends for 0.90$ extra\n"
                + " Price: 5.4", test4.toString());
    }

    @Test
    void testIsWeekend() {
        assertTrue(test1.isWeekend());
        assertFalse(test2.isWeekend());
        assertTrue(test4.isWeekend()); // Check weekend condition for test4
    }

    // New test for edge case
    @Test
    void testNoWeekendSurcharge() {
        Alcohol test5 = new Alcohol("Juice", SIZE.SMALL, false);
        assertEquals(2.0, test5.calcPrice()); // Ensure no weekend surcharge is applied
    }
}
