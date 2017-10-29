package server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import service.MainService;


public class Server {

        public static void main(String[] args) {
            
            try {
                Registry registry = LocateRegistry.createRegistry(4444);
                MainService mainService = new MainService();
                registry.rebind("server", mainService);
            } catch (RemoteException ex) {
                ex.printStackTrace();
            }
            
    }
    
}
