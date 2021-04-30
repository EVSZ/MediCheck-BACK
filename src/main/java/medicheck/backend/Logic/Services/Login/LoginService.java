package medicheck.backend.Logic.Services.Login;

import medicheck.backend.APIs.RequestModels.LoginInfo;
import medicheck.backend.DAL.DALClasses.TestDALDennisOomen;
import medicheck.backend.DTO.AccountDTO;
import medicheck.backend.Interfaces.ITestDALDennisOomen;
import org.springframework.stereotype.Component;

@Component
public class LoginService {
    private ITestDALDennisOomen dal;

    public LoginService(ITestDALDennisOomen dal) {
        this.dal = dal;
    }

    public boolean logIn(LoginInfo info){
        //wordt veranderd zodra er een DAL is voor users
        try{
            AccountDTO account = dal.getAccountInfoByName(info.getUsername());
            if(info.getPassword().equals(account.getPassword())){
                return true;
            }
            else{
                return false;
            }
        }
        catch(Exception ex){
            return false;
        }

    }
}
