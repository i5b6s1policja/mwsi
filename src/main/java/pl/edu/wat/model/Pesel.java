package pl.edu.wat.model;

public class Pesel {
    private String pesel;

    public Pesel(String pesel) {
            this.pesel = pesel;
    }

    public Pesel() {
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }
}
