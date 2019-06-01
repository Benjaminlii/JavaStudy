package entity;

import javax.servlet.ServletContext;

public class ServiceQueryVo {
    //查询条件
    private ServiceCustom serviceCustom;

    public ServiceCustom getServiceCustom() {
        return serviceCustom;
    }

    public void setServiceCustom(ServiceCustom serviceCustom) {
        this.serviceCustom = serviceCustom;
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
