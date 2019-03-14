# mortal-kombat

## Build & Run instruction

Please execute next command to run the game.

```
mvn exec:java
```

Or if you would like just to verify test results:
```
mvn test
```

## How to extend?

To create concrete character, [Character](./src/main/java/com/mlavrenko/model/character/Character.java) interface need to be implemented.

[Game](./src/main/java/com/mlavrenko/model/game/Game.java) interface could be extended in order to have concrete kind of game.

[GameView](./src/main/java/com/mlavrenko/view/GameView.java) interface could be extended to have specific way of information displaying.

[GameController](./src/main/java/com/mlavrenko/controller/GameController.java) interface could be extended to have specific control over the game.

[CommandMapper](./src/main/java/com/mlavrenko/command/CommandMapper.java) helps to map user commands to appropriate function.
Functions to execute might belong to different controllers. Basically the idea of this mapper is to simulate Handler Mapping.