package game;
import java.util.*;
public class Hangman {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         Hangman obj=new Hangman();
         obj.showMenu();
	}
	int option;
	public void showMenu(){
		
        Scanner sc=new Scanner(System.in);
		System.out.println("=========Menu=========");
		System.out.println("1. Play");
		System.out.println("2. Instructions");
		System.out.println("3. Exit");
		System.out.println("\n Choose the option: ");
		try{
	    option=sc.nextInt();
		}catch(RuntimeException e){
			System.out.println("Please provide valid numeric value");
			showMenu();
		}
	    switch(option){
	    case 1: 
	    	playGame();
	    	break;
	    case 2:
	    	instructGame();
	    	break;
	    case 3:
	    	 exit();
	    	 break;
	     default :
	    	 try{
	    		 throw new MenuInputException();
	    	 }catch(Exception e){
	    		 	//System.out.println("Something went wrong");
	    	    	showMenu();
	    	   
	    	 }
	   
	    }
	}	
	String  guess;
	void playGame(){
		System.out.println("play Game");
        int rnd;
        int len,count = 0;
		String word[]={"North America","South America","Europe","Asia","Africa","Australia","Antarctica"};
		int i, flag=0;
		String temp;
        Random obj=new Random();
        rnd=obj.nextInt(7);
        System.out.println(rnd);
        len=word[rnd].length();
        System.out.println(word[rnd]);
        char[] newString = new char[len];

		Scanner input=new Scanner(System.in);
		
		StringBuffer wrgString=new StringBuffer();
		
		for(int j=0;j<len;j++){
			System.out.print("_");
		}
		System.out.println();
		do{
			flag=0;
		try{
			System.out.println("Enter your guess??");
			String ch=input.nextLine().toLowerCase();
	
			if(ch.length()==1){
				throw new WrongInputException();
			}
			count++;
			for(i=0;i<len;i++){
				if(word[rnd].charAt(i)==ch.charAt(i)){
					newString[i]=word[rnd].charAt(i);
					flag=1;
					
				}
			}
	
			if(flag==0){
				flag=1;
				wrgString.append(input+ ",");
				System.out.println("Misses "+wrgString);
				
			}
				System.out.println("New String "+newString.toString());
				temp=new String(newString);
				if(word[rnd].equals(temp)){
					System.out.println("Congrats!! you won");
					System.out.println("Do u want guess again y/n");
			         				}
				guess=input.nextLine();

		}catch(WrongInputException e){
			System.out.println(e);
			flag=1;
		}
	         
	         
		}while(guess.equals("y"));
	}
	void instructGame(){
		System.out.println("Instruction");
	}
    void exit(){
    	System.exit(0);
    }
}
