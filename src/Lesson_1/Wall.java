package Lesson_1;

public class Wall {
    private double height;
    private boolean result;

    public Wall(double height) {
        this.height = height;
    }

    public boolean jump (int id, double jump_height) {
        RunTrack.whoAre(id);
        if (jump_height >= height) {
            double b = jump_height - height;
            result = true;
            System.out.println("Успешно перепрыгнул преграду в " + height + "метра.");
        } else {
            result = false;
            System.out.println("Слишком высоко.");
        }
        return result;
    }
}
