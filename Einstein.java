package com.company.oldAssignments;

import java.util.Scanner;
import java.lang.Math;

/**
 * class Einstein.
 * This program recieves a 3 digit positive number from the user.
 * It calculates the inverse number of the number given by the user.
 * It then finds the difference between the original number, and its inverse number.
 * It calculates the inverse number of the difference.
 * It calculates the sum of difference and the reversed difference.
 * It shows that no matter which real number between 99 and 999 the user gives, the end result will always be 1089.
 *
 * @author Neta
 * @version 1.0
 * @since 19.03.2016
 */
public class Einstein {
    public static void main(String [] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to the Einstein magic game. \n" +
                "Please enter a 3 digit positive real number whose first and last digits are different:");

        int number = scan.nextInt();
        int firstNumber = number / 100;
        int middleNum = ((number / 10) % 10) * 10;
        int lastNumber = (number % 10) * 1;
        if (number < 0)
            System.out.println("The number you entered is a negative number. That's not what I asked for.");
        else if (number == 0)
            System.out.println("The number you entered is zero. That's not what I asked for.");
        else if (number < 99 || number > 999 || firstNumber == 0 || middleNum == 0)
            System.out.println("The number you entered is not a 3 digit number.");
        else if (firstNumber == lastNumber)
            System.out.println("The first and last digits of the number you entered are equal.\n" +
                    "I asked you to give a number who's first and last digits are different.");
        else {
            System.out.println("User number is: " + number);

            int newFirstNum = lastNumber * 100;
            int newLastNum = firstNumber;
            int inverseNum = newFirstNum + middleNum + newLastNum;
            int difference = Math.abs(number - inverseNum);

            System.out.println("Difference: " + difference);

            int newFirstReversedDifference = (difference%10)*100;
            int middleReversedDifference = ((difference/10)%10)*10;
            int newLastReversedDifference = difference/100;
            int reversedDifference = newFirstReversedDifference + middleReversedDifference + newLastReversedDifference;

            System.out.println("Reversed difference: " + reversedDifference);

            if (difference + reversedDifference == 1089) System.out.println("SUCCEEDED");
            else System.out.println("FAILED");

        }


    }
}
