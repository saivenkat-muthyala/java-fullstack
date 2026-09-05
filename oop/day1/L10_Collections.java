package oop.day1;
import java.util.*;
public class L10_Collections {
    public static void main(String[] args) {
        
        // List<Integer> array = new ArrayList<>();

        // we can simply change the implementation, 
        // the rest of code works fine with LinkedList as well, because both ArrayList and LinkedList Implements List
        List<Integer> array = new LinkedList<>();
        array.add(10);
        System.out.println(array.size());
  
    }
}
