package medicheck.backend.Recept;
import java.util.ArrayList;
import java.util.List;
public class ReceptContainer {
    List<Recept> recepten = new ArrayList<>();

    public Recept GetReceptbyId(int id){
        for (Recept recept:
             recepten) {
            if(recept.getReceptId() == id) return recept;
        }
        throw new ArithmeticException("Recept niet gevonden!");
    }

    public List<Recept> GetRecepten(){
        return recepten;
    }
}
