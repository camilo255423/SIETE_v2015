// @SOURCE:/home/camilo/Documents/InpahuGeneracionInformes/glassfish/ModuloInformes/conf/routes
// @HASH:88a42ac4e6440cd4e30deb770049c56d6a83eb5a
// @DATE:Fri Mar 28 08:45:14 COT 2014


import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._
import play.libs.F

import Router.queryString

object Routes extends Router.Routes {

private var _prefix = "/"

def setPrefix(prefix: String) {
  _prefix = prefix  
  List[(String,Routes)]().foreach {
    case (p, router) => router.setPrefix(prefix + (if(prefix.endsWith("/")) "" else "/") + p)
  }
}

def prefix = _prefix

lazy val defaultPrefix = { if(Routes.prefix.endsWith("/")) "" else "/" } 


// @LINE:6
private[this] lazy val controllers_Application_index0 = Route("GET", PathPattern(List(StaticPart(Routes.prefix))))
        

// @LINE:7
private[this] lazy val controllers_Application_prueba1 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("prueba"))))
        

// @LINE:8
private[this] lazy val controllers_Informe1_excel2 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("informe1/excel/"),DynamicPart("documento", """[^/]+""",true),StaticPart("/"),DynamicPart("semestre", """[^/]+""",true))))
        

// @LINE:9
private[this] lazy val controllers_Informe1_pdf3 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("informe1/pdf/"),DynamicPart("documento", """[^/]+""",true),StaticPart("/"),DynamicPart("semestre", """[^/]+""",true))))
        

// @LINE:10
private[this] lazy val controllers_Informe2_excel4 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("informe2/excel/"),DynamicPart("documento", """[^/]+""",true),StaticPart("/"),DynamicPart("semestre", """[^/]+""",true))))
        

// @LINE:11
private[this] lazy val controllers_Informe2_pdf5 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("informe2/pdf/"),DynamicPart("documento", """[^/]+""",true),StaticPart("/"),DynamicPart("semestre", """[^/]+""",true))))
        

// @LINE:12
private[this] lazy val controllers_Informe3_excel6 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("informe3/excel/"),DynamicPart("documento", """[^/]+""",true),StaticPart("/"),DynamicPart("semestre", """[^/]+""",true))))
        

// @LINE:13
private[this] lazy val controllers_Informe3_pdf7 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("informe3/pdf/"),DynamicPart("documento", """[^/]+""",true),StaticPart("/"),DynamicPart("semestre", """[^/]+""",true))))
        

// @LINE:14
private[this] lazy val controllers_Informe4_excel8 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("informe4/excel/"),DynamicPart("documento", """[^/]+""",true),StaticPart("/"),DynamicPart("semestre", """[^/]+""",true))))
        

// @LINE:15
private[this] lazy val controllers_Informe4_pdf9 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("informe4/pdf/"),DynamicPart("documento", """[^/]+""",true),StaticPart("/"),DynamicPart("semestre", """[^/]+""",true))))
        

// @LINE:16
private[this] lazy val controllers_Informe5_excel10 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("informe5/excel/"),DynamicPart("documento", """[^/]+""",true),StaticPart("/"),DynamicPart("semestre", """[^/]+""",true))))
        

// @LINE:17
private[this] lazy val controllers_Informe5_pdf11 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("informe5/pdf/"),DynamicPart("documento", """[^/]+""",true),StaticPart("/"),DynamicPart("semestre", """[^/]+""",true))))
        

// @LINE:18
private[this] lazy val controllers_Informe6_excel12 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("informe6/excel/"),DynamicPart("documento", """[^/]+""",true),StaticPart("/"),DynamicPart("semestre", """[^/]+""",true))))
        

// @LINE:19
private[this] lazy val controllers_Informe6_pdf13 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("informe6/pdf/"),DynamicPart("documento", """[^/]+""",true),StaticPart("/"),DynamicPart("semestre", """[^/]+""",true))))
        

// @LINE:22
private[this] lazy val controllers_Informe2_informeProfesor14 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("informe2"))))
        

// @LINE:23
private[this] lazy val controllers_Informe3_informeProfesor15 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("informe3"))))
        

// @LINE:24
private[this] lazy val controllers_Informe1_informeProfesor16 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("informeprofesor"))))
        

// @LINE:25
private[this] lazy val controllers_Informe2_informeProfesor17 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("heteroevaluacion"))))
        

