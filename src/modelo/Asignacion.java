package modelo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import control.BaseDatos;

public class Asignacion {
	private String cientifico;
	private int proyecto;
	
	
	public Asignacion(String cientifico, int proyecto) {
		super();
		this.cientifico = cientifico;
		this.proyecto = proyecto;
	}
	
	// ASIGNACIONES
		public static void insertaAsignacionesDesdeFichero(String ruta) {

			try {

				BufferedReader fichero;
				fichero = new BufferedReader(new FileReader(ruta));
				String registro;

				BaseDatos bd = new BaseDatos("localhost", "laboratorio", "root", "");
				Connection conexion = bd.getConexion();
				Statement stmt = conexion.createStatement();

				while ((registro = fichero.readLine()) != null) {
					String[] campos = registro.split(",");

					
					String cientifico= campos[0];
					int proyecto = Integer.parseInt(campos[1]);
					
				
					String sql = "INSERT INTO asignaciones (cientifico, proyecto)" + " VALUES (\"" + campos[0] + "\", \""
							+ campos[1] + "\")";
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
		return "Asignacion [cientifico=" + cientifico + ", proyecto=" + proyecto + "]";
	}
	
	public String getCientifico() {
		return cientifico;
	}
	public void setCientifico(String cientifico) {
		this.cientifico = cientifico;
	}
	public int getProyecto() {
		return proyecto;
	}
	public void setProyecto(int proyecto) {
		this.proyecto = proyecto;
	}
	
	
}
