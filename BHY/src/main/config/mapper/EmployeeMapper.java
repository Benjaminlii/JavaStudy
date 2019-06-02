package main.config.mapper;

import entity.EmployeeCustom;
import entity.EmployeeQueryVo;

import java.util.List;

public interface EmployeeMapper {
    /**
     * [分页][条件]查询员工信息
     * @param employeeQueryVo 查询条件
     * @return 查询出的员工信息
     */
    public List<EmployeeCustom> findEmployeeLimitInDetail(EmployeeQueryVo employeeQueryVo) throws Exception;

    /**
     * 添加一条员工信息，将e_id回返
     * @param employeeCustom 添加的信息
     * @return 成功返回true，否则返回false
     */
    public boolean insertEmployee(EmployeeCustom employeeCustom) throws Exception;
}
