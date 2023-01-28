# Honey Tree Simulation

## Context 

In the games Pokemon Diamond, Pearl, and Platinum, there is a unique time-based method of encountering rare Pokemon by slathering honey on "honey trees." To be more specific, the player can slather an in-game item called 'Honey' on one of the 21 Honey Trees found within the map, wait 6 hours, and then revisit the tree to find a newly generated Pokemon to catch. 4 out of these 21 Honey Trees have a chance to attract a Pokemon called Munchlax, with the "Munchlax Tree" locations being determined by a trainer's ID (which is generated at the beginning of the game and can be checked in-game) and their secret ID (which unlike the trainer ID is not immediately available to the player). When the encounter tables for each slathered tree need to be generated, the game first chooses from one of three groups (A, B, or C) of Pokemon. Here is an excerpt from [Bulbapedia](https://bulbapedia.bulbagarden.net/wiki/Honey_Tree) which demonstrates how specifically these groups are chosen: 

> The 17 non-Munchlax trees have a 70% chance of choosing from Group A, a 20% chance of choosing from Group B, a 0% chance of choosing from Group C, and a 10% chance of choosing no encounter. The four Munchlax trees have a 20% chance of choosing from Group A, a 70% chance of choosing from Group B, a 1% chance of choosing from Group C, and a 9% chance of choosing no encounter. 

The encounter tables for Non-Munchlax and Munchlax trees, also taken from Bulbapedia, are displayed below.


![image](https://user-images.githubusercontent.com/80475070/215250052-1de73cb7-dc76-4f59-97f2-7140e0fae6c2.png)
![image](https://user-images.githubusercontent.com/80475070/215250074-3a38ea93-1c61-455d-947a-1dba46111ce1.png)
