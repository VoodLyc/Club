package model;
import java.lang.Exception;

public class IllegalIdException extends Exception{
	
	public IllegalIdException(String msg){
		super(msg);
	}
}