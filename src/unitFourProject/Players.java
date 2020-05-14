package unitFourProject;
import java.util.*;//imports all items

public class Players extends ArrayList<Player> implements ResetPlayers {//class definition to construct the object; inherits methods from deck and implements methods from ResetPlayers
	//instance variables
	private Player currentPlayer;//variable that will refer to a player
	private int playerCounter = 0;//variable that references an integer 0
	private static final int counterIncrease = 1;//variable that references an integer 1
	
	//constructor
	public Players() {//constructor used to initialize variables
		super();//call the parent constructor
	}
	
	//methods
	Player getCurrentPlayer() {//object's copy of the getCurrentPlayer method
		currentPlayer = this.get(playerCounter);//references variable to a player according to counter
		return currentPlayer;//return variable
	}
	
	void nextTurn(int playerNum) {//object's copy of the nextTurn method
		playerCounter += counterIncrease;//increase counter
		if (playerCounter >= playerNum) {//check if counter greater than number of player
			playerCounter = 0;//reset to 0
		}
	}
	
	Hand beginningHand(Deck deck) {//object's copy of the beginningHand method
		Hand hand = new Hand();//make a hand object
		for (int i = 0; i < 8; i++) {//iterate eight times
			hand.add(deck.dealCard(true));//add card from top of deck to hand
		}
		
		return hand;//return hand
	}
	
	void printLeaderBoard() {//object's copy of the printLeaderBoard method
		Players tempPlayers = this;//make a temporary object player
		
		for (int i = 0; i < tempPlayers.size(); i++) {//iterate according to number of players
			for (int j = 0; j < tempPlayers.size() - 1 - i; j++) {//iterate to one less then end
				if (tempPlayers.get(j).getPoints() < tempPlayers.get(j+1).getPoints()) {//check if player before's score is less then player after's score
					Player tempPlayer = tempPlayers.get(j+1);//holds a player with same properties as player after
					tempPlayers.add(j+1, tempPlayers.get(j));//add new after player in same spot
					tempPlayers.remove(j+2);//remove the old one after player
					tempPlayers.add(j, tempPlayer);//add new player in same spot as player before
					tempPlayers.remove(j+1);//remove the old before player
				}
			}
		}
		
		for (int i = 0; i < tempPlayers.size(); i++) {//iterate according to number of players
			System.out.println((i + 1) + ". " + tempPlayers.get(i).getName() + ": " + tempPlayers.get(i).getPoints());//print position name and points
		}
	}
	
	void addPlayer(Player player) {//object's copy of the addPlayer method
		this.add(player);//add player to players list
	}
	
	void removePlayer(Player player) {//object's copy of the removePlayer method
		this.remove(player);//remove player to players list
	}

	public void resetGame(Deck deck) {//object's copy of the resetGame method
		playerCounter = 0;//have counter reset
		for (int i = 0; i < this.size(); i++) {//iterate according to number of players
			this.add(i, new Player(this.get(i).getName(), this.beginningHand(deck), this.get(i).getPoints()));//make new player with same name and new points and hand; add in same spot as old player
			this.remove(i + 1);//remove old player as everything if offset
		}
		
	}
}
