package entity;

public class RecordQueryVo {
    //查询信息
    private RecordCustom recordCustom;

    public RecordCustom getRecordCustom() {
        return recordCustom;
    }

    public void setRecordCustom(RecordCustom recordCustom) {
        this.recordCustom = recordCustom;
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
