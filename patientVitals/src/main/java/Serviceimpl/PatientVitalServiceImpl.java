package Serviceimpl;

import Entity.PatientVital;
import Repository.PatientVitalRepository;
import Service.PatientVitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientVitalServiceImpl implements PatientVitalService {

    @Autowired
    private PatientVitalRepository repository;

    @Override
    public List<PatientVital> getAllVitals() {
        return repository.findAll();
    }

    @Override
    public Optional<PatientVital> getVitalById(Long id) {
        return repository.findById(id);
    }

    @Override
    public PatientVital createVital(PatientVital patientVital) {
        return repository.save(patientVital);
    }

    @Override
    public PatientVital updateVital(Long id, PatientVital patientVital) {
        if (repository.existsById(id)) {
            patientVital.setId(id);
            return repository.save(patientVital);
        }
        throw new RuntimeException("Vital not found with id: " + id);
    }

    @Override
    public void deleteVital(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new RuntimeException("Vital not found with id: " + id);
        }
    }
}
