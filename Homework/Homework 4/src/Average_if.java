public class Average_if {

    public static void main(String[] args) {

        int start = 4;
        int end = 11;

        int difference = end - start;
        int sum = 0;
        int sumEven = 0;
        int amountOfEvenNumbers = 0;

        sum = (start + end) * (difference + 1) / 2;
        if (start % 2 == 0) {
            if (end % 2 == 0) {
                amountOfEvenNumbers = difference / 2 + 1;
                sumEven = (2 * start + 2 * (amountOfEvenNumbers - 1)) * amountOfEvenNumbers / 2;
            } else {
                amountOfEvenNumbers = (difference + 1) / 2;
                sumEven = (2 * start + 2 * (amountOfEvenNumbers - 1)) * amountOfEvenNumbers / 2;
            }

        } else {
            if (end % 2 == 0) {
                amountOfEvenNumbers = (difference + 1) / 2;
                sumEven = (2 * (start + 1) + 2 * (amountOfEvenNumbers - 1)) * amountOfEvenNumbers / 2;
            } else {
                amountOfEvenNumbers = difference / 2;
                sumEven = (2 * (start + 1) + 2 * (amountOfEvenNumbers - 1)) * amountOfEvenNumbers / 2;
            }
        }


        double average = (double) sum / (difference + 1);
        double averageEven = (double) sumEven / amountOfEvenNumbers;

        System.out.printf("Среднее арифметическое всех чисел диапазона от %d до %d включительно равняется %.3f.", start, end, average);
        System.out.println();
        System.out.printf("Среднее арифметическое всех четных чисел диапазона от %d до %d включительно равняется %.3f.", start, end, averageEven);
    }

}
