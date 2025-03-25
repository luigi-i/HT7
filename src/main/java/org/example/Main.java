package org.example;


import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String input = "";
        boolean seguir = true;

        while(seguir){
            System.out.println("Hola");
            input = sc.nextLine();


        }

    }

    public static void csvfile() {

        try (CSVReader reader = new CSVReader(new FileReader("SKUcsv.csv"))) {
            List<String[]> rows = reader.readAll();
            boolean isHeader = true;

            for (String[] row : rows) {
                if (isHeader) { // Saltar la primera fila si es encabezado
                    isHeader = false;
                    continue;
                }

            }
        } catch (IOException | CsvException | NumberFormatException e) {
            e.printStackTrace();
        }

        //Estructura del metodo y manejo de excepciones extraida de: https://infogonzalez.com/2024/11/lectura-y-escritura-de-ficheros-csv-con-java.html

    }

}