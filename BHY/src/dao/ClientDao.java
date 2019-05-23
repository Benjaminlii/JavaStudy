package dao;

import entity.Client;

import java.sql.SQLException;
import java.util.List;

public interface ClientDao {
    /**
     * 向数据库中的cargo（顾客）表中添加数据
     * @param client 传入的封装好的数对象
     * @return 添加成功返回true，否则返回false
     */
    public boolean addClient(Client client);

    /**
     * 根据cl_id从Client表中删除一条信息
     * @param cl_id 需要删除的信息的cl_id
     * @return 删除成功返回true，否则返回false
     */
    public boolean deleteClient(int cl_id);

    /**
     * 根据传入信息更改一条Client表中的数据
     * @param client 传入的信息，cl_id为查找该条信息的条件，其他数据均为新数据修改到该信息处
     * @return 修改成功返回true，否则返回false
     */
    public boolean updateClient(Client client);

    /**
     * 查询Client表中的所有信息
     * @return 将表中的所有信息封装成List<Clien>进行返回
     * @throws SQLException 遍历ResultSet
     */
    public List<Client> findAllClient() throws SQLException;
}
