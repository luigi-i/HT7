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
        BinarySearchTree<Producto> bst = new BinarySearchTree<>();

        // Cargar datos desde CSV
        cargarCSV(bst);

        boolean seguir = true;
        while (seguir) {
            System.out.println("\nOpciones:");
            System.out.println("1. Buscar producto por SKU");
            System.out.println("2. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese SKU a buscar: ");
                    int sku = sc.nextInt();
                    Producto encontrado = bst.search(new Producto(sku, 0, 0, "", ""));
                    if (encontrado != null)
                        System.out.println("Producto encontrado: " + encontrado);
                    else
                        System.out.println("Producto no encontrado.");
                    break;
                case 2:
                    seguir = false;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
        sc.close();
    }

    public static void cargarCSV(BinarySearchTree<Producto> bst) {
        try (CSVReader reader = new CSVReader(new FileReader("SKUcsv.csv"))) {
            List<String[]> rows = reader.readAll();
            boolean isHeader = true;

            for (String[] row : rows) {
                if (isHeader) {
                    isHeader = false;
                    continue;
                }
                int SKU = Integer.parseInt(row[0]);
                float priceR = Float.parseFloat(row[1]);
                float priceC = Float.parseFloat(row[2]);
                String name = row[3];
                String category = row[4];

                bst.insert(new Producto(SKU, priceR, priceC, name, category));
            }
            System.out.println("Datos cargados exitosamente.");
        } catch (IOException | CsvException | NumberFormatException e) {
            e.printStackTrace();
        }

    }
      //Estructura del metodo y manejo de excepciones extraida de: https://infogonzalez.com/2024/11/lectura-y-escritura-de-ficheros-csv-con-java.html

}