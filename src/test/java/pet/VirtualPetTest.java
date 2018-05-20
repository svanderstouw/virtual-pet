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
		int healthBefore = underTest.getHealth();
		underTest.eat("apple");
		int healthAfter = underTest.getHealth();
		assertEquals(healthAfter, healthBefore + 5, 0);
	}
	
	@Test
	public void eatFoodOption4() {
		VirtualPet underTest = new VirtualPet("Bob");
		int healthBefore = underTest.getHealth();
		underTest.eat("fish");
		int healthAfter = underTest.getHealth();
		assertEquals(healthAfter, healthBefore + 50, 0);
	}

	@Test
	public void drinkPotionOption2() {
		VirtualPet underTest = new VirtualPet("Bob");
		int staminaBefore = underTest.getStamina();
		underTest.drink("Blue");
		int staminaAfter = underTest.getStamina();
		assertEquals(staminaAfter, staminaBefore + 20, 0);
	}
	
	@Test
	public void fightMonsterOption1TestStamina() {
		VirtualPet underTest = new VirtualPet("Bob");
		int staminaBefore = underTest.getStamina();
		underTest.fight("Bokoblin");
		int staminaAfter = underTest.getStamina();
		assertEquals(staminaAfter, staminaBefore - 50, 0);
	}
	
	@Test
	public void fightMonsterOption1TestHealth() {
		VirtualPet underTest = new VirtualPet("Bob");
		int healthBefore = underTest.getHealth();
		underTest.fight("Bokoblin");
		int healthAfter = underTest.getHealth();
		assertEquals(healthAfter, healthBefore - 20, 0);
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
	public void testRandomFoodDrop() {
		VirtualPet underTest = new VirtualPet("Bob");
		underTest.dropFood();
		int foodType = underTest.getFoodNum();
		assertEquals(1, foodType, 0);
	}
	
	@Test
	public void testTick() {
		VirtualPet underTest = new VirtualPet("Bob");
		int healthBefore = underTest.getHealth();
		underTest.tick(-5, 5);
		int healthAfter = underTest.getHealth();
		assertEquals(healthBefore - 5, healthAfter, 0);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
