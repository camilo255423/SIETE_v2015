
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
                    DATE: Wed Apr 02 13:48:42 COT 2014
                    SOURCE: /home/camilo/Documents/InpahuGeneracionInformes/ModuloInformes/app/views/pdf/informeheteroevaluacion.scala.html
                    HASH: 3a765ccabca3ab5ce676738701ae67bd1b7f7fc2
                    MATRIX: 878->1|1204->180|1231->234|1481->449|1508->455|1737->648|1754->656|1791->671|1829->673|1846->681|1881->694|1930->706|1961->714|2587->1305|2639->1341|2678->1342|2724->1352|2770->1389|2818->1399|2867->1412|3206->1742|3252->1750|3302->1765|3322->1776|3362->1778|3463->1843|3482->1853|3530->1878|3576->1887|3596->1897|3643->1921|3749->1991|3765->1998|3864->2074|3972->2146|3988->2153|4083->2225|4191->2297|4207->2304|4303->2377|4411->2449|4427->2456|4522->2528|4630->2600|4646->2607|4745->2683|4814->2720|4874->2748|4918->2760|4962->2772|5627->3402|5679->3438|5718->3439|5767->3452|5813->3489|5861->3499|5910->3512|6249->3842|6295->3850|6345->3865|6365->3876|6405->3878|6506->3943|6525->3953|6573->3978|6619->3987|6639->3997|6686->4021|6794->4093|6810->4100|6909->4176|7017->4248|7033->4255|7128->4327|7236->4399|7252->4406|7348->4479|7456->4551|7472->4558|7567->4630|7675->4702|7691->4709|7790->4785|7845->4808|7919->4850|7963->4862|8007->4874|8675->5506|8728->5542|8768->5543|8816->5554|8863->5591|8912->5601|8962->5614|9302->5944|9349->5952|9400->5967|9421->5978|9462->5980|9564->6045|9584->6055|9633->6080|9680->6089|9701->6099|9749->6123|9856->6193|9873->6200|9973->6276|10082->6348|10099->6355|10195->6427|10304->6499|10321->6506|10418->6579|10527->6651|10544->6658|10640->6730|10749->6802|10766->6809|10866->6885|10922->6908|10997->6950|11042->6962|11087->6974|11385->7235|11414->7241|11642->7432|11660->7440|11698->7455|11737->7457|11755->7465|11791->7478|11841->7490|11873->7498|12392->7980|12439->8017|12488->8027|12538->8040|12828->8320|12875->8328|12926->8343|12947->8354|12988->8356|13159->8490|13176->8497|13280->8577|13389->8649|13406->8656|13506->8732|13615->8804|13632->8811|13733->8888|13842->8960|13859->8967|13959->9043|14044->9095|14106->9124|14151->9136|14829->9777|14876->9814|14925->9824|14975->9837|15359->10211|15406->10219|15457->10234|15478->10245|15519->10247|15699->10390|15716->10397|15826->10483|15935->10555|15952->10562|16058->10644|16167->10716|16184->10723|16291->10806|16400->10878|16417->10885|16523->10967|16631->11038|16648->11045|16758->11131|16826->11166|16888->11195|16933->11207
                    LINES: 26->1|32->1|33->4|38->9|38->9|44->15|44->15|44->15|44->15|44->15|44->15|44->15|44->15|58->29|58->29|58->29|59->30|59->30|59->30|60->31|65->36|65->36|67->38|67->38|67->38|68->39|68->39|68->39|68->39|68->39|68->39|69->40|69->40|69->40|70->41|70->41|70->41|71->42|71->42|71->42|72->43|72->43|72->43|73->44|73->44|73->44|75->46|77->48|78->49|79->50|95->66|95->66|95->66|96->67|96->67|96->67|97->68|102->73|102->73|104->75|104->75|104->75|105->76|105->76|105->76|105->76|105->76|105->76|106->77|106->77|106->77|107->78|107->78|107->78|108->79|108->79|108->79|109->80|109->80|109->80|110->81|110->81|110->81|111->82|114->85|115->86|116->87|131->102|131->102|131->102|132->103|132->103|132->103|133->104|138->109|138->109|140->111|140->111|140->111|141->112|141->112|141->112|141->112|141->112|141->112|142->113|142->113|142->113|143->114|143->114|143->114|144->115|144->115|144->115|145->116|145->116|145->116|146->117|146->117|146->117|147->118|150->121|151->122|152->123|160->131|160->131|166->137|166->137|166->137|166->137|166->137|166->137|166->137|166->137|180->151|180->151|180->151|181->152|185->156|185->156|187->158|187->158|187->158|189->160|189->160|189->160|190->161|190->161|190->161|191->162|191->162|191->162|192->163|192->163|192->163|195->166|197->168|198->169|217->188|217->188|217->188|218->189|223->194|223->194|225->196|225->196|225->196|230->201|230->201|230->201|231->202|231->202|231->202|232->203|232->203|232->203|233->204|233->204|233->204|234->205|234->205|234->205|236->207|238->209|239->210
                    -- GENERATED --
                */
            