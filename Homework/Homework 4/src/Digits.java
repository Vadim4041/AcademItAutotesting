import java.util.Scanner;

import static java.lang.Math.abs;

public class Digits {
    public static void main(String[] args) {
        System.out.println("Введите число:");
        Scanner scanner = new Scanner(System.in);

        int a = abs(scanner.nextInt());

        int sumDigits = 0;
        int sumOddDigits = 0;
        int maxDigit = 0;
        while (a != 0) {
            int digit = a % 10;
            if (maxDigit < digit) {
                maxDigit = digit;
            }
            if (IsOdd(digit)) {
                sumOddDigits += digit;
            }
            sumDigits += digit;
            a = a / 10;
        }
        System.out.println("Максимальная цифра числа: " + maxDigit);
        System.out.println("Сумма цифр числа: " + sumDigits);
        System.out.println("Сумма нечетных цифр числа: " + sumOddDigits);
    }

    public static boolean IsOdd(int x) {
        return x % 2 == 1;
    }

}
