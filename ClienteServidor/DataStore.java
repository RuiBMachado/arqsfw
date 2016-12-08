package datastore;

import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.Collections;
import java.util.HashMap;
import java.util.Vector;

public class DataStore implements DataStoreInterface {

    /**
     * Data objects
     *
     * Registos do valor de temperaturas Registos do valor de humidade Registos
     * do valor de pressÃ£o atmosfÃ©rica Registos de audio Registos de
     * luminosidade
     *
     */
    HashMap<LocalDate, Vector<Integer>> temperatura;
    HashMap<LocalDate, Vector<Integer>> humidade;
    HashMap<LocalDate, Vector<Integer>> pressao_atm;
    HashMap<LocalDate, Vector<Integer>> audio;
    HashMap<LocalDate, Vector<Integer>> luminosidade;

    public DataStore() {
        this.humidade = new HashMap<>();
        this.temperatura = new HashMap<>();
        this.audio = new HashMap<>();
        this.luminosidade = new HashMap<>();
        this.pressao_atm = new HashMap<>();
    }

    /**
     * A estÃ§Ã£o meteriologica recebe updates dos sensores e armazena os
     * valores na estrutura de dados respectiva.
     *
     * @param id identificador do sensor XDK
     * @param values parametros lidos pelo sensor posiÃ§Ã£o 0 : temperatura
     * posiÃ§Ã£o 1 : humidade posiÃ§Ã£o 2 : pressÃ£o atmosfÃ©ria posiÃ§Ã£o 3 :
     * audio posiÃ§Ã£o 4 : luminosidade
     *
     */
    @Override
    public void update(int id, Vector<Integer> values) {

        switch (id) {
            case 1: // XDK exterior

                if (this.temperatura.get(LocalDate.now()) != null) {
                    Vector<Integer> val_temp = temperatura.get(LocalDate.now());
                    val_temp.add(values.elementAt(0));
                } else {
                    Vector<Integer> new_vector = new Vector<Integer>();
                    new_vector.add(values.elementAt(0));
                    temperatura.put(LocalDate.now(), new_vector);
                }
                if (this.humidade.get(LocalDate.now()) != null) {
                    Vector<Integer> val_temp = humidade.get(LocalDate.now());
                    val_temp.add(values.elementAt(1));
                } else {
                    Vector<Integer> new_vector = new Vector<Integer>();
                    new_vector.add(values.elementAt(1));
                    humidade.put(LocalDate.now(), new_vector);
                }

                if (this.pressao_atm.get(LocalDate.now()) != null) {
                    Vector<Integer> val_temp = pressao_atm.get(LocalDate.now());
                    val_temp.add(values.elementAt(2));
                } else {
                    Vector<Integer> new_vector = new Vector<Integer>();
                    new_vector.add(values.elementAt(2));
                    pressao_atm.put(LocalDate.now(), new_vector);
                }

                if (this.audio.get(LocalDate.now()) != null) {
                    Vector<Integer> val_temp = audio.get(LocalDate.now());
                    val_temp.add(values.elementAt(3));
                } else {
                    Vector<Integer> new_vector = new Vector<Integer>();
                    new_vector.add(values.elementAt(3));
                    audio.put(LocalDate.now(), new_vector);
                }
                if (this.luminosidade.get(LocalDate.now()) != null) {
                    Vector<Integer> val_temp = luminosidade.get(LocalDate.now());
                    val_temp.add(values.elementAt(4));
                } else {
                    Vector<Integer> new_vector = new Vector<Integer>();
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
     *
     * @return print da temperatura
     */
    @Override
    public String mostra_temperatura() {
        String r;
        int i = -100;
        LocalDate localDate = LocalDate.now();

        if (temperatura.containsKey(localDate)) {
            Vector<Integer> valores = temperatura.get(localDate);
            int size = valores.size();
            i = valores.elementAt(size - 1);
        }        
        r = "Temperatura Actual: " + i;
        
        return r;
    }

    @Override
    public String mostra_humidade() {
        String r;
        int value = -100;
        LocalDate localDate = LocalDate.now();

        if (humidade.containsKey(localDate)) {
            Vector<Integer> valores = humidade.get(localDate);
            int size = valores.size();
            value = valores.elementAt(size - 1);
        }        
        r = "Humidade Actual: " + value;
        
        return r;
    }

    @Override
    public String mostra_presao_atm() {
        String r;
        int value = -100;
        LocalDate localDate = LocalDate.now();
        if (pressao_atm.containsKey(localDate)) {
            Vector<Integer> valores = pressao_atm.get(localDate);
            int size = valores.size();
            value = valores.elementAt(size - 1);
        }        
        r = "pressÃ£o atmosfÃ©rica actual: " + value;
        
        return r;
    }

    @Override
    public String mostra_audio() {
        String r;
        int value = -100;
        LocalDate localDate = LocalDate.now();

        if (audio.containsKey(localDate)) {
            Vector<Integer> valores = audio.get(localDate);
            int size = valores.size();
            value = valores.elementAt(size - 1);
        }        
        r = "Audio actual: " + value;
        
        return r;
    }

    @Override
    public String mostra_luminusidade() {
        String r;
        int value = -100;
        LocalDate localDate = LocalDate.now();

        if (luminosidade.containsKey(localDate)) {
            Vector<Integer> valores = luminosidade.get(localDate);
            int size = valores.size();
            value = valores.elementAt(size - 1);
        }
        r = "Luminosidade actual: " + value;
        
        return r;
    }

    /**
     * Funcionalidade: mostra a mÃ©dia da temperatura para um determinado dia
     *
     * @param data dia a considerar para a mÃ©dia
     * @param sensor sensor a calcular: 0 temperatura
     */
    @Override
    public String mostra_media(LocalDate data, int sensor) {
        String r = "Sensor inválido.";
        int sum = 0;
        int tamanho = 0;
        
        switch (sensor) {
            case 0: //temperatura
                if (temperatura.containsKey(data)) {

                    for (Integer val : temperatura.get(data)) {
                        sum += val;
                        tamanho++;
                    }
                    r = "MÃ©dia temperatura: " + sum / tamanho;
                }
                break;
            case 1: //humidade
                if (humidade.containsKey(data)) {

                    for (Integer val : humidade.get(data)) {
                        sum += val;
                        tamanho++;
                    }

                    r = "MÃ©dia humidade: " + sum / tamanho;
                }
                break;
        }
        
        return r;
    }

    /**
     * Funcionalidade: Mostar os valores mÃ¡ximos e minimos do sensor de
     * temperatura
     *
     * @param data dia a considerar para recolher o valor mÃ¡ximo nosidade
     */
    @Override
    public String mostra_max_minimo_temperatura(LocalDate data) {
        String r = "Data inválida.";
        
        if (temperatura.containsKey(data)) {
            Vector<Integer> v = temperatura.get(data);
            int max = Collections.max(v);
            int min = Collections.min(v);
            r = "Max temperatura: " + max + " Min temperatura: " + min;
        }
        
        return r;
    }

    /**
     * Funcionalidade: Mostar os valores mÃ¡ximos e minimos do sensor de
     * humidade
     *
     * @param data dia a considerar para recolher o valor mÃ¡ximo nosidade
     */
    @Override
    public String mostra_max_minimo_humidade(LocalDate data) {
        String r = "Data inválida.";
        
        if (humidade.containsKey(data)) {
            Vector<Integer> v = humidade.get(data);
            int max = Collections.max(v);
            int min = Collections.min(v);
            r = "Max humidade: " + max + " Min humidade: " + min;
        }
        
        return r;
    }

    /**
     * Funcionalidade: Mostar os valores mÃ¡ximos e minimos do sensor de
     * pressÃ£o atmosfÃ©rica
     *
     * @param data dia a considerar para recolher o valor mÃ¡ximo nosidade
     */
    @Override
    public String mostra_max_minimo_pressao_atm(LocalDate data) {
        String r = "Data inválida.";
        
        if (pressao_atm.containsKey(data)) {
            Vector<Integer> v = pressao_atm.get(data);
            int max = Collections.max(v);
            int min = Collections.min(v);
            r = "Max pressÃ£o atmosfÃ©rica: " + max + " Min pressÃ£o atmosfÃ©rica: " + min;
        }
        
        return r;
    }

    /**
     * Funcionalidade: Mostar os valores mÃ¡ximos e minimos do sensor de audio
     *
     * @param data dia a considerar para recolher o valor mÃ¡ximo nosidade
     */
    @Override
    public String mostra_max_minimo_audio(LocalDate data) {
        String r = "Data inválida.";
        
        if (audio.containsKey(data)) {
            Vector<Integer> v = audio.get(data);
            int max = Collections.max(v);
            int min = Collections.min(v);
            r = "Max Audio: " + max + " Min Audio: " + min;
        }
        
        return r;
    }

    /**
     * Funcionalidade: Mostar os valores mÃ¡ximos e minimos do sensor de
     * luminosidade
     *
     * @param data dia a considerar para recolher o valor mÃ¡ximo nosidade
     */
    @Override
    public String mostra_max_minimo_luminosidade(LocalDate data) {
        String r = "Data inválida.";
        
        if (luminosidade.containsKey(data)) {
            Vector<Integer> v = luminosidade.get(data);
            int max = Collections.max(v);
            int min = Collections.min(v);
            r = "Max Luminosidade: " + max + " Min Luminosidade: " + min;
        }
        
        return r;
    }

    /**
     * Mostrar dos ultimos X dias os valores mÃ¡ximos e minumos de um sensor
     *
     * @param sensor sensor a mostrar
     * @param dias numero de dias a considerar desde a leitura mais actual.
     */
    @Override
    public String mostra_ultimos_dias(int sensor, int dias) {
        String r;
        int dias_counter = dias - 1;
        HashMap<LocalDate, Vector<Integer>> last_values = new HashMap<>();
        Vector max_min_values = new Vector();

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
        r = "Valores mÃ¡ximos e mÃ­nimos: " + last_values.toString();
        
        return r;
    }

}
