package uz.developers.controller;

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
                    "4 => List Accounts, " +
                    "5 => Account by Id");
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
                    System.out.println("Enter sender's cardNumber");
                    String senderCardNumber = scanner.next();
                    System.out.println("Enter receiver's cardNumber");
                    String receiverCardNumber = scanner.next();
                    System.out.println("Enter sending amount");
                    int sendingAmount = scanner.nextInt();
                    databaseService.transfer(senderCardNumber, receiverCardNumber, sendingAmount);
                    break;
                case 3:
                    System.out.println("Enter account id");
                    int id = scanner.nextInt();
                    databaseService.deleteAccount(id);
                    break;
                case 4:
                    databaseService.getAccounts();
                    break;
                case 5:
                    System.out.println("Enter account id");
                    id = scanner.nextInt();
                    databaseService.getAccount(id);
                    break;
            }
        }


    }

    public static String isTrue() {
        Scanner scanner = new Scanner(System.in);
        String cardNumber ;
        while (true) {
            System.out.println("Entering card number must have (16 digits):");
            cardNumber = scanner.next();
            if (cardNumber != null && cardNumber.length() == 16 && cardNumber.matches("\\d+")){
                return cardNumber;
            } else {
                System.out.println("Invalid card number. Please enter a 16-digit card number.");
            }
        }
    }
}
