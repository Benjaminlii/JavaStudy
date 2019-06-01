package entity;

public class StoreQueryVo {
    //查询条件
    private StoreCustom storeCustom;

    public StoreCustom getStoreCustom() {
        return storeCustom;
    }

    public void setStoreCustom(StoreCustom storeCustom) {
        this.storeCustom = storeCustom;
    }

    //分页信息
    private Page page;

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }
}
