package Service;

import Entity.PatientVital;
import java.util.List;
import java.util.Optional;
 
public interface PatientVitalService {
    List<PatientVital> getAllVitals();
    Optional<PatientVital> getVitalById(Long id);
    PatientVital createVital(PatientVital patientVital);
    PatientVital updateVital(Long id, PatientVital patientVital);
    void deleteVital(Long id);
}
