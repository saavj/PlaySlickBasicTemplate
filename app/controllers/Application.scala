package controllers

import com.google.inject.Inject
import play.api.mvc._
import services.database.Logic

class Application @Inject()(logic: Logic) extends Controller {

  def index = Action{ Ok }

}
