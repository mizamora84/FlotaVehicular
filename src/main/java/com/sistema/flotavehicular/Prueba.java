package com.sistema.flotavehicular;

import java.util.Scanner;
import javax.swing.JOptionPane;

public class Prueba {
    public static void main(String[] args) {
        
        
    // Crear arreglos para almacenar los vehículos, conductores y dispositivos
        Vehiculo[] flota = new Vehiculo[3];
        Conductor[] conductores = new Conductor[1];
        Dispositivo[] dispositivos = new Dispositivo[1];
           
        boolean continuar = true;
        
        while (continuar) {
            // Menú principal
            String menuPrincipal = "1. Administrador\n" +
                                   "2. Operador\n" +
                                   "3. Sistema\n" +
                                   "4. Salir\n" +
                                   "Seleccione una opción: ";
            String opcionStr = JOptionPane.showInputDialog(menuPrincipal);
            int opcionPrincipal = opcionStr != null ? Integer.parseInt(opcionStr) : 4;

            switch (opcionPrincipal) {
                case 1:
                    // Administrador: Mostrar menú para añadir vehículo y tarea
                    administradorMenu(flota, conductores, dispositivos);
                    break;
                case 2:
                    // Operador
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
                vehiculo.mostrarTipo();
            }
        }

        // Iterar sobre el arreglo y mostrar información de cada dispositivo
        for (Dispositivo dispositivo : dispositivos) {
            if (dispositivo != null) {
                dispositivo.mostrarInfoDispositivo();
            }
        }
}
    
        
    private static void administradorMenu(Vehiculo[] flota, Conductor[] conductores, Dispositivo[] dispositivos) {
       while (true) { // Comenzar un bucle infinito para mostrar el menú
        int opcion = 0; // Valor predeterminado
        String menuAdministrador = "1. Añadir Vehículo\n" +
                                   "2. Agregar Tarea\n" +
                                   "3. Volver al Menu Principal\n" +
                                   "Seleccione una opción: ";
        
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
                String menuTipoVehiculo = "1. Añadir Vehículo Pesado\n" +
                                          "2. Añadir Vehículo Liviano\n" +
                                          "Seleccione una opción: ";
                
    String opcionTipoVehiculoStr = JOptionPane.showInputDialog(menuTipoVehiculo);
    int opcionTipoVehiculo = Integer.parseInt(opcionTipoVehiculoStr);

    switch (opcionTipoVehiculo) {
        case 1:
            // Utilizar la fábrica para crear un vehículo pesado y agregarlo al arreglo
            VehiculoFactory pesadoFactory = new PesadoFactory();
            flota[0] = pesadoFactory.crearVehiculo("Volvo", "ABC123", 5000);
            // Crear un conductor y agregarlo al arreglo
            Conductor conductorPesado = new Conductor("Juan", 22);
            conductores[0] = conductorPesado;
            // Utilizar la fábrica para crear un dispositivo y agregarlo al arreglo
            SensorFactory sensorFactoryPesado = new SensorFactory();
            dispositivos[0] = sensorFactoryPesado.crearDispositivo("gps", 22);
            JOptionPane.showMessageDialog(null, "Vehículo pesado añadido.");
            break;

        case 2:
            // Utilizar la fábrica para crear un vehículo liviano y agregarlo al arreglo
            VehiculoFactory livianoFactory = new LivianoFactory();
            flota[1] = livianoFactory.crearVehiculo("Toyota", "XYZ789", 5);
            flota[2] = livianoFactory.crearVehiculo("Toyota", "XYZ789", 5);
            // Crear un conductor y agregarlo al arreglo
            Conductor conductorLiviano = new Conductor("Juan", 22);
            conductores[1] = conductorLiviano;
            // Utilizar la fábrica para crear un dispositivo y agregarlo al arreglo
            SensorFactory sensorFactoryLiviano = new SensorFactory();
            dispositivos[1] = sensorFactoryLiviano.crearDispositivo("gps", 22);
            JOptionPane.showMessageDialog(null, "Vehículo liviano añadido.");
            break;
    }
    break;
                
                
            case 2:
                JOptionPane.showMessageDialog(null, "Seleccione los vehículos a añadir tareas");
                for (Vehiculo vehiculo : flota) {
                     if (vehiculo != null) { // Asegúrate de que el vehículo no sea nulo antes de llamar a métodos en él
                        vehiculo.mostrarTipo();
                    }
                } // Esta llave cierra el bucle for
                JOptionPane.showMessageDialog(null, "Tarea agregada.");
                break;
                
            case 3:
                return; // Volver al menú principal
            default:
                JOptionPane.showMessageDialog(null, "Opción no válida.");
                break;
            }
        }
    }
}       






