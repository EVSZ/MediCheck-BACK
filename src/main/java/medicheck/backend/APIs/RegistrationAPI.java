package medicheck.backend.APIs;

import medicheck.backend.APIs.RequestModels.AccountInfo;
import medicheck.backend.DTO.AccountDTO;
import medicheck.backend.Logic.Services.Registration.RegistrationService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/register")
@CrossOrigin
public class RegistrationAPI
{
    private RegistrationService registrationService;

    public RegistrationAPI(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @PostMapping(value="/post/accountInfo", consumes = "application/json", produces = "application/json")
    public long register(@RequestBody AccountInfo info)
    {
        return registrationService.register(info).getId();
    }
}
