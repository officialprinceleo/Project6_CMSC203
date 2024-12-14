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

class CustomerTestStudent {
    Customer test;

    @BeforeEach
    void setUp() throws Exception {
        test = new Customer("Alice", 30); // Updated name and age
    }

    @AfterEach
    void tearDown() throws Exception {
        test = null;
    }

    @Test
    void testToString() {
        assertEquals("Customer name= Alice\n"
                + " age= 30", test.toString());
    }

    @Test
    void testSetName() {
        test.setName("Bob");
        assertEquals("Bob", test.getName()); // Verify name update
    }

    @Test
    void testSetAge() {
        test.setAge(35);
        assertEquals(35, test.getAge()); // Verify age update
    }

    @Test
    void testEquals() {
        Customer sameCustomer = new Customer("Alice", 30);
        Customer differentCustomer = new Customer("Charlie", 25);

        assertTrue(test.equals(sameCustomer)); // Same attributes
        assertFalse(test.equals(differentCustomer)); // Different attributes
    }
}
