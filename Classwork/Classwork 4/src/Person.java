public class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

//    Геттер name:
    public String getName() {
        return name;
    }

//    Сеттер, меняет значение для name:
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "{" + " " + name + "}";
    }

}
