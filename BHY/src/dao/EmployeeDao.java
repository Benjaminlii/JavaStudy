package dao;

import entity.Employee;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeDao {
    /**
     * 向数据库中的Employee（员工）表中添加数据
     * @param employee 传入的封装好的数对象
     * @return 添加成功返回true，否则返回false
     */
    public boolean addEmployee(Employee employee);

    /**
     * 根据e_id从Employee表中删除一条信息
     * @param e_id 需要删除的信息的e_id
     * @return 删除成功返回true，否则返回false
     */
    public boolean deleteEmployee(int e_id);

    /**
     * 根据传入信息更改一条Employee表中的数据
     * @param employee 传入的信息，e_id为查找该条信息的条件，其他数据均为新数据修改到该信息处
     * @return 修改成功返回true，否则返回false
     */
    public boolean updateEmployee(Employee employee);

    /**
     * 查询Employee表中的所有信息
     * @return 将表中的所有信息封装成List<Employee>进行返回
     * @throws SQLException 遍历ResultSet
     */
    public List<Employee> findAllEmployee() throws SQLException;
}
