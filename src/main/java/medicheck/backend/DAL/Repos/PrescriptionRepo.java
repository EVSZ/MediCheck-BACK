package medicheck.backend.DAL.Repos;

import medicheck.backend.DAL.DataModels.PrescriptionDataModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrescriptionRepo extends JpaRepository<PrescriptionDataModel, Long> { }
