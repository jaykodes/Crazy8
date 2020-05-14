package unitFourProject;

public class CardDiamond extends Card {//class definition to construct the object; inherits methods from card
	//instance variable
	private String cardValue;//variable that will refer to card's value
	
	//constructor
	public CardDiamond(String value) {//constructor used to initialize variables
		super(value, "diamond");//call the parent constructor
		cardValue = value;//initialize cardValue
	}
	
	//method
	public String printFace() {//object's copy of the printFace method
		face = " --------- \r\n|" + this.cardSpace(cardValue, false) + "       |\r\n|    ᴧ    |\r\n|   / \\   |\r\n|   \\ /   |\r\n|    v    |\r\n|       " + this.cardSpace(cardValue, true) + "|\r\n --------- ";//variable references a string
		return face;//return variable
	}
}
