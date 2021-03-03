package medicheck.backend.Patiënt;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class PatiëntContainer {

    private List<Patiënt> patiënten = new ArrayList<>();

    public PatiëntContainer() {
    }

    public Patiënt GetPatiëntByNaam(String naam){
        for (Patiënt patiënt:
             patiënten) {
            if(patiënt.getNaam() == naam) return patiënt;
        }
        throw new ArithmeticException("De patiënt is niet gevonden!");
    }

    public Patiënt GetPatiëntByID(Integer id){
        for (Patiënt patiënt:
             patiënten) {
            if(patiënt.getId() == id) return patiënt;
        }
        throw new ArithmeticException("De patiënt is niet gevonden!");
    }

    public void SavePatiënt(Patiënt patiënt){
        patiënten.add(patiënt);
    }

    public void AddPatiënt(PatiëntDTO patiëntDTO){
        Patiënt patiënt = new Patiënt(patiëntDTO);
        patiënten.add(patiënt);
    }

    public List<PatiëntDTO> GetPatiënten(){
        List<PatiëntDTO> uitvoer = new ArrayList<>();
        for (Patiënt patiënt:
             patiënten) {
            PatiëntDTO temp = new PatiëntDTO(patiënt);
            uitvoer.add(temp);
        }
        return uitvoer;
    }
}
