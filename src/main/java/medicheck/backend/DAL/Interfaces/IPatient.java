package medicheck.backend.DAL.Interfaces;

import medicheck.backend.DTO.PatientDTO;

public interface IPatient
{
    public void SavePatient(PatientDTO patientDTO);
    public void DeletePatient(PatientDTO patientDTO);
}
