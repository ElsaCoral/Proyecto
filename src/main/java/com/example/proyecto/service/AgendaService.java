package com.example.proyecto.service;
import com.example.proyecto.model.Persona;
import com.example.proyecto.persistence.AgendaMemoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Set;
@Service
public class AgendaService {
    private final ValidadorTelefono validadorTelefono;
    private final AgendaMemoryDao agendaDao;
    @Autowired
    public AgendaService(ValidadorTelefono validadorTelefono, AgendaMemoryDao agendaDao) {
        this.validadorTelefono = validadorTelefono;
        this.agendaDao = agendaDao;
    }
    public Persona guardaPersona(Persona persona) {
        String telefono = validadorTelefono.limpiaNumero(persona.getTelefono());
        persona.setTelefono(telefono);
        return agendaDao.guardaPersona(persona);
    }
    public Set<Persona> getPersonas() {
        return agendaDao.getPersonas();
    }
}