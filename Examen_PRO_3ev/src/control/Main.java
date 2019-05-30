package control;

import modelo.dao.AccesoDatos;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BaseDatos bd = new BaseDatos("localhost:3306", "laboratorio", "root", "");
		AccesoDatos ad = new AccesoDatos();
		ad.recorreTabla();
		//ad.insertaCientificosDesdeFichero("ficheros/cientificos.txt");
		//ad.insertaAsignacionesDesdeFichero("ficheros/asignaciones.txt");
		//ad.insertaProyectosDesdeFichero("ficheros/proyectos.txt");
	}

}
