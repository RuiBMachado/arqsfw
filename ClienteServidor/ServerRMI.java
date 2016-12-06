package clienteservidor;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class ServerRMI {

    public static void main(String[] args) {
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
        try {
            String name = "Storage";

            // Criação e exportação do objecto remoto
            DataStore ds = new DataStore();
            DataStore stub = (DataStore) UnicastRemoteObject.exportObject(ds, 0);

            // Registo do objecto remoto
            Registry registry = LocateRegistry.getRegistry();
            registry.rebind(name, stub);

            System.out.println("Server ready");
        } catch (Exception e) {
            System.err.println("exception:" + e.toString());
        }
    }
}
