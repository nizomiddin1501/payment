package uz.developers;

import uz.developers.model.Account;
import uz.developers.service.DatabaseService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        DatabaseService databaseService = new DatabaseService();


        boolean islui = true;

        while (islui) {
            System.out.println("0 => Exit, " +
                    "1 => Add Accounts, " +
                    "2 => Edit Account, " +
                    "3 => Delete Account, " +
                    "4 => transfer, " +
                    "5 => List Accounts, " +
                    "6 => Account(id), " +
                    "7 => Transactions list");
            int i = scanner.nextInt();
            switch (i) {
                case 0:
                    return;
                case 1:
                    System.out.println("Enter username");
                    String username = scanner.next();
                    System.out.println("Enter phoneNumber");
                    String phone_number = scanner.next();
                    //TODO rejex
                    System.out.println("Enter card number");
                    // String card_number = scanner.next();
                    String card_number = isTrue();
                    System.out.println("Enter your balance");
                    int balance = scanner.nextInt();
                    Account user = new Account(username, phone_number, card_number, balance);
                    databaseService.addAccount(user);
                    break;
                case 2:
                    System.out.println("Enter users' id");
                    int id = scanner.nextInt();
                    System.out.println("Enter editing firstname");
                    username = scanner.next();
                    System.out.println("Enter editing lastname");
                    phone_number = scanner.next();
                    System.out.println("Enter editing username");
                    card_number = scanner.next();
                    Account account = new Account(id, username, phone_number, card_number);
                    databaseService.editAccount(account);
                    break;
                case 3:
                    System.out.println("Enter account id");
                    id = scanner.nextInt();
                    databaseService.deleteAccount(id);
                    break;
                case 4:
                    System.out.println("Enter sender's cardNumber");
                    String senderCardNumber = scanner.next();
                    System.out.println("Enter receiver's cardNumber");
                    String receiverCardNumber = scanner.next();
                    System.out.println("Enter sending amount");
                    int sendingAmount = scanner.nextInt();
                    databaseService.transfer(senderCardNumber, receiverCardNumber, sendingAmount);
                    break;
                case 5:
                    databaseService.getAccounts();
                    break;
                case 6:
                    System.out.println("Enter account id");
                    id = scanner.nextInt();
                    databaseService.getAccount(id);
                    break;
                case 7:
                    System.out.println(databaseService.getAllTransactions());
            }
        }


    }

    public static String isTrue() {
        Scanner scanner = new Scanner(System.in);
        String cardNumber;
        while (true) {
            System.out.println("Entering card number must have (16 digits):");
            cardNumber = scanner.next();
            if (cardNumber != null && cardNumber.length() == 16 && cardNumber.matches("\\d+")) {
                return cardNumber;
            } else {
                System.out.println("Invalid card number. Please enter a 16-digit card number.");
            }
        }
    }
}
