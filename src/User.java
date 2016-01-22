import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.ArrayList; 
import java.util.logging.Logger;


public class User {
	/**
	 * the user's first name
	 */
	private String firstName;
	
	/**
	 * the user's last name
	 */
	private String lastName;
	
	/**
	 * the user's unique identifier
	 */
	private String uuid;
	
	/**
	 * we'll use java's MD5 encryption to store pin number
	 */
	private byte pinHash[];
	
	private ArrayList<Account> accounts;
	
	/**
	 * Constructor for a new User
	 * @param firstName LOCAl variable that will be stored as instance var
	 * @param lastName  **
	 * @param pin		we'll use a MD5 MessageDigest to process
	 * @param theBank	need the bank so we can call it's methods
	 */
	public  User(String firstName, String lastName, String pin, Bank theBank){
		
		this.firstName = firstName;
		this.lastName = lastName;
		
		accounts=new ArrayList<>();
		
		try{
			MessageDigest md= MessageDigest.getInstance("MD5");		
			this.pinHash=md.digest(pin.getBytes());
		}  catch (NoSuchAlgorithmException ex){
			System.err.println("caught a NoSuchAlgorithmException");
			Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
			System.exit(1);
		}
		
		//ask the bank to generate an ID number
		this.uuid=theBank.getNewUserUUID();
		
		
		// alert the console of a new user
		System.out.printf("New user %s, %s with ID %s created. \n", lastName, firstName, this.uuid);
		
		
	}
	
	/**
	 * add an account to the instandce arraylist
	 * @param anAcct the account to add
	 */
	
	public void addAccount(Account anAcct){
		this.accounts.add(anAcct);
	}
	
	
	/**
	 * accessor method for the user id
	 * @return user uuid
	 */
	public String getUUID(){
		return this.uuid;
	}
	
	
	/**
	 * uses the md5 messagedigest to validate pin hash
	 * @param pin   uses the hash
	 * @return    true only if the pin isEqual
	 */
	public boolean validatePin(String pin){
		try{
			MessageDigest md= MessageDigest.getInstance("MD5");		
			return MessageDigest.isEqual(md.digest(pin.getBytes()), this.pinHash);
			
		}  catch (NoSuchAlgorithmException ex){
			System.err.println("caught a NoSuchAlgorithmException");
			Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
			System.exit(1);
		}
		
		return false;	
	}

}
