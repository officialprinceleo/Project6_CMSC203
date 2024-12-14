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

class SmoothieTestStudent {
    Smoothie test1, test2, test3;

    @BeforeEach
    void setUp() throws Exception {
        // Updated test cases for variety and edge cases
        test1 = new Smoothie("Berry Blast", SIZE.LARGE, 5, true); // Large smoothie, max fruits, protein added
        test2 = new Smoothie("Tropical Delight", SIZE.SMALL, 1, false); // Small smoothie, minimal fruits, no protein
        test3 = new Smoothie("Berry Blast", SIZE.LARGE, 5, true); // Same as test1 for equality testing
    }

    @AfterEach
    void tearDown() throws Exception {
        test1 = test2 = test3 = null;
    }

    @Test
    void testCalcPrice() {
        // Assuming base price = 3.0, large size +1.5, fruits @0.5 each, protein +1.5
        // Total: 3.0 (base) + 1.5 (large) + 2.5 (5 fruits) + 1.5 (protein) = 8.5
        assertEquals(8.5, test1.calcPrice());

        // Small smoothie: 3.0 (base) + 0 (small) + 0.5 (1 fruit) + 0 (no protein) = 3.5
        assertEquals(3.5, test2.calcPrice());
    }

    @Test
    void testEquals() {
        assertTrue(test1.equals(test3)); // Same attributes
        assertFalse(test2.equals(test1)); // Different attributes
    }

    @Test
    void testToString() {
        assertEquals("Berry Blast, LARGE\n"
                + " Protein added to smoothie \n"
                + " Number of Fruit: 5\n"
                + " Price: 8.5", test1.toString());

        assertEquals("Tropical Delight, SMALL\n"
                + " No protein added to smoothie \n"
                + " Number of Fruit: 1\n"
                + " Price: 3.5", test2.toString());
    }

    @Test
    void testEdgeCases() {
        Smoothie noFruitNoProtein = new Smoothie("Simple Smoothie", SIZE.MEDIUM, 0, false);
        Smoothie maxFruitAndProtein = new Smoothie("Max Smoothie", SIZE.LARGE, 10, true);

        // No fruits, no protein: 3.0 (base) + 1.0 (medium) + 0.0 = 4.0
        assertEquals(4.0, noFruitNoProtein.calcPrice());

        // Max fruits, with protein: 3.0 (base) + 1.5 (large) + 5.0 (10 fruits) + 1.5 (protein) = 11.0
        assertEquals(11.0, maxFruitAndProtein.calcPrice());
    }
}
