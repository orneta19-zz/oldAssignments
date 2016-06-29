package com.company.oldAssignments;

import java.lang.Math;
import java.util.Scanner;
import java.lang.Double;
/**
 * class Triangle.
 * This program recieves the three sides of a triangle from a user.
 * It calculates the area and the perimeter of a given triangle using Heron's formula.
 * Heron's formula is as such:
 * (sqrt)[s(s-a)(s-b)(s-c)]
 * Where:
 * s = semiPerimeter
 * a = sideA of the triangle
 * b = sideB of the triangle
 * c = sideC of the triangle
 *
 * The first 'if statement' checks the mathematical validity of the triangle.
 * It follows the mathematical assumption that:
 * For any triangle, the sum resulting from the addition of two sides must be larger than the third side, as:
 * a + b > c
 * a + c > b
 * b + c > a
 *
 * The third 'if statement' checks whether the triangle given is degenerate.
 * It follows the mathematical assumption that:
 * A degenerate triangle is the "triangle" formed by three collinear points.
 * It doesn't look like a triangle, it looks like a line segment. Therefore its area cannot be calculated.
 * A degenerate triangle's two sides equal the third side, as:
 * a + b = c
 * a + c = b
 * b + c = a
 *
 * @author Neta
 * @version 1.0
 * @since 19.03.2016
 */
public class Triangle
{
    public static void main(String [] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("This program calculates the area and the perimeter" +
                " of a given triangle using Heron's formula.\n" +
                "Please only enter natural numbers.");

        System.out.println("Please enter the length of side A of the triangle.");
        int sideA = scan.nextInt();

        System.out.println("Please enter the length of side B of the triangle.");
        int sideB = scan.nextInt();

        System.out.println("Please enter the length of side C of the triangle.");
        int sideC = scan.nextInt();


        // 'perimeter' calculates the perimeter of the triangle by adding all three sides together.
        double perimeter = sideA + sideB + sideC;

        // 'semiPerimeter' calculates the semi perimeter of the triangle by multiplying the perimeter by half (0.5).
        double semiPerimeter = 0.5 * perimeter;

        /** 'area' calculates the triangle's area using Heron's formula.
         * It is described thoroughly in the API documentation at the top of the program.
         */
        double area = Math.sqrt(semiPerimeter * (semiPerimeter - sideA) * (semiPerimeter - sideB) * (semiPerimeter - sideC));

        /** The first 'if statement' checks whether the sides given by the user are valid triangle's sides.
         * It follows the mathematical assumption explained in the API documentation at the top of the program.
         *
         * The third 'if statement' checks whether the sides given by the user create a degenerate triangle.
         * It follows the mathematical assumption explained in the API documentation at the top of the program.

         */

        if (sideA <= 0 || sideB <= 0 || sideC <= 0) // checks whether all numbers given by user are positive.
            System.out.println("The numbers " + sideA + ", " + sideB + " and " + sideC +
                    " cannot be calculated into a triangle's area, because they're either 0 or negative.");

        else if (sideA + sideB < sideC || sideA + sideC < sideB || sideB + sideC < sideA) // first 'if statement'
            System.out.println("The numbers " + sideA + ", " + sideB + " and " + sideC +
                    " cannot be calculated into a triangle's area.");

        else if (sideA + sideB == sideC || sideA + sideC == sideB || sideB + sideC == sideA)
            System.out.println("The numbers " + sideA + ", " + sideB + " and " + sideC + "result in a degenerate" +
                    " triangle. I'm not willing to calculate areas of such triangles."); // third 'if statement'.

        else if (Math.floor(sideA) != sideA || Math.floor(sideB) != sideB || Math.floor(sideC) != sideC)
            System.out.println("One or more of the numbers you gave: " + sideA + ", " + sideB + " or " + sideC +
                    " are not natural numbers."); // checks whether all numbers given by users are of type 'int'.

        else if (area == 0) // checks whether the 'area' result equals 0.
            System.out.println("The numbers " + sideA + ", " + sideB + " and " + sideC
                    + " cannot be calculated into a triangle's area, they result in a 0.");

        else {
            area = Math.round(area * 100); // makes sure 'area' result is only 2 numbers after the decimal point.
            area = area / 100;
            System.out.println("The perimeter of this triangle is: " + perimeter + "\n" +
                    "The area of this triangle according to Heron's formula is: " + area);
        }
    }
}

