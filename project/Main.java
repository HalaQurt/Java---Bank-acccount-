package project;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;
import java.io.FileWriter; // Import the FileWriter class
import java.io.IOException; // Import the IOException class to handle errors

public class Main {
	public static void main(String[] args) {
		Bank ABC = new Bank();
		uploadDataFile(ABC);
		displayMainMenu(ABC);
	}

	public static void displayMainMenu(Bank ABC) {
		int userSelection;
		do {
			System.out
					.println("Please Select an Operation (1-8)" + "\n1-Add Account \r\n" + "\n2-View All Accounts \r\n"
							+ "\n3- Add Amount \r\n" + "\n4- Withdraw Amount \r\n" + "\n5- View Account Details \r\n"
							+ "\n6- Modify Account \r\n" + "\n7- Close an Account \r\n" + "\n8- Exit \r\n");
			Scanner input = new Scanner(System.in);
			 userSelection = input.nextInt();
			input.nextLine();
			switch (userSelection) {
			case 1:
				System.out.println("Enter Account ID , name, phoneNumber, account Type, Balance");
				Scanner data = new Scanner(System.in);
				int id = data.nextInt();
				String name = data.next();
				long phoneNumber = data.nextLong();
				char type = data.next().charAt(0);
				double balance = data.nextDouble();
				Account newAccount = new Account(id, name, phoneNumber, type, balance);
				ABC.addAccount(newAccount);
				break;
			case 2:
				ABC.displayAccounts();
				break;
			case 3:
				System.out.println("Enter Account ID ");
				Scanner scanner = new Scanner(System.in);
				int accountId = scanner.nextInt();
				Account account = ABC.findAccountById(accountId);
				if (account != null) {
					System.out.println("Enter added amount ");
					Scanner scan = new Scanner(System.in);
					double amount = scanner.nextDouble();
					account.addAmount(amount);
				}
				break;
			case 4:
				System.out.println("Enter Account ID ");
				Scanner scaning = new Scanner(System.in);
				int reqauredAccountId = scaning.nextInt();
				Account accounts = ABC.findAccountById(reqauredAccountId);
				if (accounts != null) {
					System.out.println("Enter withdrow amount ");
					Scanner scan = new Scanner(System.in);
					double amount = scaning.nextDouble();
					accounts.withdrawAmount(amount);
				}
				break;
			case 5:
				System.out.println("choose \n 1- Account ID \n 2- Holder name\n 3- part of the name ");
				Scanner scan = new Scanner(System.in);
				int choice = scan.nextInt();
				try {
					Account returnedAccount = ABC.viewAccountDetails(choice);
					System.out.println(returnedAccount.getID() + "  " + returnedAccount.getHolderName() + "  "
							+ returnedAccount.getPhoneNumber() + "  " + returnedAccount.getAccountType() + "  "
							+ returnedAccount.getBalance());
				} catch (NullPointerException e) {
					System.out.println("Account dosen't exist");
				}

				break;
			case 6:
				System.out.println("choose \n 1- Account ID \n 2- Holder name \n 3- part of the name ");
				Scanner scaner = new Scanner(System.in);
				int Choice = scaner.nextInt();
				ABC.modifyAccountDetails(Choice);
				break;
			case 7:
				System.out.println("Enter Account ID");
				Scanner scanr = new Scanner(System.in);
				int Id = scanr.nextInt();
				Account Account = ABC.findAccountById(Id);
				ABC.closeAccount(Account);
				break;
			case 8:
				System.out.println("Exit");
				break;
			default:
				System.out.println("Error try again");
				break;
			}
		} while (userSelection != 8);
		updateDataFile(ABC);

	}

	public static boolean uploadDataFile(Bank ABC) {

		try {
			File account = new File("C:\\Users\\PC\\Desktop\\account.txt");
			Scanner scanner = new Scanner(account);
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				String[] data = line.split(" ");
				int id = Integer.parseInt(data[0]);
				String holderName = data[1];
				long phoneNumber = Long.parseLong(data[2]);
				char accountType = data[3].charAt(0);
				double balance = Double.parseDouble(data[4]);
				Account bankAccount = new Account(id, holderName, phoneNumber, accountType, balance);
				ABC.addAccount(bankAccount);
			}
			scanner.close();
			return true;
		} catch (FileNotFoundException e) {
			System.out.println("the account data have not been uploded ");
			return false;

		}
	}

	public static void updateDataFile(Bank ABC) {
		try {
			FileWriter myWriter = new FileWriter("C:\\Users\\PC\\Desktop\\account.txt");

			for (int i = 0; i < ABC.getAccounts().size(); i++) {
				myWriter.write(ABC.getAccounts().get(i).getID() + " " + ABC.getAccounts().get(i).getHolderName() + " "
						+ ABC.getAccounts().get(i).getPhoneNumber() + " " + ABC.getAccounts().get(i).getAccountType()
						+ " " + ABC.getAccounts().get(i).getBalance() + "\n");

			}
			myWriter.close();
			System.out.println("Successfully wrote to the file.");
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}
}
