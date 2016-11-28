Alterações que fiz

- criei view
    - meti lá os mostrar todos
- meti main na class XDK
- apaguei iterator da weatherStation
- apaguei cenas do constructor da weather station
- alterei comentarios
- Subdividi o método mostra_max_minimo em métodos mais pequenos
- alterei nome de método mostra_presao_atm para mostra_pressao_atm
- alterei nome de método mostra_luminusidade para mostra_luminosidade
- alterei print do mostra_temperatura
- alterei print do mostra_luminosidade


Na classe weatherStation:
-instanciei os vectores fora.

Classe view:

método mostra_temperatura()
- localDate fora do if

método mostra_humidade()
- localDate fora do if
método mostra_mostra_pressao_atm()
- localDate fora do if
método mostra_audio()
- localDate fora do if
método mostra_luminosidade()
- localDate fora do if


método mostra_media
- sum fora do switch
- mudança do comentario da humidade (estava temperatura)
- tirei o “false!=“  não faz sentido

metodo mostra_max_minimo_tempertura()
- tirei o “false!=“  não faz sentido

metodo mostra_max_minimo_humidade()
- tirei o “false!=“  não faz sentido
metodo mostra_max_minimo_pressao_atm()
- tirei o “false!=“  não faz sentido
metodo mostra_max_minimo_audio()
- tirei o “false!=“  não faz sentido
metodo mostra_max_minimo_luminosidade()
- tirei o “false!=“  não faz sentido

metodo mostra_ultimos_dias
- tirei o “false!=“  não faz sentido
- tirei os operandos do hashmap
