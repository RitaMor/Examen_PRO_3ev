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
	
	
	
	public void recorreTabla(String bdName, String tabla) {
		// Mostrar por consola ...
		// CONECTAR A LA BBDD.

		try {
			BaseDatos bd = new BaseDatos("localhost", bdName, "root", "");
			Connection conexion = bd.getConexion();
			Statement stmt = conexion.createStatement();
			ResultSet rS = stmt.executeQuery("SELECT * FROM " + tabla); // para escribir cambia execute query por
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
		
//		public ArrayList<Cientifico> creaListaCientificosBD(String bdatos, String tabla) {
//			// Mostrar por consola TODOS LOS EQUIPOS...
//			// CONECTAR A LA BBDD.
//
//			try {
//				BaseDatos bd = new BaseDatos("localhost", bdatos, "root", "");
//				Connection conexion = bd.getConexion();
//				Statement stmt = conexion.createStatement();
//				ResultSet rS = stmt.executeQuery("SELECT * FROM " + tabla + " WHERE 1 ");
//				ResultSetMetaData mD = rS.getMetaData();
//				
//				ArrayList<Cientifico> listaCientifico = new ArrayList<>();
//				Cientifico cientifico;
//				System.out.println(":: LISTA CIENTIFICO ::");
//				while (rS.next()) {
//					
//					String dni = rS.getString("dni");
//					String nombre = rS.getString("nombre");
//					
//					cientifico = new Cientifico(dni, nombre);
//					listaCientifico.add(cientifico);
//					System.out.println(cientifico);
//				}
//
//				rS.close();
//				stmt.close();
//				conexion.close();
//				return listaCientifico;
//
//			} catch (SQLException e) {
//
//				System.out.println(e.getMessage());
//			}
//			return null;
//
//		}
		
		
		
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
