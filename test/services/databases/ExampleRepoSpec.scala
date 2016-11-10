package services.databases

import org.scalatestplus.play.PlaySpec
import play.api.libs.json.Json
import services.database.ExampleRecord

class ExampleRepoSpec extends PlaySpec {

  "Example" should {
    "write to Json" in {
      Json.toJson(ExampleRecord(1, "example"))
    }
  }

}
