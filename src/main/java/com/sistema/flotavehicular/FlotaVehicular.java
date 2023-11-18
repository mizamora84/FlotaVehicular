package com.sistema.flotavehicular;
import javax.swing.JOptionPane;

public class FlotaVehicular {

    public static void main(String[] args) {

        // Crear arreglos para almacenar los vehículos, conductores y dispositivos
        Vehiculo[] flota = new Vehiculo[3];
        Conductor[] conductores = new Conductor[1];
        Dispositivo[] dispositivos = new Dispositivo[1];

        // Utilizar la fábrica para crear un vehículo pesado y agregarlo al arreglo
        VehiculoFactory pesadoFactory = new PesadoFactory();
        flota[0] = pesadoFactory.crearVehiculo("Volvo", "ABC123", 5000);

        // Crear un conductor y agregarlo al arreglo
        Conductor conductor = new Conductor("Juan", 22);
        conductores[0] = conductor;

        // Utilizar la fábrica para crear un vehículo liviano y agregarlo al arreglo
        VehiculoFactory livianoFactory = new LivianoFactory();
        flota[1] = livianoFactory.crearVehiculo("Toyota", "XYZ789", 5);
        flota[2] = livianoFactory.crearVehiculo("Toyota", "XYZ789", 5);

        // Utilizar la fábrica para crear un dispositivo y agregarlo al arreglo
        DispositivoFactory sensorFactory = new SensorFactory();
        dispositivos[0] = sensorFactory.crearDispositivo("gps", 22);
        JOptionPane.showMessageDialog(null,"       ¿Por qué sos tan hermoso, Cristian?      ");

        // Iterar sobre el arreglo y mostrar el tipo de cada vehículo
        for (Vehiculo vehiculo : flota) {
            vehiculo.mostrarTipo();
        }

        // Iterar sobre el arreglo y mostrar información de cada dispositivo
        for (Dispositivo dispositivo : dispositivos) {
            dispositivo.mostrarInfoDispositivo();
        }
    }
}
