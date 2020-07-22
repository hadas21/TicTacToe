package tictactoe;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class tictactoe {

	static ArrayList <Integer> playerPossision = new ArrayList<Integer>();
	static ArrayList <Integer> cpuPossision = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		
		Scanner name = new Scanner(System.in);
		System.out.println("Helo, what is your name?");
		String playername = name.next();
		
		 char [][] gameBoard = {{' ','|',' ','|',' '},
	               {'-','+','-','+','-'},	
	               {' ','|',' ','|',' '},
	               {'-','+','-','+','-'},
	               {' ','|',' ','|',' '}};
		boolean gameOn = true;
		
		
		while(gameOn) {
			
		Scanner scan = new Scanner(System.in);
		System.out.println(name + " ,Enter your placement (1-9):");
		int playerPos = scan.nextInt();
		
		while(playerPossision.contains(playerPos) || cpuPossision.contains(playerPos)) {
			System.out.println("possision taken, sorry... try again:");
			playerPos = scan.nextInt();
		}
				placepiece(gameBoard,playerPos,"player");
				printgameBoard(gameBoard);
				
		        String result = checkWin();
		        System.out.println(result);
				gameOn = check();
		    
			
		        
		Random rand = new Random();
		int cpuPos = rand.nextInt(9) + 1 ;
		while(playerPossision.contains(cpuPos) || cpuPossision.contains(cpuPos)) {
			cpuPos = rand.nextInt(9) + 1 ;
		}
				placepiece(gameBoard, cpuPos, "cpu");
				printgameBoard(gameBoard);
				
	           result = checkWin();
	           System.out.println(result);
	           gameOn = check();
	        	
		}
		}

     public static void printgameBoard(char [][] gameBoard){  	 
    	
    	 System.out.println();
    	 
         for (char [] row: gameBoard) {
             for(char c : row) {
	           System.out.print(c);
}
        System.out.println();
}
}
    	 
     
    	

     public static void placepiece(char [][] gameBoard, int  pos, String user) {
    	
    	 char symbol = ' ';
    	 
    	 if(user.equals("player")) {
    		 symbol = 'X';
    		 playerPossision.add(pos);
    	 } else if(user.contentEquals("cpu")) {
    		 symbol = 'O';
    		cpuPossision.add(pos);
    	 }
    	 
    	 
    	 switch(pos) {
		  case 1:
			    gameBoard [0][0] = symbol;
		     	break;
		  case 2:
				gameBoard [0][2] = symbol;
				break;
		  case 3:
				gameBoard [0][4] = symbol;
				break;
		  case 4:
				gameBoard [2][0] = symbol;
				break;
		  case 5:
				gameBoard [2][2] = symbol;
				break;
		  case 6:
				gameBoard [2][4] = symbol;
				break;
		  case 7:
				gameBoard [4][0] = symbol;
				break;
		  case 8:
				gameBoard [4][2] = symbol;
				break;
		  case 9:
				gameBoard [4][4] = symbol;
				break;	
		default:
				break;}
    	 }

     

  
      
   public static String checkWin() {
    	  
          List topRow = Arrays.asList(1, 2, 3);
          List midRow = Arrays.asList(4, 5, 6);
          List botRow = Arrays.asList(7, 8, 9);
          List leftCol = Arrays.asList(3, 6, 9);
          List midCol = Arrays.asList(2, 5, 8);
          List rightCol = Arrays.asList(1, 4, 7);
          List cross1 = Arrays.asList(1, 5, 9);
          List cross2 = Arrays.asList(3, 5, 7);
          
         List <List> winning = new ArrayList <List>();
         winning.add(topRow);
         winning.add(midRow);
         winning.add(botRow);
         winning.add(leftCol);
         winning.add(midCol);
         winning.add(rightCol);
         winning.add(cross1);
         winning.add(cross2);
         
         for(List l : winning ) {
         	if(playerPossision.containsAll(l)) {
         		
  		        return "YOU WIN!!!!";  
         	}else if(cpuPossision.containsAll(l)) {
         		
         		return "YOU LOSE :(";
         	}
         	else if(cpuPossision.size() + playerPossision.size() == 9){
         		
         		return "CAT!";
         	}
         }
         return "your turn";
       }
    
      public static boolean check() {
    	  if(checkWin().equals("your turn")) {
    		return true;
    		
    	  }else {
    		  return false; 
    	  }
		
      }
}