import java.util.*;
public class SecureRandom {

    static Random rand = new Random();
    private static int difficulty = -1;
    private static int mode = -1;
    private static int modeHolder = -1;
    private static boolean modeHolderBool = false;
    private static int num1 = -1;
    private static int num2 = -1;
    private static int userInput = -1;
    private static int correctAnswer = -1;
    private static boolean answer = false;
    private static String[] correctAnswers = {"Very good!", "Excellent!", "Nice work!", "Keep up the good work!"};
    private static String[] incorrectAnswers = {"No. Please try again.", "Wrong. Try once more.", "Don’t give up!", "No. Keep trying."};

    public SecureRandom(){
        num1 = rand.nextInt(10 + 1);
        num2 = rand.nextInt(10 + 1);
        correctAnswer = num1 * num2;

    }

    private static int indexOfAnswer(){
        int index = rand.nextInt(4);
        return index;
    }



    public static void printEquation(){
        if(mode == 1){
            System.out.println("how much is " + num1 + " plus " + num2);
        }else if(mode == 2){
            System.out.println("how much is " + num1 + " times " + num2);
        }else if(mode == 3){
            System.out.println("how much is " + num1 + " minus " + num2);
        }else if(mode == 4){
            System.out.println("how much is " + num1 + " divided by " + num2);
        }else if(mode == 5){
            printEquationModeFive(modeHolder);
        }
    }
    public static void printEquationModeFive(int mode){
        if(mode == 1){
            System.out.println("how much is " + num1 + " plus " + num2);
        }else if(mode == 2){
            System.out.println("how much is " + num1 + " times " + num2);
        }else if(mode == 3){
            System.out.println("how much is " + num1 + " minus " + num2);
        }else if(mode == 4){
            System.out.println("how much is " + num1 + " divided by " + num2);
        }
    }

    public static int getUserInput(Scanner input){
        System.out.print("Answer: ");
        userInput = input.nextInt();
        return userInput;
    }

    private int setAnswer(int mode) {
        int correctAnswer = 0;

        if (mode == 1) {
            correctAnswer = num1 + num2;
        } else if (mode == 2) {
            correctAnswer = num1 * num2;
        } else if (mode == 3) {
            correctAnswer = num1 - num2;
        } else if (mode == 4) {
            if (num2 == 0) {
                num2++;
            }
            correctAnswer = num1 / num2;
        }

        return correctAnswer;
    }

    public boolean checkAnswer(int userInput){
        if(mode == 5){
            correctAnswer = setAnswer(modeHolder);
            modeHolder = modeIsFive(mode);
        }else{
            correctAnswer = setAnswer(mode);
        }

        answer = false;
        int index = indexOfAnswer();

        if(userInput == correctAnswer){
            //System.out.println(correctAnswers[indexOfAnswer()] + "\n");
            switch(index){
                case 0:
                    System.out.println(correctAnswers[0]+ "\n");
                    break;
                case 1:
                    System.out.println(correctAnswers[1]+ "\n");
                    break;
                case 2:
                    System.out.println(correctAnswers[2]+ "\n");
                    break;
                case 3:
                    System.out.println(correctAnswers[3]+ "\n");
                    break;
                default:
                    System.out.println("error");
                    break;
            }
            return answer = true;
        }else{
            //System.out.println(incorrectAnswers[indexOfAnswer()] + "\n");
            switch(index){
                case 0:
                    System.out.println(incorrectAnswers[0]+ "\n");
                    break;
                case 1:
                    System.out.println(incorrectAnswers[1]+ "\n");
                    break;
                case 2:
                    System.out.println(incorrectAnswers[2]+ "\n");
                    break;
                case 3:
                    System.out.println(incorrectAnswers[3]+ "\n");
                    break;
                default:
                    System.out.println("error");
                    break;
            }
            return answer = false;
        }


    }

    public void setNums() {
        switch (difficulty) {
            case 1:
                num1 = rand.nextInt(10);
                num2 = rand.nextInt(10);
                break;
            case 2:
                num1 = rand.nextInt(100);
                num2 = rand.nextInt(100);
                break;
            case 3:
                num1 = rand.nextInt(1000);
                num2 = rand.nextInt(1000);
                break;
            case 4:
                num1 = rand.nextInt(10000);
                num2 = rand.nextInt(10000);
                break;
            default:
                break;
        }
        if(num2 == 0){
            num2++;
        }


    }

    public void setDifficulty(int difficulty){
        this.difficulty = difficulty;
    }

    public void setMode(int mode){
        this.mode = mode;
        if(mode == 5){
            modeHolderBool = true;
        }
        modeHolder = modeIsFive(mode);
    }

    private static int modeIsFive(int modeHolder){
       modeHolder = rand.nextInt(5);
        if(modeHolder == 0){
            modeHolder++;
        }
        return modeHolder;
    }
}
