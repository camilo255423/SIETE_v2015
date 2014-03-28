// @SOURCE:/home/camilo/Documents/InpahuGeneracionInformes/glassfish/ModuloInformes/conf/routes
// @HASH:88a42ac4e6440cd4e30deb770049c56d6a83eb5a
// @DATE:Fri Mar 28 08:45:14 COT 2014

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._
import play.libs.F

import Router.queryString


// @LINE:32
// @LINE:30
// @LINE:29
// @LINE:28
// @LINE:27
// @LINE:26
// @LINE:25
// @LINE:24
// @LINE:23
// @LINE:22
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

// @LINE:28
// @LINE:17
// @LINE:16
class ReverseInforme5 {
    

// @LINE:16
def excel(documento:String, semestre:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "informe5/excel/" + implicitly[PathBindable[String]].unbind("documento", dynamicString(documento)) + "/" + implicitly[PathBindable[String]].unbind("semestre", dynamicString(semestre)))
}
                                                

// @LINE:28
def informePrograma(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "informeprograma")
}
                                                

// @LINE:17
def pdf(documento:String, semestre:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "informe5/pdf/" + implicitly[PathBindable[String]].unbind("documento", dynamicString(documento)) + "/" + implicitly[PathBindable[String]].unbind("semestre", dynamicString(semestre)))
}
                                                
    
}
                          

// @LINE:32
class ReverseAssets {
    

// @LINE:32
def at(file:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[String]].unbind("file", file))
}
                                                
    
}
                          

// @LINE:24
// @LINE:9
// @LINE:8
class ReverseInforme1 {
    

// @LINE:8
def excel(documento:String, semestre:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "informe1/excel/" + implicitly[PathBindable[String]].unbind("documento", dynamicString(documento)) + "/" + implicitly[PathBindable[String]].unbind("semestre", dynamicString(semestre)))
}
                                                

// @LINE:9
def pdf(documento:String, semestre:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "informe1/pdf/" + implicitly[PathBindable[String]].unbind("documento", dynamicString(documento)) + "/" + implicitly[PathBindable[String]].unbind("semestre", dynamicString(semestre)))
}
                                                

// @LINE:24
def informeProfesor(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "informeprofesor")
}
                                                
    
}
                          

// @LINE:27
// @LINE:15
// @LINE:14
class ReverseInforme4 {
    

// @LINE:14
def excel(documento:String, semestre:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "informe4/excel/" + implicitly[PathBindable[String]].unbind("documento", dynamicString(documento)) + "/" + implicitly[PathBindable[String]].unbind("semestre", dynamicString(semestre)))
}
                                                

// @LINE:27
def informeFacultad(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "informefacultad")
}
                                                

// @LINE:15
def pdf(documento:String, semestre:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "informe4/pdf/" + implicitly[PathBindable[String]].unbind("documento", dynamicString(documento)) + "/" + implicitly[PathBindable[String]].unbind("semestre", dynamicString(semestre)))
}
                                                
    
}
                          

// @LINE:29
// @LINE:19
// @LINE:18
class ReverseInforme6 {
    

// @LINE:29
def informeParticipantes(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "informeparticipantes")
}
                                                

// @LINE:18
def excel(documento:String, semestre:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "informe6/excel/" + implicitly[PathBindable[String]].unbind("documento", dynamicString(documento)) + "/" + implicitly[PathBindable[String]].unbind("semestre", dynamicString(semestre)))
}
                                                

// @LINE:19
def pdf(documento:String, semestre:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "informe6/pdf/" + implicitly[PathBindable[String]].unbind("documento", dynamicString(documento)) + "/" + implicitly[PathBindable[String]].unbind("semestre", dynamicString(semestre)))
}
                                                
    
}
                          

// @LINE:26
// @LINE:23
// @LINE:13
// @LINE:12
class ReverseInforme3 {
    

// @LINE:12
def excel(documento:String, semestre:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "informe3/excel/" + implicitly[PathBindable[String]].unbind("documento", dynamicString(documento)) + "/" + implicitly[PathBindable[String]].unbind("semestre", dynamicString(semestre)))
}
                                                

// @LINE:13
def pdf(documento:String, semestre:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "informe3/pdf/" + implicitly[PathBindable[String]].unbind("documento", dynamicString(documento)) + "/" + implicitly[PathBindable[String]].unbind("semestre", dynamicString(semestre)))
}
                                                

