package medicheck.backend.APIs;

import medicheck.backend.APIs.RequestModels.LoginInfo;
import medicheck.backend.DAL.DataModels.PatientDataModel;
import medicheck.backend.Logic.Services.Login.LoginService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/Login")
@CrossOrigin
public class LoginAPI
{
    private final LoginService loginService;

    public LoginAPI(LoginService _loginService){
        loginService = _loginService;
    }

    @PostMapping(value="/post/loginInfo", consumes = "application/json", produces = "application/json")
    public PatientDataModel Login(@RequestBody LoginInfo info){
        return loginService.logIn(info);
    }
}
