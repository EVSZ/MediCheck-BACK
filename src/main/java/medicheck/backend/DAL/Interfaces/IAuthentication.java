package medicheck.backend.DAL.Interfaces;

import medicheck.backend.DTO.AccountDTO;

public interface IAuthentication
{
    void RegisterPatient(AccountDTO patientDTO);
}
