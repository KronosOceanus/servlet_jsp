package mall;

import java.util.ArrayList;
import java.util.List;

/**
 * 购物车
 */
public class ShoppingCart {

    private ArrayList<ItemOrder> itemsOrdered;

    public ShoppingCart(){
        itemsOrdered = new ArrayList<>();
    }

    public List<ItemOrder> getItemsOrdered(){
        return itemsOrdered;
    }

    //数量 + 1（不要忘记向集合中添加商品）
    public synchronized void addItem(String itemID){
        for (ItemOrder order : itemsOrdered){
            if (order.getItemID().equals(itemID)){
                order.incrementNumItems();
                return;
            }
        }
        ItemOrder newOrder = new ItemOrder(Catalog.getItem(itemID));
        itemsOrdered.add(newOrder);
    }
    //设置购物车中商品数量
    public synchronized void setNumOrdered(String itemID, int numOrdered){
        for (ItemOrder order : itemsOrdered){
            if (order.getItemID().equals(itemID)){
                if (numOrdered <= 0){
                    itemsOrdered.remove(order);
                }else {
                    order.setNumItems(numOrdered);
                }
                return;
            }
        }
        ItemOrder newOrder = new ItemOrder(Catalog.getItem(itemID));
        itemsOrdered.add(newOrder);
    }
}
