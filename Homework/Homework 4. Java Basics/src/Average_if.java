//Написать программу, вычисляющую среднее
//        арифметическое чисел из некоторого диапазона чисел
//        (например, от 3 до 17)
//        • Концы диапазона задать переменными, начальное число
//        берите > 1, чтобы было посложнее
//        • Среднее арифметическое чисел – нужно сумму всех чисел
//        поделить на количество этих чисел
//        • В этом же классе - найти среднее арифметическое только
//        четных чисел из этого диапазона чисел

import java.util.Scanner;

public class Average_if {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите первое число:");
        int start = scanner.nextInt();

        System.out.println("Введите второе число:");
        int end = scanner.nextInt();

        int difference = end - start;
        int sum = 0;
        int sumEven = 0;
        int amountOfEvenNumbers = 0;

        sum = (start + end) * (difference + 1) / 2;
        if (start % 2 == 0) {
            if (end % 2 == 0) {
                amountOfEvenNumbers = difference / 2 + 1;
            } else amountOfEvenNumbers = (difference + 1) / 2;
            sumEven = (2 * start + 2 * (amountOfEvenNumbers - 1)) * amountOfEvenNumbers / 2;

        } else {
            if (end % 2 == 0) {
                amountOfEvenNumbers = (difference + 1) / 2;
            } else amountOfEvenNumbers = difference / 2;
            sumEven = (2 * (start + 1) + 2 * (amountOfEvenNumbers - 1)) * amountOfEvenNumbers / 2;
        }


        double average = (double) sum / (difference + 1);
        double averageEven = (double) sumEven / amountOfEvenNumbers;

        System.out.printf("Среднее арифметическое всех чисел диапазона от %d до %d включительно равняется %.3f.", start, end, average);
        System.out.println();
        System.out.printf("Среднее арифметическое всех четных чисел диапазона от %d до %d включительно равняется %.3f.", start, end, averageEven);
    }
//        TODO Неправильно работает, если первое число больше второго, оно и очевидно, так как логика построена на прибавлении и удалении единицы в зависимости от границы.
//        TODO Нужно упростить логику. Похоже, что использование условий не является оптимальным путем. Оставлю на будущее
}
