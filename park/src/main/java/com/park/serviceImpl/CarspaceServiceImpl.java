package main.java.com.park.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.park.dao.CarspaceDao;
import com.park.entity.CarSpace;
import com.park.service.CarspaceService;

@Repository("carspaceService")
public class CarspaceServiceImpl  implements CarspaceService{

	@Autowired
	CarspaceDao carspaceDao;
	//预定车位  若为空闲态，修改车位状态 完成该预约操作
	@Override
	public boolean reserveCarspace(CarSpace car) {
		try{
			if(carspaceDao.findStatus(car.getParking_id(), car.getSpace_location())==0)
			return carspaceDao.reserveCarspace(car);
			else
				return false;
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
			
		}
	}
	
	//停车操作 查询是否被预约或者空闲
	@Override
	public String parkCarspace(CarSpace car) {
		
		try {
			if((carspaceDao.findStatus(car.getParking_id(), car.getSpace_location())==0)||
					(carspaceDao.compareCarspace(car)==1)
					){
				
				carspaceDao.parkCarspace(car);
				return "success";
			}else {
			return "false";
			}
			
			//return carspaceDao.parkCarspace(car);
		}catch(Exception e) {
		
			return "flase";
		}
	}
	
	//取车操作
	@Override
	public boolean takeCarspace(CarSpace car) {
		try {
			if(carspaceDao.compareCarspace(car)==2) {
				return carspaceDao.takeCarspace(car);
			}else {
				return false;
			}
				
		}catch(Exception e) {
			
			return false;
		}
		
	}
	
	
	//查询车位状态
		@Override
		public int checkCarspace(CarSpace car) {
			try{
				
				return carspaceDao.findStatus(car.getParking_id(), car.getSpace_location());
				
			}catch(Exception e){
				e.printStackTrace();
				return -1;
			}
			
		}
	
	
	

	
	

}
