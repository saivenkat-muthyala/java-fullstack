package oop.day1;

public class L01_classesAndObjects {
    String color; // State (Attributes)
    int speed;

    void accelarate(){ // Behavior (Methods)
        speed+=10;
    }

}

// Object Instantiation
class Main{
    public static void main(String[] args) {
        L01_classesAndObjects car1 = new L01_classesAndObjects(); // Object creation
        car1.color = "Red"; // Setting attribute

    }
}
