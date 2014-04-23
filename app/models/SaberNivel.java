package models;
/**
 * Modelo que representa la puntuación para un saber. Almacena el nivel y el promedio para ese nivel.
 * Es utilizado para encuentrar el mejor y el peor saber en una evaluación.
 * @author Camilo Rodríguez
 *
 */
public class SaberNivel
{
	/**
	 * String nombre del saber
	 */
	String saber;
	/**
	 * Nivel (0,1,2,3,4) - (INFERIOR, BAJO, MEDIO, ALTO, SUPERIOR)
	 */
	int nivel=0;
	/**
	 * double promedio para el nivel
	 */
	double promedio=0;
	/**
	 * 
	 * @param saber String nombre del saber
	 */
	
	public SaberNivel(String saber)
	{
		this.saber=saber;
	}
	/**
	 * 
	 * @return String nombre del saber
	 */
	
	public String getSaber() {
		return saber;
	}
	/**
	 * 
	 * @param saber String nombre del saber
	 */
	
	public void setSaber(String saber) {
		this.saber = saber;
	}
	/**
	 * 
	 * @return int nivel
	 */
	public int getNivel() {
		return nivel;
	}
	/**
	 * 
	 * @param nivel 
	 */
	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
	/**
	 * 
	 * @return double promedio
	 */
	public double getPromedio() {
		return promedio;
	}
	/**
	 * 
	 * @param promedio
	 */
	public void setPromedio(double promedio) {
		this.promedio = promedio;
	}
	@Override
	public String toString() {
		return "SaberNivel [campo=" + saber + ", nivel=" + nivel
				+ ", promedio=" + promedio + "]";
	}
	
	
}
