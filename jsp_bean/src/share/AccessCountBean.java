package share;

/**
 * 共享页面访问次数的bean（每次请求算一次）
 */
public class AccessCountBean {
    private String firstPage;
    private int accessCount = 1;
    //设置访问次数增长
    public void setAccessCountIncrement(int increment){
        accessCount += increment;
    }



    public String getFirstPage() {
        return firstPage;
    }

    public void setFirstPage(String firstPage) {
        this.firstPage = firstPage;
    }

    public int getAccessCount() {
        return accessCount;
    }
}
