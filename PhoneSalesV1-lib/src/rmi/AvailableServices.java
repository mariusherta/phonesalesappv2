/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import rmi.dto.AvailablePhoneDTO;


public interface AvailableServices extends Remote{
    public List<AvailablePhoneDTO> getAvailablePhones()throws RemoteException;
    public boolean addNewPhoneModel(AvailablePhoneDTO availablePhoneDTO)throws RemoteException;
}
