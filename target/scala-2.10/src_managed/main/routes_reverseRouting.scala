// @SOURCE:/home/camilo/Documents/InpahuGeneracionInformes/ModuloInformes/conf/routes
// @HASH:3b37217133cdf87415adf68c931cd39fe73f4024
// @DATE:Sun Mar 06 18:39:32 COT 2016

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._
import play.libs.F

import Router.queryString


// @LINE:39
// @LINE:37
// @LINE:36
// @LINE:35
// @LINE:34
// @LINE:33
// @LINE:32
// @LINE:31
// @LINE:30
// @LINE:29
// @LINE:28
// @LINE:27
// @LINE:26
// @LINE:25
// @LINE:24
// @LINE:23
// @LINE:22
// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
package controllers {

// @LINE:35
// @LINE:17
// @LINE:16
class ReverseInforme5 {
    

// @LINE:35
def informePrograma(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "informeprograma")
}
                                                

// @LINE:17
def pdf(documento:String, semestre:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "informe5/pdf/" + implicitly[PathBindable[String]].unbind("documento", dynamicString(documento)) + "/" + implicitly[PathBindable[String]].unbind("semestre", dynamicString(semestre)))
}
                                                

// @LINE:16
def excel(documento:String, semestre:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "informe5/excel/" + implicitly[PathBindable[String]].unbind("documento", dynamicString(documento)) + "/" + implicitly[PathBindable[String]].unbind("semestre", dynamicString(semestre)))
}
                                                
    
}
                          

// @LINE:39
class ReverseAssets {
    

// @LINE:39
def at(file:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[String]].unbind("file", file))
}
                                                
    
}
                          

// @LINE:31
// @LINE:8
// @LINE:7
class ReverseInforme1 {
    

// @LINE:31
def informeProfesor(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "informeprofesor")
}
                                                

// @LINE:8
def pdf(documento:String, semestre:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "informe1/pdf/" + implicitly[PathBindable[String]].unbind("documento", dynamicString(documento)) + "/" + implicitly[PathBindable[String]].unbind("semestre", dynamicString(semestre)))
}
                                                

// @LINE:7
def excel(documento:String, semestre:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "informe1/excel/" + implicitly[PathBindable[String]].unbind("documento", dynamicString(documento)) + "/" + implicitly[PathBindable[String]].unbind("semestre", dynamicString(semestre)))
}
                                                
    
}
                          

// @LINE:25
// @LINE:24
// @LINE:23
// @LINE:22
class ReverseAdmin {
    

// @LINE:25
def insertar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "insertarpermiso")
}
                                                

// @LINE:22
def autocompleteLabel(term:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "autocompleteLabel" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("term", term)))))
}
                                                

// @LINE:24
def borrar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "borrarpermiso")
}
                                                

// @LINE:23
def index(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "admin")
}
                                                
    
}
                          

// @LINE:20
class ReverseGenerador {
    

// @LINE:20
def index(documento:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "generador/" + implicitly[PathBindable[String]].unbind("documento", dynamicString(documento)))
}
                                                
    
}
                          

// @LINE:34
// @LINE:15
// @LINE:14
class ReverseInforme4 {
    

// @LINE:15
def pdf(documento:String, semestre:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "informe4/pdf/" + implicitly[PathBindable[String]].unbind("documento", dynamicString(documento)) + "/" + implicitly[PathBindable[String]].unbind("semestre", dynamicString(semestre)))
}
                                                

// @LINE:34
def informeFacultad(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "informefacultad")
}
                                                

// @LINE:14
def excel(documento:String, semestre:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "informe4/excel/" + implicitly[PathBindable[String]].unbind("documento", dynamicString(documento)) + "/" + implicitly[PathBindable[String]].unbind("semestre", dynamicString(semestre)))
}
                                                
    
}
                          

// @LINE:36
// @LINE:19
// @LINE:18
class ReverseInforme6 {
    

// @LINE:36
def informeParticipantes(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "informeparticipantes")
}
                                                

// @LINE:19
def pdf(documento:String, semestre:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "informe6/pdf/" + implicitly[PathBindable[String]].unbind("documento", dynamicString(documento)) + "/" + implicitly[PathBindable[String]].unbind("semestre", dynamicString(semestre)))
}
                                                

// @LINE:18
def excel(documento:String, semestre:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "informe6/excel/" + implicitly[PathBindable[String]].unbind("documento", dynamicString(documento)) + "/" + implicitly[PathBindable[String]].unbind("semestre", dynamicString(semestre)))
}
                                                
    
}
                          

