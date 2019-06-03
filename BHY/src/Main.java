import entity.EmployeeQueryVo;
import service.EmployeeService;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        EmployeeQueryVo employeeQueryVo = new EmployeeQueryVo();
        System.out.println(EmployeeService.findEmployeeLimitInDetail(employeeQueryVo));
    }
}
