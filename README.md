# Virtual Pet Project

The app prompts the user for a name and then generates a Virtual Pet Adventurer.
Each Adventurer has stats showing their Health, Stamina, and Shield. 

During each turn, the user has four actions for their Adventurer:
1. Fight monsters - decreases health and stamina, but results in dropped food and potions
1. Eat food - increases health
1. Drink potions - increases stamina
1. Run away

The Adventurer cannot fight a monster if the their stamina stat drops too low.
If the Adventurer's shield is at full strength, it will absorb hit points during a fight.
At the end of each turn the Adventurer's health decreases and their stamina increases.

The monsters, dropped food, and dropped potions are all randomly chosen.

If the Adventurer's health drops to 0, the Adventurer dies.