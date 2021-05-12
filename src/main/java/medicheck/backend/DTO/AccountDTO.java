package medicheck.backend.DTO;

import lombok.Getter;
import medicheck.backend.APIs.RequestModels.AccountInfo;
import medicheck.backend.Logic.Models.patient.Patient;

@Getter
public class AccountDTO {
    private String username;
    private String password;
    private String email;

    public AccountDTO(AccountInfo info){
        username = info.getUsername();
        password = info.getPassword();
        email = info.getEmail();
    }

    public AccountDTO(Patient patient){
        username = patient.getUsername();
        password = patient.getPassword();
        email = patient.getEmailAddress();
    }
}
