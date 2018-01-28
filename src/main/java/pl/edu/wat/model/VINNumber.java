package pl.edu.wat.model;

public class VINNumber {
    private String vin;

    public VINNumber() {

    }

    public VINNumber(String vin){
        this.vin = vin;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }
}
