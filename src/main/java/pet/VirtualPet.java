package pet;

import java.util.concurrent.ThreadLocalRandom;

public class VirtualPet {

	private String name;
	private String monster;
	private int health = 100;
	private int stamina = 100;
	private int apples = 10;
	private int peppers = 0;
	private int mushrooms = 0;
	private int fish = 0;
	private int redPotion = 0;
	private int bluePotion = 0;
	private int foodNum = 0;

	public VirtualPet(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public String getMonster() {
		return monster;
	}

	public int getHealth() {
		return health;
	}

	public int getStamina() {
		return stamina;
	}

	public int getApples() {
		return apples;
	}

	public int getPeppers() {
		return peppers;
	}

	public int getMushrooms() {
		return mushrooms;
	}

	public int getFish() {
		return fish;
	}

	public int getRedPotion() {
		return redPotion;
	}

	public int getBluePotion() {
		return bluePotion;
	}

	public void eat(String foodOption) {
		switch (foodOption.toLowerCase()) {
		case "apple":
			health += 5;
			apples -= 1;
			break;
		case "pepper":
			health += 10;
			peppers -= 1;
			break;
		case "mushroom":
			health += 25;
			mushrooms -= 1;
		case "fish":
			health += 50;
			fish -= 1;
			break;
		}

	}

	public void drink(String potionOption) {
		switch (potionOption.toLowerCase()) {
		case "red":
			stamina += 10;
			break;
		case "blue":
			stamina += 20;
			break;
		}
	}

	public void fight(String monsterName) {
		switch (monsterName) {
		case "Bokoblin":
			health -= 20;
			stamina -= 50;
			break;
		case "Keese":
			health -= 20;
			stamina -= 50;
			break;
		case "Moblin":
			health -= 20;
			stamina -= 50;
			break;
		case "Lizalfos":
			health -= 20;
			stamina -= 50;
			break;
		}

	}

	public int getFoodNum() {
		return foodNum;
	}

	public void dropFood() {
		int randomNum = ThreadLocalRandom.current().nextInt(1, 5);
		foodNum = randomNum;
	}

	public void dropPotion() {
		int randomNum = ThreadLocalRandom.current().nextInt(1, 3);
		foodNum = randomNum;
	}

	public void createMonster() {
		int randomNum = ThreadLocalRandom.current().nextInt(1, 5);
		switch (randomNum) {
		case 1:
			monster = "Bokoblin";
			break;
		case 2:
			monster = "Keese";
			break;
		case 3:
			monster = "Moblin";
			break;
		case 4:
			monster = "Lizalfos";
			break;
		}
	}

	public void tick(int healthTick, int staminaTick ) {
		health += healthTick;
		if (health <= 0) {
			this.perish();
		}
		if (stamina <= 95) {
			stamina += staminaTick;
		} else {
			stamina = 100;
		}
	}

	public void perish() {
		System.out.println();
		System.out.println(name + " died!");
		System.out.println("Thanks for playing.");
		System.exit(0);
	}
}
