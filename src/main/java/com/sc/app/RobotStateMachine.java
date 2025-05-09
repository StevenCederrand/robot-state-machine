package com.sc.app;

public class RobotStateMachine {
    protected final Vec2 pos;
    protected final Vec2 dir;

    RobotStateMachine(Vec2 pos, Vec2 dir) {
        this.pos = pos;
        this.dir = dir;
    }

    public void left() {
        this.dir.rotate(90);
    }

    public void right() {
        this.dir.rotate(-90);
    }

    public void forward() {
        this.pos.add(this.dir);
    }

    @Override
    public String toString() {
        return "position: " + pos + " direction: " + dir;
    }
}
