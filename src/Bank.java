import java.util.ArrayList; 
import java.util.Random;


public class Bank {
	
	/**
	 * the name of the bank
	 */
	private String name;
	
	/**
	 * the list of users
	 */
	private ArrayList<User> users;
	
	/**
	 * the list of accounts
	 */
	private ArrayList<Account> accounts;
	
	
	/**
	 * bank constructor, initialize arraylists
	 * @param name set the name from the parameter
	 */
	public Bank(String name){
		this.name=name;
		
		//initialize our two arraylists
		users=new ArrayList<>();
		accounts=new ArrayList<>();
		
	}
	
	
	public String getNewUserUUID(){
		
		String uuid;
		Random rng= new Random();
		int len=6;
		boolean nonUnique;
		
		
		do{
			uuid="";//start with a blank UUID
			//generate a random number
			for (int k=0;k<len;k++){
				uuid+=((Integer)rng.nextInt(10)).toString();
			}
			nonUnique=false;
			
			//check to see if it's unique
			
			
			for(User u:this.users){
				if (uuid.compareTo(u.getUUID())==0){
					nonUnique=true;
					break;
				}
			}
			
		} while(nonUnique);
		return uuid;
	}
	
	public String getNewAccountUUID(){
		
		String uuid;
		Random rng= new Random();
		int len=10;
		boolean nonUnique;
		
		
		do{
			uuid="";//start with a blank UUID
			//generate a random number
			for (int k=0;k<len;k++){
				uuid+=((Integer)rng.nextInt(10)).toString();
			}
			nonUnique=false;
			
			//check to see if it's unique
			
			
			for(Account a:this.accounts){
				if (uuid.compareTo(a.getUUID())==0){
					nonUnique=true;
					break;
				}
			}
			
		} while(nonUnique);
		return uuid;
	}
		
	

	/**
	 * add an account to the instance array list
	 * @param anAcct the account to add
	 */
	
	public void addAccount(Account anAcct){
		this.accounts.add(anAcct);
	}
	
	
	/**
	 * create a new user of the bank
	 * @param firstName
	 * @param lastName
	 * @param pin
	 * @return
	 */
	public User addUser(String firstName, String lastName, String pin){
		//create a new User object and add it to our list
		User newUser=new User(firstName, lastName, pin, this);
		this.users.add(newUser);
		
		//create a saving account
		Account newAccount=new Account("savings",newUser, this);
		newUser.addAccount(newAccount);
		this.accounts.add(newAccount);
		
		return newUser;
	}
	
	
	/**
	 * allow the user to login
	 * @param userID  user entered id number we will compare
	 * @param pin     we'll pass the pin to the user;s validate method
	 * @return   return user if validated
	 */
	public User userLogin(String userID, String pin){
		for (User u: this.users){
			//if we find user, nad pin, return user object
			if (u.getUUID().compareTo(userID)==0&&u.validatePin(pin)){
				return u;
			}
		}
		return null;
	}
	
	
	/**
	 * accessor method
	 * @return
	 */
	public String getName(){
		return this.name;
	}
}
