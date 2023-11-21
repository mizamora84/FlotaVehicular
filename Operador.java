package com.sistema.flotavehicular;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author mizam
 */
public class Operador {

    public static void observador(ArrayList<String> flotax, ArrayList<String> tareas) {
        while (true) { // Comenzar un bucle infinito para mostrar el menú
            int opcion = 0; // Valor predeterminado
            String menuAdministrador = "1. Mostrar flota\n"
                    + "2. Mostrar Tareas\n"
                    + "3. Volver al Menu Principal\n"
                    + "Seleccione una opción: ";

            String opcionStr = JOptionPane.showInputDialog(menuAdministrador);
            if (opcionStr != null) {
                try {
                    opcion = Integer.parseInt(opcionStr);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Por favor, ingrese un número válido.");
                    continue;// Continuar con la siguiente iteración del bucle
                }
            } else {
                return; // Salir del método si el usuario cierra el diálogo o presiona cancelar
            }

            switch (opcion) {
                case 1:
                    if(!flotax.isEmpty()){
                    JOptionPane.showMessageDialog(null, flotax);
                    }
                    else {
                    JOptionPane.showMessageDialog(null, "No hay vehiculos registtrados.");
                    }
                    break;

                case 2:
                    if(!tareas.isEmpty()){
                    JOptionPane.showMessageDialog(null, tareas);
                    }
                    else { 
                        JOptionPane.showMessageDialog(null, "No hay tareas registtradas.");
                    }
                    break;
                 
                case 3:
                    
                    return;
                
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida.");
                    break;
                    
                    
                    
                
            }
        }
    }
}
