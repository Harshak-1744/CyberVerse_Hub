import java.util.*;


public class CyberVerse_Hub 
{
    public static void main(String [] args)
    {
        System.out.println("Welcome to CyberVerse_Hub...");

        System.out.println("Select a option to buy :-");

        ArrayList<ArrayList<String>> games = new ArrayList<>();
        ArrayList<String> id = new ArrayList<>();
        ArrayList<String> name = new ArrayList<>();

        
        id.add("[1]");
        id.add("[2]");
        id.add("[3]");
        id.add("[4]");
        id.add("[5]");

        name.add("The Witcher 3: Wild Hunt");
        name.add("Red Dead Redemption 2");
        name.add("Grand Theft Auto V");
        name.add("The Legend of Zelda: Breath of the Wild");
        name.add("Monster Hunter: World");

        games.add(id);
        games.add(name);


        /*games.add("[1] The Witcher 3: Wild Hunt");
        games.add("[2] Red Dead Redemption 2");
        games.add("[3] Grand Theft Auto V");
        games.add("[4] The Legend of Zelda: Breath of the Wild");
        games.add("[5] Monster Hunter: World");
        */


        for (int k = 0; k < games.get(0).size(); k++) 
        {
            System.out.println(games.get(0).get(k) + "\t" + games.get(1).get(k));
        }
       
       
       
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();

        switch(choice)
        {
            case 1:
                System.out.println("Thank you for Purchasing" + " "+  name.get(0));
                System.out.println("Your Bill is $35");
            break;
            case 2:
                System.out.println("Thank you for Purchasing" + " "+ name.get(1));
                System.out.println("Your Bill is $40");
            break;
            case 3:
                System.out.println("Thank you for Purchasing" + " "+ name.get(2));
                System.out.println("Your Bill is $45");
            break;
            case 4:
                System.out.println("Thank you for Purchasing" + " " + name.get(3));
                System.out.println("Your Bill is $50");
            break;
            case 5:
                System.out.println("Thank you for Purchasing" + " " + name.get(4));
                System.out.println("Your Bill is $30");
        }
        

        System.out.println("Choose the payment method :-");

        String [] arr = {"1. UPI, 2. CARD"};
        
        for(String pay : arr)
        {
            System.out.println(pay);
        }
        
        int Payment = sc.nextInt();
        
        

        switch(Payment)
        {
            case 1:
                System.out.println("UPI LINK");
            break;
            case 2:
                System.out.println("Do you want receipt");
            break;
        }
        System.out.println("Thank you for Shooping at CyberVerse_Hub");

    sc.close();
    }
}
