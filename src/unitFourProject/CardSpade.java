package unitFourProject;

public class CardSpade extends Card {//class definition to construct the object; inherits methods from card
	//instance variable
	private String cardValue;//variable that will refer to card's value
	
	//constructor
	public CardSpade(String value) {//constructor used to initialize variables
		super(value, "spade");//call the parent constructor
		cardValue = value;//initialize cardValue
	}

	//method
	public String printFace() {//object's copy of the printFace method
		face = " --------- \r\n|" + this.cardSpace(cardValue, false) + "       |\r\n|    .    |\r\n|   /.\\   |\r\n|  (_._)  |\r\n|    |    |\r\n|       " + this.cardSpace(cardValue, true) + "|\r\n --------- ";//variable references a string
		return face;//return variable
	}
}
