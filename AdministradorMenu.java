package com.sistema.flotavehicular;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author mizam
 */
public class AdministradorMenu {

    public static void administrador(ArrayList<Vehiculo> flota, ArrayList<Conductor> conductores, ArrayList<Dispositivo> dispositivos, ArrayList<String> flotax, ArrayList<String> tareas) {
        while (true) { // Comenzar un bucle infinito para mostrar el menú
            int opcion = 0; // Valor predeterminado
            String menuAdministrador = "1. Añadir Vehículo\n"
                    + "2. Agregar Tarea\n"
                    + "3. Mostrar Flota\n"
                    + "4. Volver al Menu Principal\n"
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

                    String menuTipoVehiculo = "1. Añadir Vehículo Pesado\n"
                            + "2. Añadir Vehículo Liviano\n"
                            + "Seleccione una opción: ";

                    String opcionTipoVehiculoStr = JOptionPane.showInputDialog(menuTipoVehiculo);
                    int opcionTipoVehiculo = Integer.parseInt(opcionTipoVehiculoStr);
                    String tipo = "";//variable que dice que tipo de vehiculo es.

                    switch (opcionTipoVehiculo) {
                        case 1:
                            // Bloque similar al primero pero para Vehículo Liviano
                            String marca = JOptionPane.showInputDialog("Ingrese la marca del vehiculo");
                            String matricula = JOptionPane.showInputDialog("Ingrese la Matricula del vehiculo");
                            String capacidad = JOptionPane.showInputDialog("Ingrese la capacidad del vehiculo");
                            String nombre = JOptionPane.showInputDialog("Ingrese el nombre del conductor del vehiculo");
                            String id = JOptionPane.showInputDialog("Ingrese el ID, del conductor");
                            String numero = JOptionPane.showInputDialog("Ingrese el NUMERO, del dispositivo GPS del vehiculo ");

                            if (opcionTipoVehiculo == 1) {
                                tipo = "(Vehiculo Pesado) ";
                            }
                            //Definiendo factory
                            VehiculoFactory pesadoFactory = new PesadoFactory();
                            TrabajadoresFactory ConductorFactory = new ConductorFactory();
                            SensorFactory sensorFactorypesado = new SensorFactory();

                            //AGREGANDO DATOS AL LOS ARREGLOS
                            Vehiculo vehiculop = new Pesado(marca, matricula, capacidad);//inicializa Pesado para usar los metodos
                            Dispositivo sensor = new Sensor("GPS", numero);
                            Trabajadores conductor = new Conductor(nombre, id);

                            conductores.add((Conductor) ConductorFactory.crearTrabajador(nombre, id));
                            dispositivos.add(sensorFactorypesado.crearDispositivo("gps", numero));

                            flotax.add(vehiculop.mostrarVehiculofull() + tipo + conductor.mostrarTrabajadores() + sensor.mostrarInfoDispositivo() + "\n"); //asigna los datos de vehiculop a un arraylist

                            JOptionPane.showMessageDialog(null, "Vehículo Pesado añadido.");

                            // Recorrer y mostrar el contenido de los ArrayLists de manera legible
                            break;

                        case 2:

                            marca = JOptionPane.showInputDialog("Ingrese la marca del vehiculo");
                            matricula = JOptionPane.showInputDialog("Ingrese la Matricula del vehiculo");
                            capacidad = JOptionPane.showInputDialog("Ingrese la capacidad del vehiculo");
                            nombre = JOptionPane.showInputDialog("Ingrese el nombre del conductor del vehiculo");
                            id = JOptionPane.showInputDialog("Ingrese el ID, del conductor");
                            numero = JOptionPane.showInputDialog("Ingrese el NUMERO, del dispositivo GPS del vehiculo");

                            if (opcionTipoVehiculo == 2) {
                                tipo = "(Vehiculo Liviano)";
                            }
                            //Definiendo factory
                            VehiculoFactory livianoFactory = new LivianoFactory();
                            TrabajadoresFactory ConductorFactoryL = new ConductorFactory();
                            SensorFactory sensorFactoryLiviano = new SensorFactory();

                            //AGREGANDO DATOS AL LOS ARREGLOS
                            Vehiculo vehiculo = new Liviano(marca, matricula, capacidad);
                            Dispositivo sensorL = new Sensor("GPS", numero);
                            Trabajadores conductorL = new Conductor(nombre, id);

                            conductores.add((Conductor) ConductorFactoryL.crearTrabajador(nombre, id));
                            dispositivos.add(sensorFactoryLiviano.crearDispositivo("GPS", numero));

                            flotax.add(vehiculo.mostrarVehiculofull() + tipo + conductorL.mostrarTrabajadores() + sensorL.mostrarInfoDispositivo() + "\n"); //asigna los datos de vehiculop a un arraylist

                            JOptionPane.showMessageDialog(null, "Vehículo liviano añadido.");

                        // Recorrer y mostrar el contenido de los ArrayLists de manera legible
                    }//opcion tipo de vehiculo
                    break;
                case 2:
                    if(!flotax.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Seleccione los vehículos a los que se asignarán tareas");
                    StringBuilder mensaje = new StringBuilder();

                    for (int i = 0; i < flotax.size(); i++) {
                        mensaje.append("Vehiculo ").append(i + 1).append(": ").append(flotax.get(i)).append("\n");
                    }

                    int indice = -1;
                    try {
                        indice = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el número del vehiculo que va a asignar la tarea\n" + mensaje)) - 1;
                        if (indice < 0 || indice >= flotax.size()) {
                            JOptionPane.showMessageDialog(null, "El número de vehículo ingresado no es válido");
                        } else {
                            String elementoSeleccionado = flotax.get(indice);

                            // Inicializar la tarea antes de asignar valores

                            String descripcion = JOptionPane.showInputDialog("Ingrese la descripción de la tarea para el vehículo " + elementoSeleccionado);
                            String prioridad = JOptionPane.showInputDialog("Ingrese la prioridad de la tarea para el vehículo " + elementoSeleccionado);
                           Tarea tarea = new Tarea(descripcion,prioridad,elementoSeleccionado);

                            String tareaAsignada = tarea.AsignarTarea(elementoSeleccionado, descripcion, prioridad + "\n");
                            tareas.add(tareaAsignada);

                            JOptionPane.showMessageDialog(null, "Mostrando tareas asignadas\n" + tareas);
                        }
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Ingrese un número válido para el vehículo");
                    }
                    }
                    else{                        JOptionPane.showMessageDialog(null, "No hay vehiculos registrados");
}
                    break;

                case 3:

                    JOptionPane.showMessageDialog(null, flotax);

                case 4:

                    return; // Volver al menú principal
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida.");
                    break;
            }
        }
    }
}
