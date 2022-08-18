//• Распечатать числа, кратные четверке от 1 до 100, причем в
//        обратном порядке (то есть, начиная с 100)
//        • Определение кратности четверке вынести в отдельную
//        функцию
//        • Использовать цикл for
public class For {
    public static void main(String[] args) {
        for (int i = 100; i > 1; i--) {
            if (IsDividableBy4(i)) {
                System.out.println(i);
            }
        }
    }

    public static boolean IsDividableBy4(int x) {
        return x % 4 == 0;
    }
}
