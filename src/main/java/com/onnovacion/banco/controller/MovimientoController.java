package com.onnovacion.banco.controller;

import com.onnovacion.banco.entity.Movimiento;
import com.onnovacion.banco.service.MovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movimiento")
public class MovimientoController {

    final MovimientoService movimientoService;

    @Autowired
    public MovimientoController(MovimientoService movimientoService){
        this.movimientoService = movimientoService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable(value = "id") int id) {
        Movimiento movimiento = movimientoService.getMovimientoById(id);
        return new ResponseEntity<>(movimiento, HttpStatus.OK);
    }

    @GetMapping("/movimientos")
    public ResponseEntity<?> getAll() {
        List<Movimiento> list = movimientoService.getALl();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> save(@RequestBody Movimiento movimiento) {
        return new ResponseEntity<>(movimientoService.save(movimiento), HttpStatus.OK);
    }
}

