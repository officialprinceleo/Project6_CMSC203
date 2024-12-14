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

public class Customer {

    private String name;
    private int age;

    /**
     * Constructor
     * 
     * @param name Customer's name
     * @param age  Customer's age
     */
    public Customer(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * Copy constructor
     * 
     * @param c The customer to copy
     */
    public Customer(Customer c) {
        this.name = new String(c.getName()); // Ensures a new string object
        this.age = c.getAge();
    }

    /**
     * Gets the customer's name.
     * 
     * @return The customer's name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the customer's name.
     * 
     * @param name The new name for the customer
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the customer's age.
     * 
     * @return The customer's age
     */
    public int getAge() {
        return age;
    }

    /**
     * Sets the customer's age.
     * 
     * @param age The new age for the customer
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * String representation of the customer includes the name and age of the
     * customer.
     * 
     * @return A string containing the customer information
     */
    @Override
    public String toString() {
        return String.format("Customer name= %s\n age= %d", name, age);
    }
}
