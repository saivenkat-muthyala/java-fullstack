package oop.day1;

public class L04_CT_Polymorphism {
    public static void main(String[] args) {
        Calculator c = new Calculator();
        System.out.println(c.add(2, 3));
        System.out.println(c.add(1,2, 3));
    }
}

class Calculator {
    // method overloading
    public int add(int a,int b){
        return a+b;
    }

    public int add(int a, int b, int c){
        return a+b+c;
    }
}