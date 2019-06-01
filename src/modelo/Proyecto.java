package modelo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import control.BaseDatos;

public class Proyecto {
	
	private int id;
	private String nombre;
	private int horas;
	
	
	public Proyecto(int id, String nombre, int horas) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.horas = horas;
	}
	
	// PROYECTOS
		public static void insertaProyectosDesdeFichero(String ruta) {

			try {

				BufferedReader fichero;
				fichero = new BufferedReader(new FileReader(ruta));
				String registro;

				BaseDatos bd = new BaseDatos("localhost", "laboratorio", "root", "");
				Connection conexion = bd.getConexion();
				Statement stmt = conexion.createStatement();

				while ((registro = fichero.readLine()) != null) {
					String[] campos = registro.split(",");

					
					int id= Integer.parseInt(campos[0]);
					String proyecto= campos[1];
					int horas= Integer.parseInt(campos[0]);
				
					String sql = "INSERT INTO proyectos (id, nombre, horas)" + " VALUES (\"" + campos[0] + "\",\""+ campos[1] + "\",\"" + campos[2] + "\")";
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
		return "Proyecto [id=" + id + ", nombre=" + nombre + ", horas=" + horas + "]";
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getHoras() {
		return horas;
	}
	public void setHoras(int horas) {
		this.horas = horas;
	}
	
	
	

}
