package JavaBankApplication;
import java.util.Scanner;
import java.util.ArrayList;

// ************************************************************************
// BankProgram.java	 Template created on 15.9.2016
// - The program class for the BankApplication exercise
// ************************************************************************

public class BankProgram {

	private static ArrayList < Account > accountList = new ArrayList < Account > ();

	// *** DO NOT change anything in the main method ***
	public static void main(String[] args) {
		Scanner input = new Scanner(System. in );
		int choice = -1;

		while (choice != 0) {

			switch (choice) {
			case 1:
				listAccounts();
				break;
			case 2:
				addAccount();
				break;
			case 3:
				depositMoney();
				break;
			case 4:
				withdrawMoney();
				break;
			case 5:
				deleteAccount();
				break;
			}

			displayMenu();
			choice = Integer.parseInt(input.nextLine());
		}

		System.out.println("\nThe program ends now. Bye!");
		input.close();
	}

	private static void displayMenu() {
		String line = "-----------------------------------------------------" + "---------------------------------------------------------------";
		System.out.println(line);
		System.out.print(" 0 = Quit | 1 = List accounts | 2 = Add an account | " + "3 = Deposit money | 4 = Withdraw money | 5 = Delete an account \n");
		System.out.println(line);
		System.out.print("Enter your choice: ");
	}

	// *** NB! Edit only the methods below. DO NOT add any other methods! ***

	private static void listAccounts() {
		System.out.print("\n*** Account list ***\n");
		if (accountList.size() == 0) {
			System.out.println("Database empty.");
			System.out.println("");
		}
		else {
			for (int i = 0; i < accountList.size(); i++) {
				System.out.println("Number: " + accountList.get(i).getAccountNumber() + " | Balance: " + accountList.get(i).getBalance());
			}
			System.out.println("");
		}

	}

	private static void addAccount() {
		Scanner input = new Scanner(System. in );
		boolean existAlready = false;
		int isAccNum;
		System.out.print("\n*** Add an account ***\n");
		System.out.print("Enter new account number: ");
		String addAccountInput = input.nextLine();
		try {
			isAccNum = Integer.parseInt(addAccountInput);
			if (isAccNum <= 0) {
				System.out.println("Invalid input. Please enter a positive number.");
			}
			else if (accountList.size() == 0) {
				accountList.add(new Account(addAccountInput));;
				System.out.println("Account created successfully!");
				System.out.println("");
			}
			else {
				for (int i = 0; i < accountList.size(); i++) {
					if (addAccountInput.equals(accountList.get(i).getAccountNumber())) {
						existAlready = true;
						break;
					}
				}
				if (!existAlready) {
					accountList.add(new Account(addAccountInput));
					System.out.println("Account created successfully!");
					System.out.println("");
				}
				else {
					System.out.println("Account not created. Account " + addAccountInput + " exists already!");
					System.out.println("");
				}
			}
		}
		catch(NumberFormatException e) {
			System.out.println("Invalid input. Please enter a positive number.");
		}
	}
	/* input.close();//
        *Do not close scanner here. It'll close the scanner for the entire class.
        *Should not put check account and add account info in same loop. That will add acc info to accList every turn it checks. 
        *Check as separate loop and return a boolean if account exists already or not.*/

	// Finds an account in accountList by given account number.
	// Returns either a reference to the account object
	// OR null if the account is not found in accountList.

	private static Account findAccount(String accountNumber) {
		Account myAccount = null;
		for (int i = 0; i < accountList.size(); i++) {
			if (accountNumber.equals(accountList.get(i).getAccountNumber())) {
				myAccount = new Account("");
				// create myAcc null (points to no objects, value=null) then if found corresponding cc, only then create Account object//
				myAccount.setAccountNumber(accountList.get(i).getAccountNumber());
				myAccount.setBalance(accountList.get(i).getBalance());
				break;
			}
			//How is Account myAccount = null; different from Account myAccount = new Account("");?
			//String newString; means newString's value=null, references nothing -> newString=null means same thing, 
			//String newString= new String("") means newString references to a "" String-type object, its value is just an address to the object
			//newString = "" means the actual value of it is ""
			//pc processors can only handle primitive types && objects of a class cannot directly hold data -> class objects are all
			// reference variables
		}
		return myAccount;
	}

