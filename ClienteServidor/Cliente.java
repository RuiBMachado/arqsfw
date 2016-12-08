package datastore;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.time.LocalDate;

public class Cliente {

    public static void main(String args[]) throws RemoteException, NotBoundException {
        String name = "Storage";

        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }

        try {

            Registry registry = LocateRegistry.getRegistry();
            DataStoreInterface stub = (DataStoreInterface) registry.lookup(name);

            //views
            name = stub.mostra_temperatura();
            System.out.println(name);
            name = stub.mostra_max_minimo_temperatura(LocalDate.now());
            System.out.println(name);
            name = stub.mostra_max_minimo_humidade(LocalDate.now());
            System.out.println(name);
            name = stub.mostra_max_minimo_pressao_atm(LocalDate.now());
            System.out.println(name);
            name = stub.mostra_max_minimo_audio(LocalDate.now());
            System.out.println(name);
            name = stub.mostra_max_minimo_luminosidade(LocalDate.now());
            System.out.println(name);
            name = stub.mostra_presao_atm();
            System.out.println(name);
            name = stub.mostra_humidade();
            System.out.println(name);
            name = stub.mostra_media(LocalDate.now(), 0);
            System.out.println(name);
            name = stub.mostra_ultimos_dias(0, 2);
            System.out.println(name);

        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }

    }
}
