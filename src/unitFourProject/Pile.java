package unitFourProject;

public class Pile extends Deck implements ResetCards {//class definition to construct the object; inherits methods from deck and implements methods from ResetCards
	//instance variable
	private Card top;//variable that will refer to the top card
	
	//constructor
	public Pile() {//constructor used to initialize variables
		super();//call the parent constructor
	}
	
	/*********************
	 * Overriding Method *
	 *********************/
	//methods
	void print() {//object's copy of the print method
		top = this.getTopCard();//variable refers to the return value of method topCard
		System.out.println(top.printFace());//print the top card
	}
	
	Card getTopCard() {//object's copy of the topCard method
		return this.get(0);//returns the card at index position of 0
	}
	
	public void resetGame(Deck deck) {//object's copy of the resetGame method
		this.clear();//clears the pile
		this.addCard(deck.dealCard(true), true);//deals the top card from deck and add it to pile using the add method
	}
}
