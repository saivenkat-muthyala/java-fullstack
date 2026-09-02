package oop.day1;

public class L09_ExceptionHandling {
    public static void main(String[] args) {
        try {
            int data = 50 / 0; // Throws ArithmeticException
            System.out.println(data);
        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero: " + e.getMessage());
        } catch (NullPointerException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Multi-catch block handled: " + e.getMessage());
        } finally {
            System.out.println("This block always runs.");
        }
    }
}
