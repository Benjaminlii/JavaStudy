package testDI;

public class ServiceImpl implements Service {
//     原始开发方式
//    private Dao dao = new DaoImpl();

    //spring后的接口+setter方式
    private Dao dao;

    public Dao getDao() {
        return dao;
    }

    public void setDao(Dao dao) {
        this.dao = dao;
    }

    public void demo(){
        this.dao.demo();
    }
}