// @LINE:26
// @LINE:23
def informeProfesor(): Call = {
   () match {
// @LINE:23
case () if true => Call("GET", _prefix + { _defaultPrefix } + "informe3")
                                                        
// @LINE:26
case () if true => Call("POST", _prefix + { _defaultPrefix } + "informefinal")
                                                        
   }
}
                                                
    
}
                          

// @LINE:30
// @LINE:7
// @LINE:6
class ReverseApplication {
    

// @LINE:30
def cambioSemestre(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "cambiosemestre")
}
                                                

// @LINE:6
def index(): Call = {
   Call("GET", _prefix)
}
                                                

// @LINE:7
def prueba(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "prueba")
}
                                                
    
}
                          

// @LINE:25
// @LINE:22
// @LINE:11
// @LINE:10
class ReverseInforme2 {
    

// @LINE:10
def excel(documento:String, semestre:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "informe2/excel/" + implicitly[PathBindable[String]].unbind("documento", dynamicString(documento)) + "/" + implicitly[PathBindable[String]].unbind("semestre", dynamicString(semestre)))
}
                                                

// @LINE:11
def pdf(documento:String, semestre:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "informe2/pdf/" + implicitly[PathBindable[String]].unbind("documento", dynamicString(documento)) + "/" + implicitly[PathBindable[String]].unbind("semestre", dynamicString(semestre)))
}
                                                

// @LINE:25
// @LINE:22
def informeProfesor(): Call = {
   () match {
// @LINE:22
case () if true => Call("GET", _prefix + { _defaultPrefix } + "informe2")
                                                        
// @LINE:25
case () if true => Call("POST", _prefix + { _defaultPrefix } + "heteroevaluacion")
                                                        
   }
}
                                                
    
}
                          
}
                  


// @LINE:32
// @LINE:30
// @LINE:29
// @LINE:28
// @LINE:27
// @LINE:26
// @LINE:25
// @LINE:24
// @LINE:23
// @LINE:22
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

// @LINE:28
// @LINE:17
// @LINE:16
class ReverseInforme5 {
    

// @LINE:16
def excel : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Informe5.excel",
   """
      function(documento,semestre) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "informe5/excel/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("documento", encodeURIComponent(documento)) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("semestre", encodeURIComponent(semestre))})
      }
   """
)
                        

// @LINE:28
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
                        
    
}
              

// @LINE:32
class ReverseAssets {
    

// @LINE:32
def at : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Assets.at",
   """
      function(file) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
   """
)
                        
    
}
              

// @LINE:24
// @LINE:9
// @LINE:8
class ReverseInforme1 {
    

// @LINE:8
def excel : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Informe1.excel",
   """
      function(documento,semestre) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "informe1/excel/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("documento", encodeURIComponent(documento)) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("semestre", encodeURIComponent(semestre))})
      }
   """
)
                        

// @LINE:9
def pdf : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Informe1.pdf",
   """
      function(documento,semestre) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "informe1/pdf/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("documento", encodeURIComponent(documento)) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("semestre", encodeURIComponent(semestre))})
      }
   """
)
                        

// @LINE:24
def informeProfesor : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Informe1.informeProfesor",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "informeprofesor"})
      }
   """
)
                        
    
}
              

// @LINE:27
// @LINE:15
// @LINE:14
class ReverseInforme4 {
    

// @LINE:14
def excel : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Informe4.excel",
   """
      function(documento,semestre) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "informe4/excel/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("documento", encodeURIComponent(documento)) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("semestre", encodeURIComponent(semestre))})
      }
   """
)
                        

// @LINE:27
def informeFacultad : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Informe4.informeFacultad",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "informefacultad"})
      }
   """
)
                        

// @LINE:15
def pdf : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Informe4.pdf",
   """
      function(documento,semestre) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "informe4/pdf/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("documento", encodeURIComponent(documento)) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("semestre", encodeURIComponent(semestre))})
      }
   """
)
                        
    
}
              

// @LINE:29
// @LINE:19
// @LINE:18
class ReverseInforme6 {
    

// @LINE:29
def informeParticipantes : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Informe6.informeParticipantes",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "informeparticipantes"})
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
                        

// @LINE:19
def pdf : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Informe6.pdf",
   """
      function(documento,semestre) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "informe6/pdf/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("documento", encodeURIComponent(documento)) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("semestre", encodeURIComponent(semestre))})
      }
   """
)
                        
    
}
              

