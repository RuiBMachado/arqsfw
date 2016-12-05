/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3alinea1;

import java.time.LocalDate;
import java.util.Vector;

/**
 *
 * @author Rui
 */
public class XDK {
       public static void main(String args[]) {

        // Create a hash map
        Vector<Integer> xdk1_reading_1= new Vector<>();
        xdk1_reading_1.add(23);
        xdk1_reading_1.add(2);
        xdk1_reading_1.add(3);
        xdk1_reading_1.add(54);
        xdk1_reading_1.add(32);

        Vector<Integer> xdk1_reading_2= new Vector<>();
        xdk1_reading_2.add(22);
        xdk1_reading_2.add(24);
        xdk1_reading_2.add(3);
        xdk1_reading_2.add(4);
        xdk1_reading_2.add(5);

        WeatherStation iot = new WeatherStation();
        // simular a recepção de valores
        iot.update(1, xdk1_reading_1);
        iot.update(1, xdk1_reading_2);
        //views
        iot.mostra_temperatura();
        iot.mostra_max_minimo_temperatura(LocalDate.now());
        iot.mostra_max_minimo_humidade(LocalDate.now());
        iot.mostra_max_minimo_pressao_atm(LocalDate.now());
        iot.mostra_max_minimo_audio(LocalDate.now());
        iot.mostra_max_minimo_luminosidade(LocalDate.now());
        iot.mostra_presao_atm();
        iot.mostra_humidade();
        iot.mostra_media(LocalDate.now(),0);
        iot.mostra_ultimos_dias(0,2);

    }

    
}
