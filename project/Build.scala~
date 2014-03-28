import sbt._
import Keys._
import play.Project._
import com.github.play2war.plugin._

object ApplicationBuild extends Build {

  val appName         = "informes"
  val appVersion      = "1"

  val appDependencies = Seq(
    
    jdbc,
 anorm
  )


  val main = PlayProject(appName, appVersion, appDependencies, mainLang = JAVA)
  .settings(Play2WarPlugin.play2WarSettings: _*)

  .settings(
    Play2WarKeys.servletVersion := "3.0"
    )
   

}


