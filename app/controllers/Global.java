package controllers;


import play.*;
import play.mvc.*;
import play.mvc.Http.*;
import play.libs.F.*;

import static play.mvc.Results.*;

public class Global extends GlobalSettings {

    public Promise<SimpleResult> onError(RequestHeader request, Throwable t) {
	String s="";
	for(int i=0;i<t.getStackTrace().length;i++)
	{
	s=s+t.getStackTrace()[i]+"\n";
	}
        return Promise.<SimpleResult>pure(internalServerError(

            views.html.error.render(t,s)
        ));
    }

}
