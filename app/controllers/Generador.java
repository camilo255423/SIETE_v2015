package controllers;

import java.util.ArrayList;
import java.util.List;

import models.Periodo;
import models.Profesor;
import play.api.libs.concurrent.Promise;
import play.api.libs.ws.Response;
import play.api.libs.ws.WS;
import play.mvc.Controller;
import play.mvc.Result;
import scala.concurrent.Future;

public class Generador extends Controller{
public static int i=0;	
public static Result index(String documento) {

    	String documentos[] = new String[]{"52174119","51625497","19112490"};
    	List<Profesor> profesores = new ArrayList<Profesor>();
    
    	controllers.Informe3.pdf(documento,"20141");
    	/*Future<Response> homePage = WS.url("http://127.0.0.1:9000/informe3/52174119").get();
    	Future<Response> homePage1 = WS.url("http://127.0.0.1:9000/informe3/52174119").get();
    	Future<Response> homePage2 = WS.url("http://127.0.0.1:9000/informe3/52174119").get();*/
    	return ok("ok");
    
    }
	
	
	
}
