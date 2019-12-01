package main.java.com.park.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.park.dao.ParkingInfoDao;
import com.park.entity.CarSpace;
import com.park.entity.ParkinglotInfo;
import com.park.service.ParkingInfoService;
import com.park.vo.ParkingInformation;

@Repository("parkingInfoService")
public class ParkingInfoServiceImpl implements ParkingInfoService {

	
	@Autowired
	ParkingInfoDao parkingInfoDao;
	

	@Override
	public List<ParkingInformation> searchParkByName(String parking_name) {
		List<ParkinglotInfo> parkinglot=parkingInfoDao.searchParkByName(parking_name);
		List<ParkingInformation> parkingInformation=new ArrayList<ParkingInformation >();
		ParkingInformation pf=null;
		for(ParkinglotInfo pl:parkinglot){
			int collect_number=parkingInfoDao.getCollectUser(pl.getParking_id());
			int emptyCarSpace=parkingInfoDao.emptyCarspace(pl.getParking_id());
			pf=new ParkingInformation(pl.getParking_id(), pl.getParking_name(), pl.getParking_location(), pl.getCar_number(), collect_number, emptyCarSpace);
			parkingInformation.add(pf);
			System.out.println("service进去了");
	
		}
		System.out.println("service也没进去了");
		return parkingInformation;
	}

	@Override
	public ParkinglotInfo getParking_Information(String parking_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ParkinglotInfo> getLocalPark(double longitude, double latitude) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getEmptyCarSpace(String parking_id) {
		try {
			return parkingInfoDao.emptyCarspace(parking_id);
		}catch(Exception e) {
			return 0;
		}
		
	}

	@Override
	public int getCollectUser(String parking_id) {
	
		return 0;
	}

	@Override
	public List<CarSpace> getAllCarspace(String parking_id) {
		List<CarSpace> carspaces=parkingInfoDao.getAllCarspace(parking_id);
		try {
			return carspaces;
		}catch(Exception e) {
			return null;
		}
		
	}
}
	
