package vim

import org.scalatest.FunSpec
import org.scalatest.matchers.ShouldMatchers

class CommandFactorySpec extends FunSpec with ShouldMatchers {

  describe("Command Factory") {
    it("returns a simple command") {
      val command = CommandFactory.stringToCommand("h")
      command.key should be("h")
    }
    
    it("vomits if no matching key") {
      intercept[IllegalStateException] { CommandFactory.stringToCommand("oasdmfojm") }
    }
  }
}