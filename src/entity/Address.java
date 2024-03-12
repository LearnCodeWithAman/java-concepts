package entity;

public class Address {

    private String area;
    private String city;
    private String state;
    private int pincode;

    public Address(String area, String city, String state, int pincode) {
        this.area = area;
        this.city = city;
        this.state = state;
        this.pincode = pincode;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getPincode() {
        return pincode;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }
}
