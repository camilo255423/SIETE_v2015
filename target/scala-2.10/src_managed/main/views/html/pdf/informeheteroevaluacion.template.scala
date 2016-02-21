
package views.html.pdf

import play.templates._
import play.templates.TemplateMagic._

import play.api.templates._
import play.api.templates.PlayMagic._
import models._
import controllers._
import java.lang._
import java.util._
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import play.api.i18n._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.data._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._
import views.html._
/**/
object informeheteroevaluacion extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template6[List[EvaluacionMateria],EvaluacionGestion,EvaluacionInvestigacion,Profesor,String,String,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(evaluacionMateria:List[EvaluacionMateria], evaluacionGestion:EvaluacionGestion, evaluacionInvestigacion:EvaluacionInvestigacion,profesor:Profesor, semestre:String, imagen:String):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import models.Nivel

import java.text.DecimalFormat


Seq[Any](format.raw/*1.181*/("""
"""),format.raw/*4.1*/("""      
 	<div id="tabs-evalgestion" style='page-break-after:always;'>
	   	<table width='704'>
  	 <tr style="font-size: 8pt;">
    <td width='222'>&nbsp;</td>
    <td width='466'><img width='219' height='63' src='"""),_display_(Seq[Any](/*9.56*/imagen)),format.raw/*9.62*/("""' alt='Logo title='Logo'  align='left' hspace='12' /></td>
  	</tr>
  	
	</table>
    <div style="text-align:center"><p><b>Oficina de Aseguramiento de la Calidad</b></p></div>
	<div style="text-align:center"><h3>Heteroevaluación</h3></div>
	<div style="text-align:center"><h4>Docente: """),_display_(Seq[Any](/*15.47*/profesor/*15.55*/.getApellidos())),format.raw/*15.70*/(""" """),_display_(Seq[Any](/*15.72*/profesor/*15.80*/.getNombres())),format.raw/*15.93*/(""", Periodo: """),_display_(Seq[Any](/*15.105*/semestre)),format.raw/*15.113*/("""</h4></div>
	
	<div style="text-align:center"><h2>Saber Pedagógico</h2></div>
	
	<table border='1'>
	<tbody>
        <tr>
        <td style="font-size: 8pt; class="row_headers">Asignatura</td>
		<td style="font-size: 8pt; class="row_headers" >Nivel<br></br>Inferior</td>
		<td style="font-size: 8pt; class="row_headers" >Nivel<br></br>Bajo</td>
		<td style="font-size: 8pt; class="row_headers" >Nivel<br></br>Medio</td>
		<td style="font-size: 8pt; class="row_headers" >Nivel<br></br>Alto</td>
		<td style="font-size: 8pt; class="row_headers" >Nivel<br></br>Superior</td>
	     </tr>
	     """),_display_(Seq[Any](/*29.8*/for(evaluacion <- evaluacionMateria) yield /*29.44*/{_display_(Seq[Any](format.raw/*29.45*/("""
	       """),_display_(Seq[Any](/*30.10*/defining(new DecimalFormat("##0.00"))/*30.47*/{formato=>_display_(Seq[Any](format.raw/*30.57*/("""
       	   """),_display_(Seq[Any](/*31.13*/defining((evaluacion.getPromedioRespuestas()(0)(Nivel.INFERIOR)+
       	   evaluacion.getPromedioRespuestas()(0)(Nivel.BAJO)+
       	   evaluacion.getPromedioRespuestas()(0)(Nivel.MEDIO)+
       	   evaluacion.getPromedioRespuestas()(0)(Nivel.ALTO)+
       	   evaluacion.getPromedioRespuestas()(0)(Nivel.SUPERIOR))
       	   )/*36.13*/{total=>_display_(Seq[Any](format.raw/*36.21*/("""
	     <tr>
		"""),_display_(Seq[Any](/*38.4*/if(total>0)/*38.15*/ {_display_(Seq[Any](format.raw/*38.17*/("""
                <td style="font-size: 8pt; class="row_headers">"""),_display_(Seq[Any](/*39.65*/evaluacion/*39.75*/.getMateria().getNombre())),format.raw/*39.100*/(""", grupo """),_display_(Seq[Any](/*39.109*/evaluacion/*39.119*/.getMateria().getGrupo())),format.raw/*39.143*/("""</td>
                <td style="font-size: 8pt; class="row_headers">"""),_display_(Seq[Any](/*40.65*/formato/*40.72*/.format((100.0*evaluacion.getPromedioRespuestas()(0)(Nivel.INFERIOR)/total)))),format.raw/*40.148*/(""" %</td>
                <td style="font-size: 8pt; class="row_headers">"""),_display_(Seq[Any](/*41.65*/formato/*41.72*/.format((100.0*evaluacion.getPromedioRespuestas()(0)(Nivel.BAJO)/total)))),format.raw/*41.144*/(""" %</td>
                <td style="font-size: 8pt; class="row_headers">"""),_display_(Seq[Any](/*42.65*/formato/*42.72*/.format((100.0*evaluacion.getPromedioRespuestas()(0)(Nivel.MEDIO)/total)))),format.raw/*42.145*/(""" %</td>
                <td style="font-size: 8pt; class="row_headers">"""),_display_(Seq[Any](/*43.65*/formato/*43.72*/.format((100.0*evaluacion.getPromedioRespuestas()(0)(Nivel.ALTO)/total)))),format.raw/*43.144*/(""" %</td>
                <td style="font-size: 8pt; class="row_headers">"""),_display_(Seq[Any](/*44.65*/formato/*44.72*/.format((100.0*evaluacion.getPromedioRespuestas()(0)(Nivel.SUPERIOR)/total)))),format.raw/*44.148*/(""" %</td>
              
             """)))})),format.raw/*46.15*/("""
          </tr>
          """)))})),format.raw/*48.12*/("""
          """)))})),format.raw/*49.12*/("""
          """)))})),format.raw/*50.12*/("""
          </tbody>
          </table>
          	<div style="text-align:center"><h2>Saber Específico</h2></div>
   	
	<table border='1'>
	<tbody>
	   
        <tr>
        <td style="font-size: 8pt; class="row_headers">Asignatura</td>
		<td style="font-size: 8pt; class="row_headers">Nivel<br></br>Inferior</td>
		<td style="font-size: 8pt; class="row_headers">Nivel<br></br>Bajo</td>
		<td style="font-size: 8pt; class="row_headers">Nivel<br></br>Medio</td>
		<td style="font-size: 8pt; class="row_headers">Nivel<br></br>Alto</td>
		<td style="font-size: 8pt; class="row_headers">Nivel<br></br>Superior</td>
	     </tr>
	      """),_display_(Seq[Any](/*66.9*/for(evaluacion <- evaluacionMateria) yield /*66.45*/{_display_(Seq[Any](format.raw/*66.46*/("""   
	       """),_display_(Seq[Any](/*67.10*/defining(new DecimalFormat("##0.00"))/*67.47*/{formato=>_display_(Seq[Any](format.raw/*67.57*/("""
       	   """),_display_(Seq[Any](/*68.13*/defining((evaluacion.getPromedioRespuestas()(1)(Nivel.INFERIOR)+
       	   evaluacion.getPromedioRespuestas()(1)(Nivel.BAJO)+
       	   evaluacion.getPromedioRespuestas()(1)(Nivel.MEDIO)+
       	   evaluacion.getPromedioRespuestas()(1)(Nivel.ALTO)+
       	   evaluacion.getPromedioRespuestas()(1)(Nivel.SUPERIOR))
       	   )/*73.13*/{total=>_display_(Seq[Any](format.raw/*73.21*/("""
	     <tr>
		"""),_display_(Seq[Any](/*75.4*/if(total>0)/*75.15*/ {_display_(Seq[Any](format.raw/*75.17*/("""
                <td style="font-size: 8pt; class="row_headers">"""),_display_(Seq[Any](/*76.65*/evaluacion/*76.75*/.getMateria().getNombre())),format.raw/*76.100*/(""", grupo """),_display_(Seq[Any](/*76.109*/evaluacion/*76.119*/.getMateria().getGrupo())),format.raw/*76.143*/(""" %</td>
                <td style="font-size: 8pt; class="row_headers">"""),_display_(Seq[Any](/*77.65*/formato/*77.72*/.format((100.0*evaluacion.getPromedioRespuestas()(1)(Nivel.INFERIOR)/total)))),format.raw/*77.148*/(""" %</td>
                <td style="font-size: 8pt; class="row_headers">"""),_display_(Seq[Any](/*78.65*/formato/*78.72*/.format((100.0*evaluacion.getPromedioRespuestas()(1)(Nivel.BAJO)/total)))),format.raw/*78.144*/(""" %</td>
                <td style="font-size: 8pt; class="row_headers">"""),_display_(Seq[Any](/*79.65*/formato/*79.72*/.format((100.0*evaluacion.getPromedioRespuestas()(1)(Nivel.MEDIO)/total)))),format.raw/*79.145*/(""" %</td>
                <td style="font-size: 8pt; class="row_headers">"""),_display_(Seq[Any](/*80.65*/formato/*80.72*/.format((100.0*evaluacion.getPromedioRespuestas()(1)(Nivel.ALTO)/total)))),format.raw/*80.144*/(""" %</td>
                <td style="font-size: 8pt; class="row_headers">"""),_display_(Seq[Any](/*81.65*/formato/*81.72*/.format((100.0*evaluacion.getPromedioRespuestas()(1)(Nivel.SUPERIOR)/total)))),format.raw/*81.148*/(""" %</td>
              """)))})),format.raw/*82.16*/("""
             
          </tr>
          """)))})),format.raw/*85.12*/("""
          """)))})),format.raw/*86.12*/("""
          """)))})),format.raw/*87.12*/("""
          </tbody>
          </table>
          <div style="text-align:center"><h2>Saber Relacional</h2></div>
           <table border='1'>
	<tbody>
	  
        <tr>
        <td style="font-size: 8pt; class="row_headers">Asignatura</td>
		<td style="font-size: 8pt; class="row_headers">Nivel<br></br>Inferior</td>
		<td style="font-size: 8pt; class="row_headers">Nivel<br></br>Bajo</td>
		<td style="font-size: 8pt; class="row_headers">Nivel<br></br>Medio</td>
		<td style="font-size: 8pt; class="row_headers">Nivel<br></br>Alto</td>
		<td style="font-size: 8pt; class="row_headers">Nivel<br></br>Superior</td>
	     </tr>
	     """),_display_(Seq[Any](/*102.8*/for(evaluacion <- evaluacionMateria) yield /*102.44*/{_display_(Seq[Any](format.raw/*102.45*/(""" 
	       """),_display_(Seq[Any](/*103.10*/defining(new DecimalFormat("##0.00"))/*103.47*/{formato=>_display_(Seq[Any](format.raw/*103.57*/("""
       	   """),_display_(Seq[Any](/*104.13*/defining((evaluacion.getPromedioRespuestas()(2)(Nivel.INFERIOR)+
       	   evaluacion.getPromedioRespuestas()(2)(Nivel.BAJO)+
       	   evaluacion.getPromedioRespuestas()(2)(Nivel.MEDIO)+
       	   evaluacion.getPromedioRespuestas()(2)(Nivel.ALTO)+
       	   evaluacion.getPromedioRespuestas()(2)(Nivel.SUPERIOR))
       	   )/*109.13*/{total=>_display_(Seq[Any](format.raw/*109.21*/("""
	     <tr>
		"""),_display_(Seq[Any](/*111.4*/if(total>0)/*111.15*/ {_display_(Seq[Any](format.raw/*111.17*/("""
                <td style="font-size: 8pt; class="row_headers">"""),_display_(Seq[Any](/*112.65*/evaluacion/*112.75*/.getMateria().getNombre())),format.raw/*112.100*/(""", grupo """),_display_(Seq[Any](/*112.109*/evaluacion/*112.119*/.getMateria().getGrupo())),format.raw/*112.143*/("""</td>
                <td style="font-size: 8pt; class="row_headers">"""),_display_(Seq[Any](/*113.65*/formato/*113.72*/.format((100.0*evaluacion.getPromedioRespuestas()(2)(Nivel.INFERIOR)/total)))),format.raw/*113.148*/(""" %</td>
                <td style="font-size: 8pt; class="row_headers">"""),_display_(Seq[Any](/*114.65*/formato/*114.72*/.format((100.0*evaluacion.getPromedioRespuestas()(2)(Nivel.BAJO)/total)))),format.raw/*114.144*/(""" %</td>
                <td style="font-size: 8pt; class="row_headers">"""),_display_(Seq[Any](/*115.65*/formato/*115.72*/.format((100.0*evaluacion.getPromedioRespuestas()(2)(Nivel.MEDIO)/total)))),format.raw/*115.145*/(""" %</td>
                <td style="font-size: 8pt; class="row_headers">"""),_display_(Seq[Any](/*116.65*/formato/*116.72*/.format((100.0*evaluacion.getPromedioRespuestas()(2)(Nivel.ALTO)/total)))),format.raw/*116.144*/(""" %</td>
                <td style="font-size: 8pt; class="row_headers">"""),_display_(Seq[Any](/*117.65*/formato/*117.72*/.format((100.0*evaluacion.getPromedioRespuestas()(2)(Nivel.SUPERIOR)/total)))),format.raw/*117.148*/(""" %</td>
              """)))})),format.raw/*118.16*/("""
             
          </tr>
          """)))})),format.raw/*121.12*/("""
          """)))})),format.raw/*122.12*/("""
          """)))})),format.raw/*123.12*/("""
          </tbody>
          </table>
      </div>    
<div id="tabs-evalgestion" style='page-break-after:always;'>
   	<table width='704'>
  	 <tr style="font-size: 8pt;">
    <td width='222'>&nbsp;</td>
    <td width='466'><img width='219' height='63' src='"""),_display_(Seq[Any](/*131.56*/imagen)),format.raw/*131.62*/("""' alt='Logo title='Logo'  align='left' hspace='12' /></td>
  	</tr>
  	
	</table>

<div style="text-align:center"><h3>Heteroevaluación</h3></div>
<div style="text-align:center"><h4>Docente: """),_display_(Seq[Any](/*137.46*/profesor/*137.54*/.getApellidos())),format.raw/*137.69*/(""" """),_display_(Seq[Any](/*137.71*/profesor/*137.79*/.getNombres())),format.raw/*137.92*/(""", Periodo: """),_display_(Seq[Any](/*137.104*/semestre)),format.raw/*137.112*/("""</h4></div>	
<div style="text-align:center"><h2>Gestión</h2></div>
       	
	<table border='1'>
	<tbody>
	  
        <tr>
        <td style="font-size: 8pt; class="row_headers"></td>
		<td style="font-size: 8pt; class="row_headers">No Cumple</td>
		<td style="font-size: 8pt; class="row_headers">Cumple Parcialmente</td>
		<td style="font-size: 8pt; class="row_headers">Cumple Totalmente</td>
		<td style="font-size: 8pt; class="row_headers">No Aplica</td>
	     </tr>
	  
	       """),_display_(Seq[Any](/*151.10*/defining(new DecimalFormat("##0.00"))/*151.47*/{formato=>_display_(Seq[Any](format.raw/*151.57*/("""
       	   """),_display_(Seq[Any](/*152.13*/defining((evaluacionGestion.getPromedioRespuestas()(Nivel.INFERIOR)+
       	   evaluacionGestion.getPromedioRespuestas()(Nivel.BAJO)+
       	   evaluacionGestion.getPromedioRespuestas()(Nivel.MEDIO)+
       	   evaluacionGestion.getPromedioRespuestas()(Nivel.ALTO)
       	   ))/*156.14*/{total=>_display_(Seq[Any](format.raw/*156.22*/("""
	     <tr>
		"""),_display_(Seq[Any](/*158.4*/if(total>0)/*158.15*/ {_display_(Seq[Any](format.raw/*158.17*/("""
                <td style="font-size: 8pt; class="row_headers"></td>
                <td style="font-size: 8pt; class="row_headers">"""),_display_(Seq[Any](/*160.65*/formato/*160.72*/.format((100.0*evaluacionGestion.getPromedioRespuestas()(Nivel.INFERIOR)/total)))),format.raw/*160.152*/(""" %</td>
                <td style="font-size: 8pt; class="row_headers">"""),_display_(Seq[Any](/*161.65*/formato/*161.72*/.format((100.0*evaluacionGestion.getPromedioRespuestas()(Nivel.BAJO)/total)))),format.raw/*161.148*/(""" %</td>
                <td style="font-size: 8pt; class="row_headers">"""),_display_(Seq[Any](/*162.65*/formato/*162.72*/.format((100.0*evaluacionGestion.getPromedioRespuestas()(Nivel.MEDIO)/total)))),format.raw/*162.149*/(""" %</td>
                <td style="font-size: 8pt; class="row_headers">"""),_display_(Seq[Any](/*163.65*/formato/*163.72*/.format((100.0*evaluacionGestion.getPromedioRespuestas()(Nivel.ALTO)/total)))),format.raw/*163.148*/(""" %</td>
               
              
            """)))})),format.raw/*166.14*/(""" 
          </tr>
          """)))})),format.raw/*168.12*/("""
          """)))})),format.raw/*169.12*/("""
          
          </tbody>
          </table>
          
     <div style="text-align:center"><h2>Investigación</h2></div>
       	
	<table border='1'>
	<tbody>
	  
        <tr>
        <td style="font-size: 8pt; class="row_headers"></td>
		<td style="font-size: 8pt; class="row_headers">Nivel<br></br>Inferior</td>
		<td style="font-size: 8pt; class="row_headers">Nivel<br></br>Bajo</td>
		<td style="font-size: 8pt; class="row_headers">Nivel<br></br>Medio</td>
		<td style="font-size: 8pt; class="row_headers">Nivel<br></br>Alto</td>
		<td style="font-size: 8pt; class="row_headers">Nivel<br></br>Superior</td>
	     </tr>
	  
	       """),_display_(Seq[Any](/*188.10*/defining(new DecimalFormat("##0.00"))/*188.47*/{formato=>_display_(Seq[Any](format.raw/*188.57*/("""
       	   """),_display_(Seq[Any](/*189.13*/defining((evaluacionGestion.getPromedioRespuestas()(Nivel.INFERIOR)+
       	   evaluacionInvestigacion.getPromedioRespuestas()(Nivel.BAJO)+
       	   evaluacionInvestigacion.getPromedioRespuestas()(Nivel.MEDIO)+
       	   evaluacionInvestigacion.getPromedioRespuestas()(Nivel.ALTO)+
       	   evaluacionInvestigacion.getPromedioRespuestas()(Nivel.SUPERIOR)
       	   ))/*194.14*/{total=>_display_(Seq[Any](format.raw/*194.22*/("""
	     <tr>
		"""),_display_(Seq[Any](/*196.4*/if(total>0)/*196.15*/ {_display_(Seq[Any](format.raw/*196.17*/("""
		
		
		
                <td style="font-size: 8pt; class="row_headers"></td>
                <td style="font-size: 8pt; class="row_headers">"""),_display_(Seq[Any](/*201.65*/formato/*201.72*/.format((100.0*evaluacionInvestigacion.getPromedioRespuestas()(Nivel.INFERIOR)/total)))),format.raw/*201.158*/(""" %</td>
                <td style="font-size: 8pt; class="row_headers">"""),_display_(Seq[Any](/*202.65*/formato/*202.72*/.format((100.0*evaluacionInvestigacion.getPromedioRespuestas()(Nivel.BAJO)/total)))),format.raw/*202.154*/(""" %</td>
                <td style="font-size: 8pt; class="row_headers">"""),_display_(Seq[Any](/*203.65*/formato/*203.72*/.format((100.0*evaluacionInvestigacion.getPromedioRespuestas()(Nivel.MEDIO)/total)))),format.raw/*203.155*/(""" %</td>
                <td style="font-size: 8pt; class="row_headers">"""),_display_(Seq[Any](/*204.65*/formato/*204.72*/.format((100.0*evaluacionInvestigacion.getPromedioRespuestas()(Nivel.ALTO)/total)))),format.raw/*204.154*/(""" %</td>
               <td style="font-size: 8pt; class="row_headers">"""),_display_(Seq[Any](/*205.64*/formato/*205.71*/.format((100.0*evaluacionInvestigacion.getPromedioRespuestas()(Nivel.SUPERIOR)/total)))),format.raw/*205.157*/(""" %</td>
              
           """)))})),format.raw/*207.13*/(""" 
          </tr>
          """)))})),format.raw/*209.12*/("""
          """)))})),format.raw/*210.12*/("""
          
          </tbody>
          </table>
		 



</div> <!-- gest-invest --> 

"""))}
    }
    
    def render(evaluacionMateria:List[EvaluacionMateria],evaluacionGestion:EvaluacionGestion,evaluacionInvestigacion:EvaluacionInvestigacion,profesor:Profesor,semestre:String,imagen:String): play.api.templates.HtmlFormat.Appendable = apply(evaluacionMateria,evaluacionGestion,evaluacionInvestigacion,profesor,semestre,imagen)
    
    def f:((List[EvaluacionMateria],EvaluacionGestion,EvaluacionInvestigacion,Profesor,String,String) => play.api.templates.HtmlFormat.Appendable) = (evaluacionMateria,evaluacionGestion,evaluacionInvestigacion,profesor,semestre,imagen) => apply(evaluacionMateria,evaluacionGestion,evaluacionInvestigacion,profesor,semestre,imagen)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Aug 03 10:49:40 COT 2014
                    SOURCE: /home/camilo/Documents/InpahuGeneracionInformes/fuentes_SIETE/SIETE/app/views/pdf/informeheteroevaluacion.scala.html
                    HASH: 7d7a6ce7fec998e4fff14637719b1b2a10cf8db6
                    MATRIX: 878->1|1204->180|1231->234|1481->449|1508->455|1830->741|1847->749|1884->764|1922->766|1939->774|1974->787|2023->799|2054->807|2680->1398|2732->1434|2771->1435|2817->1445|2863->1482|2911->1492|2960->1505|3299->1835|3345->1843|3395->1858|3415->1869|3455->1871|3556->1936|3575->1946|3623->1971|3669->1980|3689->1990|3736->2014|3842->2084|3858->2091|3957->2167|4065->2239|4081->2246|4176->2318|4284->2390|4300->2397|4396->2470|4504->2542|4520->2549|4615->2621|4723->2693|4739->2700|4838->2776|4907->2813|4967->2841|5011->2853|5055->2865|5720->3495|5772->3531|5811->3532|5860->3545|5906->3582|5954->3592|6003->3605|6342->3935|6388->3943|6438->3958|6458->3969|6498->3971|6599->4036|6618->4046|6666->4071|6712->4080|6732->4090|6779->4114|6887->4186|6903->4193|7002->4269|7110->4341|7126->4348|7221->4420|7329->4492|7345->4499|7441->4572|7549->4644|7565->4651|7660->4723|7768->4795|7784->4802|7883->4878|7938->4901|8012->4943|8056->4955|8100->4967|8768->5599|8821->5635|8861->5636|8909->5647|8956->5684|9005->5694|9055->5707|9395->6037|9442->6045|9493->6060|9514->6071|9555->6073|9657->6138|9677->6148|9726->6173|9773->6182|9794->6192|9842->6216|9949->6286|9966->6293|10066->6369|10175->6441|10192->6448|10288->6520|10397->6592|10414->6599|10511->6672|10620->6744|10637->6751|10733->6823|10842->6895|10859->6902|10959->6978|11015->7001|11090->7043|11135->7055|11180->7067|11478->7328|11507->7334|11735->7525|11753->7533|11791->7548|11830->7550|11848->7558|11884->7571|11934->7583|11966->7591|12485->8073|12532->8110|12581->8120|12631->8133|12921->8413|12968->8421|13019->8436|13040->8447|13081->8449|13252->8583|13269->8590|13373->8670|13482->8742|13499->8749|13599->8825|13708->8897|13725->8904|13826->8981|13935->9053|13952->9060|14052->9136|14137->9188|14199->9217|14244->9229|14922->9870|14969->9907|15018->9917|15068->9930|15452->10304|15499->10312|15550->10327|15571->10338|15612->10340|15792->10483|15809->10490|15919->10576|16028->10648|16045->10655|16151->10737|16260->10809|16277->10816|16384->10899|16493->10971|16510->10978|16616->11060|16724->11131|16741->11138|16851->11224|16919->11259|16981->11288|17026->11300
                    LINES: 26->1|32->1|33->4|38->9|38->9|44->15|44->15|44->15|44->15|44->15|44->15|44->15|44->15|58->29|58->29|58->29|59->30|59->30|59->30|60->31|65->36|65->36|67->38|67->38|67->38|68->39|68->39|68->39|68->39|68->39|68->39|69->40|69->40|69->40|70->41|70->41|70->41|71->42|71->42|71->42|72->43|72->43|72->43|73->44|73->44|73->44|75->46|77->48|78->49|79->50|95->66|95->66|95->66|96->67|96->67|96->67|97->68|102->73|102->73|104->75|104->75|104->75|105->76|105->76|105->76|105->76|105->76|105->76|106->77|106->77|106->77|107->78|107->78|107->78|108->79|108->79|108->79|109->80|109->80|109->80|110->81|110->81|110->81|111->82|114->85|115->86|116->87|131->102|131->102|131->102|132->103|132->103|132->103|133->104|138->109|138->109|140->111|140->111|140->111|141->112|141->112|141->112|141->112|141->112|141->112|142->113|142->113|142->113|143->114|143->114|143->114|144->115|144->115|144->115|145->116|145->116|145->116|146->117|146->117|146->117|147->118|150->121|151->122|152->123|160->131|160->131|166->137|166->137|166->137|166->137|166->137|166->137|166->137|166->137|180->151|180->151|180->151|181->152|185->156|185->156|187->158|187->158|187->158|189->160|189->160|189->160|190->161|190->161|190->161|191->162|191->162|191->162|192->163|192->163|192->163|195->166|197->168|198->169|217->188|217->188|217->188|218->189|223->194|223->194|225->196|225->196|225->196|230->201|230->201|230->201|231->202|231->202|231->202|232->203|232->203|232->203|233->204|233->204|233->204|234->205|234->205|234->205|236->207|238->209|239->210
                    -- GENERATED --
                */
            