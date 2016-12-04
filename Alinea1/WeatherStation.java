/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3alinea1;


import java.time.LocalDate;
import java.util.*;

/**
 * Created by "amateur programmer”
 */
public class WeatherStation implements WeatherObserver {


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

    public WeatherStation() {

        this.humidade = new HashMap<>();
        this.temperatura = new HashMap<>();
        this.audio = new HashMap<>();
        this.luminosidade = new HashMap<>();
        this.pressao_atm = new HashMap<>();
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

         
        switch (id) {
            case 1: // XDK exterior
                
                  
                if (this.temperatura.get(LocalDate.now()) != null){
                    Vector<Integer> val_temp = temperatura.get(LocalDate.now());
                    val_temp.add(values.elementAt(0));
                } else
                {
                    Vector<Integer> new_vector  =  new Vector<Integer>();
                    new_vector.add(values.elementAt(0));
                    temperatura.put(LocalDate.now(), new_vector);
                }
                if (this.humidade.get(LocalDate.now()) != null){
                    Vector<Integer> val_temp = humidade.get(LocalDate.now());
                    val_temp.add(values.elementAt(1));
                } else
                {
                    Vector<Integer> new_vector  =  new Vector<Integer>();
                    new_vector.add(values.elementAt(1));
                    humidade.put(LocalDate.now(), new_vector);
                }

                if (this.pressao_atm.get(LocalDate.now()) != null){
                    Vector<Integer> val_temp = pressao_atm.get(LocalDate.now());
                    val_temp.add(values.elementAt(2));
                } else
                {
                    Vector<Integer> new_vector  =  new Vector<Integer>();
                    new_vector.add(values.elementAt(2));
                    pressao_atm.put(LocalDate.now(), new_vector);
                }

                if (this.audio.get(LocalDate.now()) != null){
                    Vector<Integer> val_temp = audio.get(LocalDate.now());                
                    val_temp.add(values.elementAt(3));
                } else
                {
                    Vector<Integer> new_vector  =  new Vector<Integer>();
                    new_vector.add(values.elementAt(3));
                    audio.put(LocalDate.now(), new_vector);
                }
                if (this.luminosidade.get(LocalDate.now()) != null){
                    Vector<Integer> val_temp = luminosidade.get(LocalDate.now());
                    val_temp.add(values.elementAt(4));
                } else
                {
                    Vector<Integer> new_vector  =  new Vector<Integer>();
                    new_vector.add(values.elementAt(4));
                    luminosidade.put(LocalDate.now(), new_vector);
                }
                break;
            case 2: // XDK interior
                ;
                break;
            default:
                // ignore ;
                break;
        }
    }

    /**
     * Funcionalidade: Mostrar os valores mais recentes dos sensores
     * @return print da temperatura
     */
    public void mostra_temperatura(){
       int i = -100;
        LocalDate localDate = LocalDate.now();
        
        if (temperatura.containsKey(localDate)) {
            Vector<Integer> valores =temperatura.get(localDate);
            int size = valores.size();
            i = valores.elementAt(size - 1);
        }
        System.out.println("Temperatura Actual: " + i);
    }

    public void mostra_humidade(){
        int value = -100;
         LocalDate localDate = LocalDate.now();

        if (humidade.containsKey(localDate)) {
            Vector<Integer> valores=humidade.get(localDate);
            int size = valores.size();
            value = valores.elementAt(size - 1);
        }
        System.out.println("Humidade Actual: " + value);
    }

    public void mostra_presao_atm(){
        int value = -100;
        LocalDate localDate = LocalDate.now();
        if (pressao_atm.containsKey(localDate)) {
            Vector<Integer> valores =pressao_atm.get(localDate);
            int size = valores.size();
            value =valores.elementAt(size - 1);
        }
        System.out.println("pressão atmosférica actual: " + value);
    }

    public void mostra_audio(){
        int value = -100;
        LocalDate localDate = LocalDate.now();

        if (audio.containsKey(localDate)) {
            Vector<Integer> valores=audio.get(localDate);
            int size = valores.size();
            value = valores.elementAt(size - 1);
        }
        System.out.println("Audio actual: " + value);
    }

    public void mostra_luminusidade(){
        int value = -100;
        LocalDate localDate = LocalDate.now();

        if (luminosidade.containsKey(localDate)) {
            Vector<Integer> valores=luminosidade.get(localDate);
            int size = valores.size();
            value = valores.elementAt(size - 1);
        }
        System.out.println("Luminosidade actual: " + value);
    }

