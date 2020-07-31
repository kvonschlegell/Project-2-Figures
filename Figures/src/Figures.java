/*
Name: Kathryn von Schlegell
Date: 07/31/2020
Course:CPSC 50100 Programming Fundamentals 
Semester: Summer 2020
Assignment 2 Figures*/

import java.util.Scanner;

public class Figures {

	public static void main(String[] args) {
		// Header
		System.out.print("Programming Fundamentals" + "\nNAME: Kathryn von Schlegell" + "\nPROGRAMMING ASSINGMENT 2");

		// Asking user to pick a odd integer
		int oddNumber;
		Scanner input = new Scanner(System.in);
		System.out.print("\n" + "\nEnter the size of the figure (odd number): ");
		oddNumber = input.nextInt();

		// If user does not pick a odd integer, ask to reenter size until odd number is
		// chosen
		while (oddNumber % 2 == 0) {
			System.out
					.print("Invaild figure size - must be an odd number" + "\n" + "\nReenter the size of the figure: ");
			oddNumber = input.nextInt();
		}

		int menuChoice = 0, box = 1, diamond = 2, x = 3, quit = 4;
		while (menuChoice != quit) {

			// Menu Choices. Ask user to select an option
			System.out.print("\n" + "MENU:" + "\n1. Print box" + "\n2. Print diamond" + "\n3. Print X"
					+ "\n4. Quit Program" + "\n" + "\nPlease select an option: ");
			menuChoice = input.nextInt();
			System.out.print("\n");

			if (menuChoice == box) {
				printBox(oddNumber);
			} else if (menuChoice == diamond) {
				printDiamond(oddNumber);
			} else if (menuChoice == x) {
				printX(oddNumber);
			}
			// If user choose option 4 program will print message and terminate program
			else if (menuChoice == quit) {
				System.out.print("Good bye!");
				System.exit(0);
			}
		}
		input.close();
	}

	private static void printBox(int size) {

		for (int row = 1; row <= size; row++) {
			for (int col = 1; col <= size; col++) {
				System.out.print("X");
			}
			System.out.println("");
		}
	}

	private static void printDiamond(int size) {

		// create top half of triangle
		for (int row = 1; row <= size - 1; row += 2) {

			// Determines how many spaces are needed before an X is placed in a particular
			// row
			for (int spaceBeforeX = size; spaceBeforeX >= row; spaceBeforeX -= 2) {
				System.out.print(" ");
			}
			System.out.print("X");

			// Second loop needed to determine spaces needed after X to place to 2nd X in a
			// row
			for (int spaceAfterFirstX = 1; spaceAfterFirstX <= row - 1; spaceAfterFirstX++) {
				System.out.print(" ");
			}
			System.out.println("X");
		}

		// create bottom half of triangle
		for (int row = 1; row <= size; row += 2) {
			for (int spaceBeforeX = 1; spaceBeforeX <= row; spaceBeforeX += 2) {
				System.out.print(" ");
			}
			System.out.print("X");

			for (int spaceAfterFirstX = size; spaceAfterFirstX >= row + 1; spaceAfterFirstX--) {
				System.out.print(" ");
			}
			System.out.println("X");
		}
	}

	private static void printX(int size) {

		for (int row = 1; row <= size; row++) {
			for (int col = 1; col <= size; col++) {

				// The X lies on the main diagonal. If looking at a graph x=y
				// Off diagonal has pattern of taking the size +1. When the loop runs X will be
				// placed when condition is satisfied.
				if (row == col || col + row == size + 1) {
					System.out.print("X");
				} else {
					System.out.print(" ");
				}
			}
			System.out.print("\n");
		}

	}
}
