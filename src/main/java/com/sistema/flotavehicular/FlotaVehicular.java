package com.sistema.flotavehicular;
import javax.swing.JOptionPane;
import java.util.Scanner;

public class FlotaVehicular {

    public static void main(String[] args) {

        // Crear arreglos para almacenar los vehículos, conductores y dispositivos
        Vehiculo[] flota = new Vehiculo[3];
        Conductor[] conductores = new Conductor[1];
        Dispositivo[] dispositivos = new Dispositivo[1];
        
        
        boolean continuar = true;
        int vehiculoIndex = 0; // Contador para los vehículos registrados
        
    while (continuar) {
        String menuPrincipal = "1. Administrador\n" +
                           "2. Operador\n" +
                           "3. Sistema\n" +
                           "4. Salir\n" +
                           "Seleccione una opción: ";
    String opcionStr = JOptionPane.showInputDialog(menuPrincipal);
    int opcion = opcionStr != null ? Integer.parseInt(opcionStr) : 4;
    
    switch (opcion) {
        case 1:            
            boolean adminContinuar = true;
            while (adminContinuar) {
                String menuAdmin = "1. Agregar Vehículos\n" +
                                   "2. Agregar Tareas\n" +
                                   "3. Volver\n" +
                                   "Seleccione una opción: ";
                String opcionAdminStr = JOptionPane.showInputDialog(menuAdmin);
                int opcionAdmin = opcionAdminStr != null ? Integer.parseInt(opcionAdminStr) : 3;

                switch (opcionAdmin) {
                    case 1:
                        if (vehiculoIndex >= flota.length) {
                            JOptionPane.showMessageDialog(null, "Capacidad máxima de vehículos alcanzada.");
                        break;
                }
                // Lógica para agregar vehículos
                String tipoVehiculo = JOptionPane.showInputDialog("Ingrese tipo de vehículo (Pesado/Liviano):");
                String marca = JOptionPane.showInputDialog("Ingrese marca del vehículo:");
                String matricula = JOptionPane.showInputDialog("Ingrese matrícula del vehículo:");
                int capacidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese capacidad del vehículo:"));

                VehiculoFactory vehiculoFactory = tipoVehiculo.equalsIgnoreCase("Pesado") ? new PesadoFactory() : new LivianoFactory();
                flota[vehiculoIndex] = vehiculoFactory.crearVehiculo(marca, matricula, capacidad);

                String nombreConductor = JOptionPane.showInputDialog("Ingrese nombre del conductor:");
                int edadConductor = Integer.parseInt(JOptionPane.showInputDialog("Ingrese edad del conductor:"));
                conductores[vehiculoIndex] = new Conductor(nombreConductor, edadConductor);

                vehiculoIndex++;
                JOptionPane.showMessageDialog(null, "Vehículo y conductor registrados.");
                break;
            case 2:
                // Lógica para agregar tareas
                // Aquí puedes agregar el código para manejar tareas
                break;
            case 3:
                adminContinuar = false;
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opción no válida.");
                break;
                }
            }
            break;
        case 2:
            // Lógica para el operador
            StringBuilder reporte = new StringBuilder("Reporte de Vehículos:\n");
            for (int i = 0; i < vehiculoIndex; i++) {
                if (flota[i] != null) {
                    flota[i].mostrarTipo();
                }
            }
            JOptionPane.showMessageDialog(null, reporte.toString());
            break;
        case 3:
            // Lógica para el sistema
            JOptionPane.showMessageDialog(null, "Información del sistema:\n[Detalles del sistema]");
            break;
        case 4:
            continuar = false;
            JOptionPane.showMessageDialog(null, "Saliendo del programa.");
            break;
        default:
            JOptionPane.showMessageDialog(null, "Opción no válida.");
            break;
            }
        }
    }
} 
