package unitFourProject;

public class CardHeart extends Card {//class definition to construct the object; inherits methods from card
	//instance variable
	private String cardValue;//variable that will refer to card's value
	
	//constructor
	public CardHeart(String value) {//constructor used to initialize variables
		super(value, "heart");//call the parent constructor
		cardValue = value;//initialize cardValue
	}
	
	//method
	public String printFace() {//object's copy of the printFace method
		face = " --------- \r\n|" + this.cardSpace(cardValue, false) + "       |\r\n|   _ _   |\r\n|  ( v )  |\r\n|   \\ /   |\r\n|    v    |\r\n|       " + this.cardSpace(cardValue, true) + "|\r\n --------- ";//variable references a string
		return face;//return variable
	}

}
