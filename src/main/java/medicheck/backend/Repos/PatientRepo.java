package medicheck.backend.Repos;

import medicheck.backend.DataModels.PatientDataModel;
import medicheck.backend.DataModels.PrescriptionDataModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepo extends JpaRepository<PatientDataModel, Long> { }
