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

    //分页信息
    private Page page;

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }
}
