package com.ek.rockpaperscissors;
import java.util.Random;
import java.util.Scanner;

/**
 * @author Easmile
 */
public class RockPaperScissors {
    static int winCount;
    static int loseCount;
    static int tieCount;
    
    public static void main(String[] args){
        int playerChoice;
        int computerChoice;
        String playAgain;
        boolean keepPlaying = true;
        Scanner sc = new Scanner(System.in);
        
        while(keepPlaying){
        winCount = 0;
        loseCount = 0;
        tieCount = 0;
        int numRounds = readValue("How many rounds would you like to play?");
        if (numRounds > 10 || numRounds < 1){
            System.out.println("Please enter a number between 1 and 10...");
            System.exit(0);
        }
            for(int i = 0; i < numRounds; i++){
                playerChoice = readValue("What hand would you like to choose? Rock is 1, Paper is 2, Scissors is 3");
                computerChoice = 1 + new Random().nextInt(3);
                result(playerChoice,computerChoice);
            }
            
            printResult(winCount,loseCount,tieCount);
            System.out.println("Would you like to play again? Type yes or no.");
            playAgain = sc.nextLine();
            
            if(playAgain.equals("no")){
                keepPlaying = false;
                System.out.println("Thanks for playing!");
                break;
            }
            else{
                keepPlaying = true;
            }
        }
        
        
    }
    
    public static int readValue(String prompt){
        Scanner sc = new Scanner(System.in);
        System.out.println(prompt);
        String input = sc.nextLine();
        int intVal = Integer.parseInt(input);
        return intVal;
    }
    
    public static void result(int player,int computer){
        int subValue = player - computer;
        if(subValue == 0){
            tieCount++;
            System.out.println("You Tied!");
        }
        else if(subValue == 1 || subValue == -2){
            winCount++;
            System.out.println("You Won!");
        }
        else if(subValue == 2 || subValue == -1){
            loseCount++;
            System.out.println("You Lost!");        
        }
        
    }
    
    public static void printResult(int wins, int losses, int ties){
        System.out.println("Thanks for playing! You won: " + wins + " rounds, lost: " + losses + " rounds, and tied: " + ties + " rounds.");
        if(wins > losses){
            System.out.println("Congratultions, you won!");
        } else if (losses > wins){
            System.out.println("Sorry, you lost...");
        }else {
            System.out.println("It was a tie!");
        }
        
    }
    
}
