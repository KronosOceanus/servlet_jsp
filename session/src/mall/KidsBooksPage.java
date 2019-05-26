package mall;

/**
 * 该页面展示少年书籍商品
 *
 */
public class KidsBooksPage extends CatalogPage {

    public void init(){
        String[] ids = {"id_1", "id_2", "id_3","id_4"};
        setItems(ids);
        setTitle("All-Time Best Chidren's Fantasy Books");
    }
}
