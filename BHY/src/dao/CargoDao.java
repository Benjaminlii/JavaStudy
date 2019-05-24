package dao;

import entity.Cargo;

import java.util.List;

public interface CargoDao {
    /**
     * �����ݿ��е�cargo����Ʒ�������������
     * @param cargo ����ķ�װ�õ�������
     * @return ��ӳɹ�����true�����򷵻�false
     */
    public boolean addCargo(Cargo cargo);

    /**
     * ����c_id��cargo����ɾ��һ����Ϣ
     * @param c_id ��Ҫɾ������Ϣ��c_id
     * @return ɾ���ɹ�����true�����򷵻�false
     */
    public boolean deleteCargo(int c_id);

    /**
     * ���ݴ�����Ϣ����һ��cargo���е�����
     * @param cargo �������Ϣ��c_idΪ���Ҹ�����Ϣ���������������ݾ�Ϊ�������޸ĵ�����Ϣ��
     * @return �޸ĳɹ�����true�����򷵻�false
     */
    public boolean updateCargo(Cargo cargo);

    /**
     * ��ѯcargo���е�������Ϣ
     * @return �����е�������Ϣ��װ��List<Cargo>���з���
     */
    public List<Cargo> findAllCargo();
}
