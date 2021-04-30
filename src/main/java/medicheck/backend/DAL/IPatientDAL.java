package medicheck.backend.DAL;

import medicheck.backend.DAL.DataModels.PatientDataModel;
import medicheck.backend.DAL.Interfaces.IPatientContainer;
import medicheck.backend.DAL.Interfaces.IPatient;
import medicheck.backend.DAL.Repos.PatientRepo;
import medicheck.backend.DTO.PatientDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class IPatientDAL implements IPatientContainer, IPatient
{
    PatientRepo repo;

    public IPatientDAL(PatientRepo Repo)
    {
        repo = Repo;
    }

    public PatientDTO GetInlogPatient(String Username, String Password)
    {
        return new PatientDTO(repo.FindByUsernameAndPassword(Username,Password));
    }
    public void SavePatient(PatientDTO patientDTO)
    {
        repo.save(new PatientDataModel(patientDTO));
    }
    public void DeletePatient(PatientDTO patientDTO)
    {
        repo.delete(new PatientDataModel(patientDTO));
    }
}
