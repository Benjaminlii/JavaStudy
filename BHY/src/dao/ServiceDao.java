package dao;

import entity.Service;

import java.sql.SQLException;
import java.util.List;

public interface ServiceDao {
    /**
     * �����ݿ��е�Service�����񣩱����������
     * @param service ����ķ�װ�õ�������
     * @return ��ӳɹ�����true�����򷵻�false
     */
    public boolean addService(Service service);

    /**
     * ����s_id��Service����ɾ��һ����Ϣ
     * @param s_id ��Ҫɾ������Ϣ��s_id
     * @return ɾ���ɹ�����true�����򷵻�false
     */
    public boolean deleteService(int s_id);

    /**
     * ���ݴ�����Ϣ����һ��Service���е�����
     * @param service �������Ϣ��s_idΪ���Ҹ�����Ϣ���������������ݾ�Ϊ�������޸ĵ�����Ϣ��
     * @return �޸ĳɹ�����true�����򷵻�false
     */
    public boolean updateService(Service service);

    /**
     * ��ѯService���е�������Ϣ
     * @return �����е�������Ϣ��װ��List<Service>���з���
     * @throws SQLException ����ResultSet
     */
    public List<Service> findAllService() throws SQLException;
}
