package game;

public class WrongInputException extends Throwable{

	WrongInputException(){
		System.out.println("Please provide a single charachter only.");
	}

}
