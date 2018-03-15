package com.setmore.root.SubSystem.StockPurchaseDetails;

public class PurchaseDetailTemplate {
    public int purchaseId;
    public String purchaseStockName;
    public int puchaseAmount;
    public String purchaseCustomerName;
    public String purchaseCustomerEmailAdress;
    public int purchaseStockUnit;

    public PurchaseDetailTemplate(int purchaseId, String purchaseStockName, int puchaseAmount, String purchaseCustomerName, String purchaseCustomerEmailAdress, int purchaseStockUnit) {
        this.purchaseId = purchaseId;
        this.purchaseStockName = purchaseStockName;
        this.puchaseAmount = puchaseAmount;
        this.purchaseCustomerName = purchaseCustomerName;
        this.purchaseCustomerEmailAdress = purchaseCustomerEmailAdress;
        this.purchaseStockUnit = purchaseStockUnit;
    }
}