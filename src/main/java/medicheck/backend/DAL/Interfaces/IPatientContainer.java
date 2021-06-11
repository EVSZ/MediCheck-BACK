package medicheck.backend.DAL.Interfaces;

import medicheck.backend.DTO.PatientDTO;

import java.util.List;

public interface IPatientContainer
{
    public PatientDTO GetInlogPatient(String Username, String Password);
    public PatientDTO GetPatient(long PatientID);
    void UpdatePatient(PatientDTO patientDTO);
}