// @LINE:26
// @LINE:23
// @LINE:13
// @LINE:12
class ReverseInforme3 {
    

// @LINE:12
def excel : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Informe3.excel",
   """
      function(documento,semestre) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "informe3/excel/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("documento", encodeURIComponent(documento)) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("semestre", encodeURIComponent(semestre))})
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
                        

// @LINE:26
// @LINE:23
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
                        
    
}
              

// @LINE:30
// @LINE:7
// @LINE:6
class ReverseApplication {
    

// @LINE:30
def cambioSemestre : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.cambioSemestre",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "cambiosemestre"})
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
                        

// @LINE:7
def prueba : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.prueba",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "prueba"})
      }
   """
)
                        
    
}
              

// @LINE:25
// @LINE:22
// @LINE:11
// @LINE:10
class ReverseInforme2 {
    

// @LINE:10
def excel : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Informe2.excel",
   """
      function(documento,semestre) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "informe2/excel/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("documento", encodeURIComponent(documento)) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("semestre", encodeURIComponent(semestre))})
      }
   """
)
                        

// @LINE:11
def pdf : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Informe2.pdf",
   """
      function(documento,semestre) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "informe2/pdf/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("documento", encodeURIComponent(documento)) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("semestre", encodeURIComponent(semestre))})
      }
   """
)
                        

// @LINE:25
// @LINE:22
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
                        
    
}
              
}
        


// @LINE:32
// @LINE:30
// @LINE:29
// @LINE:28
// @LINE:27
// @LINE:26
// @LINE:25
// @LINE:24
// @LINE:23
// @LINE:22
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

// @LINE:28
// @LINE:17
// @LINE:16
class ReverseInforme5 {
    

// @LINE:16
def excel(documento:String, semestre:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Informe5.excel(documento, semestre), HandlerDef(this, "controllers.Informe5", "excel", Seq(classOf[String], classOf[String]), "GET", """""", _prefix + """informe5/excel/$documento<[^/]+>/$semestre<[^/]+>""")
)
                      

// @LINE:28
def informePrograma(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Informe5.informePrograma(), HandlerDef(this, "controllers.Informe5", "informePrograma", Seq(), "POST", """""", _prefix + """informeprograma""")
)
                      

// @LINE:17
def pdf(documento:String, semestre:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Informe5.pdf(documento, semestre), HandlerDef(this, "controllers.Informe5", "pdf", Seq(classOf[String], classOf[String]), "GET", """""", _prefix + """informe5/pdf/$documento<[^/]+>/$semestre<[^/]+>""")
)
                      
    
}
                          

// @LINE:32
class ReverseAssets {
    

// @LINE:32
def at(path:String, file:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]), "GET", """ Map static resources from the /public folder to the /assets URL path""", _prefix + """assets/$file<.+>""")
)
                      
    
}
                          

// @LINE:24
// @LINE:9
// @LINE:8
class ReverseInforme1 {
    

// @LINE:8
def excel(documento:String, semestre:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Informe1.excel(documento, semestre), HandlerDef(this, "controllers.Informe1", "excel", Seq(classOf[String], classOf[String]), "GET", """""", _prefix + """informe1/excel/$documento<[^/]+>/$semestre<[^/]+>""")
)
                      

// @LINE:9
def pdf(documento:String, semestre:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Informe1.pdf(documento, semestre), HandlerDef(this, "controllers.Informe1", "pdf", Seq(classOf[String], classOf[String]), "GET", """""", _prefix + """informe1/pdf/$documento<[^/]+>/$semestre<[^/]+>""")
)
                      

// @LINE:24
def informeProfesor(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Informe1.informeProfesor(), HandlerDef(this, "controllers.Informe1", "informeProfesor", Seq(), "POST", """""", _prefix + """informeprofesor""")
)
                      
    
}
                          

