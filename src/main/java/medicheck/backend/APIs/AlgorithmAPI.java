package medicheck.backend.APIs;


import medicheck.backend.Algoritmiek.TestRule;
import medicheck.backend.medicine.Medicine;
import medicheck.backend.medicine.MedicineModel;
import org.springframework.web.bind.annotation.*;

import medicheck.backend.Algoritmiek.AdviceGenerator;
import medicheck.backend.patient.PatientModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("algorithm")
public class AlgorithmAPI {


    @GetMapping("/execute")
    public String executeAlgorithm(){
        TestRule test = new TestRule();
        if (test.Test())
        {
            return "Test passed";
        };
        return "Test kapot";
    }
    @GetMapping("test")
    public String testalgo(){
        AdviceGenerator adviceGenerator = new AdviceGenerator();
        return adviceGenerator.TestAdvice();
    }


    @Autowired
    public AlgorithmAPI() {}

    @GetMapping("/getAdvice")
    public String GetAdvise(@RequestBody PatientModel patient)
    {
        AdviceGenerator adviceGenerator = new AdviceGenerator();

        return adviceGenerator.GetAdvice(patient);
    }

}
