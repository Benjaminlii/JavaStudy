package service;

import dao.ClientDao;
import dao.ClientDaoImpl;

/**
 * 关于Client（顾客）的业务逻辑
 */
public class ClientService {
    private ClientDao clientDao = new ClientDaoImpl();
}
