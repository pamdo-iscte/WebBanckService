package demo;

public class ClientAccount {
	private String name;
	private int id;
	private double funds;
	private String currency;
	
	
	public ClientAccount(int id,String name,String currency, double initialFunds) {
		this.name=name;
		this.id=id;
		this.currency=currency;
		this.funds= initialFunds;
		
		
	}
	
	
	public int getId() {
		return id;
	}


	public double getFunds() {
		return funds;
	}


	public void addFunds(double amount) {
		this.funds += amount;
	}
	
	public void  removeFunds (double amount ) {
		
		if(funds -amount >0) {
			this.funds -= amount;
			System.out.println("HAS ON ACCOUNT: "+funds );
			
		}else System.out.println("insufficient funds: " );
	}
	


	public String getCurrency() {
		return currency;
	}


	public void setCurrency(String currency) {
		this.currency = currency;
	}


	
	
	

}
