package com.onnovacion.banco.controller;

import com.onnovacion.banco.entity.PersonaNatural;
import com.onnovacion.banco.service.PersonaNaturalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personaNatural")
public class PersonaNaturalController {

    final PersonaNaturalService personaNaturalService;

    @Autowired
    public PersonaNaturalController(PersonaNaturalService personaNaturalService){
        this.personaNaturalService = personaNaturalService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable(value = "id") int id) {
        PersonaNatural personaNatural = personaNaturalService.getPersonaNaturalById(id);
        return new ResponseEntity<>(personaNatural, HttpStatus.OK);
    }

    @GetMapping("/personasNaturales")
    public ResponseEntity<?> getAll() {
        List<PersonaNatural> list = personaNaturalService.getALl();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> save(@RequestBody PersonaNatural personaNatural) {
        personaNaturalService.save(personaNatural);
        return new ResponseEntity<>("creado", HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable(value = "id") int id, @RequestBody PersonaNatural personaNatural){
        personaNaturalService.update(id, personaNatural);
        return new ResponseEntity<>("updated", HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete (@PathVariable(value = "id") int id){
        personaNaturalService.delete(id);
        return new ResponseEntity<>("deleted", HttpStatus.OK);
    }
}