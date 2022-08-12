package lesson4;

public class Cat {
    private String name;
    public int age;

    public Cat(String name, int age){
        this.name = name;
        this.age = age;
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
    @Override
    public String toString() {
        return "Cat{" +
                "name'" + name + '/' +
                ", age=" + age +
                '}';
    }
}
