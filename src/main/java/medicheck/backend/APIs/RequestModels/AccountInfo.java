package medicheck.backend.APIs.RequestModels;

import lombok.Getter;
import lombok.Setter;

@Getter
public class AccountInfo {
    private String username;
    private String password;
    private String email;

    public AccountInfo(String _username, String _password, String _email) {
        username = _username;
        password = _password;
        email = _email;
    }
}
