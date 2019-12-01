package main.java.com.park.service;

import javax.annotation.PostConstruct;

/** 
 * @author wangpei 
 * @version 
 *创建时间：2017年2月26日 下午7:30:24 
 * 创建socket
 */
public interface SocketService {
	
	@PostConstruct//初始化之前调用
	public void init();

}
 