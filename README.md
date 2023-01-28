# Honey Tree Simulation

## Context 

In the games Pokemon Diamond, Pearl, and Platinum, there is a unique time-based method of encountering rare Pokemon by slathering honey on "honey trees." To be more specific, the player can slather an in-game item called 'Honey' on one of the 21 Honey Trees found within the map, wait 6 hours, and then revisit the tree to find a newly generated Pokemon to catch. 4 out of these 21 Honey Trees have a chance to attract a Pokemon called Munchlax, with the "Munchlax Tree" locations being determined by a trainer's ID (which is generated at the beginning of the game and can be checked in-game) and their secret ID (which unlike the trainer ID is not immediately available to the player). When the encounter tables for each slathered tree need to be generated, the game first chooses from one of three groups (A, B, or C) of Pokemon. Here is an excerpt from [Bulbapedia](https://bulbapedia.bulbagarden.net/wiki/Honey_Tree) which demonstrates how specifically these groups are chosen: 

> The 17 non-Munchlax trees have a 70% chance of choosing from Group A, a 20% chance of choosing from Group B, a 0% chance of choosing from Group C, and a 10% chance of choosing no encounter. The four Munchlax trees have a 20% chance of choosing from Group A, a 70% chance of choosing from Group B, a 1% chance of choosing from Group C, and a 9% chance of choosing no encounter. 

The encounter tables for Non-Munchlax and Munchlax trees, also taken from Bulbapedia, are displayed below.


![image](https://user-images.githubusercontent.com/80475070/215250052-1de73cb7-dc76-4f59-97f2-7140e0fae6c2.png)
![image](https://user-images.githubusercontent.com/80475070/215250074-3a38ea93-1c61-455d-947a-1dba46111ce1.png)

All of these game mechanics are simulated in the Java program found within this repository.

## Simulator

In this simulator, there are technically 3 different commands, which can all be inputted after the first prompt. The first prompt asks
> What is your trainer ID?

In order to determine the 2/4 Munchlax tree locations associated with your trainer ID. Then, you are able to use 3 different commands. The first command, `L`, prints a list of all possible Honey Tree route locations. 

![image](https://user-images.githubusercontent.com/80475070/215250398-24aed1a8-6775-4e50-bd8e-c7d3128e08ef.png)

The second command can be the names of any of the routes present when typing the `L` command. For example, you could type `Route 207`, and that would generate an encounter for the Honey Tree at Route 207. 

![image](https://user-images.githubusercontent.com/80475070/215250479-d0dc2c4e-156b-46d1-9215-de510e8258ee.png)

Finally, the last command is `N` which ends the simulation loop. 

## Sample Output

`
Type in your trainer ID!
60000
Two of your Munchlax trees should be Route 207 and Route 214.
Type in your next honey tree location! To stop, type 'N'
To list the available locations, type 'L'
Route 207
Your (munchlaxTree) random encounter is: Burmy
Type in your next honey tree location! To stop, type 'N'
To list the available locations, type 'L'
Route 207
Your (munchlaxTree) random encounter is: Combee
Type in your next honey tree location! To stop, type 'N'
To list the available locations, type 'L'
L
Your available locations are: 
Route 205, Floroama Town side
Route 205, Eterna City side
Route 206
Route 207
Route 208
Route 209
Route 210, Solaceon Town Side
Route 210, Celestic Town side
Route 211
Route 212, Hearthome City side
Route 212, Pastoria City side
Route 213
Route 214
Route 215
Route 218
Route 221
Route 222
Valley Windworks
Eterna Forest
Fuego Ironworks
Floaroma Meadow
N

Process finished with exit code 0

`

## Todo
