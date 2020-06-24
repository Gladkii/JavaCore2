package Lesson_3;

import java.util.Iterator;
import java.util.LinkedList;

/**
 1. Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).
 Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
 Посчитать сколько раз встречается каждое слово.
*/

public class Lesson_3 {
    public static void main(String[] args) {
        LinkedList <String> farm = new LinkedList<>();

        addMassive(farm);
        System.out.println(farm);

        getUnicum(farm);

        farm.clear();
        addMassive(farm);
        getRepeated(farm);
    }

    // заполняем массив животными
    private static void addMassive (LinkedList <String> a) {
        a.add("Cat");
        a.add("Dog");
        a.add("Cockroach");
        a.add("Mouse");
        a.add("Pig");
        a.add("Sheep");
        a.add("Dog");
        a.add("Cow");
        a.add("Horse");
        a.add("Cockroach");
        a.add("Chicken");
        a.add("Sheep");
        a.add("Cockroach");
    }

    // выводим список уникальных (не повторяющихся животных)
    private static void getUnicum (LinkedList <String> a) {
        for (int i = 0; i < a.size(); i++) {
            int result = 0;
            for (int j = i +1; j < a.size(); j++) {
                if (a.get(i).equals(a.get(j))) {
                    result++;
                    a.set(j, "X");
                }
            }

            if (result != 0) {
                a.set(i, "X");
            }
        }
        Iterator <String> iter = a.iterator();
        while (iter.hasNext()) {
            String str = iter.next();
            if (str.equals("X")) {
                iter.remove();
            }
        }
        System.out.println(a + " - уникальны!");
    }

    // считаем сколько раз встречается каждое слово
    private static void getRepeated (LinkedList <String> a) {
        for (int i = 0; i < a.size(); i++) {
            int result = 1;
            for (int j = i + 1; j < a.size(); j++) {
                if (a.get(i).equals(a.get(j))) {
                    result++;
                    a.remove(j);
                }
            }
            System.out.println(a.get(i) + " встречается раз: " + result);
        }
    }
}
