package com.sistema.flotavehicular;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Prueba {

    public static void main(String[] args) {

        // Crear arreglos para almacenar los vehículos, conductores y dispositivos
        ArrayList<Vehiculo> flota = new ArrayList<>();

        // Crear ArrayList de arrays de Conductor
        ArrayList<Conductor> conductores = new ArrayList<>();

        // Crear ArrayList de arrays de Dispositivo
        ArrayList<Dispositivo> dispositivos = new ArrayList<>();

        ArrayList<String> flotax = new ArrayList<>();

        ArrayList<String> tareas = new ArrayList<>();

        boolean continuar = true;

        while (continuar) {
            // Menú principal
            String menuPrincipal = "1. Administrador\n"
                    + "2. Operador\n"
                    + "3. Sistema\n"
                    + "4. Salir\n"
                    + "Seleccione una opción: ";
            String opcionStr = JOptionPane.showInputDialog(menuPrincipal);
            int opcionPrincipal = opcionStr != null ? Integer.parseInt(opcionStr) : 4;

            switch (opcionPrincipal) {
                case 1:
                    // Administrador: Mostrar menú para añadir vehículo y tarea
                    AdministradorMenu.administrador(flota, conductores, dispositivos, flotax, tareas);

                    break;
                case 2:
                
                    Operador.observador(flotax, tareas);
                     // Aquí puedes agregar la lógica para el menú del Operador
                    break;
                case 3:
                    // Sistema
                    // Aquí puedes agregar la lógica para el menú del Sistema
                    break;
                case 4:
                    // Salir del programa
                    continuar = false;
                    JOptionPane.showMessageDialog(null, "Saliendo del programa.");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida.");
                    break;
            }
        }

        // Iterar sobre el arreglo y mostrar el tipo de cada vehículo
        for (Vehiculo vehiculo : flota) {
            if (vehiculo != null) {
            }
        }

        // Iterar sobre el arreglo y mostrar información de cada dispositivo
        for (Dispositivo dispositivo : dispositivos) {
            if (dispositivo != null) {
                dispositivo.mostrarInfoDispositivo();
            }
        }
    }

}
