import java.util.ArrayList; 
		
public class Account {
	/**
	 * the type of account
	 */
	private String name; 
	
	/**
	 * Unique universal UD, alphanumeric
	 */
	private String uuid;
	
	/**
	 * the User object associated with the account
	 */
	private User holder;
	
	/**
	 * A list of all transactions associated with this account
	 */
	private ArrayList<Transaction> transactions;
	
	public  Account(String name, User holder, Bank theBank){
		//set basic vaules
		this.name=name;
		this.holder=holder;
		
		//ask the bank to issue a new UUID
		this.uuid=theBank.getNewAccountUUID();
		
		this.transactions=new ArrayList<>();		
	}
	

	/**
	 * accessor method for the account id
	 * @return user uuid
	 */
	public String getUUID(){
		return this.uuid;
	}
}
