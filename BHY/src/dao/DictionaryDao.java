package dao;

import entity.Dictionary;

import java.sql.SQLException;
import java.util.List;

public interface DictionaryDao {
    /**
     * �����ݿ��е�dictionary�������ֵ䣩�����������
     * @param dictionary ����ķ�װ�õ�������
     * @return ��ӳɹ�����true�����򷵻�false
     */
    public boolean addDictionary(Dictionary dictionary);

    /**
     * ����d_id��Dictionary����ɾ��һ����Ϣ
     * @param d_id ��Ҫɾ������Ϣ��d_id
     * @return ɾ���ɹ�����true�����򷵻�false
     */
    public boolean deleteDictionary(int d_id);

    /**
     * ���ݴ�����Ϣ����һ��Dictionary���е�����
     * @param dictionary �������Ϣ��d_idΪ���Ҹ�����Ϣ���������������ݾ�Ϊ�������޸ĵ�����Ϣ��
     * @return �޸ĳɹ�����true�����򷵻�false
     */
    public boolean updateDictionary(Dictionary dictionary);

    /**
     * ��ѯDictionary���е�������Ϣ
     * @return �����е�������Ϣ��װ��List<Dictionary>���з���
     */
    public List<Dictionary> findAllDictionary() throws SQLException;
}
