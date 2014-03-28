
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
object informeheteroevaluacion extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template6[List[EvaluacionMateria],EvaluacionGestion,EvaluacionInvestigacion,Profesor,String,String,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(evaluacionMateria:List[EvaluacionMateria], evaluacionGestion:EvaluacionGestion, evaluacionInvestigacion:EvaluacionInvestigacion,profesor:Profesor, semestre:String, imagen:String):play.api.templates.Html = {
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
    
    def render(evaluacionMateria:List[EvaluacionMateria],evaluacionGestion:EvaluacionGestion,evaluacionInvestigacion:EvaluacionInvestigacion,profesor:Profesor,semestre:String,imagen:String): play.api.templates.Html = apply(evaluacionMateria,evaluacionGestion,evaluacionInvestigacion,profesor,semestre,imagen)
    
    def f:((List[EvaluacionMateria],EvaluacionGestion,EvaluacionInvestigacion,Profesor,String,String) => play.api.templates.Html) = (evaluacionMateria,evaluacionGestion,evaluacionInvestigacion,profesor,semestre,imagen) => apply(evaluacionMateria,evaluacionGestion,evaluacionInvestigacion,profesor,semestre,imagen)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Fri Mar 28 08:45:18 COT 2014
                    SOURCE: /home/camilo/Documents/InpahuGeneracionInformes/glassfish/ModuloInformes/app/views/pdf/informeheteroevaluacion.scala.html
                    HASH: 31debfbf81d4f2086f40491df138eb144d70eb40
                    MATRIX: 827->1|1136->180|1163->234|1413->449|1440->455|1669->648|1686->656|1723->671|1761->673|1778->681|1813->694|1862->706|1893->714|2519->1305|2571->1341|2610->1342|2656->1352|2702->1389|2750->1399|2799->1412|3138->1742|3184->1750|3234->1765|3254->1776|3294->1778|3395->1843|3414->1853|3462->1878|3508->1887|3528->1897|3575->1921|3681->1991|3697->1998|3796->2074|3904->2146|3920->2153|4015->2225|4123->2297|4139->2304|4235->2377|4343->2449|4359->2456|4454->2528|4562->2600|4578->2607|4677->2683|4746->2720|4806->2748|4850->2760|4894->2772|5559->3402|5611->3438|5650->3439|5699->3452|5745->3489|5793->3499|5842->3512|6181->3842|6227->3850|6277->3865|6297->3876|6337->3878|6438->3943|6457->3953|6505->3978|6551->3987|6571->3997|6618->4021|6726->4093|6742->4100|6841->4176|6949->4248|6965->4255|7060->4327|7168->4399|7184->4406|7280->4479|7388->4551|7404->4558|7499->4630|7607->4702|7623->4709|7722->4785|7777->4808|7851->4850|7895->4862|7939->4874|8607->5506|8660->5542|8700->5543|8748->5554|8795->5591|8844->5601|8894->5614|9234->5944|9281->5952|9332->5967|9353->5978|9394->5980|9496->6045|9516->6055|9565->6080|9612->6089|9633->6099|9681->6123|9788->6193|9805->6200|9905->6276|10014->6348|10031->6355|10127->6427|10236->6499|10253->6506|10350->6579|10459->6651|10476->6658|10572->6730|10681->6802|10698->6809|10798->6885|10854->6908|10929->6950|10974->6962|11019->6974|11317->7235|11346->7241|11574->7432|11592->7440|11630->7455|11669->7457|11687->7465|11723->7478|11773->7490|11805->7498|12324->7980|12371->8017|12420->8027|12470->8040|12760->8320|12807->8328|12858->8343|12879->8354|12920->8356|13091->8490|13108->8497|13212->8577|13321->8649|13338->8656|13438->8732|13547->8804|13564->8811|13665->8888|13774->8960|13791->8967|13891->9043|13976->9095|14038->9124|14083->9136|14761->9777|14808->9814|14857->9824|14907->9837|15291->10211|15338->10219|15389->10234|15410->10245|15451->10247|15631->10390|15648->10397|15758->10483|15867->10555|15884->10562|15990->10644|16099->10716|16116->10723|16223->10806|16332->10878|16349->10885|16455->10967|16563->11038|16580->11045|16690->11131|16758->11166|16820->11195|16865->11207
                    LINES: 26->1|32->1|33->4|38->9|38->9|44->15|44->15|44->15|44->15|44->15|44->15|44->15|44->15|58->29|58->29|58->29|59->30|59->30|59->30|60->31|65->36|65->36|67->38|67->38|67->38|68->39|68->39|68->39|68->39|68->39|68->39|69->40|69->40|69->40|70->41|70->41|70->41|71->42|71->42|71->42|72->43|72->43|72->43|73->44|73->44|73->44|75->46|77->48|78->49|79->50|95->66|95->66|95->66|96->67|96->67|96->67|97->68|102->73|102->73|104->75|104->75|104->75|105->76|105->76|105->76|105->76|105->76|105->76|106->77|106->77|106->77|107->78|107->78|107->78|108->79|108->79|108->79|109->80|109->80|109->80|110->81|110->81|110->81|111->82|114->85|115->86|116->87|131->102|131->102|131->102|132->103|132->103|132->103|133->104|138->109|138->109|140->111|140->111|140->111|141->112|141->112|141->112|141->112|141->112|141->112|142->113|142->113|142->113|143->114|143->114|143->114|144->115|144->115|144->115|145->116|145->116|145->116|146->117|146->117|146->117|147->118|150->121|151->122|152->123|160->131|160->131|166->137|166->137|166->137|166->137|166->137|166->137|166->137|166->137|180->151|180->151|180->151|181->152|185->156|185->156|187->158|187->158|187->158|189->160|189->160|189->160|190->161|190->161|190->161|191->162|191->162|191->162|192->163|192->163|192->163|195->166|197->168|198->169|217->188|217->188|217->188|218->189|223->194|223->194|225->196|225->196|225->196|230->201|230->201|230->201|231->202|231->202|231->202|232->203|232->203|232->203|233->204|233->204|233->204|234->205|234->205|234->205|236->207|238->209|239->210
                    -- GENERATED --
                */
            