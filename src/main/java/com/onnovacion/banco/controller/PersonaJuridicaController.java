package com.onnovacion.banco.controller;

import com.onnovacion.banco.entity.PersonaJuridica;
import com.onnovacion.banco.service.PersonaJuridicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personaJuridica")
public class PersonaJuridicaController {

    final PersonaJuridicaService personaJuridicaService;

    @Autowired
    public PersonaJuridicaController(PersonaJuridicaService personaJuridicaService){
        this.personaJuridicaService = personaJuridicaService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable(value = "id") int id) {
        PersonaJuridica personaJuridica = personaJuridicaService.getPersonaJuridicaById(id);
        return new ResponseEntity<>(personaJuridica, HttpStatus.OK);
    }

    @GetMapping("/personasJuridicas")
    public ResponseEntity<?> getAll() {
        List<PersonaJuridica> list = personaJuridicaService.getALl();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> save(@RequestBody PersonaJuridica personaJuridica) {
        personaJuridicaService.save(personaJuridica);
        return new ResponseEntity<>("creado", HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable(value = "id") int id, @RequestBody PersonaJuridica personaJuridica){
        personaJuridicaService.update(id, personaJuridica);
        return new ResponseEntity<>("updated", HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete (@PathVariable(value = "id") int id){
        personaJuridicaService.delete(id);
        return new ResponseEntity<>("deleted", HttpStatus.OK);
    }
}