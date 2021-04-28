package medicheck.backend.Login;

import org.springframework.stereotype.Component;

@Component
public class LoginService {

    public boolean logIn(LoginInfo info){
        //wordt veranderd zodra er een DAL is voor users
        String username = "test";
        String password = "testpassword";
        if(info.getUsername().equals(username) && info.getPassword().equals(password)){
            return true;
        }
        else{
            return false;
        }
    }
}
