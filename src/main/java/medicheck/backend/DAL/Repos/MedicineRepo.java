package medicheck.backend.DAL.Repos;

import medicheck.backend.DAL.DataModels.MedicineDataModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicineRepo extends JpaRepository<MedicineDataModel, Long> { }
