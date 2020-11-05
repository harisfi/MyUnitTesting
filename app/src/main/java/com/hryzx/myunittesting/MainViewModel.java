package com.hryzx.myunittesting;

public class MainViewModel {
    private final CuboidModel cuboidModel;

    MainViewModel(CuboidModel cuboidModel) {
        this.cuboidModel = cuboidModel;
    }

    void save(double l, double w, double h) {
        cuboidModel.save(w, l, h);
    }

    double getCircumfence() {
        return cuboidModel.getCircumfence();
    }

    double getSurfaceArea() {
        return cuboidModel.getSurfaceArea();
    }

    double getVolume() {
        return cuboidModel.getVolume();
    }
}
