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



public abstract class Beverage {
    private String bevName;
    private TYPE type;
    private SIZE size;
    private static final double BASE_PRICE = 2.0;
    private static final double SIZE_UPCHARGE = 1.0;

    public Beverage(String bevName, TYPE type, SIZE size) {
        this.bevName = bevName;
        this.type = type;
        this.size = size;
    }

    public String getBevName() {
        return bevName;
    }

    public TYPE getType() {
        return type;
    }

    public SIZE getSize() {
        return size;
    }

    public double getBasePrice() {
        return BASE_PRICE;
    }

    public double addSizePrice() {
        switch (size) {
            case MEDIUM:
                return BASE_PRICE + SIZE_UPCHARGE;
            case LARGE:
                return BASE_PRICE + 2 * SIZE_UPCHARGE;
            default:
                return BASE_PRICE;
        }
    }

    public abstract double calcPrice();

    @Override
    public String toString() {
        return bevName + ", " + size;
    }
}
