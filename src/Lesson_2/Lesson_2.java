package Lesson_2;

import java.io.IOException;

/**
 1. Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4.
 При подаче массива другого размера необходимо бросить исключение MyArraySizeException.

 2. Далее метод должен пройтись по всем элементам массива, преобразовать в int, и просуммировать.
 Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит символ или текст вместо числа),
 должно быть брошено исключение MyArrayDataException, с детализацией в какой именно ячейке лежат неверные данные.

 3. В методе main() вызвать полученный метод, обработать возможные исключения MySizeArrayException и MyArrayDataException,
 и вывести результат расчета.
 */

public class Lesson_2 {
    public static void main(String[] args) throws MyArrayDataException {
        addMassive(4,4);
    }

    // метод создания массива
    private static void addMassive (int a, int b) throws MyArreySyzeException, MyArrayDataException {
        if (a != 4 || b != 4) {
            throw new MyArreySyzeException("Такой размер массива не возможен!");
        }
        String [][] lesson = new String[a][b];

        addNumMassive(lesson);

        // changeMassive(lesson, 3, 1); // включается в случае ошибки!

        changeSettingMassive(lesson);
    }

    // метод исправления строки на число в массиве
    private static void changeMassive(String [][] arr, int a, int b) {
        arr [a-1][b-1] = "0";
    }

    // метод перехода строкового массива в числовой и выводит сумму всех ячеек
    private static int [][] changeSettingMassive (String [][] arr) throws MyArrayDataException {
        int [][] lesson = new int [arr.length][arr[0].length];
        int result = 0;
        for (int i = 0; i < lesson.length; i++) {
            for (int j = 0; j < lesson[i].length; j++) {
                if (arr[i][j].matches("\\D")) {
                    throw new MyArrayDataException("Поле массива: " + (i+1) + " строка и " + (j+1) + " столбец НЕ СООТВЕТСТУЕТ УСЛОВИЮ ЗАДАНИЯ!");
                } else {
                    lesson[i][j] = Integer.parseInt(arr[i][j]);
                    result += lesson[i][j];
                }
            }
        }

        System.out.println("Сумма всех ячеек массива = " + result);
        return lesson;
    }

    // пробное заполнение массива для тестирования
    private static void addNumMassive(String [][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = "1";
            }
        }
        arr[2][0] = "е";
    }
}

    // исключение на размеры массива
class MyArreySyzeException extends ArrayStoreException {
    public MyArreySyzeException (String message) {
        super(message);
    }
}

    // исключение на содержание массива
class MyArrayDataException extends Exception {
    public MyArrayDataException (String message) {
     super(message);
    }

}
