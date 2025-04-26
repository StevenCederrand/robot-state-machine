package com.sc.app;

import java.util.Map;

public class World {
    private static final Map<String, Vec2> startingDirections = Map.of(
            "N", new Vec2(0, 1),
            "S", new Vec2(0, -1),
            "E", new Vec2(-1, 0),
            "W", new Vec2(1, 0)
    );
    private final Vec2 worldBounds;
    private final String commands;
    private final RobotStateMachine robotto;

    World(Vec2 worldBounds, RobotStateMachine robotto, String commands) {
        this.robotto = robotto;
        this.worldBounds = worldBounds;
        this.commands = commands;
    }

    public World run() throws PositionOutOfBoundsException {
        for (int i = 0; i < commands.length(); i++) {
            switch (commands.charAt(i)) {
                case 'L':
                    this.robotto.left();
                    break;
                case 'R':
                    this.robotto.right();
                    break;
                case 'F': {
                    this.robotto.forward();
                    if (this.robotto.pos.isOutsideOfBounds(worldBounds)) {
                        throw new PositionOutOfBoundsException("Mr Robot is outside of the boundaries");
                    }
                    break;
                }
                default: { /* ignore any unknown input */ }
            }
        }
        return this;
    }

    public String getReport() {
        String direction = startingDirections
            .entrySet()
            .stream()
            .filter(e -> e.getValue().equals(robotto.dir))
            .map(Map.Entry::getKey).findFirst().get();
        return "Report: " + robotto.pos + " " + direction;
    }

    // NOTE: we are assuming that the input is correctly formatted
    public static World fromString(final String worldState) {
        final var lines = worldState.split("\n");
        final var worldBounds = worldBoundsFromLine(lines[0].split(" "));
        final var robotto = initialiseRobotStateMachine(lines[1].split(" "));

        return new World(worldBounds, robotto, lines[2]);
    }

    private static Vec2 worldBoundsFromLine(final String[] split) {
        return new Vec2(split[0], split[1]);
    }

    private static RobotStateMachine initialiseRobotStateMachine(final String[] split) {
        var startPosition = new Vec2(split[0], split[1]);
        var direction = startingDirections.get(split[2]);
        return new RobotStateMachine(startPosition, direction);
    }
}
