package it.unicam.cs.mpgc.rpg129874.dungeongrinder.controller;

import it.unicam.cs.mpgc.rpg129874.dungeongrinder.controller.input.InputController;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.controller.world.CreatureController;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.controller.world.RoomController;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.world.WorldEnvironment;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.engine.physics.MovementSystem;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.view.DebugOverlayView;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.view.GameView;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.view.StatusView;

public class GameController {
    private final WorldEnvironment environment;
    private final GameView gameView;
    private final MovementSystem movementSystem;
    private final GameLoopController gameLoopController;
    private final DebugOverlayController debugOverlayController;
    private final StatusController statusController;
    private final InputController inputController;
    private final CreatureController creatureController;
    private final RoomController roomController;

    public GameController(WorldEnvironment environment, GameView gameView, DebugOverlayView debugOverlayView, StatusView statusView) {
        this.environment = environment;
        this.gameView = gameView;
        this.movementSystem = new MovementSystem(environment);
        this.gameLoopController = new GameLoopController(this);
        this.debugOverlayController = new DebugOverlayController(debugOverlayView);
        this.statusController = new StatusController(statusView);
        this.inputController = new InputController(gameView, debugOverlayView, statusView, movementSystem, environment.getPlayer());
        this.creatureController = new CreatureController(environment.getEntityContainer());
        this.roomController = new RoomController(environment, gameView);
    }


    public void tick(double fps) {
        inputController.processInput();
        debugOverlayController.update(environment, fps);
        statusController.update(environment.getPlayer());
        creatureController.tickCreatures();
        movementSystem.update();
        roomController.checkRoomTransition();
        gameView.render(environment);
    }

}
