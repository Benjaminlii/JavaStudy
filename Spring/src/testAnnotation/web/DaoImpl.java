package testAnnotation.web;

import org.springframework.stereotype.Repository;

@Repository ("dao")
public class DaoImpl implements Dao {
    @Override
    public void add() {
        System.out.println("dao----->add");
    }
}
