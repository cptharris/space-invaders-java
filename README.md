# Space Invaders

Space Invaders was a 1978 arcade game based on other shooting games of the time, as well as movies like _Star Wars_. This is my version of Space Invaders, written in Java. I have a spinoff version [on my website](https://techiecable.github.io/programs/space_invaders), but it deviates significantly from the original gameplay. For this version, I attempted to recreate the gameplay while also adding in nicer graphics and some different touches.

## Gameplay

[![playthrough gif](assets/space-invaders-playthrough-105ed30675e9ba5e546aefbd9070fbf4d96cebbc.gif)](https://raw.githubusercontent.com/TechieCable/space-invaders-java/master/assets/space-invaders-playthrough-105ed30675e9ba5e546aefbd9070fbf4d96cebbc.gif)

A spaceship at the bottom, based on the x-wing from _Star Wars_ can travel from left to right. A group of aliens travels left to right as well, descending toward the player. The player and aliens shoot at each other. The player's goal is to stay alive as long as possible and prevent the aliens from reaching the bottom of the screen.

Powerups, such as ammo charges and hearts, travel from the left side of the screen. The player can shoot the ammo charges to reduce their reload time and the hearts to regain health (to a maximum of 10 hearts).

## Entities

| name | image |
|------|-------|
| aliens | [<img src="space-invaders/src/imgs/alien00.png" width="80">](https://raw.githubusercontent.com/TechieCable/space-invaders-java/master/space-invaders/src/imgs/alien00.png) [<img src="space-invaders/src/imgs/alien10.png" width="80">](https://raw.githubusercontent.com/TechieCable/space-invaders-java/master/space-invaders/src/imgs/alien10.png) |
| player | [<img src="space-invaders/src/imgs/xwing.png" width="100">](https://raw.githubusercontent.com/TechieCable/space-invaders-java/master/space-invaders/src/imgs/xwing.png) |
| ammo charges | [<img src="space-invaders/src/imgs/ammo.png" width="20">](https://raw.githubusercontent.com/TechieCable/space-invaders-java/master/space-invaders/src/imgs/ammo.png) |
| hearts | [<img src="space-invaders/src/imgs/heart.png" width="20">](https://raw.githubusercontent.com/TechieCable/space-invaders-java/master/space-invaders/src/imgs/heart.png) |
| blast bolts | [<img src="space-invaders/src/imgs/blast0.png" width="10">](https://raw.githubusercontent.com/TechieCable/space-invaders-java/master/space-invaders/src/imgs/blast0.png) [<img src="space-invaders/src/imgs/blast1.png" width="10">](https://raw.githubusercontent.com/TechieCable/space-invaders-java/master/space-invaders/src/imgs/blast1.png)

[![gameplay screenshot](assets/screenshot0.png)](https://raw.githubusercontent.com/TechieCable/space-invaders-java/master/assets/screenshot0.png)

## How to Play
- `space` to shoot
- `left arrow` or `right arrow` to go left or right
- `ESC` to restart
- shoot the aliens to destroy them
- shoot ammo charges to reduce reload time
- shoot the hearts to regain health
