package Lesson_1;

/**
 1.Создайте три класса Человек, Кот, Робот, которые не наследуются от одного класса.
 Эти классы должны уметь бегать и прыгать (методы просто выводят информацию о действии в консоль).
 2. Создайте два класса: беговая дорожка и стена, при прохождении через которые, участники должны выполнять соответствующие действия (бежать или прыгать), результат выполнения печатаем в консоль (успешно пробежал, не смог пробежать и т.д.).
 3. Создайте два массива: с участниками и препятствиями, и заставьте всех участников пройти этот набор препятствий.
 4*. У препятствий есть длина (для дорожки) или высота (для стены), а участников ограничения на бег и прыжки. Если участник не смог пройти одно из препятствий, то дальше по списку он препятствий не идет.
 */

public class Lesson1 {
    static Human human1 = new Human ("Виктор", 16, "Хакер", 12);
    static Cat cat1 = new Cat ("Вискас", 3, "Рыжий", 2.1);
    static Robot robot1 = new Robot ("R2KZ",14.3,"Суперпылесос", 200);
    static RunTrack track1 = new RunTrack(4.3);
    static Wall wall1 = new Wall(0.3);

    // массив участников
    static double [][] users = new double [3][2];
    // массив испытаний
    static double [][] track = new double [2][4];


    public static void main(String[] args) {
        // задание 1
        human1.run();
        human1.jump();
        cat1.run();
        cat1.jump();
        robot1.run();
        robot1.jump();

        // задание 2
        track1.run(human1.id, human1.stamina);
        track1.run(cat1.id, cat1.stamina);
        track1.run(robot1.id, robot1.stamina);
        human1.jump_height = 1.2;
        cat1.jump_height = 2.1;
        robot1.jump_height = 0.1;
        wall1.jump(human1.id, human1.jump_height);
        wall1.jump(cat1.id, cat1.jump_height);
        wall1.jump(robot1.id, robot1.jump_height);

        // задание 3-4
        setMassive();
        System.out.println("Начинаем марафон.");
        marafon(human1.id);
        marafon(cat1.id);
        marafon(robot1.id);
    }

    // метод заполнения массивов
    static void setMassive () {
        users [0][0] = human1.stamina;  // человек - выносливость бега
        users [0][1] = human1.jump_height; // человек - высота прыжка (1 прыжок = -1км выносливости)
        users [1][0] = cat1.stamina; // кот - выносливость бега (ленивый кот)
        users [1][1] = cat1.jump_height; // кот - высота прыжка (1 прыжок = -1км выносливости)
        users [2][0] = robot1.stamina; // робот - выносливость АКБ
        users [2][1] = robot1.jump_height; // робот не сильно прыгучий (1 прыжок = -1км выносливости)
        track [0][0] = 0.5;     // первая беговая дистаниция в км
        track [0][1] = 1;     // вторая беговая дистаниция в км
        track [0][2] = 1.5;       // третья беговая дистаниция в км
        track [0][3] = 2;       // четвертая беговая дистаниция в км
        track [1][0] = 0.3;     // первое прыжковое препядствие
        track [1][1] = 0.6;     // второе прыжковое препядствие
        track [1][2] = 0.9;     // третье прыжковое препядствие
        track [1][3] = 1.2;     // четвертое прыжковое препядствие
    }

    private static void marafon(int id) {
        RunTrack.whoAre(id);
        int a = 0;   // счетчик препятствий
        for (int i = 0; i <= 3; i++) {
            if (users[id-1][0] >= track[0][i]) {
                users[id-1][0] -= track [0][i];
                a++;
                System.out.println("Приодолел припятствие #" + a + ",преодолев расстояние - " + track[0][i] + "км. Осталось выносливости на " + users[id-1][0] + "км.");
            } else {
                a++;
                System.out.println("Не преодолел препядствие #" + a + ". Марафон завершен.");
                break;
            }

            if ((users[id-1][1] >= track[1][i]) && (users[id-1][0] >= 1)) {
                users[id-1][0] -= 1.0;
                a++;
                System.out.println("Приодолел припятствие #" + a + ", перепрыгнув препядствие высотой - " + track[1][i] + " метра и затратив выносливости на 1км. Осталось выносливости на " + users[id-1][0] + "км.");
            } else {
                a++;
                System.out.println("Не преодолел препядствие #" + a + ". Марафон завершен.");
                break;
            }
        }
    }
}
