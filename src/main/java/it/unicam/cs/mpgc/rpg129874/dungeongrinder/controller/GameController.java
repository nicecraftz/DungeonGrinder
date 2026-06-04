package it.unicam.cs.mpgc.rpg129874.dungeongrinder.controller;

import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.world.WorldEnvironment;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.engine.MovementSystem;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.view.GameView;

public class GameController {
    private final WorldEnvironment environment;
    private final GameView gameView;
    private final GameLoopController gameLoopController;
    private final DebugOverlayController debugOverlayController;
    private final InputController inputController;
    private final EntityController entityController;

    public GameController(WorldEnvironment environment, GameView gameView) {
        this.environment = environment;
        this.gameView = gameView;
        this.gameLoopController = new GameLoopController(this);
        this.debugOverlayController = new DebugOverlayController(gameView.getDebugOverlay());
        this.inputController = new InputController(gameView, new MovementSystem(environment));
        this.entityController = new EntityController(environment);
    }

    public void tick(double fps) {
        debugOverlayController.update(environment, fps);
        inputController.processInput();
        entityController.pathfindEntities();
        gameView.render(environment);
    }
}
