package entity;

public class Page {
    private int size = 6;//每一页的数据条数
    private int page;//当前页数
    private int offSet;//起始行数

    public Page(int page) {
        this.page = page;
        this.offSet = size * (this.page-1);
    }

    @Override
    public String toString() {
        return "Page{" +
                "size=" + size +
                ", page=" + page +
                ", offSet=" + offSet +
                '}';
    }
}
