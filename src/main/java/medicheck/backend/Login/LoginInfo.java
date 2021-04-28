package medicheck.backend.Login;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
public class LoginInfo {
    private String username;
    private String password;

    public LoginInfo(String _username, String _password){
        username = _username;
        password = _password;
    }

}
