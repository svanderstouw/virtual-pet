package pet;

import java.util.concurrent.ThreadLocalRandom;

public class VirtualPet {

	private String name;
	private String monster;
	private int monsterHealth = 0;
	private int monsterStamina = -25;
	private int minFightStamina = 25;
	private int health = 100;
	private int healthTickAmount = -5;
	private int stamina = 100;
	private int stamTickAmount = 10;
	private String dropFoodName;
	private int apples = 0;
	private int applesHBoost = 5;
	private int peppers = 0;
	private int peppersHBoost = 10;
	private int mushrooms = 0;
	private int mushroomsHBoost = 25;
	private int fish = 0;
	private int fishHBoost = 50;
	private String dropPotionColor;
	private int redPotion = 0;
	private int redSBoost = 10;
	private int bluePotion = 0;
	private int blueSBoost = 20;
	private int yellowPotion = 0;
	private int yellowSBoost = 30;

	public VirtualPet(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public String getMonster() {
		return monster;
	}
	
	public int getMonsterHealth() {
		return monsterHealth;
	}
	
	public int getMonsterStamina() {
		return monsterStamina;
	}
	
	public int getMinFightStamina() {
		return minFightStamina;
	}

	public int getHealth() {
		return health;
	}
	
	public void setHealth(int healthNum) {
		health = healthNum;
	}
	
	public int getHealthTickAmount() {
		return healthTickAmount;
	}

	public int getStamina() {
		return stamina;
	}
	
	public void setStamina(int staminaNum) {
		stamina = staminaNum;
	}
	
	public int getStamTickAmount() {
		return stamTickAmount;
	}
	
	public String getDropFood() {
		return dropFoodName;
	}

	public int getApples() {
		return apples;
	}
	
	public int getApplesHBoost() {
		return applesHBoost;
	}
	
	public int getPeppers() {
		return peppers;
	}

	public int getPeppersHBoost() {
		return peppersHBoost;
	}
	
	public int getMushrooms() {
		return mushrooms;
	}

	public int getMushroomsHBoost() {
		return mushroomsHBoost;
	}
	
	public int getFish() {
		return fish;
	}

	public int getFishHBoost() {
		return fishHBoost;
	}
	
	public String getDropPotion() {
		return dropPotionColor;
	}
	
	public int getRedPotion() {
		return redPotion;
	}
	
	public int getRedSBoost() {
		return redSBoost;
	}

	public int getBluePotion() {
		return bluePotion;
	}
	
	public int getBlueSBoost() {
		return blueSBoost;
	}
	
	public int getYellowPotion() {
		return yellowPotion;
	}
	
	public int getYellowSBoost() {
		return yellowSBoost;
	}

	public void eat(String foodOption) {
		switch (foodOption.toLowerCase()) {
		case "apple":
			this.tick(applesHBoost, 0);
			apples --;
			break;
		case "pepper":
			this.tick(peppersHBoost, 0);
			peppers --;
			break;
		case "mushroom":
			this.tick(mushroomsHBoost, 0);
			mushrooms --;
			break;
		case "fish":
			this.tick(fishHBoost, 0);
			fish --;
			break;
		}

	}

	public void drink(String potionOption) {
		switch (potionOption.toLowerCase()) {
		case "red":
			this.tick(0, redSBoost);
			redPotion --;
			break;
		case "blue":
			this.tick(0, blueSBoost);
			bluePotion --;
			break;
		case "yellow":
			this.tick(0, yellowSBoost);
			yellowPotion --;
			break;
		}
	}

	public void fight() {
		this.tick(monsterHealth, monsterStamina);
		this.dropFood();
		this.dropPotion();
	}

	public void dropFood() {
		int randomNum = ThreadLocalRandom.current().nextInt(1, 5);
		switch (randomNum) {
		case 1:
			dropFoodName = "apple";
			apples ++;
			break;
		case 2:
			dropFoodName = "pepper";
			peppers ++;
			break;
		case 3:
			dropFoodName = "mushroom";
			mushrooms ++;
			break;
		case 4:
			dropFoodName = "fish";
			fish ++;
			break;
		}
		
	}

	public void dropPotion() {
		int randomNum = ThreadLocalRandom.current().nextInt(1, 4);
		switch (randomNum) {
		case 1:
			dropPotionColor = "red";
			redPotion ++;
			break;
		case 2:
			dropPotionColor = "blue";
			bluePotion ++;
			break;
		case 3:
			dropPotionColor = "yellow";
			yellowPotion ++;
			break;
		}	
	}

	public void createMonster() {
		int randomNum = ThreadLocalRandom.current().nextInt(1, 5);
		switch (randomNum) {
		case 1:
			monster = "Bokoblin";
			monsterHealth = -20;
			break;
		case 2:
			monster = "Keese";
			monsterHealth = -10;
			break;
		case 3:
			monster = "Moblin";
			monsterHealth = -75;
			break;
		case 4:
			monster = "Lizalfos";
			monsterHealth = -50;
			break;
		}
	}

	public void tick(int healthTick, int staminaTick ) {
		health += healthTick;
		if (health <= 0) {
			this.perish();
		}else if (health > 100){
			health = 100;
		}
		stamina += staminaTick;
		if (stamina < 0) {
			stamina = 0;
		} else if (stamina > 100){
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
