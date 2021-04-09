package medicheck.backend.Repos;

import medicheck.backend.DataModels.MedicineDataModel;
import medicheck.backend.DataModels.PrescriptionDataModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicineRepo extends JpaRepository<MedicineDataModel, Long> { }
