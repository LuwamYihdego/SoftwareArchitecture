package nextdayshippingservice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NextDayShippingController {

    @PostMapping("/orders")
    public ResponseEntity<?> receiveOrder(@RequestBody Order order) {
        System.out.println("Next day shipping application receiving order: "+order);
        return new ResponseEntity<Order>(order, HttpStatus.OK);
    }
}
