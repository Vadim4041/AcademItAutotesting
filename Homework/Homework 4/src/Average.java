public class Average {
    public static void main(String[] args) {
        int start = 1;
        int end = 50;
        int difference = end - start;
        int sum = start;
        for (int i = 0; i < difference; i++) {
            sum += (start + i + 1);
        }
        double average = (double) sum / (difference + 1);
        System.out.println(sum);
        System.out.println(average);

//        TODO Добавить подробное описание вывода + найти среднее арифметическое для четных из диапазона чисел
    }
}
