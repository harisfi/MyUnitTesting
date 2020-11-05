package com.hryzx.myunittesting;

public class CuboidModel {
    private double width, length, height;

    public CuboidModel() {}

    public void save(double width, double length, double height) {
        this.width = width;
        this.length = length;
        this.height = height;
    }

    double getVolume() {
        return width * length * height;
    }

    public double getSurfaceArea() {
        double wl = width * length;
        double wh = width * height;
        double lh = length * height;
        return 2 * (wl + wh + lh);
    }

    public double getCircumfence() {
        return 4 * (width + length + height);
    }
}