package by.katya.manomstore.service;


import by.katya.manomstore.entity.Manometer;
import by.katya.manomstore.entity.ManometerType;
import by.katya.manomstore.repository.ManomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ManometerService {


    private final ManomRepository manomRepository;

    @Autowired
    public ManometerService(ManomRepository manomRepository) {
        this.manomRepository = manomRepository;
    }

    public boolean addManometer(Manometer manometer) {
        if (manometer != null) {
            manomRepository.save(manometer);
            return true;
        }
        return false;
    }

    public boolean deleteManometer(long id) {
        Optional<Manometer> findById = manomRepository.findById(id);
        if (findById.isPresent()) {
            manomRepository.delete(findById.get());
            return true;
        }
        return false;
    }

    public Manometer searchManometer(long id) {
        Optional<Manometer> findById = manomRepository.findById(id);
        if (findById.isPresent()) {
            return findById.get();
        }
        return null;
    }

    public boolean editManometer(Manometer manometer, String specification) {
        Optional<Manometer> findById = manomRepository.findById(manometer.getId());
        if (findById.isPresent()) {
            manometer.setSpecification(specification);
            manomRepository.save(manometer);
        }
        return false;
    }
}




//  с сохранением в лист
//    private List<Manometer> manometers;
//
//    @Autowired
//    public ManometerService(List<Manometer> manometers) {
//        this.manometers = manometers;
//    }
//
//    public List<Manometer> getManometers () {
//        return  manometers;
//    }
//
//    public boolean addManometer (Manometer manometer) {
//        return manometers.add(manometer);
//    }
//
//    public boolean deleteManometer (Manometer manometer) {
//        return manometers.remove(manometer);
//    }
//
//    public Manometer searchManometer (long id) {
//        for (Manometer manom: manometers) {
//            if (manom.getId() == id) {
//                return manom;
//            }
//        }
//        return null;
//    }
//
//    public Manometer editManometer (Manometer manometer, String specification) {
//        manometer.setSpecification(specification);
//        return manometer;
//    }