// @LINE:33
// @LINE:30
// @LINE:13
// @LINE:12
// @LINE:11
class ReverseInforme3 {
    

// @LINE:33
// @LINE:30
def informeProfesor(): Call = {
   () match {
// @LINE:30
case () if true => Call("GET", _prefix + { _defaultPrefix } + "informe3")
                                                        
// @LINE:33
case () if true => Call("POST", _prefix + { _defaultPrefix } + "informefinal")
                                                        
   }
}
                                                

// @LINE:11
def index(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "informe3/index")
}
                                                

// @LINE:13
def pdf(documento:String, semestre:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "informe3/pdf/" + implicitly[PathBindable[String]].unbind("documento", dynamicString(documento)) + "/" + implicitly[PathBindable[String]].unbind("semestre", dynamicString(semestre)))
}
                                                

// @LINE:12
def excel(documento:String, semestre:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "informe3/excel/" + implicitly[PathBindable[String]].unbind("documento", dynamicString(documento)) + "/" + implicitly[PathBindable[String]].unbind("semestre", dynamicString(semestre)))
}
                                                
    
}
                          

// @LINE:37
// @LINE:28
// @LINE:27
// @LINE:26
// @LINE:6
class ReverseApplication {
    

// @LINE:37
def cambioSemestre(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "cambiosemestre")
}
                                                

// @LINE:27
def logout(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "logout")
}
                                                

// @LINE:28
def authenticate(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "login")
}
                                                

// @LINE:6
def index(): Call = {
   Call("GET", _prefix)
}
                                                

// @LINE:26
def login(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "login")
}
                                                
    
}
                          

// @LINE:32
// @LINE:29
// @LINE:10
// @LINE:9
class ReverseInforme2 {
    

// @LINE:32
// @LINE:29
def informeProfesor(): Call = {
   () match {
// @LINE:29
case () if true => Call("GET", _prefix + { _defaultPrefix } + "informe2")
                                                        
// @LINE:32
case () if true => Call("POST", _prefix + { _defaultPrefix } + "heteroevaluacion")
                                                        
   }
}
                                                

// @LINE:10
def pdf(documento:String, semestre:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "informe2/pdf/" + implicitly[PathBindable[String]].unbind("documento", dynamicString(documento)) + "/" + implicitly[PathBindable[String]].unbind("semestre", dynamicString(semestre)))
}
                                                

// @LINE:9
def excel(documento:String, semestre:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "informe2/excel/" + implicitly[PathBindable[String]].unbind("documento", dynamicString(documento)) + "/" + implicitly[PathBindable[String]].unbind("semestre", dynamicString(semestre)))
}
                                                
    
}
                          
}
                  


// @LINE:39
// @LINE:37
// @LINE:36
// @LINE:35
// @LINE:34
// @LINE:33
// @LINE:32
// @LINE:31
// @LINE:30
// @LINE:29
// @LINE:28
// @LINE:27
// @LINE:26
// @LINE:25
// @LINE:24
// @LINE:23
// @LINE:22
// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
package controllers.javascript {

// @LINE:35
// @LINE:17
// @LINE:16
class ReverseInforme5 {
    

// @LINE:35
def informePrograma : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Informe5.informePrograma",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "informeprograma"})
      }
   """
)
                        

// @LINE:17
def pdf : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Informe5.pdf",
   """
      function(documento,semestre) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "informe5/pdf/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("documento", encodeURIComponent(documento)) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("semestre", encodeURIComponent(semestre))})
      }
   """
)
                        

// @LINE:16
def excel : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Informe5.excel",
   """
      function(documento,semestre) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "informe5/excel/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("documento", encodeURIComponent(documento)) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("semestre", encodeURIComponent(semestre))})
      }
   """
)
                        
    
}
              

// @LINE:39
class ReverseAssets {
    

// @LINE:39
def at : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Assets.at",
   """
      function(file) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
   """
)
                        
    
}
              

// @LINE:31
// @LINE:8
// @LINE:7
class ReverseInforme1 {
    

// @LINE:31
def informeProfesor : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Informe1.informeProfesor",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "informeprofesor"})
      }
   """
)
                        

// @LINE:8
def pdf : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Informe1.pdf",
   """
      function(documento,semestre) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "informe1/pdf/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("documento", encodeURIComponent(documento)) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("semestre", encodeURIComponent(semestre))})
      }
   """
)
                        

// @LINE:7
def excel : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Informe1.excel",
   """
      function(documento,semestre) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "informe1/excel/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("documento", encodeURIComponent(documento)) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("semestre", encodeURIComponent(semestre))})
      }
   """
)
                        
    
}
              

