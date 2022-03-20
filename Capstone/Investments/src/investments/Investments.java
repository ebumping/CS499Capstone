package investments;

//import java.util.HashMap;
//import java.util.Map;
import java.util.Scanner;

public class Investments {
	static int[] serviceChoice = {1,2,1,1,2};
	static String name1 = "Bob Jones";
	static String name2 = "Sarah Davis";
	static String name3 = "Amy Friendly";
	static String name4 = "Johnny Smith";
	static String name5 = "Carol Spears";
	
	/*	This could be a better way to handle the clients
	
	String[] clientList = {"Bob Jones", "Sarah Davis",
							"Amy Friendly", "Johnny Smith",
							"Carol Spears"};
	*/
	static int clientChoice1 = serviceChoice[0];
	static int clientChoice2 = serviceChoice[1];
	static int clientChoice3 = serviceChoice[2];
	static int clientChoice4 = serviceChoice[3];
	static int clientChoice5 = serviceChoice[4];
	
	public static int[] changeCustomerChoice(int[] serviceChoice, int client, int service) {
		if(client == 1) {
			clientChoice1 = service;
		}
		else if (client == 2) {
			clientChoice2 = service;
		}
		else if (client == 3) {
			clientChoice3 = service;
		}
		else if (client == 4) {
			clientChoice4 = service;
		}
		else if (client == 5) {
			clientChoice5 = service;
		}else {
			//TODO:Handle fringe cases?
		}
		return serviceChoice;
		
	}
	
	static void displayInfo() {
		System.out.println("You chose 1");
		System.out.println("  Client's Name    Service Selected (1 = Brokerage, 2 = Retirement)");
		//this could be handled in a loop
		System.out.println("1. " + name1 + " selected option " + clientChoice1);
		System.out.println("2. " + name2 + " selected option " + clientChoice2);
		System.out.println("3. " + name3 + " selected option " + clientChoice3);
		System.out.println("4. " + name4 + " selected option " + clientChoice4);
		System.out.println("5. " + name5 + " selected option " + clientChoice2);
	}
	
	static void checkUserPermission() {
		int password;
		boolean loopMenu = true;
		Scanner in = new Scanner(System.in);		
		System.out.println("Enter your password:");
		int pw = in.nextInt();

		while(loopMenu == true) {
			if(pw == 123) {
				try {
				System.out.println("What would you like to do?");
				System.out.println("DISPLAY the client list (enter 1)");
				System.out.println("CHANGE a client's choice (enter 2)");
				System.out.println("Exit the program.. (enter 3)");
				int option = in.nextInt();

				
				if (option == 1) {
					displayInfo();
				}
				else if(option == 2) {
					int client, service;
					System.out.println("You chose 2");
					System.out.println("Enter the number of the client that you wish to change");
					client = in.nextInt();
					System.out.println("Please enter the client's new service choice "
									+ "(1 = Brokerage, 2 = Retirement)");
					service = in.nextInt();
					changeCustomerChoice(serviceChoice, client, service);
					//TODO: finish translating this
				}else if(option == 3){
					System.out.println("You chose 3");
					loopMenu = false;
				}else if(option > 3) {
					loopMenu = true;
				}else{
					checkUserPermission();
				}
			}catch(Exception e1) {
				System.out.println("An error has occured.");
				loopMenu = false;
				checkUserPermission();
				
			}
			}else loopMenu = true;

			
		}
		
	}
	
		public static void main(String[] argz) {
			Scanner in = new Scanner(System.in);
			System.out.println("Created by Dilli Vanilli");
			System.out.println("Hello! Welcome to our Investment Company");
			System.out.println("Enter your username:");
			String user = in.next();
			checkUserPermission();
		}
	}
	
	


