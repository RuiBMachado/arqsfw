/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3alinea1;



import java.util.Vector;


/**
 * Created by andreferreira on 03/11/2016.
 */
public interface WeatherObserver {


    void update(int id, Vector<Integer> values);
}