// @LINE:25
// @LINE:24
// @LINE:23
// @LINE:22
class ReverseAdmin {
    

// @LINE:25
def insertar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Admin.insertar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "insertarpermiso"})
      }
   """
)
                        

// @LINE:22
def autocompleteLabel : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Admin.autocompleteLabel",
   """
      function(term) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "autocompleteLabel" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("term", term)])})
      }
   """
)
                        

// @LINE:24
def borrar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Admin.borrar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "borrarpermiso"})
      }
   """
)
                        

// @LINE:23
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Admin.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "admin"})
      }
   """
)
                        
    
}
              

// @LINE:20
class ReverseGenerador {
    

// @LINE:20
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Generador.index",
   """
      function(documento) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "generador/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("documento", encodeURIComponent(documento))})
      }
   """
)
                        
    
}
              

// @LINE:34
// @LINE:15
// @LINE:14
class ReverseInforme4 {
    

// @LINE:15
def pdf : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Informe4.pdf",
   """
      function(documento,semestre) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "informe4/pdf/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("documento", encodeURIComponent(documento)) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("semestre", encodeURIComponent(semestre))})
      }
   """
)
                        

// @LINE:34
def informeFacultad : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Informe4.informeFacultad",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "informefacultad"})
      }
   """
)
                        

// @LINE:14
def excel : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Informe4.excel",
   """
      function(documento,semestre) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "informe4/excel/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("documento", encodeURIComponent(documento)) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("semestre", encodeURIComponent(semestre))})
      }
   """
)
                        
    
}
              

// @LINE:36
// @LINE:19
// @LINE:18
class ReverseInforme6 {
    

// @LINE:36
def informeParticipantes : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Informe6.informeParticipantes",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "informeparticipantes"})
      }
   """
)
                        

// @LINE:19
def pdf : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Informe6.pdf",
   """
      function(documento,semestre) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "informe6/pdf/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("documento", encodeURIComponent(documento)) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("semestre", encodeURIComponent(semestre))})
      }
   """
)
                        

// @LINE:18
def excel : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Informe6.excel",
   """
      function(documento,semestre) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "informe6/excel/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("documento", encodeURIComponent(documento)) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("semestre", encodeURIComponent(semestre))})
      }
   """
)
                        
    
}
              

// @LINE:33
// @LINE:30
// @LINE:13
// @LINE:12
// @LINE:11
class ReverseInforme3 {
    

// @LINE:33
// @LINE:30
def informeProfesor : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Informe3.informeProfesor",
   """
      function() {
      if (true) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "informe3"})
      }
      if (true) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "informefinal"})
      }
      }
   """
)
                        

// @LINE:11
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Informe3.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "informe3/index"})
      }
   """
)
                        

// @LINE:13
def pdf : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Informe3.pdf",
   """
      function(documento,semestre) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "informe3/pdf/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("documento", encodeURIComponent(documento)) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("semestre", encodeURIComponent(semestre))})
      }
   """
)
                        

// @LINE:12
def excel : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Informe3.excel",
   """
      function(documento,semestre) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "informe3/excel/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("documento", encodeURIComponent(documento)) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("semestre", encodeURIComponent(semestre))})
      }
   """
)
                        
    
}
              

// @LINE:37
// @LINE:28
// @LINE:27
// @LINE:26
// @LINE:6
class ReverseApplication {
    

// @LINE:37
def cambioSemestre : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.cambioSemestre",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "cambiosemestre"})
      }
   """
)
                        

// @LINE:27
def logout : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.logout",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "logout"})
      }
   """
)
                        

// @LINE:28
def authenticate : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.authenticate",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "login"})
      }
   """
)
                        

// @LINE:6
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + """"})
      }
   """
)
                        

// @LINE:26
def login : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.login",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "login"})
      }
   """
)
                        
    
}
              

// @LINE:32
// @LINE:29
// @LINE:10
// @LINE:9
class ReverseInforme2 {
    

// @LINE:32
// @LINE:29
def informeProfesor : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Informe2.informeProfesor",
   """
      function() {
      if (true) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "informe2"})
      }
      if (true) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "heteroevaluacion"})
      }
      }
   """
)
                        

// @LINE:10
def pdf : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Informe2.pdf",
   """
      function(documento,semestre) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "informe2/pdf/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("documento", encodeURIComponent(documento)) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("semestre", encodeURIComponent(semestre))})
      }
   """
)
                        

// @LINE:9
def excel : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Informe2.excel",
   """
      function(documento,semestre) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "informe2/excel/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("documento", encodeURIComponent(documento)) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("semestre", encodeURIComponent(semestre))})
      }
   """
)
                        
    
}
              
}
        


