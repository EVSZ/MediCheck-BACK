package medicheck.backend.Logic.Services.Registration;

import medicheck.backend.APIs.RequestModels.AccountInfo;
import medicheck.backend.DAL.Interfaces.IAuthentication;
import medicheck.backend.DAL.Interfaces.IPatient;
import medicheck.backend.DTO.AccountDTO;
import medicheck.backend.Interfaces.ITestDALDennisOomen;
import org.springframework.stereotype.Component;

@Component
public class RegistrationService {
    private IAuthentication dal;

    public RegistrationService(IAuthentication dal) {
        this.dal = dal;
    }

    public AccountDTO register(AccountInfo info){
        AccountDTO dto = new AccountDTO(info);
            dal.RegisterPatient(dto);
            return dto;
    }
}
