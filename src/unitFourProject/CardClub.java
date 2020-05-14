package unitFourProject;

public class CardClub extends Card {//class definition to construct the object; inherits methods from card
	//instance variable
	private String cardValue;//variable that will refer to card's value
	
	//constructor
	public CardClub(String value) {//constructor used to initialize variables
		super(value, "club");//call the parent constructor
		cardValue = value;//initialize cardValue
	}
	
	//method
	public String printFace() {//object's copy of the printFace method
		face = " --------- \r\n|" + this.cardSpace(cardValue, false) + "       |\r\n|    _    |\r\n|   ( )   |\r\n|  (_'_)  |\r\n|    |    |\r\n|       " + this.cardSpace(cardValue, true) + "|\r\n --------- ";//variable references a string
		return face;//return variable
	}
}
