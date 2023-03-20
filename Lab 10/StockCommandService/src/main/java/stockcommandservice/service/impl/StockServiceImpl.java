package stockcommandservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stockcommandservice.integration.JmsSender;
import stockcommandservice.model.Stock;
import stockcommandservice.repository.StockRepository;
import stockcommandservice.service.StockService;

@Service
public class StockServiceImpl implements StockService {

    @Autowired
    private StockRepository stockRepository;

    @Autowired
    private JmsSender jmsSender;

    @Override
    public Stock addStock(Stock stock) {
        stockRepository.save(stock);
        jmsSender.sendMessage(new StockEvent("Add stock", stock.getQuantity()));
        return stock;
    }

    @Override
    public Stock updateStock(String stockNumber, Stock stock) {
        stockRepository.save(stock);
        jmsSender.sendMessage(new StockEvent("update stock", stock.getQuantity()));
        return stock;
    }

    @Override
    public void deleteStock(String stockNumber) {
        Stock stock = stockRepository.findById(stockNumber).get();
        jmsSender.sendMessage(new StockEvent("Delete stock", stock.getQuantity()));
        stockRepository.deleteById(stockNumber);
    }
}
