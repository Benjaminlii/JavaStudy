package main.java.com.park.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.park.dao.CarspaceDao;

public class SpringTask {
	
	@Autowired
	CarspaceDao carspaceDao;
	public boolean TaskCarspace() {
		try {
			//System.out.println("轮训数据库");
			return carspaceDao.taskCarspace();
		}catch(Exception e) {
			e.getMessage();
			return false;
		}
	}
	
	

}
