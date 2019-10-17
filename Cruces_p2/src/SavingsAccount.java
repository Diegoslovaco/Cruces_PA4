
public class SavingsAccount {
    private double monthlyInterest;
    private double savingsBalance;
    private static double annualInterestRate;




    public SavingsAccount(double savingsBalance) {
        this.savingsBalance = savingsBalance;

    }

    public void modifyInterestRate(double annualInterestRate){
        this.annualInterestRate = annualInterestRate;

    }

    public void calculateMonthlyInterest(){
        monthlyInterest = savingsBalance * annualInterestRate / 12;
        updateSavingsBalance();
    }

    private void updateSavingsBalance(){
          savingsBalance = savingsBalance + monthlyInterest;
    }

    public double getSavingBalance(){
        return savingsBalance;
    }

    public double getAnnualInterestRate(){
        return annualInterestRate;
    }



}
