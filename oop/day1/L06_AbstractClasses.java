package oop.day1;
// Abstract Parent Class

abstract class Vehicle {
    // Abstract method (No implementation detail here)
    abstract void startEngine();

    // Concrete method (Shared implementation detail)
    void blowHorn() {
        System.out.println("Beep Beep!");
    }
}

// Subclass inheriting from Vehicle
class Car extends Vehicle {
    
    @Override
    void startEngine() {
        // Concrete implementation specific to a Car
        System.out.println("Car engine started via push-button.");
    }
}

public class L06_AbstractClasses {
    public static void main(String[] args) {
        // Vehicle myVehicle = new Vehicle(); // Error: Cannot instantiate abstract class
        
        Vehicle myCar = new Car(); 
        myCar.startEngine(); // Output: Car engine started via push-button.
        myCar.blowHorn();    // Output: Beep Beep!
    }
}
