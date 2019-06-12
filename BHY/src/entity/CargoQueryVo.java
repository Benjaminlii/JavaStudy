package entity;

public class CargoQueryVo {
    //货物
    private CargoCustom cargoCustom;

    public CargoCustom getCargoCustom() {
        return cargoCustom;
    }

    public void setCargoCustom(CargoCustom cargoCustom) {
        this.cargoCustom = cargoCustom;
    }

    //用户信息，用于查询宠物店
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    //分页
    private Page page;

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

}
