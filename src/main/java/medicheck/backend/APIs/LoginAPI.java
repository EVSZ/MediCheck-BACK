package medicheck.backend.APIs;

import medicheck.backend.APIs.RequestModels.LoginInfo;
import medicheck.backend.APIs.RequestModels.AccessData;
import medicheck.backend.Converters.PatientConverter;
import medicheck.backend.Logic.Models.patient.Patient;
import medicheck.backend.Logic.Services.Login.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/Login")
@Scope(value = "session")
public class LoginAPI
{
    @Autowired
    private AccessData accessData;

    @ModelAttribute("accessData")
    public AccessData getAccessData() {
        return this.accessData;
    }


    private final LoginService loginService;
    private PatientConverter converter  = new PatientConverter();

    public LoginAPI(LoginService _loginService, AccessData accessdat){
        loginService = _loginService;
        this.accessData = accessdat;
    }

    @PostMapping(value="/post/loginInfo", consumes = "application/json", produces = "application/json")
    public String Login(@RequestBody LoginInfo info){
//        HttpSession session = request.getSession();
        Patient patient = loginService.logIn(info);
        AccessData sessionData2 = new AccessData();
        sessionData2.setUserID(patient.getId());
        //session.setAttribute("patientId", patient.getId());
        CopyProperties(accessData,sessionData2);
//        Cookie cookie = new Cookie("JSESSIONID", session.getId());
//        response.addCookie(cookie);
        return "Logged in successfully";
    }

    public void CopyProperties(AccessData data1, AccessData data2 ){
        data1.setUserID(data2.getUserID());
    }


}
