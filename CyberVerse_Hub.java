import java.util.*;

public class CyberVerse_Hub {
    
    static class Game {
        String name;
        double price;

        Game(String name, double price) {
            this.name = name;
            this.price = price;
        }
    }

    public static void main(String[] args) {
        System.out.println("Welcome to CyberVerse_Hub...");

        List<Game> games = createGamesList();

        displayGames(games);

        int choice = getUserChoice(games.size());

        System.out.println("Thank you for purchasing " + games.get(choice-1).name);
        System.out.println("Your Bill is $" + games.get(choice-1).price);

        displayPaymentMethods();
        
        System.out.println("Thank you for shopping at CyberVerse_Hub");
    }

    private static List<Game> createGamesList() {
        return Arrays.asList(
            new Game("The Witcher 3: Wild Hunt", 35),
            new Game("Red Dead Redemption 2", 40),
            new Game("Grand Theft Auto V", 45),
            new Game("The Legend of Zelda: Breath of the Wild", 50),
            new Game("Monster Hunter: World", 30)
        );
    }

    private static void displayGames(List<Game> games) {
        for (int i = 0; i < games.size(); i++) {
            System.out.println("[" + (i+1) + "] " + games.get(i).name);
        }
    }

    private static int getUserChoice(int max) {
        Scanner sc = new Scanner(System.in);
        int choice;
        while (true) {
            try {
                choice = sc.nextInt();
                if (choice > 0 && choice <= max) return choice;
                else throw new Exception();
            } catch (Exception e) {
                System.out.println("Invalid choice. Please choose a valid game number.");
            }
        }
    }

    private static void displayPaymentMethods() {
        System.out.println("Choose the payment method :-");
        String[] methods = { "UPI", "CARD" };

        for (int i = 0; i < methods.length; i++) {
            System.out.println((i+1) + ". " + methods[i]);
        }

        Scanner sc = new Scanner(System.in);
        int choice;
        while (true) {
            try {
                choice = sc.nextInt();
                if (choice == 1) {
                    displayClickableLink("Click this link for UPI Payment:", "https://www.example.com/upi-payment");
                    break;
                } else if (choice == 2) {
                    System.out.println("Do you want a receipt?");
                    break;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Invalid choice. Please choose a valid payment method.");
            }
        }
        sc.close();
    }

    public static void displayClickableLink(String text, String url) {
        String clickableLink = "\u001B]8;;" + url + "\u001B\\" 
                + text 
                + "\u001B]8;;\u001B\\";
        System.out.println(clickableLink);
    }
}
