package pet;

import java.util.Scanner;

public class VirtualPetApp {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		boolean isAlive = true;

		System.out.println("Enter the name of your adventurer:");
		String enteredName = input.nextLine();
		VirtualPet myPet = new VirtualPet(enteredName);
		System.out.println("Welcome " + myPet.getName() + "!");

		myPet.createMonster();

		while (isAlive) {

			System.out.println("Stats:  Health-" + myPet.getHealth() + " Stamina-" + myPet.getStamina());
			System.out.println();

			String monsterName = myPet.getMonster();
			String menuChoice = "0";
			while (!menuChoice.equals("4")) {
				System.out.println("A " + monsterName + " is in front of you.");
				System.out.println("What do you want to do?");
				System.out.println("1: Fight");
				System.out.println("2: Eat food");
				System.out.println("3: Drink potion");
				System.out.println("4: Run away");
				menuChoice = input.nextLine();
				switch (menuChoice) {
				case "1":
					break;
				case "2":
					if (myPet.getApples() == 0 && myPet.getPeppers() == 0 && myPet.getMushrooms() == 0 && myPet.getFish() == 0) {
						System.out.println("You don't have any food.");
					}else {
						System.out.println("You have");
						System.out.println("Apple: " +myPet.getApples());
						System.out.println("Pepper: " + myPet.getPeppers());
						System.out.println("Mushroom: " + myPet.getMushrooms());
						System.out.println("Fish: " + myPet.getFish());
						System.out.println("What do you want to eat?");
						String foodChoice = input.nextLine();
						myPet.eat(foodChoice);
						myPet.tick(-5, 5);
					}
					break;
				case "3":
					break;
				case "4":
					myPet.createMonster();
					myPet.tick(-5, 5);
					break;
				}
				
			}
			
		}
		input.close();
		myPet.perish();
	}

}
