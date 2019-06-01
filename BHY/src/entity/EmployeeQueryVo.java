package entity;

public class EmployeeQueryVo {
    //查询信息
    private EmployeeCustom employeeCustom;

    public EmployeeCustom getEmployeeCustom() {
        return employeeCustom;
    }

    public void setEmployeeCustom(EmployeeCustom employeeCustom) {
        this.employeeCustom = employeeCustom;
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
