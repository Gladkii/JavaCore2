package Lesson_1;

public class Robot {
    public int id = 3;
    private String name;
    private double version;
    private String prof;
    public double stamina;
    public double jump_height;

    public Robot(String name, double version, String prof, double stamina) {
        this.name = name;
        this.version = version;
        this.prof = prof;
        this.stamina = stamina;
    }

    public void run() {
        System.out.println("Робот " + this.name + " побежал.");
    }

    public void jump() {
        System.out.println("Робот " + this.name + " прыгнул.");
    }
}
