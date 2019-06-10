package testAnnotation.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.Resource;

@org.springframework.stereotype.Service
public class ServiceImpl implements Service {

    private Dao dao;

    @Autowired
    @Qualifier("dao")
    //setter方法注入，通过id注入bean
//    @Resource(name = "dao")
    public void setDao(Dao dao) {
        this.dao = dao;
    }

    @Override
    public void add() {
        dao.add();
    }
}
