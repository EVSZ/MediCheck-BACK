package medicheck.backend.APIs;

import medicheck.backend.Login.LoginInfo;
import medicheck.backend.Login.LoginService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/Login")
@CrossOrigin
public class LoginAPI {
    private final LoginService loginService;

    public LoginAPI(LoginService _loginService){
        loginService = _loginService;
    }

    @PostMapping(value="/post/loginInfo", consumes = "application/json", produces = "application/json")
    public boolean Login(@RequestBody LoginInfo info){
        return loginService.logIn(info);
    }
}
