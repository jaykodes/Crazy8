package unitFourProject;

public class Player {//class definition to construct the object
	//instance variables
	private String name;//variable that will refer to a string
	private Hand hand;//variable that will refer to a hand
	private int points;//variable that will refer to the number of points
	
	//constructor
	public Player(String name, Hand hand, int points) {//constructor used to initialize variables
		this.name = name;//initialize name
		this.hand = hand;//initialize hand
		this.points = points;//initialize points
	}
	
	//methods
	void setName(String name) {//object's copy of the setName method
		this.name = name;//variable to refer to the string passed
	}
	
	void setHand(Hand hand) {//object's copy of the setHand method
		this.hand = hand;//variable to refer to the hand passed
	}
	
	void setPoints(int points) {//object's copy of the setPoints method
		this.points = points;//variable to refer to the integer passed
	}
	
	String getName() {//object's copy of the getName method
		return this.name;//return the variable
	}
	
	Hand getHand() {//object's copy of the getHand method
		return this.hand;//return the variable
	}
	
	int getPoints() {//object//return the variable's copy of the getPoints method
		return this.points;
	}
	
	void increasePoint() {//object's copy of the increasePoint method
		this.points++;//increase the points counter by 1
	}
}
