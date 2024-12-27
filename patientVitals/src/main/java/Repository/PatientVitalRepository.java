package Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import Entity.PatientVital;

public interface PatientVitalRepository extends JpaRepository<PatientVital, Long> {
}