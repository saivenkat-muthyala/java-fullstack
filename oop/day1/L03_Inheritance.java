package oop.day1;
public class L03_Inheritance {
    public static void main(String[] args) {
        Car1 myCar = new Car1();
        myCar.honk(); // Calling inherited method from super class

        System.out.println(myCar.brand + " " + myCar.modelName);
    }
}

// Super class
class Vehicle1 {
    protected String brand = "Maruti Suzuki"; // Accessible to subclasses

    public void honk(){
        System.out.println("Tutu Tutu");
    }

}

class Car1 extends Vehicle1 {
    public String modelName = "Brezza";
}
