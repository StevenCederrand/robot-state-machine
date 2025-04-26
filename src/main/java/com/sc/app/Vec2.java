package com.sc.app;

/**
 * Vec2 is a simple class providing basic mathematical vector operations.
 * Operations supports are:
 *   * Addition
 *   * 90degree (counter)clockwise rotation
 *   * bounds checking
 */
public class Vec2 {
    private double x;
    private double y;

    Vec2(double x, double y) {
        this.x = x;
        this.y = y;
    }

    Vec2(String x, String y) {
        this.x = Double.parseDouble(x);
        this.y = Double.parseDouble(y);
    }

    public void add(final Vec2 oVec) {
        this.x += oVec.x;
        this.y += oVec.y;
    }

    public void rotate90CounterClockwise() {
        final double n = Math.toRadians(90);
        double rx = (this.x * Math.cos(n)) - (this.y * Math.sin(n));
        double ry = (this.x * Math.sin(n)) + (this.y * Math.cos(n));
        x = Math.rint(rx);
        y = Math.rint(ry);
    }

    public void rotate90Clockwise() {
        final double n = Math.toRadians(90);
        double rx = (this.x * Math.cos(-n)) - (this.y * Math.sin(-n));
        double ry = (this.x * Math.sin(-n)) + (this.y * Math.cos(-n));
        x = Math.rint(rx);
        y = Math.rint(ry);
    }

    public boolean isOutsideOfBounds(final Vec2 bounds) {
        return this.x < 0 || this.x > bounds.x || this.y < 0 || this.y > bounds.y;
    }

    @Override
    public String toString() {
        return "(" + this.x + ", " + this.y + ")";
    }
}