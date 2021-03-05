package medicheck.backend.APIs;

import medicheck.backend.Patiënt.Patiënt;
import medicheck.backend.Patiënt.PatiëntContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import medicheck.backend.patiënt.PatiëntModel;
import medicheck.backend.patiënt.PatiëntDTO;

import java.util.List;


@RestController
@RequestMapping("api/patiënten")
public class PatiëntController {

    private PatiëntContainer patiënten;

    @Autowired
    public PatiëntController(PatiëntContainer container){
        this.patiënten = container;
    }

    @PostMapping(value= "/post", consumes = "application/json")
    public void AddPatiënt(@RequestBody PatiëntModel patiënt){
        patiënten.SavePatiënt(new Patiënt(patiënt));
    }
    /*public void AddPatiënt(Integer id){
        patiënten.SavePatiënt(new Patiënt(id));
    }*/

    @GetMapping("/get")
    public List<Patiënt> GetPatiënt(){
        return patiënten.GetPatiënten();
    }
    /*@GetMapping("/get")
    public Patiënt GetPatiënt(){
        LocalDate date = LocalDate.of(2001,6,11);
        return new Patiënt(1, "Daan", 10.00, 10.00, false, date, Gender.Male);
    }*/
}