    /**
     * Funcionalidade: mostra a média da temperatura para um determinado dia
     * @param data dia a considerar para a média
     * @param sensor sensor a calcular: 0 temperatura
     */
    public void mostra_media(LocalDate data, int sensor){

         int sum=0;
        int tamanho=0;
        switch (sensor) {
            case 0: //temperatura
                if ( temperatura.containsKey(data)) {

                    
                    for (Integer val : temperatura.get(data)) {
                        sum += val;
                        tamanho++;
                    }

                    System.out.println("Média temperatura: " + sum / tamanho);
                }
                break;
            case 1: //humidade
                if ( humidade.containsKey(data)) {

                   
                    for (Integer val : humidade.get(data)) {
                        sum += val;
                        tamanho++;
                    }

                    System.out.println("Média humidade: " + sum / tamanho);
                }
                break;
        }
    }

   
   /**
     * Funcionalidade: Mostar os valores máximos e minimos do sensor de temperatura
     *
     * @param data dia a considerar para recolher o valor máximo nosidade
     */
    public void mostra_max_minimo_temperatura(LocalDate data) {

        if (temperatura.containsKey(data)) {
            Vector<Integer> v = temperatura.get(data);
            int max = Collections.max(v);
            int min = Collections.min(v);
            System.out.println("Max temperatura: " + max + " Min temperatura: " + min);
        }
    }
    /**
     * Funcionalidade: Mostar os valores máximos e minimos do sensor de humidade
     *
     * @param data dia a considerar para recolher o valor máximo nosidade
     */
    public void mostra_max_minimo_humidade(LocalDate data) {

        if (humidade.containsKey(data)) {
            Vector<Integer> v = humidade.get(data);
            int max = Collections.max(v);
            int min = Collections.min(v);
            System.out.println("Max humidade: " + max + " Min humidade: " + min);
        }
    }

    /**
     * Funcionalidade: Mostar os valores máximos e minimos do sensor de pressão atmosférica
     *
     * @param data dia a considerar para recolher o valor máximo nosidade
     */
    public void mostra_max_minimo_pressao_atm(LocalDate data) {

        if (pressao_atm.containsKey(data)) {
            Vector<Integer> v = pressao_atm.get(data);
            int max = Collections.max(v);
            int min = Collections.min(v);
            System.out.println("Max pressão atmosférica: " + max + " Min pressão atmosférica: " + min);
        }
    }
    
    /**
     * Funcionalidade: Mostar os valores máximos e minimos do sensor de audio
     *
     * @param data dia a considerar para recolher o valor máximo nosidade
     */
    public void mostra_max_minimo_audio(LocalDate data) {

        if (audio.containsKey(data)) {
            Vector<Integer> v = audio.get(data);
            int max = Collections.max(v);
            int min = Collections.min(v);
            System.out.println("Max Audio: " + max + " Min Audio: " + min);
        }
    }

    /**
     * Funcionalidade: Mostar os valores máximos e minimos do sensor de luminosidade
     *
     * @param data dia a considerar para recolher o valor máximo nosidade
     */
    public void mostra_max_minimo_luminosidade(LocalDate data) {

        if (luminosidade.containsKey(data)) {
            Vector<Integer> v = luminosidade.get(data);
            int max = Collections.max(v);
            int min = Collections.min(v);
            System.out.println("Max Luminosidade: " + max + " Min Luminosidade: " + min);
        }
    }

    /**
     * Mostrar dos ultimos X dias os valores máximos e minumos de um sensor
     * @param sensor sensor a mostrar
     * @param dias numero de dias a considerar desde a leitura mais actual.
     */
    public void mostra_ultimos_dias(int sensor, int dias) {

       int dias_counter = dias - 1;
        HashMap<LocalDate, Vector<Integer>> last_values = new HashMap<>();
        Vector max_min_values = new Vector();
        switch (sensor) {
            case 0: //temperatura
                LocalDate today = LocalDate.now();
                while (dias_counter >= 0) {

                    if (temperatura.containsKey(today.minusDays(dias_counter))) {
                        Vector<Integer> temp_values = temperatura.get(today.minusDays(dias_counter));
                        max_min_values.add(Collections.max(temp_values));
                        max_min_values.add(Collections.min(temp_values));
                        last_values.put(today.minusDays(dias_counter), max_min_values);

                    }
                    dias_counter -= 1;
                }
                break;
        }
        System.out.println("Valores máximos e mínimos: " + last_values.toString());
    }


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
        // Views
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
