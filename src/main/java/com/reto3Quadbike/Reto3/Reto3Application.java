/**  
 * REVISAR DE NUEVO HAY MUCHOS ERRORES ---
 * 
 * 
 * COMPLETOS
 * 1. Parte 1 -> https://www.youtube.com/watch?v=81-zDQw_HFs&ab_channel=PaulaAndreaMartinez --------> 2:05:09
 * 2. Parte 2 -> https://www.youtube.com/watch?v=9Ybd42-6pZI&ab_channel=PaulaAndreaMartinez
 * 3. Parte 3-> https://www.youtube.com/watch?v=0sNQkejIT2g&ab_channel=PaulaAndreaMartinez
 * ----> https://drive.google.com/drive/u/1/folders/110R2f1TpvbWL8Y-t7herYzhk2jzvMA5a
 * 
 * Elementos a crear
 * 1. Crear Clase modelo o entidad
 * 2. Crear una interfase
 * 3. Crear un repositorio
 * 4. Crear un servicio
 * 5. Crear un controlador web (API web)
 * 
 * -> Por cada tabla se van a realizar estos 5 procedimientos
 * 
 * Creacion de tablas:
 * 1. tabla quadbike -> Tabla base de todas las demas ----- (DONE)
 * 2. Tabla categoria ------------------------------------- (DONE)
 * 3. Tabla cliente --------------------------------------- (DONE)
 * 4. Tabla mensaje --------------------------------------- (DONE)
 * 5. Tabla reservaciones --------------------------------- (DONE)
 */
package com.reto3Quadbike.Reto3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Reto3Application {

	public static void main(String[] args) {
		SpringApplication.run(Reto3Application.class, args);
	}

}
