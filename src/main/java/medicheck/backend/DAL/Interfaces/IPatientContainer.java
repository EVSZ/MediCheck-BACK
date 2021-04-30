package medicheck.backend.DAL.Interfaces;

import medicheck.backend.DTO.PatientDTO;

import java.util.List;

public interface IPatientContainer
{
    public List<PatientDTO> GetAllPatient();
}
