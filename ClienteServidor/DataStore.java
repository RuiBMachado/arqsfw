package clienteservidor;

import java.rmi.RemoteException;
import java.time.LocalDate;

public class DataStore implements DataStoreInterface {

    @Override
    public String mostra_temperatura() throws RemoteException {
        return "Paste here";
    }

    @Override
    public String mostra_humidade() throws RemoteException {
        return "Paste here";
    }

    @Override
    public String mostra_presao_atm() throws RemoteException {
        return "Paste here";
    }

    @Override
    public String mostra_audio() throws RemoteException {
        return "Paste here";
    }

    @Override
    public String mostra_luminusidade() throws RemoteException {
        return "Paste here";
    }

    @Override
    public String mostra_media(LocalDate data, int sensor) throws RemoteException {
        return "Paste here";
    }

    @Override
    public String mostra_max_minimo_temperatura(LocalDate data) throws RemoteException {
        return "Paste here";
    }

    @Override
    public String mostra_max_minimo_humidade(LocalDate data) throws RemoteException {
        return "Paste here";
    }

    @Override
    public String mostra_max_minimo_pressao_atm(LocalDate data) throws RemoteException {
        return "Paste here";
    }

    @Override
    public String mostra_max_minimo_audio(LocalDate data) throws RemoteException {
        return "Paste here";
    }

    @Override
    public String mostra_max_minimo_luminosidade(LocalDate data) throws RemoteException {
        return "Paste here";
    }

    @Override
    public String mostra_ultimos_dias(int sensor, int dias) throws RemoteException {
        return "Paste here";
    }

}
