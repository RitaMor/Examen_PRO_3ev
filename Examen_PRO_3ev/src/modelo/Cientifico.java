package modelo;

public class Cientifico {

	private String dni;
	private String nombre;
	
	public Cientifico(String dni, String nombre) {
		super();
		this.dni = dni;
		this.nombre = nombre;
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
