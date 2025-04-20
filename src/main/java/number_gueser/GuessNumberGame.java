package src.main.java.number_gueser;
import java.util.Random;
import java.util.Scanner;

public class GuessNumberGame {
    public static void main(String[] args) {
        System.out.println("Игра угадай число от -100 до 100");
        Number rand = randInt(-100, 100);
        Scanner scanner = new Scanner(System.in);
        Number guess;
        while (true) {
            guess = scanner.nextInt();
            if (guess.equals(rand)) {
                System.out.println("Поздравляю!");
                return;
            } else if (rand.intValue() < guess.intValue()) {
                System.out.println("Загаданное число меньше, чем введенное");
            } else {
                System.out.println("Загаданное число больше, чем введенное");
            }
        }
    }
    public static int randInt(int min, int max) {
        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
    }
}
