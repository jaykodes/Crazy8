package unitFourProject;
import java.util.*;//imports all item

public class Deck extends ArrayList<Card> implements ResetCards {//class definition to construct the object; inherits methods from deck and implements methods from ResetCards
	//instance variable
	private Deck deck;//variable that will refer to a deck
	
	//constructor
	/***************************
	 * Overloading Constructor *
	 ***************************/
	public Deck() {//constructor used to initialize variables
		super();//call the parent constructor
	}
	
	public Deck(Deck deck){//constructor used to initialize variables
		this.deck = deck;//initialize deck
	}
	
	//methods
	void fill() {//object's copy of the fill method
		String[] values = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};//array that refers to possible values
		for (int i = 0; i < values.length; i++) {//iterates according to the number of elements in values
			this.add(new CardDiamond(values[i]));//make a new diamond card and adds it to deck
			this.add(new CardClub(values[i]));//make a new club card and adds it to deck
			this.add(new CardHeart(values[i]));//make a new heart card and adds it to deck
			this.add(new CardSpade(values[i]));//make a new spade card and adds it to deck
		}
	}
	
	void shuffle() {//object's copy of the shuffle method
		Random rand = new Random();//random object
		
		for (int i = this.size() - 1; i > 0; i--) {//repeats according to the length of the deck
			int swap = rand.nextInt(i);//variable references a random integer
			Card temp = this.get(swap);//variable reference a card that is in the index position of swap
			this.set(swap, this.get(i));//inserts a card at index position
			this.set(i, temp);//inserts a card at index position
		}
	}
	
	
	Card dealCard(boolean place) {//object's copy of the dealCard method
		Card card;//variable that will refer to a card
		
		/***************
		 * Inheritance *
		 ***************/
		if (place) {//checks if place is true
			card = this.get(0);//get card from the top of the deck
			this.remove(0);//remove card from the top of the deck
		}
		else {
			card = this.get(this.size() - 1);//get card from the bottom of the deck
			this.remove(this.size() - 1);//remove card from the bottom of the deck
		}
		
		return card;//return the variable
	}
	
	/**********************
	 * Overloading Method *
	 **********************/
	void addCard(Card card, boolean place, int iterations) {//object's copy of the add method
		if (place) {//check if place is true
			for (int i = 0; i < iterations; i++) {//iterates according to iterations
				this.add(0, card);//add card at the beginning of the deck
			}
		}
		else {
			for (int i = 0; i < iterations; i++) {//iterates according to iterations
				this.add(card);//add card at the end of the deck
			}
		}
		
	}
	
	void addCard(Card card, boolean place) {//object's copy of the add method
		if (place) {//check if place is true
			this.add(0, card);//add card at the beginning of the deck
		}
		else {
			this.add(card);//add card at the end of the deck
		}
	}
	
	/*********************
	 * Overriding Method *
	 *********************/
	void print() {//object's copy of the print method
		for (int i = 0; i < this.size(); i++) {//iterates according to the size of the deck
			System.out.println(this.get(i).printFace());//gets card from deck and prints its face
		}
	}
	
	boolean empty() {//object's copy of the empty method
		if (this.size() == 0) {//checks if the size of the deck if 0
			return true;//returns true
		}
		else {
			return false;//returns false
		}
	}
	
	/**********************
	 * Interface Function *
	 **********************/
	public void resetGame() {//object's copy of the resetGame method
		this.clear();//calls the clear method on deck
		this.fill();//calls the fill method on deck
		this.shuffle();//calls the shuffle method on deck
	}
}
