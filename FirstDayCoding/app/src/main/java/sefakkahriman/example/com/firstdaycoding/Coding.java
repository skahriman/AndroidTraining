package sefakkahriman.example.com.firstdaycoding;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Admin on 3/20/2018.
 */
/*find duplicates ina list of strings
1. find duplicates in a list olf strings
2. print duplicate characters in a string
3. Fizz Buzz problem fro integers < 20
Output

 */

public class Coding {
    public static void main(String[] args) {
        System.out.println("Duplicates in a list");
        List<String> strings = Arrays.asList("a", "f", "b", "c", "a", "f");
        findDuplicateString(strings);
        //output: {a, f}
        findDuplicateChars("happybirthday");
        printFizzBuzz();
    }

    public static void findDuplicateChars(String string) {
        System.out.println("duplicates in " + string);
        char [] arr = string.toCharArray();

        for(int i = 0; i < arr.length; i++) {
            for(int j = i+1; j < arr.length; j++) {
                if(arr[i] == arr[j])
                    System.out.println(arr[i]);
            }
        }
    }

    public static void findDuplicateString(List<String> strings) {
        for(int i = 0; i < strings.size(); i++) {
            for(int j = i+1; j < strings.size(); j++) {
                if(strings.get(i).equals(strings.get(j)))
                    System.out.println(strings.get(i));
            }
        }
    }


    public static void printFizzBuzz() {
        for(int i = 0; i < 20; i ++){
            if(i%15 == 0)
                System.out.println(i + " --> FizzBuzz");
            else if(i%3 == 0)
                System.out.println(i + " --> Fizz");
            else if(i%5 == 0)
                System.out.println(i + " --> Buzz");
        }
    }


}
