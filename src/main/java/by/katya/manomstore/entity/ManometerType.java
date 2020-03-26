package by.katya.manomstore.entity;

import java.io.Serializable;

public enum ManometerType implements Serializable {

    PressureGauge("Манометр"),
    VacuumGauge("Вакууметр"),
    PressureVacuumGauge("Мановакууметр"),
    HeadGauge("Напоромер"),
    DraftMeter("Тягомер"),
    WeightGauge("Тягонапоромер");

    private String name;

    ManometerType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
