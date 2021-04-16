package medicheck.backend.APIs;

import medicheck.backend.Algoritmiek.AdviceGenerator;
import medicheck.backend.patient.PatientModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("algorithm")
public class AlgorithmAPI {

    @Autowired
    public AlgorithmAPI() {}

    @GetMapping("/getAdvice")
    public String GetAdvise(@RequestBody PatientModel patient)
    {
        AdviceGenerator adviceGenerator = new AdviceGenerator();

        return adviceGenerator.GetAdvice(patient);
    }

}
