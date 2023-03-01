package org.example;

import java.util.*;

//import com.google.gson.Gson;
//import com.google.gson.JsonObject;

public class Main {
    public static void main(String[] args) {
//        Gson gson = new Gson();
        Scanner scanner = new Scanner(System.in);
        String input;
//        String json;
        while (true) {
            input = scanner.nextLine();
            System.out.println(input);
            StringTokenizer tokenizer = new StringTokenizer(input, " ");
            String command = tokenizer.nextToken();

            if (input.equals("exit")) {
                break;
            }

            switch (command){
                case "addUser":
                    break;
                case "addProvider":
                    break;
                case "addCommodity":
                    break;

                default:
                    System.out.println("Invalid command.");
                    break;

            }

        }
        scanner.close();
        System.out.println("bye");
    }
}