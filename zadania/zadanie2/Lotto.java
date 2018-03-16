package zadanie2;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Lotto {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] input = getInputNums(scan);
		int[] random = random6();

		System.out.println(Arrays.toString(input));

		System.out.println(Arrays.toString(random));
		System.out.println("trafiłeś dokładnie " + howManyHits(input, random) + " liczby");
		scan.close();
	}

	static int[] getInputNums(Scanner scan) {
		System.out.println("podawaj liczby od 1 do 49");
		int[] result = new int[6];
		int i = 0;

		while (i < 6) {
			System.out.println("podaj liczbę " + (i+1) + ":");
			while (!scan.hasNextInt()) {
				System.out.println("podaj liczbę");
				scan.next();
			}
			while (true) {
				while (!scan.hasNextInt()) {
					System.out.println("podaj liczbę");
					scan.next();
				}
				int temp = scan.nextInt();
				if (temp > 0 && temp < 50 && !isUsed(temp, result)) {
					result[i] = temp;
					System.out.println("dodano: " + temp);
					break;
				} else {
					System.out.println("zla liczba: liczby nie moga sie powtarzac i musza byc z zakresu od 1 do 49!");
				}
			}
			i++;
		}
		 Arrays.sort(result);
		return result;
	}
	static boolean isUsed (int test, int[] list) {
		for (int i = 0; i < list.length; i++) {
			if (list[i] == test) {
				return true;
			}
		}
		return false;
	}
	static int[] random6 () {
		int[] result = new int[6];
		Integer[] arr = new Integer[49];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i;
		}
		Collections.shuffle(Arrays.asList(arr));
		for (int i = 0; i < 6; i++) {
			result[i] = arr[i];
		}
		return result;
	}
	static int howManyHits(int[] tab1, int[] tab2) {
		int result = 0;
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				if (tab1[i] == tab2[j]) {
					result++;
				}
			}
		}
		if (result == 3) {
			System.out.println("trafiłeś trójkę");
		} else if (result == 4) {
			System.out.println("trafiłeś czwórkę");
		} else if (result == 5) {
			System.out.println("trafiłeś piątkę");
		} else if (result == 6) {
			System.out.println("trafiłeś szóstkę");
		}
		return result;
	}
}
