package medicheck.backend.Prescription;

import medicheck.backend.medicine.Medicine;

public class Prescription {
    private Medicine medcine;
    private int doses;
    private int receptId;

    public Medicine getMedcine() {
        return medcine;
    }

    public void setMedcine(Medicine medcine) {
        this.medcine = medcine;
    }

    public int getDoses() {
        return doses;
    }

    public void setDoses(int doses) {
        this.doses = doses;
    }

    public int getReceptId() {
        return receptId;
    }

    public void setReceptId(int receptId) {
        this.receptId = receptId;
    }

    public Prescription(Medicine medcine, int doses) {
        this.medcine = medcine;
        this.doses = doses;
    }
}
