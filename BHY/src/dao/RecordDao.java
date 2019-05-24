package dao;

import entity.Record;

import java.util.List;

public interface RecordDao {
    /**
     * �����ݿ��е�Record�����ۼ�¼�������������
     * @param record ����ķ�װ�õ�������
     * @return ��ӳɹ�����true�����򷵻�false
     */
    public boolean addRecord(Record record);

    /**
     * ����p_id��Record����ɾ��һ����Ϣ
     * @param r_id ��Ҫɾ������Ϣ��r_id
     * @return ɾ���ɹ�����true�����򷵻�false
     */
    public boolean deleteRecord(int r_id);

    /**
     * ���ݴ�����Ϣ����һ��Record���е�����
     * @param record �������Ϣ��r_idΪ���Ҹ�����Ϣ���������������ݾ�Ϊ�������޸ĵ�����Ϣ��
     * @return �޸ĳɹ�����true�����򷵻�false
     */
    public boolean updateRecord(Record record);

    /**
     * ��ѯRecord���е�������Ϣ
     * @return �����е�������Ϣ��װ��List<Record>���з���
     */
    public List<Record> findAllRecord();
}
