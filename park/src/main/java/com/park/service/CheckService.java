package main.java.com.park.service;

import java.util.Date;
import java.util.List;

import com.park.entity.Check;


public interface CheckService {
	
	public boolean addCheck(Check check);
	
	public boolean updateCheck1(Check check);
	
	public boolean updateCheck2(Check check);
	
	public List<Check> findAllCheck(Check check);
	
	public List<Check> findParkingStatus(Check check);
	
	//public boolean deleteCheck(Check check);
	
	//public Date getDate(String license);

}
