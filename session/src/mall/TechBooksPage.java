package mall;

/**
 * 该页面展示老师书籍产品
 */
public class TechBooksPage extends CatalogPage {
    public void init(){
        String[] ids = {"id_5", "id_6", "id_7","id_8"};
        setItems(ids);
        setTitle("All-Time Best Computer Books");
    }
}
