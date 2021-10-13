// Java program to demonstrate the
// working of ArrayList in Java

import java.io.*;
import java.util.*;

class ArrayListExample {
	public static void main(String[] args)
	{
		

		// Declaring the ArrayList with
		ArrayList<Integer> arrli
			= new ArrayList<Integer>();

		// Appending new elements at
		// the end of the list
		for (int i = 1; i <= 10; i++)
			arrli.add(i);

		arrli.add(2,100);

		// Printing elements
		System.out.println(arrli);


		// Setting element at 1st index
        arrli.set(2,200);
		
		// Printing elements
		System.out.println(arrli);

		// Remove element at index 3
		arrli.remove(3);

		// Displaying the ArrayList
		// after deletion
		System.out.println(arrli);

		// Printing elements one by one
		for (int i = 0; i < arrli.size(); i++)
			System.out.print(arrli.get(i) + " ");

		 // Using the for each loop
        for (int num : arrli)
            System.out.print(num + " ");


	}
}
