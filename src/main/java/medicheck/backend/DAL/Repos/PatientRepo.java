package medicheck.backend.DAL.Repos;

import medicheck.backend.DAL.DataModels.PatientDataModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepo extends JpaRepository<PatientDataModel, Long>
{
    PatientDataModel FindByUsernameAndPassword(String Username, String Password);
}
