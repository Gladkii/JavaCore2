package Lesson_6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 1. Написать консольный вариант клиент\серверного приложения, в котором пользователь может писать сообщения, как на клиентской стороне, так и на серверной.
 Т.е. если на клиентской стороне написать "Привет", нажать Enter то сообщение должно передаться на сервер и там отпечататься в консоли.
 Если сделать то же самое на серверной стороне, сообщение соответственно передается клиенту и печатается у него в консоли.
 Есть одна особенность, которую нужно учитывать: клиент или сервер может написать несколько сообщений подряд,
 такую ситуацию необходимо корректно обработать.

 Разобраться с кодом с занятия, он является фундаментом проекта-чата
 ВАЖНО! Сервер общается только с одним клиентом, т.е. не нужно запускать цикл, который будет ожидать второго/третьего/n-го клиентов
 */

public class Server {
    private static String SERVER_NAME = "Server";
    private static Socket socket;
    private static DataInputStream input;
    private static DataOutputStream output;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        addServer();
        dataSTREAM();
        readMessage();
        sendMessage();
    }

    public static void addServer () {
        try {
            ServerSocket serverSocket = new ServerSocket(9090);
            System.out.println("Сервер запущен. Ожидаем подключения.");
            socket = serverSocket.accept();
            System.out.println("Клиент подключился.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void dataSTREAM () {
        try {
            input = new DataInputStream(socket.getInputStream());
            output = new DataOutputStream(socket.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void readMessage () {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        System.out.println(input.readUTF());
                    } catch (Exception e) {
                        e.printStackTrace();
                        try {
                            input.close();
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                }
            }
        }).start();
    }
    public static void sendMessage () {
        while (true) {
            String message = (SERVER_NAME + ": " + scanner.nextLine());
            try {
                output.writeUTF(message);
            } catch (Exception e) {
                e.printStackTrace();
                try {
                    output.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}
