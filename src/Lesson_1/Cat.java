package Lesson_1;

public class Cat {
    public int id = 2;
    private String name;
    private int age;
    private String color;
    public double stamina;
    public double jump_height;

    public Cat(String name, int age, String color, double stamina) {
        this.name = name;
        this.age = age;
        this.color = color;
        this.stamina = stamina;
    }

    public void run() {
        System.out.println("Кот " + this.name + " побежал.");
    }

    public void jump() {
        System.out.println("Кот " + this.name + " прыгнул.");
    }
}
