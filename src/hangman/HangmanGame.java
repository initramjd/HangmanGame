package hangman;

import java.util.Random;
import java.util.Scanner;

public class HangmanGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s = new Scanner(System.in);
		int hangman = 0;
		char slovo = ' ';

		String randomMovie = " ";
		String[] filmovi = { "titanik", "prohujalo sa vihorom", "otac na sluzbenom putu", "romeo i julija",
				"mi nismo andjeli", "kakav deda takav unuk", "cekaj me ja sigurno necu doci",
				"ni na nebu ni na zemlji" };
		randomMovie = randomFromArray(filmovi);

		int arrayLength = randomMovie.length();

		char[] hangmanArray = new char[arrayLength];
		char[] slovaFilma = stringToChar(randomMovie);

		System.out.println("HANGMAN BY JACK INITRAM");
		hangmanArray(slovaFilma, hangmanArray);

		while ((!isWinner(hangmanArray, slovaFilma)) && (!isGameOver(hangman))) {

			System.out.println();
			printHanhman(hangman);

			System.out.println();
			System.out.print("Unesi slovo: ");
			slovo = s.next().charAt(0);

			printSearchLine(slovaFilma, slovo, hangmanArray);
			System.out.println();

			if (!isFieldGood(slovaFilma, slovo)) {
				hangman++;
			}

		}

		if (isWinner(hangmanArray, slovaFilma)) {

			System.out.println();
			System.out.println("BRAVO, POGODILI STE FILM: ");
			System.out.println(randomMovie);

		}

		if (isGameOver(hangman)) {
			System.out.println();
			System.out.println("HaHaHaHa - YOU LOOSE");
			printHanhman(hangman);
			System.out.println(randomMovie);
		}
	}

	public static String randomFromArray(String[] filmovi) {

		Random r = new Random();
		int randomNumber = r.nextInt(filmovi.length);
		return filmovi[randomNumber];

	}

	public static char[] stringToChar(String film) {

		String str = film;

		char[] slovo = str.toCharArray();

		return slovo;

		/*
		 * for (char c : ch) { System.out.print(c);
		 */
	}

	public static void hangmanArray(char[] slovaFilma, char[] hangmanArray) {

		for (int i = 0; i < slovaFilma.length; i++) {

			if (slovaFilma[i] != ' ') {

				System.out.print("_ ");
				hangmanArray[i] = '_';
			} else {
				System.out.print("  ");
				hangmanArray[i] = ' ';

			}
		}
	}

	public static void printSearchLine(char[] slovaFilma, char slovo, char[] hangmanArray) {

		for (int i = 0; i < slovaFilma.length; i++) {

			if (slovo == slovaFilma[i]) {
				hangmanArray[i] = slovaFilma[i];
			}
			System.out.print(hangmanArray[i] + " ");

		}

	}

	public static boolean isWinner(char[] hangmanArray, char[] slovaFilma) {

		for (int i = 0; i < slovaFilma.length; i++) {

			if (hangmanArray[i] != slovaFilma[i]) {
				return false;
			}

		}
		return true;
	}

	public static boolean isFieldGood(char[] slovaFilma, char slovo) {

		for (int i = 0; i < slovaFilma.length; i++) {

			if (slovo == slovaFilma[i]) {
				return true;
			}
		}
		return false;
	}

	public static boolean isGameOver(int hangman) {

		return hangman > 5;
	}

	public static void printHanhman(int hangman) {

		switch (hangman) {
		case 0:
			System.out.println("_____");
			System.out.println("|    |");
			System.out.println("|    ");
			System.out.println("|  ");
			System.out.println("|    ");
			break;
		case 1:
			System.out.println("_____");
			System.out.println("|    |");
			System.out.println("|    o");
			System.out.println("|  ");
			System.out.println("|    ");
			break;

		case 2:

			System.out.println("_____");
			System.out.println("|    |");
			System.out.println("|    o");
			System.out.println("|    |");
			System.out.println("|   ");
			break;

		case 3:
			System.out.println("_____");
			System.out.println("|    |");
			System.out.println("|    o");
			System.out.println("|  --|");
			System.out.println("|   ");

			break;

		case 4:
			System.out.println("_____");
			System.out.println("|    |");
			System.out.println("|    o");
			System.out.println("|  --|--");
			System.out.println("|   ");
			break;

		case 5:

			System.out.println("_____");
			System.out.println("|    |");
			System.out.println("|    o");
			System.out.println("|  --|--");
			System.out.println("|   / ");
			break;
		case 6:
			System.out.println("_____");
			System.out.println("|    |");
			System.out.println("|    o");
			System.out.println("|  --|--");
			System.out.println("|   / |");
			break;

		}

	}

}
