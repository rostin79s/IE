package rostin;

import java.util.*;
import com.google.gson.*;

class User {
    private String username;
    private String password;
    private String email;
    private String birthDate;
    private String address;
    private int credit;

    public String getUsername() {
        return username;
    }
}
class Provider{
    private int id;
    private String name;
    private String registryDate;

    public int getId(){
        return id;
    }
}

class Commodity{
    private int id;
    private String name;
    private int providerId;
    private int price;
    private String[] categories;
    private double rating;
    private int inStock;

    public int getId(){
        return id;
    }
}

public class Main {
    private static List<User> userList = new ArrayList<User>();
    private static List<Provider> providerList = new ArrayList<Provider>();
    private static List<Commodity> commodityList = new ArrayList<Commodity>();

    public static void main(String[] args) {
        Gson gson = new Gson();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String input = scanner.nextLine();
            String command = input.substring(0, input.indexOf(' '));
            String json;
            if (input.equals("exit")) {
                break;
            }

            switch (command){

                case "addUser":
                    json = input.substring(input.indexOf(' ')+1);
                    User user = gson.fromJson(json, User.class);

                    if (!user.getUsername().matches("^[a-zA-Z0-9]+$")) {
                        System.out.println("Error: Username must be alphanumeric.");
                    } else if (userList.stream().anyMatch(u -> u.getUsername().equals(user.getUsername()))) {
                        System.out.println("Error: Username already exists.");
                    } else {
                        userList.add(user);
                        System.out.println("User added successfully.");
                    }
                    break;


                case "addProvider":
                    json = input.substring(input.indexOf(' ')+1);
                    json = "{\"id\": 1, \"name\": \"provider1\", \"registryDate\": \"2023-09-15\"}";
                    System.out.println(json);
                    Provider provider = gson.fromJson(json,Provider.class);
                    System.out.println(provider.getId());
                    providerList.add(provider);
                    break;

                case "addCommodity":
                    json = input.substring(input.indexOf(' ')+1);
                    json = "{\"id\": 1, \"name\": \"Headphone\", \"providerId\": 3, \"price\": 35000, \"categories\": \"[Technology, Phone]\", \"rating\": 8.8, \"inStock\": 50}";
                    System.out.println(json);
                    Commodity commodity = gson.fromJson(json,Commodity.class);

                    if (commodityList.stream().anyMatch(u -> u.getId()==commodity.getId())) {
                        System.out.println("Error: commodity id already exists.");
                    }
                    else if (providerList.stream().anyMatch(u -> u.getId()==commodity.getId())) {
                        commodityList.add(commodity);
                    }
                    else {
                        System.out.println("Error: commodity does not have a provider");
                    }
                    break;

                case "getCommoditiesList":
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