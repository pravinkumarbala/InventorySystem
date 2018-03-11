package com.setmore.root.SubSystem.StockDetails;

public class StockDetailsTemplate {
    public int stockId;
    public String stockName;
    public int stockPrice;
    public int stockUnit;
    public String stockPurchaseDate;

    public StockDetailsTemplate(int stockId, String stockName, int stockPrice, int stockUnit, String stockPurchaseDate) {
        this.stockId = stockId;
        this.stockName = stockName;
        this.stockPrice = stockPrice;
        this.stockUnit = stockUnit;
        this.stockPurchaseDate = stockPurchaseDate;
    }
}
