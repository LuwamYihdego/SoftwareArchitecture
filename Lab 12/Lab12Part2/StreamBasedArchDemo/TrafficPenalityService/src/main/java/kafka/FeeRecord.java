package kafka;

public class FeeRecord {
    private String licencePlate;
    private String ownerName;
    private String ownerAddress;
    private int speed;

    public FeeRecord() {
        super();
    }

    public FeeRecord(String licencePlate, String ownerName, String ownerAddress, int speed) {
        super();
        this.licencePlate = licencePlate;
        this.ownerName = ownerName;
        this.ownerAddress = ownerAddress;
        this.speed = speed;
    }

    public String getLicencePlate() {
        return licencePlate;
    }

    public void setLicencePlate(String licencePlate) {
        this.licencePlate = licencePlate;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerAddress() {
        return ownerAddress;
    }

    public void setOwnerAddress(String ownerAddress) {
        this.ownerAddress = ownerAddress;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

}

