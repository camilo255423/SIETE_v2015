package models;
/**
 * Clase que contiene las constantes para los roles
 * @author Camilo Rodríguez
 *
 */
public class Rol {
	/**
	 * Rol administrador. Tiene permiso para ver todos los informes y usar el módulo administrativo.
	 */
	public static final String ADMINISTRADOR = "1";
	/**
	 * Rol Coordinador , corresponde a los directores de programa. Tiene permiso para ver los informes 1,2,3 y 5
	 * de su respectivo programa
	 */
	
	public static final String COORDINADOR = "2";
	/**
	 * Rol profesor. Solo tiene permiso sobre el informe 1 del respectivo profesor.No tiene permiso para ver las observaciones
	 * hechas por los estudiantes.
	 */
	public static final String PROFESOR = "3";
	
	public static final String COORDINADOR_DE_AREA="4";
	
	public static final String DECANO="5";
			
	public static final String SECRETARIA_FACULTAD="6";

	public String getAdministradorId() {
		return Rol.ADMINISTRADOR;
	}

	public  String getCoordinadorId() {
		return COORDINADOR;
	}

	public  String getProfesorId() {
		return PROFESOR;
	}

	public  String getCoordinadorDeAreaId() {
		return COORDINADOR_DE_AREA;
	}

	public  String getDecanoId() {
		return DECANO;
	}

	public  String getSecretariaFacultadId() {
		return SECRETARIA_FACULTAD;
	}		
	
	

}
