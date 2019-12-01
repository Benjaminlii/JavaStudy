package main.java.com.park.dao;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import main.java.com.park.entity.Check;


/*
 * 订单状态：0：已预订，未支付，1：正在使用，未支付
 * 			2：已支付，待评价，3：已支付，已评价)
 */

/*
 * 
 */
@Repository
public interface CheckDao {
	
	public boolean addCheck(Check check);
	
	public boolean updateCheck1(Check check);
	
	public boolean updateCheck2(Check check);
	
	public String findChecktatus(Check check);
	
	public List<Check> findAllCheck(Check check);
	
	public List<Check> findParkingStatus(Check check);

	public Date getDate();
}
