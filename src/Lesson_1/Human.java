package Lesson_1;

public class Human {
    public int id = 1;
    private String name;
    private int age;
    private String prof;
    public double stamina;
    public double jump_height;

    public Human(String name, int age, String prof, double stamina) {
        this.name = name;
        this.age = age;
        this.prof = prof;
        this.stamina = stamina;
    }

    public void run() {
        System.out.println("Человек " + this.name + " побежал.");
    }

    public void jump() {
        System.out.println("Человек " + this.name + " прыгнул.");
    }
}
