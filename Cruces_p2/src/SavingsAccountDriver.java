public class SavingsAccountDriver {

    public static void main(String args[]){
        SavingsAccount saver1 = new SavingsAccount(3000.00);
        SavingsAccount saver2 = new SavingsAccount(2000.00);

        saver1.modifyInterestRate(0.04);

        for(int i = 0; i < 12; i++){
            saver1.calculateMonthlyInterest();
            saver2.calculateMonthlyInterest();
            System.out.println("Month " + (i+1));
            System.out.printf("     Saver 1 balance is: %.2f\n", saver1.getSavingBalance());
            System.out.printf("     Saver 2 balance is: %.2f\n", saver2.getSavingBalance());
        }

        saver2.modifyInterestRate(0.05);

        saver1.calculateMonthlyInterest();
        saver2.calculateMonthlyInterest();

        System.out.printf("\nSaver 1 balance for the next month is: %.2f\n", saver1.getSavingBalance());
        System.out.printf("Saver 2 balance for the next month is: %.2f\n", saver2.getSavingBalance());

    }

}
