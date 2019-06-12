package http2;

/**
 * 搜索工具类
 * 储存搜索站点
 * 组合搜索URL
 */
public class SearchUtilities {

    //搜索站点的名称，和搜索URL
    private static SearchSpec[] commonSpecs = {
            new SearchSpec("Google",
                    "http://www.google.cn/search?q="),
            new SearchSpec("Baidu",
                    "http://www.baidu.com/s?wd="),
    };

    //选择用户指定的搜索引擎，返回总URL
    public static String makeURL(String searchEngineName,
                                 String searchString){
        SearchSpec[] searchSpecs = getCommonSpecs();
        String searchURL = null;
        for (SearchSpec spec : searchSpecs){
            if (spec.getName().equalsIgnoreCase(searchEngineName)){
                searchURL = spec.makeURL(searchString);
                break;
            }
        }
        return searchURL;
    }

    public static SearchSpec[] getCommonSpecs() {
        return commonSpecs;
    }
}
