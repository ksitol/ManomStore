package by.katya.manomstore.controller;


import by.katya.manomstore.entity.Manometer;
import by.katya.manomstore.entity.ManometerType;
import by.katya.manomstore.exception.ManomEx;
import by.katya.manomstore.service.ManometerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping ("/manometer")
public class ManometerController {

    private ManometerService manometerService;

    public ManometerController(ManometerService manometerService) {
        this.manometerService = manometerService;
    }

    @GetMapping (path = "/test")
    public ResponseEntity<Manometer> getManometer () {
        Manometer manometer = new Manometer (0, "MT", ManometerType.PressureGauge, "Test", 10 );
        return  new ResponseEntity<>(manometer, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Manometer> addManometer (@Valid @RequestBody Manometer manometer) {
        manometerService.addManometer(manometer);
        return new ResponseEntity<>(manometer, HttpStatus.OK);
    }

    @DeleteMapping (path = "/{id}")
    public ResponseEntity<Manometer> deleteManometer (@PathVariable int id) throws ManomEx {
        Manometer manometer = manometerService.searchManometer(id);
        if (manometer == null) {
            throw new ManomEx();
        }
        manometerService.deleteManometer(manometer);
        return new ResponseEntity<>(manometer, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Manometer> searchManometer (@PathVariable int id)  throws ManomEx {
        Manometer manometer = manometerService.searchManometer(id);
        if (manometer == null) {
            throw new ManomEx();
        }
        return new ResponseEntity<>(manometer, HttpStatus.OK);
    }

    @PostMapping (path = "/{id}")
    public ResponseEntity<Manometer> editManometer (@PathVariable int id, String specification) throws ManomEx {
        Manometer manometer = manometerService.searchManometer(id);
        if (manometer == null) {
            throw new ManomEx();
        }
        manometerService.editManometer(manometer, specification);
        return new ResponseEntity<>(manometer, HttpStatus.OK);
    }

}