// @LINE:39
// @LINE:37
// @LINE:36
// @LINE:35
// @LINE:34
// @LINE:33
// @LINE:32
// @LINE:31
// @LINE:30
// @LINE:29
// @LINE:28
// @LINE:27
// @LINE:26
// @LINE:25
// @LINE:24
// @LINE:23
// @LINE:22
// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
package controllers.ref {


// @LINE:35
// @LINE:17
// @LINE:16
class ReverseInforme5 {
    

// @LINE:35
def informePrograma(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Informe5.informePrograma(), HandlerDef(this, "controllers.Informe5", "informePrograma", Seq(), "POST", """""", _prefix + """informeprograma""")
)
                      

// @LINE:17
def pdf(documento:String, semestre:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Informe5.pdf(documento, semestre), HandlerDef(this, "controllers.Informe5", "pdf", Seq(classOf[String], classOf[String]), "GET", """""", _prefix + """informe5/pdf/$documento<[^/]+>/$semestre<[^/]+>""")
)
                      

// @LINE:16
def excel(documento:String, semestre:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Informe5.excel(documento, semestre), HandlerDef(this, "controllers.Informe5", "excel", Seq(classOf[String], classOf[String]), "GET", """""", _prefix + """informe5/excel/$documento<[^/]+>/$semestre<[^/]+>""")
)
                      
    
}
                          

// @LINE:39
class ReverseAssets {
    

// @LINE:39
def at(path:String, file:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]), "GET", """ Map static resources from the /public folder to the /assets URL path""", _prefix + """assets/$file<.+>""")
)
                      
    
}
                          

// @LINE:31
// @LINE:8
// @LINE:7
class ReverseInforme1 {
    

// @LINE:31
def informeProfesor(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Informe1.informeProfesor(), HandlerDef(this, "controllers.Informe1", "informeProfesor", Seq(), "POST", """""", _prefix + """informeprofesor""")
)
                      

// @LINE:8
def pdf(documento:String, semestre:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Informe1.pdf(documento, semestre), HandlerDef(this, "controllers.Informe1", "pdf", Seq(classOf[String], classOf[String]), "GET", """""", _prefix + """informe1/pdf/$documento<[^/]+>/$semestre<[^/]+>""")
)
                      

// @LINE:7
def excel(documento:String, semestre:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Informe1.excel(documento, semestre), HandlerDef(this, "controllers.Informe1", "excel", Seq(classOf[String], classOf[String]), "GET", """""", _prefix + """informe1/excel/$documento<[^/]+>/$semestre<[^/]+>""")
)
                      
    
}
                          

// @LINE:25
// @LINE:24
// @LINE:23
// @LINE:22
class ReverseAdmin {
    

// @LINE:25
def insertar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Admin.insertar(), HandlerDef(this, "controllers.Admin", "insertar", Seq(), "POST", """""", _prefix + """insertarpermiso""")
)
                      

// @LINE:22
def autocompleteLabel(term:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Admin.autocompleteLabel(term), HandlerDef(this, "controllers.Admin", "autocompleteLabel", Seq(classOf[String]), "GET", """""", _prefix + """autocompleteLabel""")
)
                      

// @LINE:24
def borrar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Admin.borrar(), HandlerDef(this, "controllers.Admin", "borrar", Seq(), "POST", """""", _prefix + """borrarpermiso""")
)
                      

// @LINE:23
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Admin.index(), HandlerDef(this, "controllers.Admin", "index", Seq(), "GET", """""", _prefix + """admin""")
)
                      
    
}
                          

// @LINE:20
class ReverseGenerador {
    

// @LINE:20
def index(documento:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Generador.index(documento), HandlerDef(this, "controllers.Generador", "index", Seq(classOf[String]), "GET", """""", _prefix + """generador/$documento<[^/]+>""")
)
                      
    
}
                          

// @LINE:34
// @LINE:15
// @LINE:14
class ReverseInforme4 {
    

// @LINE:15
def pdf(documento:String, semestre:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Informe4.pdf(documento, semestre), HandlerDef(this, "controllers.Informe4", "pdf", Seq(classOf[String], classOf[String]), "GET", """""", _prefix + """informe4/pdf/$documento<[^/]+>/$semestre<[^/]+>""")
)
                      

// @LINE:34
def informeFacultad(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Informe4.informeFacultad(), HandlerDef(this, "controllers.Informe4", "informeFacultad", Seq(), "POST", """""", _prefix + """informefacultad""")
)
                      

// @LINE:14
def excel(documento:String, semestre:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Informe4.excel(documento, semestre), HandlerDef(this, "controllers.Informe4", "excel", Seq(classOf[String], classOf[String]), "GET", """""", _prefix + """informe4/excel/$documento<[^/]+>/$semestre<[^/]+>""")
)
                      
    
}
                          

