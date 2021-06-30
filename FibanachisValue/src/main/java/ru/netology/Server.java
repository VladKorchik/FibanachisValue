package ru.netology;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private static final int port = 25111;
    private static boolean autoFlush = true;

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(port);
        while (true) {
            try (Socket socket = serverSocket.accept();
                 PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                 BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
                String line;
                while ((line = in.readLine()) != null) {
                    int valuePlace = Integer.parseInt(line);
                    int[] fibanachiArray = new int[valuePlace];
                    fibanachiArray[0] = 0;
                    fibanachiArray[1] = 1;
                    for (int i = 2; i < fibanachiArray.length; ++i ) {
                        fibanachiArray[i] = fibanachiArray[i - 1] + fibanachiArray[i - 2];
                    }
                    out.println(fibanachiArray[valuePlace - 1]);
                }
            } catch (IOException ex) {
                ex.printStackTrace(System.out);
            }
        }
    }
}