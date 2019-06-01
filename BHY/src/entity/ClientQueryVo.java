package entity;

public class ClientQueryVo {
    //顾客信息
    private ClientCustom clientCustom;

    public ClientCustom getClientCustom() {
        return clientCustom;
    }

    public void setClientCustom(ClientCustom clientCustom) {
        this.clientCustom = clientCustom;
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
