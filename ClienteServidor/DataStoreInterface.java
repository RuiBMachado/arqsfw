package tp3cliserv;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.Vector;

public interface DataStoreInterface extends Remote {
    
    void update(int id, Vector<Integer> values) throws RemoteException;
    String mostra_temperatura() throws RemoteException;
    String mostra_humidade()throws RemoteException;
    String mostra_pressao_atm() throws RemoteException;
    String mostra_audio() throws RemoteException;
    String mostra_luminosidade() throws RemoteException;
    String mostra_media(LocalDate data, int sensor) throws RemoteException;
    String mostra_max_minimo_temperatura(LocalDate data) throws RemoteException;
    String mostra_max_minimo_humidade(LocalDate data) throws RemoteException;
    String mostra_max_minimo_pressao_atm(LocalDate data) throws RemoteException;
    String mostra_max_minimo_audio(LocalDate data) throws RemoteException;
    String mostra_max_minimo_luminosidade(LocalDate data) throws RemoteException;
    String mostra_ultimos_dias(int sensor, int dias) throws RemoteException; 
}