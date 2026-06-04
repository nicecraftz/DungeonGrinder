package it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.world.position;

public record Point(int x, int y) {

    public static Point zero() {
        return new Point(0, 0);
    }
}
