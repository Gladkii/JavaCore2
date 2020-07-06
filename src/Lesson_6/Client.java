package Lesson_6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private static String CLIENT_NAME = "Kostya";
    private static String SERVER_ADDR = "localhost";
    private static int SERVER_PORT = 9090;
    private static Socket socket;
    private static DataInputStream input;
    private static DataOutputStream output;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        connectClient();
        dataSTREAM();
        readMessage();
        sendMessage();
    }

    public static void connectClient () {
        try {
            socket = new Socket(SERVER_ADDR, SERVER_PORT);
            System.out.println(CLIENT_NAME + " подключился к серверу.");
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
            String message = (CLIENT_NAME + ": " + scanner.nextLine());
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
