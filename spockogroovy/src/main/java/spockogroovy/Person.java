package spockogroovy;

public class Person {

    public static final String PRIVATE_VALUE = "Hey!";

    private long id;
    private String name;
    private int age;

    private String privates = PRIVATE_VALUE;

    public Person() {}

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

