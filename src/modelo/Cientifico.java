package modelo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import control.BaseDatos;

public class Cientifico {

	private String dni;
	private String nombre;
	
	public Cientifico(String dni, String nombre) {
		super();
		this.dni = dni;
		this.nombre = nombre;
	}
	
	
	// Ejercicio 3 
		// CIENTIFICOS
		public static void insertaCientificosDesdeFichero(String ruta) {

			try {

				BufferedReader fichero;
				fichero = new BufferedReader(new FileReader(ruta));
				String registro;

				BaseDatos bd = new BaseDatos("localhost", "laboratorio", "root", "");
				Connection conexion = bd.getConexion();
				Statement stmt = conexion.createStatement();

				while ((registro = fichero.readLine()) != null) {
					String[] campos = registro.split(",");

					
					String dni= campos[0];
					String nombre = campos[1];
					
				
					String sql = "INSERT INTO cientificos (dni, nombre)" + " VALUES (\""+ campos[0] + "\",\""+ campos[1] + "\")";
					System.out.println(sql);
					stmt.executeUpdate(sql);
				}

				fichero.close();
				System.out.println("Fin de la lectura del fichero");
			} catch (FileNotFoundException excepcion) {
				System.out.println("fichero no encontrado");

			} catch (IOException e) {
				System.out.println("IO Excepcion");
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}

		}

	@Override
	public String toString() {
		return "Cientifico [dni=" + dni + ", nombre=" + nombre + "]";
	}
	
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
