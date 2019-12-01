package main.java.com.park.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import main.java.com.park.entity.CarSpace;
import main.java.com.park.entity.ParkinglotInfo;

@Repository
public interface ParkingInfoDao {
	
	public List<ParkinglotInfo>searchParkByName(String parking_name);//根据停车场的名称模糊查找停车场
	
	//查看某个车库的空闲车位
	public int emptyCarspace(String parking_id);
	
	//查看某个车库的收藏情况
	public int getCollectUser(String parking_id);
	
	//查看某一个停车场的所有情况
	public ParkinglotInfo getParkinglotInformation(String parking_id);
	
	public List<ParkinglotInfo>getLocalPark(double longitude,double latitude );
	
	public List<CarSpace> getAllCarspace(String parking_id);
	
	
	/*
	 * 1.根据id查看某个停车场的空闲、收藏
	 * 2.根据名称查找停车场
	 */

}
