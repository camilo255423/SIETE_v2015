package controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TimeZone;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;


import models.Periodo;
import models.Profesor;


import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.api.libs.json.util.*;

public class Admin extends Controller{
	public static List<String> locations() {
		   final List<String> result = new ArrayList<String>();
		   final String[] timeZones = TimeZone.getAvailableIDs();
		   for (int i = 0; i < timeZones.length; i++) {
		      final String[] parts = timeZones[i].split("/");
		      if (parts.length == 2 && parts[1].matches("[A-Za-z_]+")) {
		         final String location = parts[1].replaceAll("_", " ");
		         result.add(location);
		      }
		   }
		   Collections.sort(result);
		   return result;
	}
	
	public static int AUTOCOMPLETE_MAX = 10;


	public static Result autocompleteLabel(final String term) {
		   final List<String> response = new ArrayList<String>();
		   ObjectNode result = Json.newObject();
		   int i=0;
		   for (String label : locations()) {
		      if (label.toLowerCase().startsWith(term.toLowerCase())) {
		         response.add(label);
		         result.put(i+"",label);
		      }
		      if (response.size() == AUTOCOMPLETE_MAX) {
		         break;
		      }
		   }
		   return ok(result);
	}
	  public static Result index() {

	    	
	    
	    	return ok(views.html.admin.render());
	    }

}
