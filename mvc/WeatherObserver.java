/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3;
import java.util.Vector;

/**
 *
 * @author Rui
 */
public interface WeatherObserver {


    void update(int id, Vector<Integer> values);
}
