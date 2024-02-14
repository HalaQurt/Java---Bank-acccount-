package project;

public class Account {
	private int ID;
	private String holderName;
	private long phoneNumber;
	private char accountType;
	private double balance = 0;

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getHolderName() {
		return holderName;
	}

	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public char getAccountType() {
		return accountType;
	}

	public void setAccountType(char accountType) {
		this.accountType = accountType;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Account(int ID, String holderName, long phoneNumber, char accountType, double balance) {
		this.ID = ID;
		this.holderName = holderName;
		this.accountType = accountType;
		this.phoneNumber = phoneNumber;
		this.balance = balance;
	}

	public Account() {
	}

	public void addAmount(double amount) {
		this.balance += amount;
	}

	public void withdrawAmount(double amount) {
		if (this.accountType == 's' && amount > 500) {
			System.out.println("withdraw is not possible");
			return;
		}
		this.balance -= amount;
	}
}
