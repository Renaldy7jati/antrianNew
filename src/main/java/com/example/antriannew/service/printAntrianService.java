package com.example.antriannew.service;

import com.example.antriannew.mainApp;
import com.example.antriannew.models.connection;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class printAntrianService {
    connection connection = new connection();



    public static void main(String[] args) throws IOException {

        InputStream inputStream = mainApp.class.getResource("Antrian.jasper").openStream();
        Reader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
        StringBuilder stringBuilder = new StringBuilder();
        while (inputStream.read() != -1){
            stringBuilder.append((char) reader.read());
            System.out.println(stringBuilder);
        }
    }
}
