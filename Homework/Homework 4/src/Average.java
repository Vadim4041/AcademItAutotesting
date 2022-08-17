import java.util.Scanner;

public class Average {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int start = scanner.nextInt();
        int end = scanner.nextInt();

        int difference = end - start;
        int sum = 0;
        int sumEven = 0;
        int amountOfEvenNumbers = 0;

        for (int i = start; i <= end; i++) {
            sum += (start + i);
            if ((start + i) % 2 == 0) {
                sumEven += (start + i);
                amountOfEvenNumbers += 1;
            }
        }

        double average = (double) sum / (difference + 1);
        double averageEven = (double) sumEven / amountOfEvenNumbers;

        System.out.printf("Среднее арифметическое всех чисел диапазона от %d до %d включительно равняется %.3f.", start, end, average);
        System.out.println();
        System.out.printf("Среднее арифметическое всех четных чисел диапазона от %d до %d включительно равняется %.3f.", start, end, averageEven);
    }
}
