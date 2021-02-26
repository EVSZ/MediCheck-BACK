package medicheck.backend.medicine;

import java.time.LocalDate;
import java.util.List;

public class Medicine {
    private Integer id;
    private Integer amount;
    private String naam;
    private MedicineType medicineType;
    private List<Bijwerkingen> bijwerkingenList;
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

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public MedicineType getMedicineType() {
        return medicineType;
    }

    public void setMedicineType(MedicineType medicineType) {
        this.medicineType = medicineType;
    }

    public List<Bijwerkingen> getBijwerkingenList() {
        return bijwerkingenList;
    }

    public void setBijwerkingenList(List<Bijwerkingen> bijwerkingenList) {
        this.bijwerkingenList = bijwerkingenList;
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

    public Medicine(Integer id, Integer amount, String naam, MedicineType medicineType, List<Bijwerkingen> bijwerkingenList,
                    Integer doses, LocalDate timePeriod) {
        this.id = id;
        this.amount = amount;
        this.naam = naam;
        this.medicineType = medicineType;
        this.bijwerkingenList = bijwerkingenList;
        this.doses = doses;
        this.timePeriod = timePeriod;
    }

    public Medicine(Integer amount, String naam, MedicineType medicineType, List<Bijwerkingen> bijwerkingenList, Integer doses,
                    LocalDate timePeriod) {
        this.amount = amount;
        this.naam = naam;
        this.medicineType = medicineType;
        this.bijwerkingenList = bijwerkingenList;
        this.doses = doses;
        this.timePeriod = timePeriod;
    }
}
