package com.onnovacion.banco.service;

import com.onnovacion.banco.entity.PersonaNatural;
import com.onnovacion.banco.repository.PersonaNaturalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@Transactional
public class PersonaNaturalService {

    final PersonaNaturalRepository personaNaturalRepository;

    @Autowired
    PersonaNaturalService(PersonaNaturalRepository personaNaturalRepository) {
        this.personaNaturalRepository = personaNaturalRepository;
    }

    public PersonaNatural getPersonaNaturalById(int id) {
        return personaNaturalRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "not found"));

    }

    public List<PersonaNatural> getALl() {
        return personaNaturalRepository.findAll();
    }

    public void save(PersonaNatural personaNatural) {
        personaNaturalRepository.save(personaNatural);
    }

    public void savePersona(PersonaNatural newPersonaNatural){
        PersonaNatural personaNatural = new PersonaNatural(newPersonaNatural.getNombre(),
                newPersonaNatural.getApellido(),
                newPersonaNatural.getTipoDocumento(),
                newPersonaNatural.getIdentificacion(),
                newPersonaNatural.getRut(),
                newPersonaNatural.getPersonaJuridica());
        save(personaNatural);
    }

    public void update(int id, PersonaNatural newPersonaNatural) {
        PersonaNatural personaNatural = getPersonaNaturalById(id);
        personaNatural.setNombre(newPersonaNatural.getNombre());
        personaNatural.setApellido(newPersonaNatural.getApellido());
        personaNatural.setTipoDocumento(newPersonaNatural.getTipoDocumento());
        personaNatural.setIdentificacion(newPersonaNatural.getIdentificacion());
        personaNatural.setRut(newPersonaNatural.getRut());
        personaNatural.setPersonaJuridica(newPersonaNatural.getPersonaJuridica());
        save(personaNatural);
    }

    public void delete(int id){
        PersonaNatural personaNatural = getPersonaNaturalById(id);
        personaNaturalRepository.delete(personaNatural);
    }
}