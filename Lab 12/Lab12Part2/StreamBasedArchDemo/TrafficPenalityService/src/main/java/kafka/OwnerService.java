package kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OwnerService {
    @Autowired
    Sender sender;

    private String name="Frank Brown";
    private String address = "1000 N, 4th Street";
    private int counter=1;

    public void findOwner(String licencePlate, int speed) {
        Owner owner = new Owner(name+counter, address+counter);
        counter++;
        FeeRecord feeRecord= new FeeRecord(licencePlate,owner.getName(), owner.getAddress(),speed);
        sender.send(feeRecord);
    }

}

