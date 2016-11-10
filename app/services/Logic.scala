package services.database

import com.google.inject.Inject
import play.api.libs.json.Json

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

case class Example(example: String)
object Example {
  implicit val exampleFormat = Json.format[Example]
}

class Logic @Inject()(repo: ExampleRepo) {
  import repo.dbConfig.driver.api._

  def addClient(example: Example): Future[Unit] =
    repo.db.run(repo.clients += ExampleRecord(0, example.example)).map(_=>())
}
