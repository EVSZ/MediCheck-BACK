package medicheck.backend.Logic.Services.Registration;

import medicheck.backend.APIs.RequestModels.AccountInfo;
import medicheck.backend.DTO.AccountDTO;
import medicheck.backend.Interfaces.ITestDALDennisOomen;
import org.springframework.stereotype.Component;

@Component
public class RegistrationService {
    private ITestDALDennisOomen dal;

    public RegistrationService(ITestDALDennisOomen dal) {
        this.dal = dal;
    }

    public boolean register(AccountInfo info){
        try{
            dal.register(new AccountDTO(info));
            return true;
        }
        catch(Exception ex){
            return false;
        }
    }
}
