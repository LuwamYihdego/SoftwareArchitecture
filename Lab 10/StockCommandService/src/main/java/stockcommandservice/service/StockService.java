package stockcommandservice.service;

import stockcommandservice.model.Stock;

public interface StockService {
    public Stock addStock(Stock stock);
    public Stock updateStock(String stockNumber, Stock stock);
    public void deleteStock(String stockNumber);
}
