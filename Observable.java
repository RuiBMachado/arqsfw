/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3;

/**
 *
 * @author Rui
 */
public interface Observable {
    
    public void notifyObservers(); 
    public void registerObserver(Observer observer);
    public void removeObserver(Observer observer);
}
