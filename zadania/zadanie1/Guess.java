package zadanie1;

import java.util.Scanner;

public class Guess {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int numberToGuess = random();
		int inputGuess = 0;

		while (true) {
			inputGuess = inputNumber(scan);
			if (numberToGuess > inputGuess) {
				System.out.println("za mało");
			} else if (numberToGuess < inputGuess) {
				System.out.println("za dużo");
			} else {
				System.out.println("Zgadłeś!");
				break;
			}
		}
		scan.close();
	}

	static int random() {
		int max = 100;
		int range = (max - 1) + 1;
		int result = 0;
		while (true) {
			int rand = (int) (Math.random() * range) + 1;
			result = rand;
			break;
		}
		return result;
	}

	static int inputNumber(Scanner scan) {
		
		System.out.println("Zgadnij liczbę");

		while (!scan.hasNextInt()) {
			System.out.println("podaj liczbę");
			scan.next();
		}
		int res = scan.nextInt();
		return res;
	}

}
