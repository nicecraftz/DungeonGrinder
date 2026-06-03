package it.unicam.cs.mpgc.rpg129874.dungeongrinder.controller;

import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.world.WorldMap;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.view.WorldMapView;

public class GameController {
    private final WorldMap worldMapModel;
    private final WorldMapView worldMapView;
    
    public GameController(WorldMap worldMapModel, WorldMapView worldMapView) {
        this.worldMapModel = worldMapModel;
        this.worldMapView = worldMapView;
        updateRender();
    }

    public void updateRender() {
        worldMapView.render(worldMapModel);
    }

}
