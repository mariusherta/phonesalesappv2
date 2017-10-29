/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.AvailablePhoneDao;
import entities.AvailablePhone;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import rmi.AvailableServices;
import rmi.dto.AvailablePhoneDTO;

/**
 *
 * @author Marius
 */
public class MainService extends UnicastRemoteObject implements AvailableServices {
    
    private EntityManagerFactory emf;
    
    public MainService()throws RemoteException{
        emf = Persistence.createEntityManagerFactory("PhoneSalesV1-serverPU");
    }

    @Override
    public List<AvailablePhoneDTO> getAvailablePhones() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addNewPhoneModel(AvailablePhoneDTO availablePhoneDTO)throws RemoteException{
        boolean rez = false;
        EntityManager em = emf.createEntityManager();
        AvailablePhone availablePhone = convertToAvailablePhone(availablePhoneDTO);
        
        AvailablePhoneDao availablePhoneDao = new AvailablePhoneDao(em);
        
        rez = availablePhoneDao.addNewPhoneModel(availablePhone);
        return rez;
               
    }
    
    public AvailablePhone convertToAvailablePhone(AvailablePhoneDTO availablePhoneDTO){
        
        String maker = availablePhoneDTO.getMaker();
        String model = availablePhoneDTO.getModel();
        int quantity = availablePhoneDTO.getQuantity();
       
        return new AvailablePhone(maker, model,quantity);
    }
    
}
