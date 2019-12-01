package main.java.com.park.serviceImpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.park.dao.CheckDao;
import com.park.entity.Check;
import com.park.service.CheckService;

@Repository("checkService")
public class CheckServiceImpl implements CheckService {

	
	@Autowired
	CheckDao checkDao;
	
	//添加
	@Override
	public boolean addCheck(Check check) {
		try{
			return checkDao.addCheck(check);
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
			
		}
	}
	
	//更新账单1
	@Override
	public boolean updateCheck1(Check check) {
		try {
			if((checkDao.findChecktatus(check)).equals("0")==true) {
			return checkDao.updateCheck1(check);
			}else {
				return checkDao.addCheck(check);
			}
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	//更新账单2
	@Override
	public boolean updateCheck2(Check check) {
		try {
			return checkDao.updateCheck2(check);
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public List<Check> findAllCheck(Check check) {
		try {
			return checkDao.findAllCheck(check);
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	

	@Override
	public List<Check> findParkingStatus(Check check) {
		
		try {
			return checkDao.findParkingStatus(check);
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}


	



	

}
