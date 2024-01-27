import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.random.RandomGenerator;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Hang Man!");
        ArrayList<String> cuvinte = new ArrayList<>(Arrays.asList("elicopter", "caine", "casa", "masina", "tanc", "mere",
                "hipopotam", "elefant", "fazan", "papagal", "pisica", "flamingo", "telefon", "laptop", "tabla", "ghiozdan",
                "bluza", "alfabet", "foaie", "imprimanta", "tort"));
        Random rnd = new Random();
        String word = cuvinte.get(rnd.nextInt(cuvinte.size()));
        int lives = 6;
        int lettersNr = word.length();
        System.out.println("Today's word is:");
        Scanner sc = new Scanner(System.in);
        char[] stars = new char[lettersNr];
        for (int i = 0; i < lettersNr; i++) {
            stars[i] = '*';
        }
        while (true) {
            boolean isLetterFound = false;
            System.out.println(String.valueOf(stars));
            System.out.println("Input a letter:");
            char letter = sc.next().charAt(0);
            for (int i = 0; i < word.length(); i++) {
                if (letter == word.charAt(i)) {
                    System.out.println("Letter correct");
                    stars[i] = letter;
                    isLetterFound = true;
                }
            }
            if (!String.valueOf(stars).contains("*")) {
                System.out.println("You win!");
                break;
            }
            if (!isLetterFound) {
                System.out.println("Wrong letter");
                lives--;
            }
            if (lives == 0) {
                System.out.println("You lost!");
                break;
            }
        }
    }
}
