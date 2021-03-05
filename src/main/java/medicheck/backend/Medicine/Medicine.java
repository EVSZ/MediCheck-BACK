package medicheck.backend.Medicine;

import java.time.LocalDate;
import java.util.List;

public class Medicine {
    private Integer id;
    private Integer amount;
    private String name;
    private MedicineType medicineType;
    private List<SideEffect> sideEffectList;
    private Integer doses;
    private LocalDate timePeriod;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MedicineType getMedicineType() {
        return medicineType;
    }

    public void setMedicineType(MedicineType medicineType) {
        this.medicineType = medicineType;
    }

    public List<SideEffect> getBijwerkingenList() {
        return sideEffectList;
    }

    public void setBijwerkingenList(List<SideEffect> sideEffectList) {
        this.sideEffectList = sideEffectList;
    }

    public Integer getDoses() {
        return doses;
    }

    public void setDoses(Integer doses) {
        this.doses = doses;
    }

    public LocalDate getTimePeriod() {
        return timePeriod;
    }

    public void setTimePeriod(LocalDate timePeriod) {
        this.timePeriod = timePeriod;
    }

    public Medicine(Integer id, Integer amount, String name, MedicineType medicineType, List<SideEffect> sideEffectList,
                    Integer doses, LocalDate timePeriod) {
        this.id = id;
        this.amount = amount;
        this.name = name;
        this.medicineType = medicineType;
        this.sideEffectList = sideEffectList;
        this.doses = doses;
        this.timePeriod = timePeriod;
    }

    public Medicine(Integer amount, String name, MedicineType medicineType, List<SideEffect> sideEffectList, Integer doses,
                    LocalDate timePeriod) {
        this.amount = amount;
        this.name = name;
        this.medicineType = medicineType;
        this.sideEffectList = sideEffectList;
        this.doses = doses;
        this.timePeriod = timePeriod;
    }
}
