package project;
import java.util.ArrayList;
import java.util.Scanner;

public class Bank {
	public Bank() {

	}

	static ArrayList<Account> accounts = new ArrayList<Account>();

	public static ArrayList<Account> getAccounts() {
		return accounts;
	}

	public void displayAccounts() {
		for (int counter = 0; counter < accounts.size(); counter++) {
			Account account = accounts.get(counter);
			System.out.println(account.getID() + "  " + account.getHolderName() + "  " + account.getPhoneNumber() + "  "
					+ account.getAccountType() + "  " + account.getBalance());
		}
	}

	public Account findAccountById(int id) {
		for (int counter = 0; counter < accounts.size(); counter++) {
			if (accounts.get(counter).getID() == id) {
				return accounts.get(counter);
			}
		}
		return null;
	}

	public void addAccount(Account a) {
		if (findAccountById(a.getID()) == null)
			accounts.add(a);
		else
			System.out.println("account aleady exsits");

	}

	public void closeAccount(Account b) {
		for (int i = 0; i < accounts.size(); i++) {
			if (accounts.get(i).getID() == b.getID()) {
				accounts.remove(i);
				return;
			}
		}
		System.out.println("account dose not exsits");

	}

	public Account viewAccountDetails(int choice) {
		switch (choice) {
		case 1:
			System.out.println("Enter Id");
			Scanner scaning = new Scanner(System.in);
			int reqauredAccountId = scaning.nextInt();
			Account account = findAccountById(reqauredAccountId);
			if (account != null) {
				return account;
			}

			break;
		case 2:
			System.out.println("Enter name");
			Scanner scan = new Scanner(System.in);
			String reqauredAccountname = scan.nextLine();
			for (int counter = 0; counter < accounts.size(); counter++) {
				if (accounts.get(counter).getHolderName().equals(reqauredAccountname)) {
					return accounts.get(counter);
				}
			}
			break;
		case 3:
			System.out.println("Enter part of the name");
			Scanner scaner = new Scanner(System.in);
			String reqauredPartOfTheName = scaner.nextLine();
			for (int counter = 0; counter < accounts.size(); counter++) {
				if (accounts.get(counter).getHolderName().contains(reqauredPartOfTheName)) {
            System.out.println(accounts.get(counter)) ;                
				}
				

			}
			
		default:
			System.out.println("unvalid choice");
			return null;
		}
		return null;

	}

	public void modifyAccountDetails(int Choice) {
		switch (Choice) {
		case 1:
			System.out.println("Enter Id");
			Scanner scaning = new Scanner(System.in);
			int reqauredAccountId = scaning.nextInt();
			System.out.println(
					"Enter new Id , Enter new holder name , enter new phone number , enter new account type , enter new balance ");
			Scanner input = new Scanner(System.in);
			int id = input.nextInt();
			String name = input.next();
			long phoneNumber = input.nextLong();
			char type = input.next().charAt(0);
			double balance = input.nextDouble();
			Account newAccount = new Account(id, name, phoneNumber, type, balance);
			for (int counter = 0; counter < accounts.size(); counter++) {
				if (accounts.get(counter).getID() == reqauredAccountId) {
					accounts.set(counter, newAccount);
				}
			}

			break;
		case 2:
			System.out.println("Enter holder name");
			Scanner scan = new Scanner(System.in);
			String reqauredAccountName = scan.nextLine();
			System.out.println(
					"Enter new Id , Enter new holder name , enter new phone number , enter new account type , enter new balance ");
			Scanner scaner = new Scanner(System.in);
			int Id = scaner.nextInt();
			String Name = scaner.next();
			long PhoneNumber = scaner.nextLong();
			char Type = scaner.next().charAt(0);
			double Balance = scaner.nextDouble();
			Account account = new Account(Id, Name, PhoneNumber, Type, Balance);
			for (int counter = 0; counter < accounts.size(); counter++) {
				if (accounts.get(counter).getHolderName().equals(reqauredAccountName)) {
					accounts.set(counter, account);
				}
			}
			break;
		case 3:
			System.out.println("Enter part of the name");
			Scanner scanning = new Scanner(System.in);
			String reqauredPartOfTheName = scanning.nextLine();
			System.out.println(
					"Enter new Id , Enter new holder name , enter new phone number , enter new account type , enter new balance ");
			Scanner inputs = new Scanner(System.in);
			int ID = inputs.nextInt();
			String namePart = inputs.next();
			long newPhoneNumber = inputs.nextLong();
			char newType = inputs.next().charAt(0);
			double newBalance = inputs.nextDouble();
			Account bankAccount = new Account(ID, namePart, newPhoneNumber, newType, newBalance);
			for (int counter = 0; counter < accounts.size(); counter++) {
				if (accounts.get(counter).getHolderName().contains(reqauredPartOfTheName)) {
					accounts.set(counter, bankAccount);
				}

			}
			break;
		default:
			System.out.println("unvalid choice");

		}

	}

}
