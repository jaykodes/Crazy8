package unitFourProject;

/******************
 * Abstract Class *
 ******************/
public abstract class Card {//class definition to construct the object
	//instance variables
	/*****************
	 * Encapsulation *
	 *****************/
	private int value;//variable that will refer to a value
	private String suit;//variable that will refer to suit
	private String back;//variable that will refer to the back of the card
	protected String face;//variable that will refer to the front of the card
	
	//constructor
	public Card(String value, String suit) {//constructor used to initialize variables
		if (value.equals("A")) {//checks if value refers to a string equal to A
			this.value = 1;//initialize value
		}
		else if (value.equals("J")) {//checks if value refers to a string equal to J
			this.value = 11;//initialize value
		}
		else if (value.equals("Q")) {//checks if value refers to a string equal to Q
			this.value = 12;//initialize value
		}
		else if (value.equals("K")) {//checks if value refers to a string equal to K
			this.value = 13;//initialize value
		}
		else {//not a card with letter
			this.value = Integer.parseInt(value);//initialize value
		}
		this.suit = suit;//initialize suit
	}
	
	//methods
	String cardSpace(String original, boolean place) {//object's copy of the cardSpace method
		if (original.length() != 2 && place) {//checks if length is not already two and if want space before
			original = " " + original;//variable refers to same string but with a space before
		}
		else if (original.length() != 2) {//checks if length is not already two
			original = original + " "; //variable refers to same string but with a space after
		}
		
		return original;//return variable
	}
	
	void setValue(int value) {//object's copy of the setValue method
		this.value = value;//variable to refer to the integer passed
	}
	
	/**********
	 * Setter *
	 **********/
	void setSuit(String suit) {//object's copy of the setSuit method
		this.suit = suit;//variable to refer to the string passed
	}
	
	int getValue() {//object's copy of the getValue method
		return this.value;//return the variable
	}
	
	/**********
	 * Getter *
	 **********/
	String getSuit() {//object's copy of the getSuit method
		return this.suit;//return the variable
	}
	
	abstract String printFace();//object's copy of the printFace method
	
	String printBack() {//object's copy of the printBack method
		this.back = " ------- \r\n|* * * *|\r\n| * * * |\r\n|* * * *|\r\n| * * * |\r\n|* * * *|\r\n| * * * |\r\n ------- ";////variable to refer to the string
		return this.back;//return the variable
	}
}
