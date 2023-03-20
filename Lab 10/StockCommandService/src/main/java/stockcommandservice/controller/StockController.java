package stockcommandservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import stockcommandservice.model.Stock;
import stockcommandservice.service.StockService;

@RestController
@RequestMapping("/stocks")
public class StockController {

    @Autowired
    private StockService stockService;

    @PostMapping("")
    public ResponseEntity<Stock> addStock(@RequestBody Stock stock){
        stockService.addStock(stock);
        return new ResponseEntity<>(stock, HttpStatus.OK);
    }

    @PutMapping("/{stockNumber}")
    public ResponseEntity<Stock> updateStock(@PathVariable String stockNumber, @RequestBody Stock stock){
        stockService.updateStock(stockNumber, stock);
        return new ResponseEntity<>(stock, HttpStatus.OK);
    }

    @DeleteMapping("/{stockNumber}")
    public ResponseEntity<Stock> deleteStock(@PathVariable String stockNumber){
        stockService.deleteStock(stockNumber);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
