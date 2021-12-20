package com.onnovacion.banco.service;

import com.onnovacion.banco.entity.PersonaJuridica;
import com.onnovacion.banco.repository.PersonaJuridicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@Transactional
public class PersonaJuridicaService {

    final PersonaJuridicaRepository personaJuridicaRepository;

    @Autowired
    PersonaJuridicaService(PersonaJuridicaRepository personaJuridicaRepository) {
        this.personaJuridicaRepository = personaJuridicaRepository;
    }

    public PersonaJuridica getPersonaJuridicaById(int id) {
        return personaJuridicaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "not found"));

    }

    public List<PersonaJuridica> getALl() {
        return personaJuridicaRepository.findAll();
    }

    public void save(PersonaJuridica personaJuridica){
        personaJuridicaRepository.save(personaJuridica);
    }
    public void savePersona(PersonaJuridica personaJuridica){
        PersonaJuridica newPersona = new PersonaJuridica(personaJuridica.getRazonSocial(), personaJuridica.getAño());
        save(newPersona);
    }

    public void update(int id, PersonaJuridica newPersonaJuridica) {
        PersonaJuridica personaJuridica = getPersonaJuridicaById(id);
        personaJuridica.setRazonSocial(newPersonaJuridica.getRazonSocial());
        personaJuridica.setAño(newPersonaJuridica.getAño());
        save(personaJuridica);
    }

    public void delete(int id){
        PersonaJuridica personaJuridica = getPersonaJuridicaById(id);
        personaJuridicaRepository.delete(personaJuridica);
    }
}