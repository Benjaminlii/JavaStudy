package entity;

public class PetQueryVo {
    //宠物信息
    private PetCustom petCustom;

    public PetCustom getPetCustom() {
        return petCustom;
    }

    public void setPetCustom(PetCustom petCustom) {
        this.petCustom = petCustom;
    }

    //用户信息，用于查询宠物店
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    //用户信息
    private Client client;

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
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
