import java.util.Random;
import java.util.Scanner;

public class Blackjack {

	public static void main(String[] args) {
		Random r = new Random(); 
		Scanner kb = new Scanner(System.in);
		int yourCard1 = 1 + r.nextInt(11), yourCard2 = 1 + r.nextInt(11), yourNextCard = 1 + r.nextInt(11),
				yourTotal, dealerCard1 = 1 + r.nextInt(11), dealerCard2 = 1 + r.nextInt(11), 
				dealerNextCard = 1 + r.nextInt(11), dealerTotal;
		String decision, dealerDecision = "hit";
		
		System.out.println("Welcome to Michael's blackjack program!");
		System.out.println("You get a " + yourCard1 + " and " + yourCard2 + ".");
		
		yourTotal = yourCard1 + yourCard2;
		dealerTotal = dealerCard1 + dealerCard2;
		
		System.out.println("Your total is " + yourTotal + ".");
		
		System.out.println("\nThe dealer has a " + dealerCard1 + " showing, and a hidden card.");
		System.out.println("His total is hidden, too.");
		
		System.out.print("\nWould you like to \"hit\" or \"stay\"? ");
		decision = kb.nextLine();
		
		
		// Deleting the "yourTotal <= 21" portion makes the System print out the bust message endlessly
		while (!decision.equals("hit") && !decision.equals("stay")) {
			System.out.print("That's not a valid choice. Would you like to \"hit\" or \"stay\"? ");
			decision = kb.nextLine();
		}
		while (decision.equals("hit") && yourTotal <= 21) {
			yourTotal = yourTotal + yourNextCard;
								
			if (yourTotal > 21) 
				System.out.println("You have busted.");
			else {
				System.out.println("You drew a " + yourNextCard + ".");
					
				System.out.println("Your total is " + yourTotal + ".");
				yourNextCard = 1 + r.nextInt(11);
				
				System.out.print("\nWould you like to \"hit\" or \"stay\"? ");
				decision = kb.nextLine();
				
				while (!decision.equals("hit") && !decision.equals("stay")) {
					System.out.print("That's not a valid choice. Would you like to \"hit\" or \"stay\"? ");
					decision = kb.nextLine();
				}
			}
				
		}
		
		if (yourTotal > 21)
			System.out.println("\nDealer wins. Better luck next time!");
		else {
			System.out.println("\nOkay, dealer's turn.");
			
			if (dealerTotal > 21)
				System.out.println("Dealer has busted!");
			else {
				System.out.println("His hidden card was a " + dealerCard2 + ".");
				System.out.println("His total was " + dealerTotal + ".");
				
				while (dealerDecision.equals("hit") && dealerTotal <= 21) {
					if (dealerTotal <= 16) {
						dealerTotal = dealerTotal + dealerNextCard;
						
						System.out.println("\nDealer chooses to " + dealerDecision + ".");
						
						if (dealerTotal > 21) 
							System.out.println("Dealer has busted!");
						else {
							System.out.println("He draws a " + dealerNextCard + ".");
							
							System.out.println("His total is " + dealerTotal + ".");
							
						}
						dealerNextCard = 1 + r.nextInt(11);
					}
						
					else {
						dealerDecision = "stays";
						System.out.println("\nDealer " + dealerDecision + ".");			
					}
				}
				
			}
					
			if (dealerTotal > 21) {
				System.out.println("\nYOU WIN!");
			}
			else {
				System.out.println("\nDealer total is " + dealerTotal + ".");
				System.out.println("Your total is " + yourTotal + ".");
						
				if (yourTotal > dealerTotal)
					System.out.println("\nYOU WIN!");
				else
					System.out.println("\nDealer wins. Better luck next time!");
			}
			
		}
										
		
	}

}
