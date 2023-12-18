package ru.taranenko.homeworks.homework20;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Locale;
import java.util.Scanner;

public class ClientMain {

    public static void main(String[] args) throws IOException {

        String cmdConnect = "connect client";
        String cmdCalc = "calc";

        String operands;
        double arg1;
        double arg2;
        String operand;

        String request;
        String response;

        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);

        int mode = 0;
        while (mode != 2) {
            System.out.println();
            System.out.println("Режимы работы:");
            System.out.println("1. Расчет выражения");
            System.out.println("2. Выход");
            System.out.println();
            System.out.println("Введите режим: ");
            mode = scanner.nextInt();

            if (mode == 1) {

                //подключиться к серверу и получить список операций
                request = cmdConnect;
                operands = sendCommandToServer(request);
                System.out.println("Список доступных операций: " + operands);

                System.out.println("Введите операцию: ");
                operand = scanner.next();

                System.out.println("Введите первое число: ");
                String arg1Str = scanner.next().replace(",", ".");
                arg1 = Double.parseDouble(arg1Str);

                System.out.println("Введите второе число: ");
                String arg2Str = scanner.next().replace(",", ".");
                arg2 = Double.parseDouble(arg2Str);

                //передать аргументы серверу и получить результат
                request = cmdCalc + " " + operand + " " + arg1 + " " + arg2;
                response = sendCommandToServer(request);

                System.out.println("Результат выражения: "
                        + arg1Str + " " + operand + " " + arg2Str + " = " + response);
            }
        }
    }

    public static String sendCommandToServer(String request) throws IOException {
        Socket socket = new Socket("localhost", 8890);
        InputStream is = socket.getInputStream();

        socket.getOutputStream().write(request.getBytes());
        socket.getOutputStream().flush();

        byte[] responseByte = new byte[32];
        int bytesRead = is.read(responseByte, 0, 32);
        String responseStr = new String(responseByte, 0, bytesRead);

        is.close();
        socket.close();

        return responseStr;
    }
}
