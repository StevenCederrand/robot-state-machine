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

    public void rotate(final double degrees) {
        final double r = Math.toRadians(degrees);
        double rx = (this.x * Math.cos(r)) - (this.y * Math.sin(r));
        double ry = (this.x * Math.sin(r)) + (this.y * Math.cos(r));
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
