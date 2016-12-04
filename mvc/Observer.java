/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Vector;

/**
 *
 * @author Rui
 */
public interface Observer {
    
    public void update(HashMap<LocalDate,Vector<Integer>> temperatura,HashMap<LocalDate,Vector<Integer>> humidade, HashMap<LocalDate,Vector<Integer>> pressao_atm,HashMap<LocalDate,Vector<Integer>> audio,HashMap<LocalDate,Vector<Integer>> luminosidade);
    
}
