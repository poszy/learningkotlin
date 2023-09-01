import person.Person;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Person person = new Person();
        person.setAge(21);
        person.setName("Luis");
        System.out.println(person);

    }
}