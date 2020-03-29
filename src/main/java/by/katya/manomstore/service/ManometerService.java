package by.katya.manomstore.service;


import by.katya.manomstore.entity.Manometer;
import by.katya.manomstore.entity.ManometerType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManometerService {

    private List<Manometer> manometers;

    @Autowired
    public ManometerService(List<Manometer> manometers) {
        this.manometers = manometers;
    }

    public List<Manometer> getManometers () {
        return  manometers;
    }

    public boolean addManometer (Manometer manometer) {
        return manometers.add(manometer);
    }

    public boolean deleteManometer (Manometer manometer) {
        return manometers.remove(manometer);
    }

    public Manometer searchManometer (long id) {
        for (Manometer manom: manometers) {
            if (manom.getId() == id) {
                return manom;
            }
        }
        return null;
    }

    public Manometer editManometer (Manometer manometer, String specification) {
        manometer.setSpecification(specification);
        return manometer;
    }




}
