import java.util.Scanner;

public class Task3_for {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите ваше имя:");
        String name = scanner.nextLine();
        while (name.length() == 0) {
            System.out.println("Имя не может быть пустым. Попробуйте еще раз");
            name = scanner.nextLine();
        }
        System.out.println("Привет, " + name + "!");
    }
}
