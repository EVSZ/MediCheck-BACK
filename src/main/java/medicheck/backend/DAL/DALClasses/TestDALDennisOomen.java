package medicheck.backend.DAL.DALClasses;

import medicheck.backend.APIs.RequestModels.AccountInfo;
import medicheck.backend.DAL.Repos.PatientRepo;
import medicheck.backend.DTO.AccountDTO;
import medicheck.backend.Interfaces.ITestDALDennisOomen;
import org.springframework.stereotype.Component;

@Component
public class TestDALDennisOomen implements ITestDALDennisOomen {

    public AccountDTO getAccountInfoByName(String username) throws Exception {
        AccountDTO account = new AccountDTO(new AccountInfo("test", "testpassword", "test@test.test")) ;
        if(account.getUsername().equals(username)){
            return account;
        }
        else throw new Exception();
    }

    public void register(AccountDTO account) throws Exception{

    }
    public void update(){

    }
    public void delete(){

    }
}
