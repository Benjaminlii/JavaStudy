package util;

public class Page {
    private static final int size = 20;//每一页的数据条数
    private int page;//当前页数

    public Page(int page) {
        this.page = page;
    }

    public int getOffSet(){
        return size * (this.page-1);
    }

    public static int getSize() {
        return size;
    }
}
