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

class CoffeeTestStudent {
    Coffee test1, test2, test3;

    @BeforeEach
    void setUp() throws Exception {
        // Adjusting data for variety in testing
        test1 = new Coffee("Espresso", SIZE.LARGE, true, false); // Extra shot, no syrup
        test2 = new Coffee("Cappuccino", SIZE.SMALL, false, true); // No extra shot, syrup added
        test3 = new Coffee("Espresso", SIZE.LARGE, true, false); // Same as test1 for equals testing
    }

    @AfterEach
    void tearDown() throws Exception {
        test1 = test2 = test3 = null;
    }

    @Test
    void testCalcPrice() {
        // Assuming large size adds a base price, extra shot adds cost
        assertEquals(4.5, test1.calcPrice(), 0.01); // Adjusted expected price for Large + Extra Shot
        assertEquals(3.0, test2.calcPrice(), 0.01); // Adjusted expected price for Small + Syrup
    }

    @Test
    void testEquals() {
        assertTrue(test1.equals(test3)); // Same attributes
        assertFalse(test2.equals(test1)); // Different attributes
    }

    @Test
    void testToString() {
        assertEquals("Espresso, LARGE\n"
                + " Extra shot of Coffee added\n"
                + " Price: 4.5", test1.toString());

        assertEquals("Cappuccino, SMALL\n"
                + " Syrup added\n"
                + " Price: 3.0", test2.toString());
    }
}