// @LINE:36
// @LINE:19
// @LINE:18
class ReverseInforme6 {
    

// @LINE:36
def informeParticipantes(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Informe6.informeParticipantes(), HandlerDef(this, "controllers.Informe6", "informeParticipantes", Seq(), "POST", """""", _prefix + """informeparticipantes""")
)
                      

// @LINE:19
def pdf(documento:String, semestre:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Informe6.pdf(documento, semestre), HandlerDef(this, "controllers.Informe6", "pdf", Seq(classOf[String], classOf[String]), "GET", """""", _prefix + """informe6/pdf/$documento<[^/]+>/$semestre<[^/]+>""")
)
                      

// @LINE:18
def excel(documento:String, semestre:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Informe6.excel(documento, semestre), HandlerDef(this, "controllers.Informe6", "excel", Seq(classOf[String], classOf[String]), "GET", """""", _prefix + """informe6/excel/$documento<[^/]+>/$semestre<[^/]+>""")
)
                      
    
}
                          

// @LINE:33
// @LINE:30
// @LINE:13
// @LINE:12
// @LINE:11
class ReverseInforme3 {
    

// @LINE:30
def informeProfesor(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Informe3.informeProfesor(), HandlerDef(this, "controllers.Informe3", "informeProfesor", Seq(), "GET", """""", _prefix + """informe3""")
)
                      

// @LINE:11
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Informe3.index(), HandlerDef(this, "controllers.Informe3", "index", Seq(), "GET", """""", _prefix + """informe3/index""")
)
                      

// @LINE:13
def pdf(documento:String, semestre:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Informe3.pdf(documento, semestre), HandlerDef(this, "controllers.Informe3", "pdf", Seq(classOf[String], classOf[String]), "GET", """""", _prefix + """informe3/pdf/$documento<[^/]+>/$semestre<[^/]+>""")
)
                      

// @LINE:12
def excel(documento:String, semestre:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Informe3.excel(documento, semestre), HandlerDef(this, "controllers.Informe3", "excel", Seq(classOf[String], classOf[String]), "GET", """""", _prefix + """informe3/excel/$documento<[^/]+>/$semestre<[^/]+>""")
)
                      
    
}
                          

// @LINE:37
// @LINE:28
// @LINE:27
// @LINE:26
// @LINE:6
class ReverseApplication {
    

// @LINE:37
def cambioSemestre(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.cambioSemestre(), HandlerDef(this, "controllers.Application", "cambioSemestre", Seq(), "POST", """""", _prefix + """cambiosemestre""")
)
                      

// @LINE:27
def logout(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.logout(), HandlerDef(this, "controllers.Application", "logout", Seq(), "GET", """""", _prefix + """logout""")
)
                      

// @LINE:28
def authenticate(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.authenticate(), HandlerDef(this, "controllers.Application", "authenticate", Seq(), "POST", """""", _prefix + """login""")
)
                      

// @LINE:6
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.index(), HandlerDef(this, "controllers.Application", "index", Seq(), "GET", """ Home page""", _prefix + """""")
)
                      

// @LINE:26
def login(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.login(), HandlerDef(this, "controllers.Application", "login", Seq(), "GET", """""", _prefix + """login""")
)
                      
    
}
                          

// @LINE:32
// @LINE:29
// @LINE:10
// @LINE:9
class ReverseInforme2 {
    

// @LINE:29
def informeProfesor(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Informe2.informeProfesor(), HandlerDef(this, "controllers.Informe2", "informeProfesor", Seq(), "GET", """""", _prefix + """informe2""")
)
                      

// @LINE:10
def pdf(documento:String, semestre:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Informe2.pdf(documento, semestre), HandlerDef(this, "controllers.Informe2", "pdf", Seq(classOf[String], classOf[String]), "GET", """""", _prefix + """informe2/pdf/$documento<[^/]+>/$semestre<[^/]+>""")
)
                      

// @LINE:9
def excel(documento:String, semestre:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Informe2.excel(documento, semestre), HandlerDef(this, "controllers.Informe2", "excel", Seq(classOf[String], classOf[String]), "GET", """""", _prefix + """informe2/excel/$documento<[^/]+>/$semestre<[^/]+>""")
)
                      
    
}
                          
}
        
    