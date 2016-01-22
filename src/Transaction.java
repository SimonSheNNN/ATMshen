import java.util.Date;


public class Transaction {

	/**
	 * the size of this transaction
	 */
	private static double amount;
	
	/**
	 * the time of the transaction, using java's Date object
	 */
	private Date timeStamp;
	
	/**
	 * An optional note about the purpose of this transaction
	 */
	private String memo;
	
	/**
	 * the amount from which this transaction originates
	 */
	private Account inAccount;
	
	/**
	 * create a new transaction
	 * @param amount amount transacted
	 * @param inAccount account this transaction belongs to
	 */
	public Transaction (double amount, Account inAccount){
		this.amount=amount;
		this.inAccount=inAccount;
		this.timeStamp=new Date();
		this.memo="";
	}
	
	public Transaction(double anount, String memo, Account inAccount){
		//call the two-grg constructor first
		this(amount, inAccount);
		//set memo
		this.memo=memo;
	}
	
}
