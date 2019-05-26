package higher;

/**
 * 处理成员变量不是String的bean
 */
public class SaleEntry {

    private String itemID = "unknown";
    private double discountCode = 1.0;
    private int numItems = 0;
    //得到多件某种商品的花费
    public double getItemCost(){
        double cost;
        if (itemID.equals("a1234")){
            cost = 12.99 * getDiscountCode();
        }else {
            cost = - 9999;
        }
        return roundToPennies(cost);
    }
    //取整
    private double roundToPennies(double cost){
        return Math.floor(cost * 100) / 100.0;
    }
    //得到总花费
    public double getTotalCost(){
        return getItemCost() * getNumItems();
    }



    public String getItemID() {
        return itemID;
    }

    public void setItemID(String itemID) {
        if (itemID != null){
            this.itemID = itemID;
        }else {
            this.itemID = "unknown";
        }
    }

    public double getDiscountCode() {
        return discountCode;
    }

    public void setDiscountCode(double discountCode) {
        this.discountCode = discountCode;
    }

    public int getNumItems() {
        return numItems;
    }

    public void setNumItems(int numItems) {
        this.numItems = numItems;
    }
}
