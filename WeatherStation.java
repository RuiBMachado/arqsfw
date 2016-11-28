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
import java.time.LocalDate;
import java.util.*;

/**
 * Created by "amateur programmer”
 */
public class WeatherStation implements WeatherObserver,Observable {



    /**  Data objects
     *
     * Registos do valor de temperaturas
     * Registos do valor de humidade
     * Registos do valor de pressão atmosférica
     * Registos de audio
     * Registos de luminosidade
     * */

    HashMap<LocalDate,Vector<Integer>> temperatura;
    HashMap<LocalDate,Vector<Integer>> humidade;
    HashMap<LocalDate,Vector<Integer>> pressao_atm;
    HashMap<LocalDate,Vector<Integer>> audio;
    HashMap<LocalDate,Vector<Integer>> luminosidade;
    ArrayList<Observer> views;
    View view;
    
    public WeatherStation() {

        this.humidade = new HashMap<>();
        this.temperatura = new HashMap<>();
        this.audio = new HashMap<>();
        this.luminosidade = new HashMap<>();
        this.pressao_atm = new HashMap<>();
        this.views=new ArrayList<>();
        this.view=new View(this);
    }

    /**
     * A estção meteriologica recebe updates dos sensores e armazena os valores na estrutura de dados respectiva.
     * @param id identificador do sensor XDK
     * @param values parametros lidos pelo sensor
     *               posição 0 : temperatura
     *               posição 1 : humidade
     *               posição 2 : pressão atmosféria
     *               posição 3 : audio
     *               posição 4 : luminosidade
     *
     */
    @Override
    public void update(int id, Vector<Integer> values){
        
        Vector<Integer> new_vector  =  new Vector<Integer>();
        Vector<Integer> valores;
        
        switch (id) {
            case 1: // XDK exterior
                
                valores=this.temperatura.get(LocalDate.now());
                if (valores != null){
                    valores.add(values.elementAt(0));
                } else
                {
                   
                    new_vector.add(values.elementAt(0));
                    temperatura.put(LocalDate.now(), new_vector);
                }
                
                valores=this.humidade.get(LocalDate.now());
                if (valores != null){
                    valores.add(values.elementAt(1));
                } else
                {
                    new_vector.add(values.elementAt(1));
                    humidade.put(LocalDate.now(), new_vector);
                }
                
                valores =this.pressao_atm.get(LocalDate.now()) ;
                if (valores!= null){
                    valores.add(values.elementAt(2));
                } else
                {
                    new_vector.add(values.elementAt(2));
                    pressao_atm.put(LocalDate.now(), new_vector);
                }

                valores=this.audio.get(LocalDate.now());
                if (valores != null){
                    valores.add(values.elementAt(3));
                } else
                {
                    new_vector.add(values.elementAt(3));
                    audio.put(LocalDate.now(), new_vector);
                }
                
                valores=this.luminosidade.get(LocalDate.now());
                if (valores != null){
                    valores.add(values.elementAt(4));
                } else
                {
                    new_vector.add(values.elementAt(4));
                    luminosidade.put(LocalDate.now(), new_vector);
                }
                notifyObservers();
                break;
            case 2: // XDK interior
                ;
                break;
            default:
                // ignore ;
                break;
        }
    }

    
    @Override
    public void notifyObservers() {
        int i;

        for (i = 0; i < views.size(); i++) {
            Observer ob = (Observer) views.get(i);
            ob.update(temperatura,humidade,pressao_atm,audio,luminosidade);
           
        }
    }


    public void removeObserver(Observer observer) {
        this.views.remove(observer);
    }

    @Override
    public void registerObserver(Observer observer) {
        this.views.add(observer);
    }


    

 


 

}
