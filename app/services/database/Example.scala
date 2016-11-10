package services.database

import com.google.inject.Inject
import play.api.db.slick.DatabaseConfigProvider
import play.api.libs.json.Json
import slick.driver.JdbcProfile

case class ExampleRecord(id: Int, example: String)
object ExampleRecord {
  implicit val exampleRecordFormat = Json.format[ExampleRecord]
}

class ExampleRepo @Inject()(protected val dbConfigProvider: DatabaseConfigProvider) {
  val dbConfig = dbConfigProvider.get[JdbcProfile]
  val db       = dbConfig.db

  import dbConfig.driver.api._
  val clients = TableQuery[ExampleTable]

  class ExampleTable(tag: Tag) extends Table[ExampleRecord](tag, "EXAMPLE") {

    def id = column[Int]("ID", O.AutoInc, O.PrimaryKey)
    def example = column[String]("EXAMPLE")

    def * = (id, example) <> ((ExampleRecord.apply _).tupled, ExampleRecord.unapply)
  }
}