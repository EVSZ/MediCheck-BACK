package medicheck.backend.DAL;

import medicheck.backend.DAL.DataModels.PatientDataModel;
import medicheck.backend.DAL.Interfaces.IAuthentication;
import medicheck.backend.DAL.Interfaces.IPatientContainer;
import medicheck.backend.DAL.Interfaces.IPatient;
import medicheck.backend.DAL.Repos.PatientRepo;
import medicheck.backend.DTO.AccountDTO;
import medicheck.backend.DTO.PatientDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PatientDAL implements IPatientContainer, IPatient, IAuthentication
{

    PatientRepo repo;
    @Autowired
    public PatientDAL(PatientRepo repo)
    {
        this.repo = repo;
    }

    public PatientDTO GetInlogPatient(String Username, String Password)
    {
        return new PatientDTO(repo.FindByUsernameAndPassword(Username,Password));
    }

    public PatientDTO GetPatient(long patientID)
    {
        return new PatientDTO(repo.findById(patientID));
    }

    public void SavePatient(PatientDTO patientDTO)
    {
        repo.save(new PatientDataModel(patientDTO));
    }

    public void RegisterPatient(AccountDTO patientDTO)
    {
        repo.save(new PatientDataModel(patientDTO));
    }

    public void DeletePatient(PatientDTO patientDTO)
    {
        repo.delete(new PatientDataModel(patientDTO));
    }
}
