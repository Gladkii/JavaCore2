package Lesson_3;

import java.util.*;

/**
 2. Написать простой класс ТелефонныйСправочник, который хранит в себе список фамилий и телефонных номеров.
 В этот телефонный справочник с помощью метода add() можно добавлять записи.
 С помощью метода get() искать номер телефона по фамилии.
 Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев),
 тогда при запросе такой фамилии должны выводиться все телефоны.

 Желательно как можно меньше добавлять своего, чего нет в задании
 (т.е. не надо в телефонную запись добавлять еще дополнительные поля (имя, отчество, адрес),
 делать взаимодействие с пользователем через консоль и т.д.).
 Консоль желательно не использовать (в том числе Scanner), тестировать просто из метода main() прописывая add() и get().
 */

public class PhoneBook {
    public static void main(String[] args) {
        HashMap <String, String> phoneBook = new HashMap<>();
        add(phoneBook, "105-344", "Иванов");
        add(phoneBook, "303-611", "Петров");
        add(phoneBook, "345-111", "Сидоров" );
        add(phoneBook, "663-662", "Иванов");
        add(phoneBook, "112-233", "Шматько");
        System.out.println(phoneBook);
        get(phoneBook, "Иванов");
    }

    // метод добавления контакта
    private static void add (HashMap <String, String> a, String phone, String name) {
        a.put(phone, name);
    }

    // метод поиска по фамилии
    private static void get (HashMap <String, String> a, String name) {
        Iterator iter = a.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry map = (Map.Entry) iter.next();
            if (map.getValue().equals(name)) {
                System.out.println(name + ": " + map.getKey());
            }
        }

    }
}
