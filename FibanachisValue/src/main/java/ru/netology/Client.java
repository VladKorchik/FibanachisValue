package ru.netology;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    private static final String host = "127.0.0.1";
    private static final int port = 25111;

    public static void main(String[] args) {

        try (Socket socket = new Socket(host, port);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
             Scanner scanner = new Scanner(System.in)) {
            String input;
            while (true) {
                System.out.println("Введите номер числа из последовательности");
                input = scanner.nextLine();
                out.println(input);
                if ("end".equals(input)) break;
                System.out.println("SERVER: " + in.readLine());
            }
        }   catch (IOException | NumberFormatException ex) {
            ex.printStackTrace();
        }
    }
}
