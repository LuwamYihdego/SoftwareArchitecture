package kafka;

public class Owner {
    private String name;
    private String address;

    public Owner() {
        super();
    }

    public Owner(String name, String address) {
        super();
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
