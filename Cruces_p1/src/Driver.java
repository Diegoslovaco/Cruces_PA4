import java.util.*;
public class Driver {
    public static void main(String[] args){
        SecureRandom student = new SecureRandom();
        Scanner input = new Scanner(System.in);
        double correctAnswers = 0.0;
        double percent = 0.0;
        int userSelection;
        int userInput;
        while(true){
            while(true){
                System.out.print("Please select difficulty level (1 - 4): ");
                userSelection = input.nextInt();
                if(userSelection >= 1 && userSelection <= 4){
                    student.setDifficulty(userSelection);
                    break;
                }else{
                    System.out.println("Not a valid value, try again");
                }
            }

            while(true){
                System.out.print("Please select type of Arithmetic problem (1 - 5): ");
                userSelection = input.nextInt();
                if(userSelection >= 1 && userSelection <= 5){
                    student.setMode(userSelection);
                    break;
                }else{
                    System.out.println("Not a valid value, try again");
                }
            }



            for(int i = 0; i < 10; i++){
                student.printEquation();
                userInput = student.getUserInput(input);

                if(student.checkAnswer(userInput) == true) {
                    correctAnswers++;
                }
                student.setNums();
            }
            percent = (correctAnswers / 10.0) * 100;
            if(percent >= 75.0){
                System.out.println("\nCongratulations, you are ready to go to the next level!\n");
            }else{
                System.out.println("\nPlease ask your teacher for extra help.\n");
            }
            correctAnswers = 0;
        }





    }
}
