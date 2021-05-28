package medicheck.backend.Logic.Services.Login;

import medicheck.backend.APIs.RequestModels.LoginInfo;
import medicheck.backend.DAL.DALClasses.TestDALDennisOomen;
import medicheck.backend.DAL.DataModels.PatientDataModel;
import medicheck.backend.DAL.PatientDAL;
import medicheck.backend.DTO.AccountDTO;
import medicheck.backend.Interfaces.ITestDALDennisOomen;
import medicheck.backend.Logic.Models.patient.Patient;
import org.springframework.stereotype.Component;

@Component
public class LoginService {
    private PatientDAL dal = new PatientDAL();

    public Patient logIn(LoginInfo info){
        //wordt veranderd zodra er een DAL is voor users
        try{
            return new Patient(dal.GetInlogPatient(info.getUsername(), info.getPassword()));
        }
        catch(Exception ex){
            return null;
        }

    }
}
