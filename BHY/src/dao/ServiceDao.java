package dao;

import entity.Service;

import java.sql.SQLException;
import java.util.List;

public interface ServiceDao {
    /**
     * 向数据库中的Service（服务）表中添加数据
     * @param service 传入的封装好的数对象
     * @return 添加成功返回true，否则返回false
     */
    public boolean addService(Service service);

    /**
     * 根据s_id从Service表中删除一条信息
     * @param s_id 需要删除的信息的s_id
     * @return 删除成功返回true，否则返回false
     */
    public boolean deleteService(int s_id);

    /**
     * 根据传入信息更改一条Service表中的数据
     * @param service 传入的信息，s_id为查找该条信息的条件，其他数据均为新数据修改到该信息处
     * @return 修改成功返回true，否则返回false
     */
    public boolean updateService(Service service);

    /**
     * 查询Service表中的所有信息
     * @return 将表中的所有信息封装成List<Service>进行返回
     * @throws SQLException 遍历ResultSet
     */
    public List<Service> findAllService() throws SQLException;
}
