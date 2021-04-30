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

    public List<PatientDTO> GetAllPatient()
    {
        List<PatientDataModel> patientDataModels = repo.findAll();
        List<PatientDTO> PatientsDTO = new ArrayList<PatientDTO>();
        for (PatientDataModel patient: patientDataModels)
        {
            PatientsDTO.add(new PatientDTO(patient));
        }
        return PatientsDTO;
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
