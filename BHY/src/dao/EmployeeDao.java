package dao;

import entity.Employee;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeDao {
    /**
     * �����ݿ��е�Employee��Ա���������������
     * @param employee ����ķ�װ�õ�������
     * @return ��ӳɹ�����true�����򷵻�false
     */
    public boolean addEmployee(Employee employee);

    /**
     * ����e_id��Employee����ɾ��һ����Ϣ
     * @param e_id ��Ҫɾ������Ϣ��e_id
     * @return ɾ���ɹ�����true�����򷵻�false
     */
    public boolean deleteEmployee(int e_id);

    /**
     * ���ݴ�����Ϣ����һ��Employee���е�����
     * @param employee �������Ϣ��e_idΪ���Ҹ�����Ϣ���������������ݾ�Ϊ�������޸ĵ�����Ϣ��
     * @return �޸ĳɹ�����true�����򷵻�false
     */
    public boolean updateEmployee(Employee employee);

    /**
     * ��ѯEmployee���е�������Ϣ
     * @return �����е�������Ϣ��װ��List<Employee>���з���
     * @throws SQLException ����ResultSet
     */
    public List<Employee> findAllEmployee() throws SQLException;
}
