package medicheck.backend.DTO;

import lombok.Getter;
import medicheck.backend.APIs.RequestModels.AccountInfo;

@Getter
public class AccountDTO {
    private String username;
    private String password;
    private String email;

    public AccountDTO(String _username, String _password, String _email) {
        username = _username;
        password = _password;
        email = _email;
    }

    public AccountDTO(AccountInfo info){
        username = info.getUsername();
        password = info.getPassword();
        email = info.getEmail();
    }
}
