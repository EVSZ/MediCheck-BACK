package medicheck.backend.APIs;

import medicheck.backend.APIs.RequestModels.LoginInfo;
import medicheck.backend.APIs.RequestModels.PatientModel;
import medicheck.backend.Converters.PatientConverter;
import medicheck.backend.DAL.DataModels.PatientDataModel;
import medicheck.backend.Logic.Models.patient.Patient;
import medicheck.backend.Logic.Services.Login.LoginService;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("api/Login")
@CrossOrigin
public class LoginAPI
{
    private final LoginService loginService;
    private PatientConverter converter  = new PatientConverter();

    public LoginAPI(LoginService _loginService){
        loginService = _loginService;
    }

    @PostMapping(value="/post/loginInfo", consumes = "application/json", produces = "application/json")
    public String Login(@RequestBody LoginInfo info, HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        Patient patient = loginService.logIn(info);
        session.setAttribute("patientId", patient.getId());
        Cookie cookie = new Cookie("JSESSIONID", session.getId());
        response.addCookie(cookie);
        return "Logged in successfully";
    }


}
