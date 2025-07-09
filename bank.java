package real_time;
import java.util.*;

/* 1. Bank Management System**

**Concepts:** Encapsulation, Inheritance, Abstraction
**Problem:**
Design a system to manage different types of bank accounts (e.g., savings, current).

* Common properties: account number, balance, customer name.
* Savings account has interest calculation.
* Current account has overdraft limit.
* Use methods for `deposit()`, `withdraw()`, and `displayDetails()`.
* Use abstract classes or interfaces to define common behavior.
* */


class Account{
	 String name;
	 int Accountnumber;
	 double balance;
	
	public Account(String name,int number,double amount){
		this.name=name;
		this.Accountnumber=number;
		this.balance=amount;
	}
	

	void displayInfo() {
		System.out.println("User Name : " +this.name+ "\t\tAccount number : "+this.Accountnumber+ "\tBalance Amount : " +this.balance);
//		System.out.println(name);
//		System.out.println(balance);
//		System.out.println(Accountnumber);
	}
}
 


class bank {
	static Scanner sc=new Scanner(System.in);
	static ArrayList<Account> list =new ArrayList<>();
//	static Account acc=new Account();
	
	static void addAccount() {
		Random rand=new Random();
		System.out.println("====================Account Creation ================");
		
		System.out.println("Enter the Account Holder Name : ");
		sc.nextLine();
		String name=sc.nextLine();
		
		
		System.out.println("Creating your Account number : ");
		int number=rand.nextInt(100000);
		System.out.println(number);
		
		System.out.println("Enter your initial balance : ");
		double balance=sc.nextDouble();
		sc.nextLine();
		
		if(balance<500) {
			System.out.println("The minimum balance of the account is 500 ");
			 balance=sc.nextDouble();
			
		}
		//else {
		System.out.println("your account balance is "+balance);
		
		list.add(new Account(name,number,balance));
		System.out.println("Account creation successful....");
		//}
			
	}
	
	static void viewallAccount() {
		if(list.isEmpty()) {
			System.out.println("No users found");
		}
		else {
			for(Account a:list) {
				a.displayInfo();
			}	
		}
		
	}
	
	static void updateAccount() {
		System.out.println("Enter your Account number :");
		int num=sc.nextInt();
		boolean isaccount=false;
		for(Account a:list) {
			if(a.Accountnumber==num) {
				System.out.println("Enter new Name of Account Holder :");
				sc.nextLine();
				String name=sc.nextLine();
				a.name=name;
				isaccount=true;
				System.out.println("Account update succesfull");
				break;
					
			}
			
		}
		
		if(!isaccount) {
			System.out.println(" no such type of account in our bank . please check you account number ...!");
			
		}
		
	}
	
	static void deleteAccount() {
	    System.out.println("Enter the account number to delete it permanently:");
	    int number = sc.nextInt();
	    boolean deleted = false;

	    Iterator<Account> iterator = list.iterator();
	    while (iterator.hasNext()) {
	        Account a = iterator.next();
	        if (a.Accountnumber == number) {
	            iterator.remove();  // ✅ Safe removal
	            deleted = true;
	            break;  // Optional: Stop after deleting the match
	        }
	    }

	    if (deleted) {
	        System.out.println("Your account is removed.");
	    } else {
	        System.out.println("Account not found or server busy. Please try later.");
	    }
	}

	public static void main(String args[]) {
		int ch;
		do {
		System.out.println("===================== SBI Bank ==============================");
		System.out.println("1. Create new Account ");
		System.out.println("2. View All Account ");
		System.out.println("3. Update Account ");
		System.out.println("4. Delete Account ");
		System.out.println("5. Thank you for using our services");
		System.out.println("Enter your choice ");
		ch=sc.nextInt();
		switch(ch) {
		case 1 -> addAccount();
		case 2 -> viewallAccount();
		case 3 -> updateAccount();
		case 4 -> deleteAccount();
		}
		}while(ch!=5);
		
		System.out.println("===================== Thank you   ==============================");
			
	}
	
}
