package dao;

import entity.Pet;
import util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PetDaoImpl implements PetDao {
    @Override
    public boolean addPet(Pet pet) {
        String sql = "insert into pet (cl_id, d_id, s_id, p_age, p_sex, p_height, p_healthy) " +
                "values (?,?,?,?,?,?,?);";
        Object[] para = {
                pet.getCl_id(), pet.getD_id(), pet.getS_id(),
                pet.getP_age(), pet.getP_sex(), pet.getP_height(),
                pet.getP_healthy()
        };
        boolean rtn = DBUtil.executeUpdate(sql, para) == 1;
        DBUtil.closeAll();
        return rtn;
    }

    @Override
    public boolean deletePet(int p_id) {
        String sql = "delete from pet where p_id = ?";
        Object[] para = {p_id};
        boolean rtn = DBUtil.executeUpdate(sql, para) == 1;
        DBUtil.closeAll();
        return rtn;
    }

    @Override
    public boolean updatePet(Pet pet) {
        String sql = "update pet set cl_id = ?, d_id = ?, s_id = ? " +
                "p_age = ?, p_sex = ?, p_height = ? " +
                "p_healthy = ? " +
                "where p_id = ?";
        Object[] para = {
                pet.getCl_id(), pet.getD_id(), pet.getS_id(),
                pet.getP_age(), pet.getP_sex(), pet.getP_height(),
                pet.getP_healthy(), pet.getP_id()
        };
        boolean rtn = DBUtil.executeUpdate(sql, para) == 1;
        DBUtil.closeAll();
        return rtn;
    }

    @Override
    public List<Pet> findAllPet() throws SQLException {
        String sql = "select * from pet;";
        ResultSet resultSet = DBUtil.executeQuery(sql, null);
        List<Pet> rtn = new ArrayList<>();
        Pet pet;
        while (resultSet.next()) {
            pet = new Pet(
                    resultSet.getInt("p_id"),
                    resultSet.getInt("cl_id"),
                    resultSet.getInt("d_id"),
                    resultSet.getInt("s_id"),
                    resultSet.getInt("p_age"),
                    resultSet.getString("p_sex"),
                    resultSet.getFloat("p_height"),
                    resultSet.getString("p_healthy")
            );
            rtn.add(pet);
        }
        DBUtil.closeAll();
        return rtn;
    }
}
