package dao;

import entity.Client;

import java.sql.SQLException;
import java.util.List;

public interface ClientDao {
    /**
     * �����ݿ��е�cargo���˿ͣ������������
     * @param client ����ķ�װ�õ�������
     * @return ��ӳɹ�����true�����򷵻�false
     */
    public boolean addClient(Client client);

    /**
     * ����cl_id��Client����ɾ��һ����Ϣ
     * @param cl_id ��Ҫɾ������Ϣ��cl_id
     * @return ɾ���ɹ�����true�����򷵻�false
     */
    public boolean deleteClient(int cl_id);

    /**
     * ���ݴ�����Ϣ����һ��Client���е�����
     * @param client �������Ϣ��cl_idΪ���Ҹ�����Ϣ���������������ݾ�Ϊ�������޸ĵ�����Ϣ��
     * @return �޸ĳɹ�����true�����򷵻�false
     */
    public boolean updateClient(Client client);

    /**
     * ��ѯClient���е�������Ϣ
     * @return �����е�������Ϣ��װ��List<Clien>���з���
     * @throws SQLException ����ResultSet
     */
    public List<Client> findAllClient() throws SQLException;
}
