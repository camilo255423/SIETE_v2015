package models;
/**
 * Clase que permite representar los valores de las listas autocompletables
 * @author Camilo Rodríguez
 *
 */
public class AutocompleteValue {

	   private String value;
	   private String label;

	   public AutocompleteValue(final String value, final String label) {
	      this.value = value;
	      this.label = label;
	   }
}