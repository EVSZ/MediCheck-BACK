package medicheck.backend.DAL.Interfaces;

import medicheck.backend.DTO.AccountDTO;
import medicheck.backend.DTO.PatientDTO;

public interface IPatient
{
    void SavePatient(PatientDTO patientDTO);
    void DeletePatient(PatientDTO patientDTO);
}
