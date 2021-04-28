package medicheck.backend.APIs.RequestModels;

import lombok.Getter;

@Getter
public class LoginInfo {
    private String username;
    private String password;

    public LoginInfo(String _username, String _password){
        username = _username;
        password = _password;
    }

}
