package src.main.java.calculator;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Простой калькулятор (поддерживает +, -, *, /)");
        System.out.println("Введите выражение (например, 2 + 3):");

        String input = scanner.nextLine();
        try {
            double result = calculate(input);
            System.out.println("Результат: " + result);
        } catch (Exception e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }

    public static double calculate(String expression) {
        String[] tokens = expression.split(" ");
        if (tokens.length != 3) {
            throw new IllegalArgumentException("Некорректный формат выражения. Используйте: число оператор число (например, 2 + 3)");
        }

        double a = Double.parseDouble(tokens[0]);
        double b = Double.parseDouble(tokens[2]);
        String op = tokens[1];

        return switch (op) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> {
                if (b == 0) throw new ArithmeticException("Деление на ноль!");
                yield a / b;
            }
            default -> throw new IllegalArgumentException("Неподдерживаемая операция: " + op);
        };
    }
}