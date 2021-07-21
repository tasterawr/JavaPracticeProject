package org.java_plilosophy_tasks;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;

/** Philosophy of Java, Chapter 4. Class for working with "vampire" numbers. Class contains two main static methods and doesn't contain any data.*/
public class VampireNumbers {

    /**Method finds all "vampire" numbers in a specified range.
     * @param startRange Defines the start position of range.
     * @param endRange Defines the end position of range.*/
    public static void getVampireNumbers(int startRange, int endRange){
        for (int i = startRange; i<endRange; i++){
            isVampire(i);
        }
    }

    /**Method checks if provided integer number is "vampire".
     * @param number Specified number.*/
    public static boolean isVampire(int number) {
        String str = String.valueOf(number);
        char[] strCharArray = str.toCharArray();
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < strCharArray.length; i++) {
            for (int j = i; j < strCharArray.length; j++) {
                if (i == j) {
                    numbers.add(strCharArray[i] - '0' * 10 + strCharArray[i] - '0');
                    continue;
                }

                int first = strCharArray[i] - '0';
                int second = strCharArray[j] - '0';

                numbers.add(first * 10 + second);
                numbers.add(second * 10 + first);
            }
        }

        for (int i = 0; i < numbers.size(); i++) {
            for (int j = i; j < numbers.size(); j++) {
                if (numbers.get(i) * numbers.get(j) == number){
                    System.out.println(number + " = " + numbers.get(i) + " * " + numbers.get(j));
                    return true;
                }
            }
        }

        return false;
    }
}
