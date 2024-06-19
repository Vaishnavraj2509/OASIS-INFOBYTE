import java.util.*;
public class numbergame {
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        Random random = new Random();
        int n = random.nextInt(100)+1;
        for(int i=1;i<=100;i++){
            System.out.print("  " + i);
        }
     System.out.println("\nGuess the number between 1 and 100. You have 3 attempts.");

             System.out.print("Enter your guess: ");
             int guess=sc.nextInt();

             if(guess>n)
             System.out.println("Try a smaller number.");
             else if(guess<n)
             System.out.println("Try a larger number.");


            if(n==guess){
               System.out.println("Congratulations! You guessed the correct number.");

        }

        else{
                System.out.println("Incorrect guess left with 2 attempts");
}

        int guess1=sc.nextInt();
        if(guess1>n)
             System.out.println("Try a smaller number.");
             else if(guess1<n)
             System.out.println("Try a larger number.");

        if(n==guess1){
            System.out.println("Congratulations! You guessed the correct number.");
        }
        else{
            System.out.println("Incorrect guess left with 1 attempts");
        }

        int guess2=sc.nextInt();

        if(n==guess2){
            System.out.println("Congratulations! You guessed the correct number.");
        }
        else{
    System.out.println("Sorry, you've run out of attempts. The correct number was " + n + ".");
            }
    }

}




