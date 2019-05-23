package dao;

import entity.Pet;

import java.sql.SQLException;
import java.util.List;

public interface PetDao {
    /**
     * �����ݿ��е�Pet����������������
     * @param pet ����ķ�װ�õ�������
     * @return ��ӳɹ�����true�����򷵻�false
     */
    public boolean addPet(Pet pet);

    /**
     * ����p_id��Pet����ɾ��һ����Ϣ
     * @param p_id ��Ҫɾ������Ϣ��p_id
     * @return ɾ���ɹ�����true�����򷵻�false
     */
    public boolean deletePet(int p_id);

    /**
     * ���ݴ�����Ϣ����һ��Pet���е�����
     * @param pet �������Ϣ��p_idΪ���Ҹ�����Ϣ���������������ݾ�Ϊ�������޸ĵ�����Ϣ��
     * @return �޸ĳɹ�����true�����򷵻�false
     */
    public boolean updatePet(Pet pet);

    /**
     * ��ѯPet���е�������Ϣ
     * @return �����е�������Ϣ��װ��List<Pet>���з���
     * @throws SQLException ����ResultSet
     */
    public List<Pet> findAllPet() throws SQLException;
}
