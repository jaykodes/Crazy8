package unitFourProject;
import java.util.*;//imports all items

public class Hand extends Deck {//class definition to construct the object; inherits methods from deck
	
	//constructor
	public Hand() {//constructor used to initialize variables
		super();//call the parent constructor
	}
	
	//methods
	/*****************
	 * Static Member *
	 *****************/
	public static void quickSortValue(Hand data, int L, int R) {//quickSort function
		int SL = L;//starting position of the left
		int SR = R;//starting position of the right
		int P = L;//starting position of the pivot; on the right
		
		while (L != R) {//while the left marker and right marker are on different indexes
			while (data.get(R).getValue() >= data.get(P).getValue() && L != R) {//while the right marker value is greater than the pivot and right marker and left marker on different indexes
				R--;//decrease right marker
			}
			Collections.swap(data, P, R);//right marker is less than the pivot; swap markers
			P = R;//set the pivot to be the right marker now
			
			while (data.get(L).getValue() <= data.get(P).getValue() && L != R) {//while the left marker value is less than pivot and left marker and right marker on different indexes
				L++;//increase left marker
			}
			Collections.swap(data, L, P);//left marker is greater than the pivot; swap markers
			P = L;//set the pivot to be the left marker now
		}
		
		if ((P - 1) > SL) {//if there is more than one number on the left side of the marker call the function again
        	quickSortValue(data, SL, P - 1);//call function again but the right end is one index less of the pivot
        }
		if ((P + 1) < SR) { //if there is more than one number on the right side of the marker call the function again
        	quickSortValue(data, P + 1, SR);//call function again but the left end is one index greater of the pivot
        }
	}
	
	void sortHigh() {//object's copy of the sortHigh method
		quickSortValue(this, 0, this.size() - 1);//call the quickSortValue method on hand
	}
	
	void sortLow() {//object's copy of the sortLow method
		this.sortHigh();//call sortHigh method
		Collections.reverse(this);//reverses the ArrayList
	}
	
	void sortFace() {//object's copy of the sortFace method
		Hand diamondHand = new Hand();//Instantiate a diamond hand
		Hand clubHand = new Hand();//Instantiate a club hand
		Hand heartHand = new Hand();//Instantiate a heart hand
		Hand spadeHand = new Hand();//Instantiate a spade hand
		
		for (int i = 0; i < this.size(); i++) {//iterates according to the size of the hand
			if (this.get(i).getSuit().equals("diamond")) {//checks if the card value is a diamond
				diamondHand.add(this.get(i));//add to diamond hand
			}
			else if (this.get(i).getSuit().equals("club")) {//checks if the card value is a club
				clubHand.add(this.get(i));//add to club hand
			}
			else if (this.get(i).getSuit().equals("heart")) {//checks if the card value is a heart
				heartHand.add(this.get(i));//add to heart hand
			}
			else {//checks if the card value is a spade
				spadeHand.add(this.get(i));//add to spade hand
			}
		}
		
		if (diamondHand.size() > 1) {//checks if diamond hand size is greater than one
			quickSortValue(diamondHand, 0, diamondHand.size() - 1);//call quickSortValue on diamondHand
		}
		if (clubHand.size() > 1) {//checks if club hand size is greater than one
			quickSortValue(clubHand, 0, clubHand.size() - 1);//call quickSortValue on clubHand
		}
		if (heartHand.size() > 1) {//checks if heart hand size is greater than one
			quickSortValue(heartHand, 0, heartHand.size() - 1);//call quickSortValue on heartHand
		}
		if  (spadeHand.size() > 1) {//checks if spade hand size is greater than one
			quickSortValue(spadeHand, 0, spadeHand.size() - 1);//call quickSortValue on spadeHand
		}
		
		this.clear();//clear any cards in hand
		for (int i = 0; i < diamondHand.size(); i++) {//iterates according to the number of cards in diamondHand
			this.add(diamondHand.get(i));//add diamond card to hand
		}
		for (int i = 0; i < clubHand.size(); i++) {//iterates according to the number of cards in clubHand
			this.add(clubHand.get(i));//add club card to hand
		}
		for (int i = 0; i < heartHand.size(); i++) {//iterates according to the number of cards in heartHand
			this.add(heartHand.get(i));//add heart card to hand
		}
		for (int i = 0; i < spadeHand.size(); i++) {//iterates according to the number of cards in spadeHand
			this.add(spadeHand.get(i));//add spade card to hand
		}
	}
	
