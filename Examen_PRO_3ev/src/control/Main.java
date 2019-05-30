package control;

import modelo.dao.AccesoDatos;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Ejercicio 1
		BaseDatos bd = new BaseDatos("localhost:3306", "laboratorio", "root", "");
		
		// Ejercicio 2
		AccesoDatos ad = new AccesoDatos();
		
		ad.recorreTabla();
		
		// Ejercicio 3 
		//AccesoDatos.insertaCientificosDesdeFichero("ficheros/cientificos.txt");
		//AccesoDatos.insertaAsignacionesDesdeFichero("ficheros/asignaciones.txt");
		//AccesoDatos.insertaProyectosDesdeFichero("ficheros/proyectos.txt");
		
		// Ejercicio 4 y 5 Hecho en sus respectivas clases
		
		// Ejercicio 6
		//ad.creaListaBDGenerica("laboratorio", "proyectos");
		
		// Ejercicio 7
		ad.creaListaProyectoBD("laboratorio", "proyectos");
		
		// Ejercicio 8
		ad.creaMapaProyectoBD("laboratorio", "proyectos");
		
		
	}

}
