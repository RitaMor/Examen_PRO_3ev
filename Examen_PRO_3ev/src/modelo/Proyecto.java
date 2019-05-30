package modelo;

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
