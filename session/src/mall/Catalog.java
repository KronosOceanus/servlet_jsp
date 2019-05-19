package session;

/**
 * 储存列表项（商品）的数组
 * 提供根据ID查找列表项（商品）的方法
 */
public class Catalog {

    private static CatalogItem[] items = {};

    //根据ID查找列表项（商品）
    public static CatalogItem getItem(String itemID){
        if (itemID == null){
            return null;
        }
        for (CatalogItem c : items){
            if (itemID.equals(c.getItemID())){
                return c;
            }
        }
        return null;
    }
}
