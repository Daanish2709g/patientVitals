package Controller;
  
import Entity.PatientVital;
import Service.PatientVitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
 
import java.util.List;

@RestController
@RequestMapping("/api/vitals")
public class PatientVitalController {

    @Autowired
    private PatientVitalService service;

    @GetMapping
    public ResponseEntity<List<PatientVital>> getAllVitals() {
        return ResponseEntity.ok(service.getAllVitals());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientVital> getVitalById(@PathVariable Long id) {
        return service.getVitalById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<PatientVital> createVital(@RequestBody PatientVital patientVital) {
        return new ResponseEntity<>(service.createVital(patientVital), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PatientVital> updateVital(@PathVariable Long id, @RequestBody PatientVital patientVital) {
        try {
            return ResponseEntity.ok(service.updateVital(id, patientVital));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVital(@PathVariable Long id) {
        try {
            service.deleteVital(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