// @LINE:27
// @LINE:15
// @LINE:14
class ReverseInforme4 {
    

// @LINE:14
def excel(documento:String, semestre:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Informe4.excel(documento, semestre), HandlerDef(this, "controllers.Informe4", "excel", Seq(classOf[String], classOf[String]), "GET", """""", _prefix + """informe4/excel/$documento<[^/]+>/$semestre<[^/]+>""")
)
                      

// @LINE:27
def informeFacultad(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Informe4.informeFacultad(), HandlerDef(this, "controllers.Informe4", "informeFacultad", Seq(), "POST", """""", _prefix + """informefacultad""")
)
                      

// @LINE:15
def pdf(documento:String, semestre:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Informe4.pdf(documento, semestre), HandlerDef(this, "controllers.Informe4", "pdf", Seq(classOf[String], classOf[String]), "GET", """""", _prefix + """informe4/pdf/$documento<[^/]+>/$semestre<[^/]+>""")
)
                      
    
}
                          

// @LINE:29
// @LINE:19
// @LINE:18
class ReverseInforme6 {
    

// @LINE:29
def informeParticipantes(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Informe6.informeParticipantes(), HandlerDef(this, "controllers.Informe6", "informeParticipantes", Seq(), "POST", """""", _prefix + """informeparticipantes""")
)
                      

// @LINE:18
def excel(documento:String, semestre:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Informe6.excel(documento, semestre), HandlerDef(this, "controllers.Informe6", "excel", Seq(classOf[String], classOf[String]), "GET", """""", _prefix + """informe6/excel/$documento<[^/]+>/$semestre<[^/]+>""")
)
                      

// @LINE:19
def pdf(documento:String, semestre:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Informe6.pdf(documento, semestre), HandlerDef(this, "controllers.Informe6", "pdf", Seq(classOf[String], classOf[String]), "GET", """""", _prefix + """informe6/pdf/$documento<[^/]+>/$semestre<[^/]+>""")
)
                      
    
}
                          

// @LINE:26
// @LINE:23
// @LINE:13
// @LINE:12
class ReverseInforme3 {
    

// @LINE:12
def excel(documento:String, semestre:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Informe3.excel(documento, semestre), HandlerDef(this, "controllers.Informe3", "excel", Seq(classOf[String], classOf[String]), "GET", """""", _prefix + """informe3/excel/$documento<[^/]+>/$semestre<[^/]+>""")
)
                      

// @LINE:13
def pdf(documento:String, semestre:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Informe3.pdf(documento, semestre), HandlerDef(this, "controllers.Informe3", "pdf", Seq(classOf[String], classOf[String]), "GET", """""", _prefix + """informe3/pdf/$documento<[^/]+>/$semestre<[^/]+>""")
)
                      

// @LINE:23
def informeProfesor(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Informe3.informeProfesor(), HandlerDef(this, "controllers.Informe3", "informeProfesor", Seq(), "GET", """""", _prefix + """informe3""")
)
                      
    
}
                          

// @LINE:30
// @LINE:7
// @LINE:6
class ReverseApplication {
    

// @LINE:30
def cambioSemestre(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.cambioSemestre(), HandlerDef(this, "controllers.Application", "cambioSemestre", Seq(), "POST", """""", _prefix + """cambiosemestre""")
)
                      

// @LINE:6
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.index(), HandlerDef(this, "controllers.Application", "index", Seq(), "GET", """ Home page""", _prefix + """""")
)
                      

// @LINE:7
def prueba(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.prueba(), HandlerDef(this, "controllers.Application", "prueba", Seq(), "GET", """""", _prefix + """prueba""")
)
                      
    
}
                          

// @LINE:25
// @LINE:22
// @LINE:11
// @LINE:10
class ReverseInforme2 {
    

// @LINE:10
def excel(documento:String, semestre:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Informe2.excel(documento, semestre), HandlerDef(this, "controllers.Informe2", "excel", Seq(classOf[String], classOf[String]), "GET", """""", _prefix + """informe2/excel/$documento<[^/]+>/$semestre<[^/]+>""")
)
                      

// @LINE:11
def pdf(documento:String, semestre:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Informe2.pdf(documento, semestre), HandlerDef(this, "controllers.Informe2", "pdf", Seq(classOf[String], classOf[String]), "GET", """""", _prefix + """informe2/pdf/$documento<[^/]+>/$semestre<[^/]+>""")
)
                      

// @LINE:22
def informeProfesor(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Informe2.informeProfesor(), HandlerDef(this, "controllers.Informe2", "informeProfesor", Seq(), "GET", """""", _prefix + """informe2""")
)
                      
    
}
                          
}
                  
      