	private static void depositMoney() {
		Scanner input = new Scanner(System. in );
		System.out.print("\n*** Deposit money to an account ***\n");
		if (accountList.size() == 0) {
			System.out.println("Database empty.");
			System.out.println("");
		}
		else {
			Account dummyAcc = null;
			System.out.print("Enter account number: ");
			String depositNumInput = input.nextLine();
			//////////////

			dummyAcc = findAccount(depositNumInput);
			if (dummyAcc == null) {
				System.out.println("Account " + depositNumInput + " does not exists.");
				System.out.println("");
			}
			else {
				System.out.print("Enter the amount to be deposited: ");
				double deposit = Double.parseDouble(input.nextLine());
				if (deposit <= 0) {
					System.out.println("Invalid withdrawal amount. Please enter a positive number.");
				}
				else {
					for (int i = 0; i < accountList.size(); i++) {
						if (dummyAcc.getAccountNumber().equals(accountList.get(i).getAccountNumber())) {
							accountList.get(i).deposit(deposit);
							System.out.print("Deposit completed successfully!");
							System.out.println("");
							break;
						}
					}
				}
			}
		}
	}
	/*
			resultAcc = findAccount(depositNumInput);
			if (resultAcc == null) {
				System.out.println("Account "+depositNumInput+" does not exists.");
			}
			else {
			System.out.print("Enter the amount to be deposited: ");
			double deposit = Double.parseDouble(input.nextLine());
			resultAcc.deposit(deposit);
			System.out.print("Deposit completed successfully!");
			}
			*/
	//////////////////
	/*resultAcc=findAccount(accNum);
		System.out.print("Enter the amount to be deposited: ");
		
		double deposit = Double.parseDouble(input.nextLine());
		resultAcc.deposit(deposit);
		System.out.print("Deposit completed successfully!");*/

	private static void withdrawMoney() {
		Scanner input = new Scanner(System. in );
		System.out.print("\n*** Withdraw money from an account ***\n");
		if (accountList.size() == 0) {
			System.out.println("Database empty.");
			System.out.println("");
		}
		else {
			Account dummyAcc = null;
			boolean isWithdrawn = false;
			System.out.print("Enter account number: ");
			String withdrawNumInput = input.nextLine();
			//////////////

			dummyAcc = findAccount(withdrawNumInput);
			if (dummyAcc == null) {
				System.out.println("Account " + withdrawNumInput + " does not exists.");
				System.out.println("");
			}
			else {
				System.out.print("Enter the amount to be withdrawn: ");
				double withdrawal = Double.parseDouble(input.nextLine());
				if (withdrawal <= 0) {
					System.out.println("Invalid withdrawal amount. Please enter a positive number.");
				}
				else {
					for (int i = 0; i < accountList.size(); i++) {
						if (dummyAcc.getAccountNumber().equals(accountList.get(i).getAccountNumber()) && accountList.get(i).withdraw(withdrawal)) {
							//accountList.get(i).withdraw(withdrawal// ->Withdraws twice
							//Bad code practice : putting any functions that update values in if clause
							//Solution: loop, for each turn, check if acc correspond if yes then check if can withdraw if yes then withdraw
							System.out.print("Withdrawal completed successfully!");
							System.out.println("");
							isWithdrawn = true;
							break;
						}
						//if sentence does change values??`````
					}
					if (!isWithdrawn) {
						System.out.println("Withdrawal not completed. Available balance is too low.");
						System.out.println("");
					}
				}
			}
		}
	}

	private static void deleteAccount() {
		System.out.print("\n*** Delete an account ***\n");
		if (accountList.size() == 0) {
			System.out.println("There is nothing in the database to delete.");
			System.out.println("");
		}
		else {
			Scanner input = new Scanner(System. in );
			Account dummyAcc = null;
			System.out.print("Enter account number: ");
			String deleteAccountInput = input.nextLine();
			dummyAcc = findAccount(deleteAccountInput);
			if (dummyAcc == null) {
				System.out.println("Account " + deleteAccountInput + " does not exists.");
				System.out.println("");
			}
			else {
				for (int i = 0; i < accountList.size(); i++) {
					if (dummyAcc.getAccountNumber().equals(accountList.get(i).getAccountNumber())) {
						accountList.remove(i);
						System.out.println("Account deleted successfully!");
						System.out.println("");
						break;
					}
				}
			}
		}
	}
}

// End