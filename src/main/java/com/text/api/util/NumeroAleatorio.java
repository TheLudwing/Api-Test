package com.text.api.util;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import org.springframework.stereotype.Component;


@Component
public class NumeroAleatorio {
	    private Set<String> numerosGenerados = new HashSet<>();
	    private Random random = new Random();

	    public String generarNumeroUnico() {
	        if (numerosGenerados.size() >= 10001) { // 0.00 a 100.00 = 10001 posibles valores
	            throw new IllegalStateException("No hay más números únicos disponibles");
	        }

	        String numero;
	        do {
	            // Generar número entre 0 y 100 con 2 decimales
	            double numeroDouble = random.nextDouble() * 100;
	            numero = String.format("%.2f", numeroDouble);
	        } while (numerosGenerados.contains(numero));

	        numerosGenerados.add(numero);
	        return numero;
	    }

	    // Método para limpiar los números generados si es necesario
	    public void reiniciar() {
	        numerosGenerados.clear();
	    }

	    // Método para ver cuántos números únicos se han generado
	    public int getCantidadGenerados() {
	        return numerosGenerados.size();
	    
	}
}
