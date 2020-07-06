package Lesson_5;

/**
 Необходимо написать два метода, которые делают следующее:

 1) Создают одномерный длинный массив, например:

 static final int size = 10000000;
 static final int h = size / 2;
 float[] arr = new float[size];

 2) Заполняют этот массив единицами;
 3) Засекают время выполнения: long a = System.currentTimeMillis();
 4) Проходят по всему массиву и для каждой ячейки считают новое значение по формуле:
 arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
 5) Проверяется время окончания метода System.currentTimeMillis();
 6) В консоль выводится время работы: System.out.println(System.currentTimeMillis() - a);

 Отличие первого метода от второго:
 Первый просто бежит по массиву и вычисляет значения.
 Второй разбивает массив на два массива, в двух потоках высчитывает новые значения и потом склеивает эти массивы обратно в один.
 Пример деления одного массива на два:

 System.arraycopy(arr, 0, a1, 0, h);
 System.arraycopy(arr, h, a2, 0, h);

 Пример обратной склейки:

 System.arraycopy(a1, 0, arr, 0, h);
 System.arraycopy(a2, 0, arr, h, h);

 Примечание:
 System.arraycopy() – копирует данные из одного массива в другой:
 System.arraycopy(массив-источник, откуда начинаем брать данные из массива-источника, массив-назначение, откуда начинаем записывать данные в массив-назначение, сколько ячеек копируем)

 По замерам времени:
 Для первого метода надо считать время только на цикл расчета:

 for (int i = 0; i < size; i++) {
 arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
 }

 Для второго метода замеряете время разбивки массива на 2, просчета каждого из двух массивов и склейки.
 */

public class Lesson_5 {
    static final int size = 10_000_000;
    static final int half = size / 2;

    public static void main(String[] args) {
        method1();
        method2();
    }

    static void method1 () {
        float [] arr = new float[size];
        for (int i = 0; i < size; i++) {
            arr[i] = 1;
        }

        long a = System.currentTimeMillis();

        for (int i = 0; i < size; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println("Время метода 1: " + (System.currentTimeMillis() - a));
    }

    static void method2 () {
        float [] arr = new float[size];
        for (int i = 0; i < size; i++) {
            arr[i] = 1;
        }

        long a = System.currentTimeMillis();

        float [] a1 = new float[half];
        float [] a2 = new float[half];
        System.arraycopy(arr, 0, a1, 0, half);
        System.arraycopy(arr, half, a2, 0, half);

        //  два потока
        MyThread tr1 = new MyThread(a1);
        MyThread tr2 = new MyThread(a2);
        tr1.start();
        tr2.start();

        System.arraycopy(a1, 0, arr, 0, half);
        System.arraycopy(a2, 0, arr, half, half);

        System.out.println("Время метода 2: " + (System.currentTimeMillis() - a));
    }

    static class MyThread extends Thread {
        private float [] arr;

        MyThread (float [] arr) {
            this.arr = arr;
        }

        @Override
        public void run () {
            for (int i = 0; i < arr.length; i++) {
                try {
                    arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                } catch (Exception e) {
                }
            }
        }
    }
}
