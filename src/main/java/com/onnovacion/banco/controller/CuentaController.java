package com.onnovacion.banco.controller;

import com.onnovacion.banco.entity.Cuenta;
import com.onnovacion.banco.service.CuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cuenta")
public class CuentaController {

    final CuentaService cuentaService;

    @Autowired
    public CuentaController(CuentaService cuentaService){
        this.cuentaService = cuentaService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable(value = "id") int id) {
        Cuenta personaNatural = cuentaService.getCuentaById(id);
        return new ResponseEntity<>(personaNatural, HttpStatus.OK);
    }

    @GetMapping("/cuentas")
    public ResponseEntity<?> getAll() {
        List<Cuenta> list = cuentaService.getALl();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> save(@RequestBody Cuenta cuenta) {
        cuentaService.saveCuenta(cuenta);
        return new ResponseEntity<>("creado", HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable(value = "id") int id, @RequestBody Cuenta cuenta){
        cuentaService.update(id, cuenta);
        return new ResponseEntity<>("updated", HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete (@PathVariable(value = "id") int id){
        cuentaService.delete(id);
        return new ResponseEntity<>("deleted", HttpStatus.OK);
    }
}

