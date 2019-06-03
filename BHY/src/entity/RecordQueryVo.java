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

    //购买者手机号
    private String mobile;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    //当前登陆的用户（根据用户查询员工e_id，然后查询宠物店st_id）
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
