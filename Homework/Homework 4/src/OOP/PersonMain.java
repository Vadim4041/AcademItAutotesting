package OOP;

import java.util.Scanner;

public class PersonMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя:");
        String name = scanner.nextLine();

        System.out.println("Введите отчество:");
        String middleName = scanner.nextLine();

        System.out.println("Введите фамилию:");
        String familyName = scanner.nextLine();

        System.out.println("Введите возраст:");
        int age = scanner.nextInt();

        Person person = new Person(name, middleName, familyName, age);

        System.out.println("Объект класса Person был создан: " + person);
        System.out.println("Год рождения: " + person.getBirthYear());

        person.setName("name_placeholder");
        person.setFamilyName("familyName_placeholder");
        person.setMiddleName("middleName_placeholder");
        person.setAge(99);

        System.out.println("Ниже будет использован сеттер для изменения того, что было введено: " + person);
        System.out.println("Год рождения: " + person.getBirthYear());

    }
}
