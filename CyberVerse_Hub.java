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

        displayPaymentMethods(games.get(choice-1));

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

    private static void displayPaymentMethods(Game purchasedGame) {
        System.out.println("Choose the payment method :-");
        String[] methods = { "UPI", "CARD" };

        for (int i = 0; i < methods.length; i++) {
            System.out.println((i+1) + ". " + methods[i]);
        }

        Scanner sc = new Scanner(System.in);
        int choice;
        String paymentMethod = "";
        while (true) {
            try {
                choice = sc.nextInt();
                if (choice == 1) {
                    paymentMethod = "UPI";
                    displayClickableLink("Click this link for UPI Payment:", "https://www.example.com/upi-payment");
                    break;
                } else if (choice == 2) {
                    paymentMethod = "CARD";
                    break;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Invalid choice. Please choose a valid payment method.");
            }
        }
        askForReceipt(sc, purchasedGame, paymentMethod);
        sc.close();
    }

    private static void askForReceipt(Scanner sc, Game purchasedGame, String paymentMethod) {
        System.out.println("Do you want a receipt? (yes/no)");
        String receiptChoice = sc.next();
        if (receiptChoice.equalsIgnoreCase("yes")) {
            generateReceipt(purchasedGame, paymentMethod);
        } else if (receiptChoice.equalsIgnoreCase("no")) {
            System.out.println("Receipt declined.");
        } else {
            System.out.println("Invalid choice. No receipt generated.");
        }
    }

    private static void generateReceipt(Game game, String paymentMethod) {
        System.out.println("---------- CyberVerse_Hub Receipt ----------");
        System.out.println("Game Purchased: " + game.name);
        System.out.println("Price: $" + game.price);
        System.out.println("Payment Method: " + paymentMethod);
        System.out.println("--------------------------------------------");
    }

    public static void displayClickableLink(String text, String url) {
        String clickableLink = "\u001B]8;;" + url + "\u001B\\"
                + text
                + "\u001B]8;;\u001B\\";
        System.out.println(clickableLink);
    }
}
