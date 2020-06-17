package Lesson_1;

public class RunTrack {
    private double distance;
    private boolean result;

    public RunTrack(double distance) {
        this.distance = distance;
    }

    public boolean run(int id, double stamina) {
        whoAre(id);
        if (stamina >= distance) {
            double b = stamina - distance;
            result = true;
            System.out.println("Успешно пробежал дистанцию - " + distance + "км, осталось выносливости на " + b + "км.");
        } else {
            result = false;
            System.out.println("Выносливости не хватило.");
        }
        return result;
    }

    public static void whoAre (int a) {
        if (a == 1) {
            System.out.print("Человек начал движение. ");
        }  else if (a == 2) {
            System.out.print("Кот начал движение. ");
        } else {
            System.out.print("Робот начал движение. ");
        }
    }
}
