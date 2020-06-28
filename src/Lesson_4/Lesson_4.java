package Lesson_4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 Создать окно для клиентской части чата: большое текстовое поле для отображения переписки в центре окна.
 Однострочное текстовое поле для ввода сообщений и кнопка для отсылки сообщений на нижней панели.
 Сообщение должно отсылаться либо по нажатию кнопки на форме, либо по нажатию кнопки Enter.
 При «отсылке» сообщение перекидывается из нижнего поля в центральное.
*/

public class Lesson_4 {
    public static void main(String[] args) {
        new MyWindow();
    }
}

class MyWindow extends JFrame{
    private JTextArea chat;
    private JTextField jtfMessage;

    public MyWindow () {
        // создаем окно
        setTitle("Создание чата");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(200, 200, 400,400);

        // создаем поле для вывода сообщений
        chat = new JTextArea();
        chat.setEditable(false);
        chat.setLineWrap(true);
        JScrollPane jsp = new JScrollPane(chat);
        add(jsp, BorderLayout.CENTER);

        // создаем основную панель строки и кнопки
        JPanel panel = new JPanel(new BorderLayout());
        add(panel, BorderLayout.SOUTH);

        // добавляем на панель строку и кнопку
        jtfMessage = new JTextField();
        panel.add(jtfMessage, BorderLayout.CENTER);
        JButton send = new JButton(">>");
        panel.add(send, BorderLayout.EAST);

        // слушатель строки
        jtfMessage.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    sendMsg();
                }
            }
        });

        // слушатель кнопки
        send.addActionListener(e -> {
            sendMsg();
        });

        setVisible(true);
    }

    // метод отправки сообщения
    public void sendMsg() {
        String msg = jtfMessage.getText();
        chat.append(msg + "\n");
        jtfMessage.setText("");
    }
}
