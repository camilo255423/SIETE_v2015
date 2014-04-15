package models;

public class SaberNivel
{
	String saber;
	int nivel=0;
	double promedio=0;
	public SaberNivel(String saber)
	{
		this.saber=saber;
	}
	public String getSaber() {
		return saber;
	}
	public void setSaber(String saber) {
		this.saber = saber;
	}
	public int getNivel() {
		return nivel;
	}
	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
	public double getPromedio() {
		return promedio;
	}
	public void setPromedio(double promedio) {
		this.promedio = promedio;
	}
	@Override
	public String toString() {
		return "SaberNivel [campo=" + saber + ", nivel=" + nivel
				+ ", promedio=" + promedio + "]";
	}
	
	
}
