package vim

object CommandFactory {
  
  case class Command(key: String, help: String, commandExec: CommandExec)
  
  private val COMMAND_MAP = Map(
      "h" -> new Command("h", "Move Left", (state) => state.copy(position = state.position - 1))
  )
  
  def stringToCommand(str: String) = {
    COMMAND_MAP.get(str)
  }

}