	boolean hasCard(Card card, boolean firstMove) {//object's copy of the hasCard method
		boolean exists = false;//variable refers to false
		
		if (firstMove) {//checks if firstMove is true
			for (int i = 0; i < this.size(); i++) {//iterates according to the number of cards in the hand
				if (this.get(i).getValue() == card.getValue() || this.get(i).getSuit().equals(card.getSuit()) || this.get(i).getValue() == 8) {//checks if card in hand has same properties as card in pile or if card in hand is an 8
					exists = true;//variable refers to true
					break;//breaks out of loop
				}
			}
		}
		else {
			for (int i = 0; i < this.size(); i++) {//iterates according to the number of cards in the hand
				if (this.get(i).getValue() == card.getValue()) {//checks if card in hand has same value property as card
					exists = true;//variable refers to false
					break;//breaks out of loop
				}
			}
		}
		
		return exists;//returns variable
	}
	
	/*********************
	 * Overriding Method *
	 *********************/
	void print() {//object's copy of the print method
		for (int i = 0; i < 8; i++) {//iterates 8 times
			for (int j = 0; j < this.size(); j++) {//iterates according to the number of cards in hand
				System.out.print(this.get(j).printFace().split("\r\n")[i]);//splits face into line breaks and prints all lines at one
			}
			System.out.println();//empty line
		}
	}
	
	Pile playCard(Pile pile, Card card, String suit, int value, boolean firstMove) {//object's copy of the playCard method
		boolean inHand = false;//variable refers to false
		boolean matchesTop = false;//variable refers to false
		int position = 0;//variable refers to integer 0
		
		if (firstMove) {//checks if firstMove is true
			if (value == 8) {//checks if value is 8
				matchesTop = true;//variable refers to true
			}
			
			for (int i = 0; i < this.size(); i++) {//iterates according to the number of cards in hand
				if (this.get(i).getValue() == value && this.get(i).getSuit().equals(suit)) {//checks if card in hand has same properties as properties sent as parameters
					inHand = true;//variable refers to true
					position = i;//reference to integer i
					break;//breaks out of loop
				}
			}
			
			if (inHand) {//checks if inHand is true
				if (card.getValue() == value || card.getSuit().equals(suit)) {//checks if card in hand has same properties as card in pile
					matchesTop = true;//variable refers to true
				}
			}
			
			if (matchesTop) {//checks if matchesTop is true
				pile.add(0, this.get(position));//add card to beginning of pile
				this.remove(position);//remove card from hand a position (integer i)
			}
		}
		else {
			for (int i = 0; i < this.size(); i++) {//iterates according to the number of cards in hand
				if (this.get(i).getValue() == value && this.get(i).getSuit().equals(suit)) {//checks if card in hand has same properties as properties sent as parameters
					inHand = true;//variable refers to true
					position = i;//reference to integer i
					break;//breaks out of loop
				}
			}
			
			if (inHand) {//checks if inHand is true
				if (card.getValue() == value) {//checks if card in hand has same value property as card in pile
					matchesTop = true;//variable refers to true
				}
			}
			
			if (matchesTop) {//checks if matchesTop is true
				pile.add(0, this.get(position));//add card to beginning of pile
				this.remove(position);//remove card from hand a position (integer i)
			}
		}
		return pile;//return pile
	}
}
