package unitFourProject;
import java.util.*;//import items from java.util

public class Game {//class definition to construct the object
	//instance variables
	private Players players;//variable that will refer to Players object
	private Deck deck;//variable that will refer to deck object
	private Pile pile;//variable that will refer to pile object
	private boolean win = false;
	/*************
	 * Constants *
	 *************/
	private static final String[] suits = {"diamond", "club", "heart", "spade"};//array that refers to possible suits
	private static final String[] values = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};//array that refers to possible values
	
	//constructor
	public Game(Players players, Deck deck, Pile pile) {//constructor used to initialize variables
		this.players = players;//initialize players
		this.deck = deck;//initialize deck
		this.pile = pile;//initialize pile
	}
	
	//methods
	void clearScreen() {//object's copy of the clearScreen method
		for (int i = 0; i < 50; i ++) {//iterates 50 times
			System.out.println();//print empty line
		}
	}
	
	public static void logo() {//object's copy of the logo method
		System.out.println("  _____                       ______ _       _     _       ");//print first line of logo
		System.out.println(" / ____|                     |  ____(_)     | |   | |      ");//print second line of logo
		System.out.println("| |     _ __ __ _ _____   _  | |__   _  __ _| |__ | |_ ___ ");//print third line of logo
		System.out.println("| |    | '__/ _` |_  / | | | |  __| | |/ _` | '_ \\| __/ __|");//print fourth line of logo
		System.out.println("| |____| | | (_| |/ /| |_| | | |____| | (_| | | | | |_\\__ \\");//print fifth line of logo
		System.out.println(" \\_____|_|  \\__,_/___|\\__, | |______|_|\\__, |_| |_|\\__|___/");//print sixth line of logo
		System.out.println("                       __/ |            __/ |              ");//print seventh line of logo
		System.out.println("                      |___/            |___/               ");//print eighth line of logo
	}
	
	void makePlayer(int playerNum) {//object's copy of the makePlayer method
		Scanner scan = new Scanner(System.in);//scanner object
		String playerName;//variable that will refer to player's name
		String[] playerPossibility = {"Player 1", "Player 2", "Player 3", "Player 4"};//references array to different player possibilities
		
		deck.fill();//call the fill method on deck
		deck.shuffle();//call the shuffle method on deck
		for (int i = 0; i < playerNum; i++) {//iterates according to the number of players
			System.out.println("What is your name " + playerPossibility[i] + "?");//asks player for name
			playerName = scan.nextLine().trim();//references array to player input
			players.add(new Player(playerName, players.beginningHand(deck), 0));//call the add method on players
		}
	}
	
	void welcome() {//object's copy of the welcome method
		Scanner scan = new Scanner(System.in);//scanner object
		int playerNum = 0;//references to integer 0
		while (!(playerNum > 1 && playerNum < 5)) {//loops while player not between 1 and 5
			try {
				logo();//call logo method
				System.out.println();//empty line
				System.out.println();//empty line
				System.out.println("Enter 2 to Play with 2 Players");//2 player option
				System.out.println("Enter 3 to Play with 3 Players");//3 player option
				System.out.println("Enter 4 to Play with 4 Players");//4 player option
				playerNum = Integer.parseInt(scan.nextLine());//references to integer
				this.clearScreen();//call clearScreen method on game
			} catch (NumberFormatException ex) {//catch any converting issues
				this.clearScreen();//call clearScreen method on game
			}
		}
		this.makePlayer(playerNum);//call makePlayer method on game
	}
	
	void startGame() {//object's copy of the startGame method
		this.clearScreen();//call clearScreen method on game
		pile.add(deck.dealCard(true));//call the add method on pile
	}
	
	String playerMenu() {//object's copy of the makePlayer method
		Scanner scan = new Scanner(System.in);//scanner object
		String playerOption;//variable that will refer to player's option
		System.out.println("Enter 1 to sort from highest to lowest");//print option 1
		System.out.println("Enter 2 to sort from lowest to highest");//print option 2
		System.out.println("Enter 3 to sort according to faces");//print option 3
		System.out.println("Enter 4 to check if you can play a card");//print option 4
		System.out.println("Enter 5 to play a card");//print option 5
		System.out.println("Enter 6 to pass to next player");//print option 6
		System.out.println("Enter 7 to quit");//print option 7
		playerOption = scan.nextLine().trim().toLowerCase();//references to a string
		
		return playerOption;//returns the variable
	}
	
	String[] getCard() {//object's copy of the getCard method
		Scanner scan = new Scanner(System.in);//scanner object
		String value = "";//variable that refers to empty string
		String suit = "";//variable that refers to empty string
		String[] returnArray = new String[2];//array that will refer to string array
		int valuePosition = -1;//variable that refers to integer -1
		
		while (!Arrays.asList(suits).contains(suit)) {//repeats until suit is a string in suits
			this.clearScreen();//call clearScreen method on game
			pile.print();//call the print method on pile
			players.getCurrentPlayer().getHand().print();//call the print method on the current player's hand
			System.out.println("What is the suit of your card? (diamond, club, heart, spade)");//asks user's for the suit of the card
			suit = scan.nextLine().trim().toLowerCase();//references to a string
		}
		while (!Arrays.asList(values).contains(value)) {//repeats until value is a string in values
			this.clearScreen();//call clearScreen method on game
			pile.print();//call the print method on pile
			players.getCurrentPlayer().getHand().print();//call the print method on the current player's hand
			System.out.println("What is the value of your card? (A, 2, 3 ... 10, J, Q, K)");//asks user's for the value of the card
			value = scan.nextLine().trim().toUpperCase();//references to a string
		}
		valuePosition = Arrays.asList(values).indexOf(value) + 1;//references to the index position in array (integer)
		returnArray[0] = suit;//first index position of array references to a string
		returnArray[1] = Integer.toString(valuePosition);//second index position of array references to an integer turned to string		
		
		return returnArray;//return the array
	}
	
	void playerPickup(Card card) {//object's copy of the playerPickup method
		Scanner scan = new Scanner(System.in);//scanner object
		String playerOption;//variable that will refer to player's option
		
		if (card.getSuit().equals(pile.getTopCard().getSuit()) || card.getValue() == pile.getTopCard().getValue()) {
			clearScreen();
			pile.print();//call the print method on pile
			System.out.println("You just picked up a ");//tell player they picked a card
			System.out.println(card.printFace());//print the face of the card by calling the printFace method on card
			System.out.println("Would you like to play it? (Yes or No)");//asks player if they want to play the card
			playerOption = scan.nextLine().trim().toLowerCase() + " ";//references variable to a string
			if (playerOption.charAt(0) == 'y') {//checks if first character is a y
				pile = players.getCurrentPlayer().getHand().playCard(pile, pile.getTopCard(), card.getSuit(), card.getValue(), true);//returns a new pile by calling the playCard method on the current player's hand
			}
		}
	}
	
	void checkTopCard() {//object's copy of the checkTopCard method
		Scanner scan = new Scanner(System.in);//scanner object
		String suit = "";//variable that refers to empty string
		
		if (pile.getTopCard().getValue() == 8) {//checks if the pile top card's value is an 8 by calling the getValue method
			while (!Arrays.asList(suits).contains(suit)) {//repeats until suit is a string in suits
				this.clearScreen();//call clearScreen method on game
				pile.print();//call the print method on pile
				players.getCurrentPlayer().getHand().print();//call the print method on the current player's hand
				System.out.println("What suit would you like the 8 to be?");//asks user for a suit
				suit = scan.nextLine();//references variable to a string
			}
			pile.getTopCard().setSuit(suit);//set the suit of the top card in pile to the player's choice of suit
		}
	}
	
	boolean deckCheck() {//object's copy of the deckCheck method
		boolean empty = false;//variable refers to false
		if (deck.empty() && pile.size() == 1) {//checks if deck is empty and if the pile has one card in it
			empty = true;//variable refers to false
		}
		else if (deck.empty()) {//checks if deck is empty
			deck.addCard(pile.get(1), false, pile.size());//call add method on deck
			for (int i = 1; i < pile.size(); i++) {//iterates according to pile's list
				pile.remove(1);//call remove method on pile
			}
			deck.shuffle();//call shuffle method on deck
		}
		return empty;//return variable
	}
	
	void playerTurns() {//object's copy of the playerTurns method
		String playerOption;//variable that will refer to player's option
		boolean loopThru = true;
		boolean firstMove = true;
		
		while (loopThru) {
			pile.print();//call the print method on pile
			System.out.println("Suit: " + pile.getTopCard().getSuit());//prints the suit value of the card
			System.out.println();//empty line
			System.out.println(players.getCurrentPlayer().getName() + "'s Turn");//prints whose turn it is
			players.getCurrentPlayer().getHand().print();//call the print method on the current player's hand
			playerOption = playerMenu();//have playerOption refer to the return value of playerMenu
			if (playerOption.equals("1")) {//checks if playerOption reference equals to 1 in value
				this.clearScreen();//call clearScreen method on game
				players.getCurrentPlayer().getHand().sortLow();//call the sortLow method on the current player's hand
			}
			else if (playerOption.equals("2")) {//checks if playerOption reference equals to 2 in value
				this.clearScreen();//call clearScreen method on game
				players.getCurrentPlayer().getHand().sortHigh();//call the sortHigh method on the current player's hand
			}
			else if (playerOption.equals("3")) {//checks if playerOption reference equals to 3 in value
				this.clearScreen();//call clearScreen method on game
				players.getCurrentPlayer().getHand().sortFace();//call the sortFace method on the current player's hand
			}
			else if (playerOption.equals("4")) {//checks if playerOption reference equals to 4 in value
				this.clearScreen();//call clearScreen method on game
				if (players.getCurrentPlayer().getHand().hasCard(pile.getTopCard(), firstMove)) {//checks if the hasCard method return true by calling it on current player's hand
					System.out.println("There is a card in your hand that you can play");//prints that there is a possible card to play
				}
				else {
					System.out.println("There is not a card in your hand that you can play");//prints that there is not a possible card to play
				}
			}
			else if (playerOption.equals("5")) {//checks if playerOption reference equals to 5 in value
				/****************
				 * Polymorphism *
				 ****************/
				Card tempCard = pile.getTopCard();//card object that refers to top card of pile
				String[] temp = this.getCard();//array that references to the return of the getCard method on game
				
				this.clearScreen();//call clearScreen method on game
				pile.print();//call the print method on pile
				players.getCurrentPlayer().getHand().print();//call the print method on the current player's hand
				pile = players.getCurrentPlayer().getHand().playCard(pile, pile.getTopCard(), temp[0], Integer.parseInt(temp[1]), firstMove);//returns a new pile by calling the playCard method on the current player's hand
				if ((tempCard.getValue() != pile.getTopCard().getValue() || !(tempCard.getSuit().equals(pile.getTopCard().getSuit()))) && firstMove) {//checks if the player has played a card yet by checking if the top card changed
					firstMove = false;//variable refers to false
				}
				if (players.getCurrentPlayer().getHand().size() == 0) {//checks if the size of the current player is 0; if so they win
					win = true;//variable refers to true
					loopThru = false;//variable refers to false
				}
				this.clearScreen();//call clearScreen method on game
			}
			else if (playerOption.equals("6")) {//checks if playerOption reference equals to 6 in value
				if (firstMove && !deckCheck()) {//checks if player has not moved
					players.getCurrentPlayer().getHand().add(0, deck.dealCard(true));//call the add method on the current player's hand
					this.playerPickup(players.getCurrentPlayer().getHand().get(0));//call the playerPickup method on game
				}
				else {
					this.checkTopCard();//call the checkTopCard method on game
				}
				loopThru = false;//variable refers to false
			}
			else if (playerOption.equals("7")) {//checks if playerOption reference equals to 7 in value
				players.remove(players.getCurrentPlayer());//call the remove method on players
				if (players.size() <= 1) {//checks if 1 person
					win = true;//last player standing wins
				}
				loopThru = false;//variable refers to false
			}
			else {
				this.clearScreen();//call clearScreen method on game
			}
		}
	}
	
	void playerWin() {//object's copy of the playerWin method
		Scanner scan = new Scanner(System.in);//scanner object
		String playerOption;//variable that will refer to player's option
		
		System.out.println(players.getCurrentPlayer().getName() + " Wins");//prints who wins
		players.getCurrentPlayer().increasePoint();//call the increasePoint method on the current player
		System.out.println("Current Leaderboard");//print the current leaderboard
		players.printLeaderBoard();//call the printLeaderBoard on players
		
		if (players.size() > 1) {//checks if there are more than one player
			System.out.println();//empty line
			System.out.println("Do you guys want to play again?");//asks if the users wants to play again
			playerOption = scan.nextLine().trim().toLowerCase();//references to a string
			if (!(playerOption.charAt(0) == 'y')) {//checks if first character is a not a y
				for (int i = 0; i < players.size(); i++) {//repeats according to the number of players
					players.remove(0);//call the remove method on players
				}
			}
		}
	}
	
	void resetGame() {//object's copy of the resetGame method
		deck.resetGame();//call the resetGame method on deck
		players.resetGame(deck);//call the resetGame method on players
		pile.resetGame(deck);//call the resetGame method on pile
		win = false;//variable refers to false
		this.clearScreen();//call clearScreen method on game
	}
	
	void goodBye() {//object's copy of the goodBye method
		if (players.size() <= 1) {//checks if there is one player left
			System.out.println("Looks like everyone quit. Can't play a game with one person");//prints that no one to play against
		}
		System.out.println("Thank you for playing. Good Bye");//prints a good bye
	}
	
	void playGame() {//object's copy of the playGame method
		this.clearScreen();//call clearScreen method on game
		this.welcome();//call clearScreen method on game
		this.startGame();//call clearScreen method on game
		while (players.size() > 1) {//repeats until there is one player left
			while (!win) {//repeats until a player wins
				this.playerTurns();//call playerTurns method on game
				players.nextTurn(players.size());//call the nextTurn method on players
				this.clearScreen();//call clearScreen method on game
			}
			this.playerWin();//call playerWin method on game
			this.resetGame();//call resetGame method on game
		}
		this.goodBye();//call goodBye method on game
	}
}
