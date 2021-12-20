package com.onnovacion.banco.service;

import com.onnovacion.banco.entity.Cuenta;
import com.onnovacion.banco.entity.Movimiento;
import com.onnovacion.banco.repository.MovimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@Transactional
public class MovimientoService {

    final MovimientoRepository movimientoRepository;

    @Autowired
    MovimientoService(MovimientoRepository movimientoRepository) {
        this.movimientoRepository = movimientoRepository;
    }

    public Movimiento getMovimientoById(int id) {
        return movimientoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "not found"));

    }

    public List<Movimiento> getALl() {
        return movimientoRepository.findAll();
    }

    public String save(Movimiento movimiento){
        String respuesta = "";
        String error = "";
        movimientoRepository.saveMovimiento(movimiento.getValor(), movimiento.getCuenta().getId(), respuesta, error);
        return respuesta + error;
    }

}
