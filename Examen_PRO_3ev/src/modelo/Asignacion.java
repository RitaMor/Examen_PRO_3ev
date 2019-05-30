package modelo;

public class Asignacion {
	private String cientifico;
	private int proyecto;
	
	
	public Asignacion(String cientifico, int proyecto) {
		super();
		this.cientifico = cientifico;
		this.proyecto = proyecto;
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
