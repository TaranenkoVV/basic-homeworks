package ru.taranenko.homeworks.homework20;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain {

    public static void main(String[] args) throws IOException {
        String operands = "+, -, *, /";
        String response;
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(8890);
            System.out.println("server start");
            while (true) {
                System.out.println("server wait command");
                Socket socket = serverSocket.accept();
                System.out.println("receive command from client");
                byte[] requestByte = new byte[32];

                InputStream is = socket.getInputStream();
                int bytesRead  = is.read(requestByte, 0, 32);
                String requestStr = new String(requestByte, 0 , bytesRead);
                System.out.println(requestStr);

                String[] requestItem = requestStr.split(" ");

                if (requestItem.length >= 1) {
                    switch (requestItem[0]) {
                        case "connect":
                            response = operands;
                            break;

                        case "calc":
                            response = calculate(requestItem);
                            break;

                        default:
                            response = "unknown command";
                            break;
                    }
                } else {
                    response = "empty command";
                }
                System.out.println("send response to client: " + response);
                // отправить ответ клиенту
                socket.getOutputStream().write(response.getBytes());
                socket.getOutputStream().flush();

                is.close();
                socket.close();
            }
        } finally {
            System.out.println("server stop");
            serverSocket.close();
        }
    }

    public static String calculate(String[] requestItem) {
        double result = 0;
        String response = "";
        if (requestItem.length == 4) {
            switch (requestItem[1]) {
                case "+":
                    result = (Double.parseDouble(requestItem[2]) + Double.parseDouble(requestItem[3]));
                    break;
                case "-":
                    result = (Double.parseDouble(requestItem[2]) - Double.parseDouble(requestItem[3]));
                    break;
                case "*":
                    result = (Double.parseDouble(requestItem[2]) * Double.parseDouble(requestItem[3]));
                    break;
                case "/":
                    if (Double.parseDouble(requestItem[3]) == 0.0) {
                        response = "Illegal argument: " + requestItem[3];
                        return response;
                    } else {
                        result = (Double.parseDouble(requestItem[2]) / Double.parseDouble(requestItem[3]));
                    }
                    break;
            }
            response =  String.valueOf(result);

        } else {
            response = "Illegal argument count";
        }
        return response;
    }
}
