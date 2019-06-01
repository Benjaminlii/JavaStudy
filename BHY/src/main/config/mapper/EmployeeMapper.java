package main.config.mapper;

import entity.EmployeeCustom;
import entity.EmployeeQueryVo;

import java.util.List;

public interface EmployeeMapper {
    public List<EmployeeCustom> findEmployeeLimitInDetail(EmployeeQueryVo employeeQueryVo) throws Exception;
}
