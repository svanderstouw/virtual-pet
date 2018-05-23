package pet;

import java.util.concurrent.ThreadLocalRandom;

public class VirtualPet {

	private String name;
	boolean isAlive = true;
	
	private String monster;
	private int monsterHealth = 0;
	private int monsterStamina = -30;
	private int monsterAttacksShield = 100;
	
	private int health = 100;
	private int healthTickAmount = -10;
	
	private int stamina = 100;
	private int stamTickAmount = 10;
	private int minFightStamina = 30;
	
	private int shield = 100;
	private int shieldTickAmount = 34;
	
	private String dropFoodName;
	private int apples = 0;
	private int applesHealthBoost = 5;
	private int peppers = 0;
	private int peppersHealthBoost = 10;
	private int mushrooms = 0;
	private int mushroomsHealthBoost = 25;
	private int fish = 0;
	private int fishHealthBoost = 50;
	
	private String dropPotionColor;
	private int redPotion = 0;
	private int redStamBoost = 10;
	private int bluePotion = 0;
	private int blueStamBoost = 30;
	private int yellowPotion = 0;
	private int yellowStamBoost = 50;

	public VirtualPet(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	public boolean getIsAlive() {
		return isAlive;
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
	
	public String getShieldStatus() {
		if (shield >= 100) {
			return "Full strength!";
		} else {
			return "Regenerating...";
		}
	}
	
	public int getShieldTickAmount() {
		return shieldTickAmount;
	}
	
	public int getShield() {
		return shield;
	}
	
	public void setShield(int shieldNum) {
		shield = shieldNum;
	}
	
	public int getMonsterAttacksShield () {
		return monsterAttacksShield; 
	}
	
	public String getDropFood() {
		return dropFoodName;
	}

	public int getApples() {
		return apples;
	}
	
	public int getApplesHealthBoost() {
		return applesHealthBoost;
	}
	
	public int getPeppers() {
		return peppers;
	}

	public int getPeppersHealthBoost() {
		return peppersHealthBoost;
	}
	
	public int getMushrooms() {
		return mushrooms;
	}

	public int getMushroomsHealthBoost() {
		return mushroomsHealthBoost;
	}
	
	public int getFish() {
		return fish;
	}

	public int getFishHealthBoost() {
		return fishHealthBoost;
	}
	
	public String getDropPotion() {
		return dropPotionColor;
	}
	
	public int getRedPotion() {
		return redPotion;
	}
	
	public int getRedStamBoost() {
		return redStamBoost;
	}

	public int getBluePotion() {
		return bluePotion;
	}
	
	public int getBlueStamBoost() {
		return blueStamBoost;
	}
	
	public int getYellowPotion() {
		return yellowPotion;
	}
	
	public int getYellowStamBoost() {
		return yellowStamBoost;
	}

	public void eat(String foodOption) {
		switch (foodOption.toLowerCase()) {
		case "apple":
			this.tick(applesHealthBoost, 0, 0);
			apples --;
			break;
		case "pepper":
			this.tick(peppersHealthBoost, 0, 0);
			peppers --;
			break;
		case "mushroom":
			this.tick(mushroomsHealthBoost, 0, 0);
			mushrooms --;
			break;
		case "fish":
			this.tick(fishHealthBoost, 0, 0);
			fish --;
			break;
		}

	}

	public void drink(String potionOption) {
		switch (potionOption.toLowerCase()) {
		case "red":
			this.tick(0, redStamBoost, 0);
			redPotion --;
			break;
		case "blue":
			this.tick(0, blueStamBoost, 0);
			bluePotion --;
			break;
		case "yellow":
			this.tick(0, yellowStamBoost, 0);
			yellowPotion --;
			break;
		}
	}

	public void fight() {
		int shieldFightResult = 0;
		int healthFightResult = 0;
		if (shield == 100) {
			shieldFightResult -= monsterAttacksShield;
			healthFightResult = monsterHealth + shield;
			if (healthFightResult > 0) {
				healthFightResult = 0;
			}
		} else {
			healthFightResult = monsterHealth;
			shieldFightResult = shieldTickAmount;
		}
		this.tick(healthFightResult, monsterStamina, shieldFightResult);
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
			monsterHealth = -50;
			break;
		case 2:
			monster = "Keese";
			monsterHealth = -30;
			break;
		case 3:
			monster = "Moblin";
			monsterHealth = -80;
			break;
		case 4:
			monster = "Lizalfos";
			monsterHealth = -125;
			break;
		}
	}

	public void tick(int healthTick, int staminaTick, int shieldTick) {
		health += healthTick;
		if (health <= 0) {
			isAlive = false;
		}else if (health > 100){
			health = 100;
		}
		stamina += staminaTick;
		if (stamina < 0) {
			stamina = 0;
		} else if (stamina > 100){
			stamina = 100;
		}
		shield += shieldTick;
		if (shield < 0) {
			shield = 0;
		} else if (shield > 100){
			shield = 100;
		}
	}
}