// @LINE:26
private[this] lazy val controllers_Informe3_informeProfesor18 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("informefinal"))))
        

// @LINE:27
private[this] lazy val controllers_Informe4_informeFacultad19 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("informefacultad"))))
        

// @LINE:28
private[this] lazy val controllers_Informe5_informePrograma20 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("informeprograma"))))
        

// @LINE:29
private[this] lazy val controllers_Informe6_informeParticipantes21 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("informeparticipantes"))))
        

// @LINE:30
private[this] lazy val controllers_Application_cambioSemestre22 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("cambiosemestre"))))
        

// @LINE:32
private[this] lazy val controllers_Assets_at23 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/"),DynamicPart("file", """.+""",false))))
        
def documentation = List(("""GET""", prefix,"""controllers.Application.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """prueba""","""controllers.Application.prueba()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """informe1/excel/$documento<[^/]+>/$semestre<[^/]+>""","""controllers.Informe1.excel(documento:String, semestre:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """informe1/pdf/$documento<[^/]+>/$semestre<[^/]+>""","""controllers.Informe1.pdf(documento:String, semestre:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """informe2/excel/$documento<[^/]+>/$semestre<[^/]+>""","""controllers.Informe2.excel(documento:String, semestre:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """informe2/pdf/$documento<[^/]+>/$semestre<[^/]+>""","""controllers.Informe2.pdf(documento:String, semestre:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """informe3/excel/$documento<[^/]+>/$semestre<[^/]+>""","""controllers.Informe3.excel(documento:String, semestre:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """informe3/pdf/$documento<[^/]+>/$semestre<[^/]+>""","""controllers.Informe3.pdf(documento:String, semestre:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """informe4/excel/$documento<[^/]+>/$semestre<[^/]+>""","""controllers.Informe4.excel(documento:String, semestre:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """informe4/pdf/$documento<[^/]+>/$semestre<[^/]+>""","""controllers.Informe4.pdf(documento:String, semestre:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """informe5/excel/$documento<[^/]+>/$semestre<[^/]+>""","""controllers.Informe5.excel(documento:String, semestre:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """informe5/pdf/$documento<[^/]+>/$semestre<[^/]+>""","""controllers.Informe5.pdf(documento:String, semestre:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """informe6/excel/$documento<[^/]+>/$semestre<[^/]+>""","""controllers.Informe6.excel(documento:String, semestre:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """informe6/pdf/$documento<[^/]+>/$semestre<[^/]+>""","""controllers.Informe6.pdf(documento:String, semestre:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """informe2""","""controllers.Informe2.informeProfesor()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """informe3""","""controllers.Informe3.informeProfesor()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """informeprofesor""","""controllers.Informe1.informeProfesor()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """heteroevaluacion""","""controllers.Informe2.informeProfesor()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """informefinal""","""controllers.Informe3.informeProfesor()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """informefacultad""","""controllers.Informe4.informeFacultad()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """informeprograma""","""controllers.Informe5.informePrograma()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """informeparticipantes""","""controllers.Informe6.informeParticipantes()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """cambiosemestre""","""controllers.Application.cambioSemestre()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
  case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
  case l => s ++ l.asInstanceOf[List[(String,String,String)]] 
}}
       
    
def routes:PartialFunction[RequestHeader,Handler] = {        

// @LINE:6
case controllers_Application_index0(params) => {
   call { 
        invokeHandler(controllers.Application.index(), HandlerDef(this, "controllers.Application", "index", Nil,"GET", """ Home page""", Routes.prefix + """"""))
   }
}
        

// @LINE:7
case controllers_Application_prueba1(params) => {
   call { 
        invokeHandler(controllers.Application.prueba(), HandlerDef(this, "controllers.Application", "prueba", Nil,"GET", """""", Routes.prefix + """prueba"""))
   }
}
        

// @LINE:8
case controllers_Informe1_excel2(params) => {
   call(params.fromPath[String]("documento", None), params.fromPath[String]("semestre", None)) { (documento, semestre) =>
        invokeHandler(controllers.Informe1.excel(documento, semestre), HandlerDef(this, "controllers.Informe1", "excel", Seq(classOf[String], classOf[String]),"GET", """""", Routes.prefix + """informe1/excel/$documento<[^/]+>/$semestre<[^/]+>"""))
   }
}
        

// @LINE:9
case controllers_Informe1_pdf3(params) => {
   call(params.fromPath[String]("documento", None), params.fromPath[String]("semestre", None)) { (documento, semestre) =>
        invokeHandler(controllers.Informe1.pdf(documento, semestre), HandlerDef(this, "controllers.Informe1", "pdf", Seq(classOf[String], classOf[String]),"GET", """""", Routes.prefix + """informe1/pdf/$documento<[^/]+>/$semestre<[^/]+>"""))
   }
}
        

// @LINE:10
case controllers_Informe2_excel4(params) => {
   call(params.fromPath[String]("documento", None), params.fromPath[String]("semestre", None)) { (documento, semestre) =>
        invokeHandler(controllers.Informe2.excel(documento, semestre), HandlerDef(this, "controllers.Informe2", "excel", Seq(classOf[String], classOf[String]),"GET", """""", Routes.prefix + """informe2/excel/$documento<[^/]+>/$semestre<[^/]+>"""))
   }
}
        

// @LINE:11
case controllers_Informe2_pdf5(params) => {
   call(params.fromPath[String]("documento", None), params.fromPath[String]("semestre", None)) { (documento, semestre) =>
        invokeHandler(controllers.Informe2.pdf(documento, semestre), HandlerDef(this, "controllers.Informe2", "pdf", Seq(classOf[String], classOf[String]),"GET", """""", Routes.prefix + """informe2/pdf/$documento<[^/]+>/$semestre<[^/]+>"""))
   }
}
        

// @LINE:12
case controllers_Informe3_excel6(params) => {
   call(params.fromPath[String]("documento", None), params.fromPath[String]("semestre", None)) { (documento, semestre) =>
        invokeHandler(controllers.Informe3.excel(documento, semestre), HandlerDef(this, "controllers.Informe3", "excel", Seq(classOf[String], classOf[String]),"GET", """""", Routes.prefix + """informe3/excel/$documento<[^/]+>/$semestre<[^/]+>"""))
   }
}
        

// @LINE:13
case controllers_Informe3_pdf7(params) => {
   call(params.fromPath[String]("documento", None), params.fromPath[String]("semestre", None)) { (documento, semestre) =>
        invokeHandler(controllers.Informe3.pdf(documento, semestre), HandlerDef(this, "controllers.Informe3", "pdf", Seq(classOf[String], classOf[String]),"GET", """""", Routes.prefix + """informe3/pdf/$documento<[^/]+>/$semestre<[^/]+>"""))
   }
}
        

// @LINE:14
case controllers_Informe4_excel8(params) => {
   call(params.fromPath[String]("documento", None), params.fromPath[String]("semestre", None)) { (documento, semestre) =>
        invokeHandler(controllers.Informe4.excel(documento, semestre), HandlerDef(this, "controllers.Informe4", "excel", Seq(classOf[String], classOf[String]),"GET", """""", Routes.prefix + """informe4/excel/$documento<[^/]+>/$semestre<[^/]+>"""))
   }
}
        

// @LINE:15
case controllers_Informe4_pdf9(params) => {
   call(params.fromPath[String]("documento", None), params.fromPath[String]("semestre", None)) { (documento, semestre) =>
        invokeHandler(controllers.Informe4.pdf(documento, semestre), HandlerDef(this, "controllers.Informe4", "pdf", Seq(classOf[String], classOf[String]),"GET", """""", Routes.prefix + """informe4/pdf/$documento<[^/]+>/$semestre<[^/]+>"""))
   }
}
        

// @LINE:16
case controllers_Informe5_excel10(params) => {
   call(params.fromPath[String]("documento", None), params.fromPath[String]("semestre", None)) { (documento, semestre) =>
        invokeHandler(controllers.Informe5.excel(documento, semestre), HandlerDef(this, "controllers.Informe5", "excel", Seq(classOf[String], classOf[String]),"GET", """""", Routes.prefix + """informe5/excel/$documento<[^/]+>/$semestre<[^/]+>"""))
   }
}
        

// @LINE:17
case controllers_Informe5_pdf11(params) => {
   call(params.fromPath[String]("documento", None), params.fromPath[String]("semestre", None)) { (documento, semestre) =>
        invokeHandler(controllers.Informe5.pdf(documento, semestre), HandlerDef(this, "controllers.Informe5", "pdf", Seq(classOf[String], classOf[String]),"GET", """""", Routes.prefix + """informe5/pdf/$documento<[^/]+>/$semestre<[^/]+>"""))
   }
}
        

// @LINE:18
case controllers_Informe6_excel12(params) => {
   call(params.fromPath[String]("documento", None), params.fromPath[String]("semestre", None)) { (documento, semestre) =>
        invokeHandler(controllers.Informe6.excel(documento, semestre), HandlerDef(this, "controllers.Informe6", "excel", Seq(classOf[String], classOf[String]),"GET", """""", Routes.prefix + """informe6/excel/$documento<[^/]+>/$semestre<[^/]+>"""))
   }
}
        

// @LINE:19
case controllers_Informe6_pdf13(params) => {
   call(params.fromPath[String]("documento", None), params.fromPath[String]("semestre", None)) { (documento, semestre) =>
        invokeHandler(controllers.Informe6.pdf(documento, semestre), HandlerDef(this, "controllers.Informe6", "pdf", Seq(classOf[String], classOf[String]),"GET", """""", Routes.prefix + """informe6/pdf/$documento<[^/]+>/$semestre<[^/]+>"""))
   }
}
        

// @LINE:22
case controllers_Informe2_informeProfesor14(params) => {
   call { 
        invokeHandler(controllers.Informe2.informeProfesor(), HandlerDef(this, "controllers.Informe2", "informeProfesor", Nil,"GET", """""", Routes.prefix + """informe2"""))
   }
}
        

// @LINE:23
case controllers_Informe3_informeProfesor15(params) => {
   call { 
        invokeHandler(controllers.Informe3.informeProfesor(), HandlerDef(this, "controllers.Informe3", "informeProfesor", Nil,"GET", """""", Routes.prefix + """informe3"""))
   }
}
        

// @LINE:24
case controllers_Informe1_informeProfesor16(params) => {
   call { 
        invokeHandler(controllers.Informe1.informeProfesor(), HandlerDef(this, "controllers.Informe1", "informeProfesor", Nil,"POST", """""", Routes.prefix + """informeprofesor"""))
   }
}
        

// @LINE:25
case controllers_Informe2_informeProfesor17(params) => {
   call { 
        invokeHandler(controllers.Informe2.informeProfesor(), HandlerDef(this, "controllers.Informe2", "informeProfesor", Nil,"POST", """""", Routes.prefix + """heteroevaluacion"""))
   }
}
        

// @LINE:26
case controllers_Informe3_informeProfesor18(params) => {
   call { 
        invokeHandler(controllers.Informe3.informeProfesor(), HandlerDef(this, "controllers.Informe3", "informeProfesor", Nil,"POST", """""", Routes.prefix + """informefinal"""))
   }
}
        

// @LINE:27
case controllers_Informe4_informeFacultad19(params) => {
   call { 
        invokeHandler(controllers.Informe4.informeFacultad(), HandlerDef(this, "controllers.Informe4", "informeFacultad", Nil,"POST", """""", Routes.prefix + """informefacultad"""))
   }
}
        

// @LINE:28
case controllers_Informe5_informePrograma20(params) => {
   call { 
        invokeHandler(controllers.Informe5.informePrograma(), HandlerDef(this, "controllers.Informe5", "informePrograma", Nil,"POST", """""", Routes.prefix + """informeprograma"""))
   }
}
        

// @LINE:29
case controllers_Informe6_informeParticipantes21(params) => {
   call { 
        invokeHandler(controllers.Informe6.informeParticipantes(), HandlerDef(this, "controllers.Informe6", "informeParticipantes", Nil,"POST", """""", Routes.prefix + """informeparticipantes"""))
   }
}
        

// @LINE:30
case controllers_Application_cambioSemestre22(params) => {
   call { 
        invokeHandler(controllers.Application.cambioSemestre(), HandlerDef(this, "controllers.Application", "cambioSemestre", Nil,"POST", """""", Routes.prefix + """cambiosemestre"""))
   }
}
        

// @LINE:32
case controllers_Assets_at23(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        invokeHandler(controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]),"GET", """ Map static resources from the /public folder to the /assets URL path""", Routes.prefix + """assets/$file<.+>"""))
   }
}
        
}
    
}
        