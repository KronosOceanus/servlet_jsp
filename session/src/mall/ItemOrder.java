package mall;

/**
 * 购物车中单个商品信息清单
 */
public class ItemOrder {

    //商品，商品数量
    private CatalogItem item;
    private int numItems;

    public ItemOrder(CatalogItem item){
        setItem(item);
        //初始数量为 1
        setNumItems(1);
    }
    //通过购物清单也能获得商品的各种信息（间接调用）
    public String getItemID(){
        return getItem().getItemID();
    }

    public String getShortDescription(){
        return getItem().getShortDescription();
    }

    public String getLongDescription(){
        return getItem().getLongDescription();
    }
    //商品单价
    public double getUnitCost(){
        return getItem().getCost();
    }
    //再次添加物品，数量自动 + 1
    public void incrementNumItems(){
        setNumItems(getNumItems() + 1);
    }
    //清空购物清单
    public void cancelOrder(){
        setNumItems(0);
    }
    //得到总消费
    public double getTotalCost(){
        return getNumItems() * getUnitCost();
    }

    //getter和setter方法
    public CatalogItem getItem() {
        return item;
    }

    public void setItem(CatalogItem item) {
        this.item = item;
    }

    public int getNumItems() {
        return numItems;
    }

    public void setNumItems(int numItems) {
        this.numItems = numItems;
    }
}
