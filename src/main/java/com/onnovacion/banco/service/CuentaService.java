package com.onnovacion.banco.service;

import com.onnovacion.banco.entity.Cuenta;
import com.onnovacion.banco.repository.CuentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@Service
@Transactional
public class CuentaService {

    final CuentaRepository cuentaRepository;

    @Autowired
    CuentaService(CuentaRepository cuentaRepository) {
        this.cuentaRepository = cuentaRepository;
    }

    public Cuenta getCuentaById(int id) {
        return cuentaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "not found"));

    }

    public List<Cuenta> getALl() {
        return cuentaRepository.findAll();
    }

    public void save(Cuenta cuenta) {
        cuentaRepository.save(cuenta);
    }

    public void saveCuenta(Cuenta newCuenta){
        Cuenta cuenta = new Cuenta(newCuenta.getNumero(),
                newCuenta.getMoneda(),
                newCuenta.getSaldo(),
                newCuenta.getPersonaNatural());
        save(cuenta);
    }

    public void update(int id, Cuenta newCuenta) {
        Cuenta cuenta = getCuentaById(id);
        cuenta.setNumero(newCuenta.getNumero());
        cuenta.setSaldo(newCuenta.getSaldo());
        cuenta.setMoneda(newCuenta.getMoneda());
        cuenta.setPersonaNatural(newCuenta.getPersonaNatural());
        save(cuenta);
    }

    public void delete(int id){
        Cuenta personaNatural = getCuentaById(id);
        cuentaRepository.delete(personaNatural);
    }
}