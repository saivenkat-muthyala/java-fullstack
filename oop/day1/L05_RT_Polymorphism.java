package oop.day1;

public class L05_RT_Polymorphism {
    public static void main(String[] args) {
        Animal myAnimal = new Dog();
        myAnimal.makeSound();
    }
}

class Animal {
    void makeSound(){
        System.out.println("The animal makes a sound");
    }
}

class Dog extends Animal {
    @Override
    void makeSound(){
        System.out.println("The Dog barks");
    }
}