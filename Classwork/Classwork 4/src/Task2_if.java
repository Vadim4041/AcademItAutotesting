import java.util.Scanner;

public class Task2_if {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите ваше имя:");
        String name = scanner.nextLine();
        if (name.equals("")) {
            System.out.println("Имя не может быть пустым");
        } else {
            System.out.println("Привет, " + name + "!");
        }

    }
}
