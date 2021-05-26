package medicheck.backend.Logic.Services.Login;

import medicheck.backend.APIs.RequestModels.LoginInfo;
import medicheck.backend.DAL.DALClasses.TestDALDennisOomen;
import medicheck.backend.DAL.DataModels.PatientDataModel;
import medicheck.backend.DAL.PatientDAL;
import medicheck.backend.DTO.AccountDTO;
import medicheck.backend.Interfaces.ITestDALDennisOomen;
import org.springframework.stereotype.Component;

@Component
public class LoginService {
    private PatientDAL dal = new PatientDAL();

    public PatientDataModel logIn(LoginInfo info){
        //wordt veranderd zodra er een DAL is voor users
        try{
            return new PatientDataModel(dal.GetInlogPatient(info.getUsername(), info.getPassword()));
        }
        catch(Exception ex){
            return null;
        }

    }
}
