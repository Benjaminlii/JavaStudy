package dao;

import entity.Service;
import entity.Store;

import java.sql.SQLException;
import java.util.List;

public interface StoreDao {
    /**
     * �����ݿ��е�Store������꣩�����������
     * @param store ����ķ�װ�õ�������
     * @return ��ӳɹ�����true�����򷵻�false
     */
    public boolean addStore(Store store);

    /**
     * ����st_id��Store����ɾ��һ����Ϣ
     * @param st_id ��Ҫɾ������Ϣ��st_id
     * @return ɾ���ɹ�����true�����򷵻�false
     */
    public boolean deleteStore(int st_id);

    /**
     * ���ݴ�����Ϣ����һ��Store���е�����
     * @param store �������Ϣ��st_idΪ���Ҹ�����Ϣ���������������ݾ�Ϊ�������޸ĵ�����Ϣ��
     * @return �޸ĳɹ�����true�����򷵻�false
     */
    public boolean updateStore(Store store);

    /**
     * ��ѯService���е�������Ϣ
     * @return �����е�������Ϣ��װ��List<Store>���з���
     * @throws SQLException ����ResultSet
     */
    public List<Store> findAllStore() throws SQLException;
}
