package oop.day1;
public class L08_Constructors {
    public static void main(String[] args) {
        Food burger = new Food("Burger", 20);
        burger.printFood();
    }
}

class Food {
    String name;
    int quantity;

    Food(){
        System.out.println("This is a No Arguement constructor");
    }

    Food(String name,int quantity){
        System.out.println("Parameterized Constructor");
        this.name = name;
        this.quantity = quantity;
    }

    Food(Food otherFood){
        System.out.println("Copy COnstructor");
        this.name=otherFood.name;
        this.quantity=otherFood.quantity;
    }

    void printFood(){
        System.out.println("The food name is "+this.name);
    }
}