package pet;

import java.util.Scanner;

public class VirtualPetApp {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		boolean isAlive = true;

		System.out.println("Enter the name of your Pet Adventurer:");
		String enteredName = input.nextLine();
		VirtualPet myPet = new VirtualPet(enteredName);
		System.out.println(myPet.getName() + " enters the game!");
		System.out.println();
		System.out.println("At the end of each turn " + myPet.getName() + "'s health decreases by "
				+ myPet.getHealthTickAmount() + " unless food is eaten,");
		System.out.println("and " + myPet.getName() + "'s stamina increases by " + myPet.getStamTickAmount() + ".");
		System.out.println("Each time " + myPet.getName() + " fights, " + myPet.getName() + "'s stamina decreases by "
				+ myPet.getMonsterStamina() + ".");
		System.out.println(myPet.getName() + " eats food to increase health.");
		System.out.println(myPet.getName() + " drinks potions to increase stamina.");
		System.out.println();

		myPet.createMonster();
		boolean newMonster = true;
		String menuChoice = "0";

		while (isAlive) {
			System.out.println(
					myPet.getName() + "'s Stats:  Health=" + myPet.getHealth() + "  Stamina=" + myPet.getStamina());
			System.out.println();
			if (newMonster == true) {
				System.out.println("A " + myPet.getMonster() + "(H" + myPet.getMonsterHealth() + ") appears.");
			} else {
				System.out.println("The " + myPet.getMonster() + "(H" + myPet.getMonsterHealth() + ") is still there.");
			}
			System.out.println("What should " + myPet.getName() + " do?");
			System.out.println("1: Fight");
			System.out.println("2: Eat food");
			System.out.println("3: Drink potion");
			System.out.println("4: Run away");
			menuChoice = input.nextLine();
			switch (menuChoice) {
			case "1":
				if (myPet.getStamina() < 25) {
					System.out.println(myPet.getName() + " needs a stamina higher than " + myPet.getMinFightStamina()
							+ " to fight.");
					System.out.println();
					newMonster = false;
				} else {
					myPet.fight();
					System.out.println("The " + myPet.getMonster() + " dies and drops 1 " + myPet.getDropFood()
							+ " and 1 " + myPet.getDropPotion() + " potion.");
					System.out.println(myPet.getName() + " picks them up.");
					myPet.createMonster();
					newMonster = true;
					System.out.println();
					System.out.println("Next turn.");
				}
				break;
			case "2":
				if (myPet.getApples() == 0 && myPet.getPeppers() == 0 && myPet.getMushrooms() == 0
						&& myPet.getFish() == 0) {
					System.out.println(myPet.getName() + " doesn't have any food.");
					System.out.println();
					newMonster = false;
				} else {
					System.out.println(myPet.getName() + " has:");
					System.out.println("   Apple (H+" + myPet.getApplesHBoost() + "): " + myPet.getApples());
					System.out.println("   Pepper (H+" + myPet.getPeppersHBoost() + "): " + myPet.getPeppers());
					System.out.println("   Mushroom (H+" + myPet.getMushroomsHBoost() + "): " + myPet.getMushrooms());
					System.out.println("   Fish (H+" + myPet.getFishHBoost() + "): " + myPet.getFish());
					System.out.println("What should " + myPet.getName() + " eat?");
					String foodChoice = input.nextLine();
					System.out.println(myPet.getName() + " ate the " + foodChoice + ".");
					myPet.eat(foodChoice);
					newMonster = false;
					myPet.tick(0, myPet.getStamTickAmount());
					System.out.println();
					System.out.println("Next turn.");
				}
				break;
			case "3":
				if (myPet.getRedPotion() == 0 && myPet.getBluePotion() == 0 && myPet.getYellowPotion() == 0) {
					System.out.println(myPet.getName() + " doesn't have any potions.");
					System.out.println();
					newMonster = false;
				} else {
					System.out.println(myPet.getName() + " has:");
					System.out.println("   Red (S+" + myPet.getRedSBoost() + "): " + myPet.getRedPotion());
					System.out.println("   Blue (S+" + myPet.getBlueSBoost() + "): " + myPet.getBluePotion());
					System.out.println("   Yellow (S+" + myPet.getYellowSBoost() + "): " + myPet.getYellowPotion());
					System.out.println("Which potion should " + myPet.getName() + " drink?");
					String potionChoice = input.nextLine();
					System.out.println(myPet.getName() + " drank the " + potionChoice + " potion.");
					myPet.drink(potionChoice);
					newMonster = false;
					myPet.tick(myPet.getHealthTickAmount(), myPet.getStamTickAmount());
					System.out.println();
					System.out.println("Next turn.");
				}
				break;
			case "4":
				System.out.println(myPet.getName() + " runs away.");
				myPet.createMonster();
				newMonster = true;
				myPet.tick(myPet.getHealthTickAmount(), myPet.getStamTickAmount());
				System.out.println();
				System.out.println("Next turn.");
				break;
			default:
				System.out.println("Please enter 1 - 4.");
				System.out.println();
			}

		}
		input.close();
	}

}
