package http2;

/**
 * 搜索工具类
 * 储存搜索站点
 * 组合搜索URL
 */
public class SearchUtilities {

    private static SearchSpec[] commonSpecs = {
            new SearchSpec("Google",
                    "http://www.google.cn/search?q="),
            new SearchSpec("Baidu",
                    "http://www.baidu.com/s?wd="),
    };

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
