package service;

import dao.ClientDao;
import dao.ClientDaoImpl;
import entity.Client;

/**
 * 关于Client（顾客）的业务逻辑
 */
public class ClientService {
    private static ClientDao clientDao = new ClientDaoImpl();

    public static boolean addClient(Client client){
        return clientDao.addClient(client);
    }
}
