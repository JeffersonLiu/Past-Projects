public class Bank_Account{
  public long acct_num;
  private double balance;
  private String type;
  private float interest_rate;
  
  public Bank_Account (long acct, double bal, String ty, float interest){
    acct_num = acct;
    balance =bal;
    type = ty;
    interest_rate = interest;
  }
  
  public double getBalance(){
    System.out.println(balance);
    return balance;
  }
  
  public String getType(){
    System.out.println(type);
    return type;
  }
  
  public void deposit(double amt){
    balance += amt;
  }
  
  public boolean withdrawal(double amt){
    if (amt <= balance){
      balance -= amt;
      return true;
    }
    else{
      return false;
    }    
  }
  
  public void applyInterest(){
    balance += balance*interest_rate;
  }
  
  
  public static void main(String[] args){
    Bank_Account account1 = new Bank_Account(11111111, 1, "Student1", 0.011111f);
    Bank_Account account2 = new Bank_Account(22222222, 2, "Student2", 0.022222f);

    account1.getBalance();
    account1.getType();
    account1.deposit(30.0);
    account1.withdrawal(30.0);
  }
}

      
      
      