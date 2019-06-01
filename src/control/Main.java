package control;

import modelo.Asignacion;
import modelo.Cientifico;
import modelo.Proyecto;
import modelo.dao.AccesoDatos;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Ejercicio 1
		BaseDatos bd = new BaseDatos("localhost:3306", "laboratorio", "root", "");
		
		// Ejercicio 2
		AccesoDatos ad = new AccesoDatos();
		
		ad.recorreTabla("laboratorio", "proyectos");
		
		// Ejercicio 3 
		//Cientifico.insertaCientificosDesdeFichero("ficheros/cientificos.txt");
		//Proyecto.insertaProyectosDesdeFichero("ficheros/proyectos.txt");
		//Asignacion.insertaAsignacionesDesdeFichero("ficheros/asignaciones.txt");
		
		
		// Ejercicio 4 y 5 Hecho en sus respectivas clases
		
		// Ejercicio 6
		//ad.creaListaBDGenerica("laboratorio", "proyectos");
		
		// Ejercicio 7
		ad.creaListaCientificosBD("laboratorio", "cientificos");
		ad.creaListaProyectoBD("laboratorio", "proyectos");
		ad.creaListaAsignacionesBD("laboratorio", "asignaciones");
		
		
		// Ejercicio 8
		ad.creaMapaCientificoBD("laboratorio", "cientificos");
		ad.creaMapaProyectoBD("laboratorio", "proyectos");
		ad.creaMapaAsignacionBD("laboratorio", "asignaciones");
		System.out.println("FIN");
		
		// Comentario para hacer commit
	}

}
