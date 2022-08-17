import java.util.Scanner;

public class Average {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите первое число:");
        int start = scanner.nextInt();

        System.out.println("Введите второе число:");
        int end = scanner.nextInt();

        int sum = 0;
        int sumEven = 0;
        int amountOfEvenNumbers = 0;

        for (int i = start; i <= end; i++) {
            sum +=  i;
            if (i % 2 == 0) {
                sumEven += i;
                amountOfEvenNumbers += 1;
            }
        }

        double average = (double) sum / ((end - start) + 1);
        double averageEven = (double) sumEven / amountOfEvenNumbers;

        System.out.printf("Среднее арифметическое всех чисел диапазона от %d до %d включительно равняется %.3f.", start, end, average);
        System.out.println();
        System.out.printf("Среднее арифметическое всех четных чисел диапазона от %d до %d включительно равняется %.3f.", start, end, averageEven);
    }
}
