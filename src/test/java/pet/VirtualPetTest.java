package pet;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class VirtualPetTest {

	@Test
	public void getPetName() {
		VirtualPet underTest = new VirtualPet("Bob");
		String name = underTest.getName();
		assertEquals("", "Bob", name);
	}

	@Test
	public void eatFoodOption1() {
		VirtualPet underTest = new VirtualPet("Bob");
		underTest.setHealth(50);
		int healthBefore = underTest.getHealth();
		underTest.eat("apple");
		int healthAfter = underTest.getHealth();
		assertEquals(healthAfter, healthBefore + underTest.getApplesHealthBoost(), 0);
	}
	
	@Test
	public void eatFoodOption2() {
		VirtualPet underTest = new VirtualPet("Bob");
		underTest.setHealth(50);
		int healthBefore = underTest.getHealth();
		underTest.eat("pepper");
		int healthAfter = underTest.getHealth();
		assertEquals(healthAfter, healthBefore + underTest.getPeppersHealthBoost(), 0);
	}
	
	@Test
	public void eatFoodOption3() {
		VirtualPet underTest = new VirtualPet("Bob");
		underTest.setHealth(50);
		int healthBefore = underTest.getHealth();
		underTest.eat("mushroom");
		int healthAfter = underTest.getHealth();
		assertEquals(healthAfter, healthBefore + underTest.getMushroomsHealthBoost(), 0);
	}
	
	@Test
	public void eatFoodOption4() {
		VirtualPet underTest = new VirtualPet("Bob");
		underTest.setHealth(50);
		int healthBefore = underTest.getHealth();
		underTest.eat("fish");
		int healthAfter = underTest.getHealth();
		assertEquals(healthAfter, healthBefore + underTest.getFishHealthBoost(), 0);
	}

	@Test
	public void drinkPotionOption2() {
		VirtualPet underTest = new VirtualPet("Bob");
		underTest.setStamina(50);
		int staminaBefore = underTest.getStamina();
		underTest.drink("Blue");
		int staminaAfter = underTest.getStamina();
		assertEquals(staminaAfter, staminaBefore + underTest.getBlueStamBoost(), 0);
	}
	
	@Test
	public void drinkPotionOption1() {
		VirtualPet underTest = new VirtualPet("Bob");
		underTest.setStamina(50);
		int staminaBefore = underTest.getStamina();
		underTest.drink("Red");
		int staminaAfter = underTest.getStamina();
		assertEquals(staminaAfter, staminaBefore + underTest.getRedStamBoost(), 0);
	}
	
	@Test
	public void drinkPotionOption3() {
		VirtualPet underTest = new VirtualPet("Bob");
		underTest.setStamina(50);
		int staminaBefore = underTest.getStamina();
		underTest.drink("Yellow");
		int staminaAfter = underTest.getStamina();
		assertEquals(staminaAfter, staminaBefore + underTest.getYellowStamBoost(), 0);
	}
	
	@Test
	public void fightMonsterTestStamina() {
		VirtualPet underTest = new VirtualPet("Bob");
		int staminaBefore = underTest.getStamina();
		underTest.fight();
		int staminaAfter = underTest.getStamina();
		assertEquals(staminaAfter, staminaBefore + underTest.getMonsterStamina(), 0);
	}
	
	@Test
	public void fightMonsterTestHealth() {
		VirtualPet underTest = new VirtualPet("Bob");
		underTest.createMonster();
		underTest.setShield(50);
		int healthBefore = underTest.getHealth();
		int healthChange = underTest.getMonsterHealth();
		underTest.fight();
		int healthAfter = underTest.getHealth();
		assertEquals(healthAfter, healthBefore + healthChange, 0);
	}

	@Test
	public void eatApplesLessApples() {
		VirtualPet underTest = new VirtualPet("Bob");
		int applesBefore = underTest.getApples();
		underTest.eat("apple");
		int applesAfter = underTest.getApples();
		assertEquals(applesAfter, applesBefore - 1, 0);		
	}
	
	@Test
	public void testTick() {
		VirtualPet underTest = new VirtualPet("Bob");
		int healthBefore = underTest.getHealth();
		underTest.tick(-5, 5, 0);
		int healthAfter = underTest.getHealth();
		assertEquals(healthBefore - 5, healthAfter, 0);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
