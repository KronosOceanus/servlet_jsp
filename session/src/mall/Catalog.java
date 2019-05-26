package mall;

/**
 * 商品目录
 * 储存商品的数组
 * 提供根据ID查找商品的方法
 */
public class Catalog {

    private static CatalogItem[] items = {
            new CatalogItem("id_1","shortDescription_1",
            "longDescription_1",1),
            new CatalogItem("id_2","shortDescription_2",
                    "longDescription_2",2),
            new CatalogItem("id_3","shortDescription_3",
                    "longDescription_3",3),
            new CatalogItem("id_4","shortDescription_4",
                    "longDescription_4",4),
            new CatalogItem("id_5","shortDescription_5",
                    "longDescription_5",5),
            new CatalogItem("id_6","shortDescription_6",
                    "longDescription_6",6),
            new CatalogItem("id_7","shortDescription_7",
                    "longDescription_7",7),
            new CatalogItem("id_8","shortDescription_8",
                    "longDescription_8",8),
    };

    //根据ID查找商品
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
