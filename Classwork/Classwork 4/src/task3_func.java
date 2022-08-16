public class task3_func {
    public static double getAverage(int a, int b) {
        return (double) (a + b) / 2;
    }

    public static void main(String[] args) {
        int x = 5;
        int y = 6;
        double average = task3_func.getAverage(x, y);
        System.out.println("Cреднее арифметическое = " + average);
    }

}

