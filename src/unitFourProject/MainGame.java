package unitFourProject;

public class MainGame {
	//instance variables
	static Players players = new Players();//new player object
	static Deck deck = new Deck();//new deck object
	static Pile pile = new Pile();//new pile object
	static Game game = new Game(players, deck, pile);//new game object
	
	//methods
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		game.playGame();//call the playGame method on game
	}

}
