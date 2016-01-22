import java.util.Scanner;




public class ATM {
	public static void main(String[] args) {
	
		//init Scanner
		Scanner sc=new Scanner(System.in);
		
		
		//init a bank for testing
		Bank theBank=new Bank("aName");
		
		User aUser=theBank.addUser("John","Doe","1234");
		
		Account newAccount=new Account("checking", aUser, theBank);
		aUser.addAccount(newAccount);
		theBank.addAccount(newAccount);
		
		//create a user object for our current user
		User curUser;
		
		//stay in the main class until user quit
		while (true){
			//login prompt, user canat get past until validated
			curUser=ATM.mainMenuPrompt(theBank, sc);
			
			ATM.printUserMenu(curUser,sc);
		}
	
	}
	
	public static User mainMenuPrompt(Bank theBank,Scanner sc){
		//inits
		String userID;
		String pin;
		User authUser;
		
		//prompt the user for userID/pin combo
		
		do{
			System.out.printf("\n\nwelcome to %s\n\n", theBank.getName());
			System.out.print("enter userID");
			userID=sc.nextLine();
			System.out.print("Enter pin:");
			pin =sc.nextLine();
			
			//try to get user object corresponding to his id and pin
			authUser=theBank.userLogin(userID, pin);
			
			if (authUser==null){
				System.out.println("incorrect user ID/pin comno"+"plz try again");
			}
		} while(authUser==null);
		return authUser;
	}
}
