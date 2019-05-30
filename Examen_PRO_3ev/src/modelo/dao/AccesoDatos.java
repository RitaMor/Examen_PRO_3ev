package modelo.dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import control.BaseDatos;
import modelo.Asignacion;
import modelo.Cientifico;
import modelo.Proyecto;

public class AccesoDatos {
	
	
	
	
	
	public void recorreTabla() {
		// Mostrar por consola ...
		// CONECTAR A LA BBDD.

		try {
			BaseDatos bd = new BaseDatos("localhost", "laboratorio", "root", "");
			Connection conexion = bd.getConexion();
			Statement stmt = conexion.createStatement();
			ResultSet rS = stmt.executeQuery("SELECT * FROM Asignaciones "); // para escribir cambia execute query por
																				// executeUpdate
			ResultSetMetaData mD = rS.getMetaData();
			mD.getColumnCount(); // Número de columnas
			System.out.println(mD.getColumnName(1)+"\t\t"+mD.getColumnName(2)); // nombre de la columna

			while (rS.next()) {
				System.out.println(rS.getString(1) + "\t\t" + rS.getString(2));

			}
			rS.close();
			stmt.close();
			conexion.close();

		} catch (SQLException e) {

			System.out.println(e.getMessage());
		}

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
	
	// Ejercicio 6 - ArrayList de String generico
		public ArrayList<String> creaListaBDGenerica(String bdatos, String tabla) {
			// Mostrar por consola TODOS LOS DATOS...
			// CONECTAR A LA BBDD.

			try {
				BaseDatos bd = new BaseDatos("localhost", bdatos, "root", "");
				Connection conexion = bd.getConexion();
				Statement stmt = conexion.createStatement();
				ResultSet rS = stmt.executeQuery("SELECT * FROM " + tabla + " WHERE 1 ");
				ResultSetMetaData mD = rS.getMetaData();
				
				System.out.println();
				System.out.println("ArrayList genérico");
				
				ArrayList<String> listado = new ArrayList<>();
				for (int i = 0; i < mD.getColumnCount(); i++) {
					System.out.printf("%-27s",i + " -> " + mD.getColumnName(i+1));
				}
				System.out.println();
				while (rS.next()) {
					
					for (int i = 1; i <mD.getColumnCount()+1; i++) {
						
						listado.add(rS.getString(i));
						
						
						System.out.printf("%-27s", rS.getString(i));
						
					}System.out.println();
					
			
				}

				rS.close();
				stmt.close();
				conexion.close();
				return listado;

			} catch (SQLException e) {

				System.out.println(e.getMessage());
			}
			return null;

		}
	
		// Ejercicio 7 Array de objeto
		
		public ArrayList<Cientifico> creaListaCientificosBD(String bdatos, String tabla) {
			// Mostrar por consola TODOS LOS EQUIPOS...
			// CONECTAR A LA BBDD.

			try {
				BaseDatos bd = new BaseDatos("localhost", bdatos, "root", "");
				Connection conexion = bd.getConexion();
				Statement stmt = conexion.createStatement();
				ResultSet rS = stmt.executeQuery("SELECT * FROM " + tabla + " WHERE 1 ");
				ResultSetMetaData mD = rS.getMetaData();
				
				ArrayList<Cientifico> listaCientifico = new ArrayList<>();
				Cientifico cientifico;
				System.out.println(":: LISTA CIENTIFICO ::");
				while (rS.next()) {
					
					String dni = rS.getString("dni");
					String nombre = rS.getString("nombre");
					
					cientifico = new Cientifico(dni, nombre);
					listaCientifico.add(cientifico);
					System.out.println(cientifico);
				}

				rS.close();
				stmt.close();
				conexion.close();
				return listaCientifico;

			} catch (SQLException e) {

				System.out.println(e.getMessage());
			}
			return null;

		}
		
		
		
		public ArrayList<Proyecto> creaListaProyectoBD(String bdatos, String tabla) {
			// Mostrar por consola TODOS LOS EQUIPOS...
			// CONECTAR A LA BBDD.

			try {
				BaseDatos bd = new BaseDatos("localhost", bdatos, "root", "");
				Connection conexion = bd.getConexion();
				Statement stmt = conexion.createStatement();
				ResultSet rS = stmt.executeQuery("SELECT * FROM " + tabla + " WHERE 1 ");
				ResultSetMetaData mD = rS.getMetaData();
				
				ArrayList<Proyecto> listaProyecto = new ArrayList<>();
				Proyecto proyecto;
				System.out.println(":: LISTA PROYECTO::");
				while (rS.next()) {
					int id = Integer.parseInt(rS.getString(1));
					String nombre = rS.getString("nombre");
					int horas = Integer.parseInt(rS.getString(3));
					
					proyecto = new Proyecto(id, nombre, horas);
					listaProyecto.add(proyecto);
					System.out.println(proyecto);
				}

				rS.close();
				stmt.close();
				conexion.close();
				return listaProyecto;

			} catch (SQLException e) {

				System.out.println(e.getMessage());
			}
			return null;

		}

		public ArrayList<Asignacion> creaListaAsignacionesBD(String bdatos, String tabla) {
			// Mostrar por consola TODOS LOS EQUIPOS...
			// CONECTAR A LA BBDD.

			try {
				BaseDatos bd = new BaseDatos("localhost", bdatos, "root", "");
				Connection conexion = bd.getConexion();
				Statement stmt = conexion.createStatement();
				ResultSet rS = stmt.executeQuery("SELECT * FROM " + tabla + " WHERE 1 ");
				ResultSetMetaData mD = rS.getMetaData();
				
				ArrayList<Asignacion> listaAsignacion = new ArrayList<>();
				Asignacion asignacion;
				System.out.println(":: LISTA ASIGNACION ::");
				while (rS.next()) {
					
					String cientifico = rS.getString("cientifico");
					int proyecto = Integer.parseInt(rS.getString(2));
					
					asignacion = new Asignacion(cientifico, proyecto);
					listaAsignacion.add(asignacion);
					System.out.println(asignacion);
				}

				rS.close();
				stmt.close();
				conexion.close();
				return listaAsignacion;

			} catch (SQLException e) {

				System.out.println(e.getMessage());
			}
			return null;

		}
		
	
		public HashMap<String, Cientifico> creaMapaCientificoBD(String bdatos, String tabla) {
			// Mostrar por consola TODOS LOS EQUIPOS...
			// CONECTAR A LA BBDD.

			try {
				BaseDatos bd = new BaseDatos("localhost", bdatos, "root", "");
				Connection conexion = bd.getConexion();
				Statement stmt = conexion.createStatement();
				ResultSet rS = stmt.executeQuery("SELECT * FROM " + tabla + " WHERE 1 ");
				ResultSetMetaData mD = rS.getMetaData();
				
				HashMap<String, Cientifico> listaCientifico = new HashMap<String, Cientifico>();
				Cientifico cientifico;
				System.out.println(":: MAPA CIENTIFICO::");
				while (rS.next()) {
					
					String dni = rS.getString("dni");
					String nombre = rS.getString("nombre");
					
					
					cientifico = new Cientifico(dni, nombre);
					
					listaCientifico.put(rS.getString(1), cientifico);
					System.out.println(cientifico);
				}

				rS.close();
				stmt.close();
				conexion.close();
				return listaCientifico;

			} catch (SQLException e) {

				System.out.println(e.getMessage());
			}
			return null;

		}
		
		public HashMap<String, Proyecto> creaMapaProyectoBD(String bdatos, String tabla) {
			// Mostrar por consola TODOS LOS EQUIPOS...
			// CONECTAR A LA BBDD.

			try {
				BaseDatos bd = new BaseDatos("localhost", bdatos, "root", "");
				Connection conexion = bd.getConexion();
				Statement stmt = conexion.createStatement();
				ResultSet rS = stmt.executeQuery("SELECT * FROM " + tabla + " WHERE 1 ");
				ResultSetMetaData mD = rS.getMetaData();
				
				HashMap<String, Proyecto> listaProyecto = new HashMap<String, Proyecto>();
				Proyecto proyecto;
				System.out.println(":: MAPA PROYECTO::");
				while (rS.next()) {
					
					int id = Integer.parseInt(rS.getString(1));
					String nombre = rS.getString("nombre");
					int horas = Integer.parseInt(rS.getString(3));
					
					proyecto = new Proyecto(id, nombre, horas);
					
					listaProyecto.put(rS.getString(1), proyecto);
					System.out.println(proyecto);
				}

				rS.close();
				stmt.close();
				conexion.close();
				return listaProyecto;

			} catch (SQLException e) {

				System.out.println(e.getMessage());
			}
			return null;

		}
		
		public HashMap<String, Asignacion> creaMapaAsignacionBD(String bdatos, String tabla) {
			// Mostrar por consola TODOS LOS EQUIPOS...
			// CONECTAR A LA BBDD.

			try {
				BaseDatos bd = new BaseDatos("localhost", bdatos, "root", "");
				Connection conexion = bd.getConexion();
				Statement stmt = conexion.createStatement();
				ResultSet rS = stmt.executeQuery("SELECT * FROM " + tabla + " WHERE 1 ");
				ResultSetMetaData mD = rS.getMetaData();
				
				HashMap<String, Asignacion> mapaAsignacion= new HashMap<String, Asignacion>();
				Asignacion asignacion;
				System.out.println(":: MAPA ASIGNACION ::");
				while (rS.next()) {
					
					
					String cientifico = rS.getString("cientifico");
					int proyecto = Integer.parseInt(rS.getString(2));
					
					asignacion = new Asignacion(cientifico, proyecto);
					
					mapaAsignacion.put(rS.getString("cientifico"), asignacion);
					System.out.println(asignacion);
				}

				rS.close();
				stmt.close();
				conexion.close();
				return mapaAsignacion;

			} catch (SQLException e) {

				System.out.println(e.getMessage());
			}
			return null;

		}
		
		
		
}
