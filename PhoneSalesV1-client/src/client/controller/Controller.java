/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.controller;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;
import rmi.AvailableServices;
import rmi.dto.AvailablePhoneDTO;


public class Controller {
    private AvailableServices availableServices;
    
    private Controller(){
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 4444);
            availableServices = (AvailableServices) registry.lookup("server");
        } catch (Exception ex) {
            ex.printStackTrace();
        } 
    }
    
    private static final class SingletonHolder {
        private static final Controller INSTANCE = new Controller();
    }
    
    public static Controller getInstance (){
        return SingletonHolder.INSTANCE;
    }
            
    public boolean addNewPhoneModel(AvailablePhoneDTO availablePhoneDTO){
        
        boolean rez = false;
        
        try {
            rez = availableServices.addNewPhoneModel(availablePhoneDTO);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
        return rez;
    }
    
}
