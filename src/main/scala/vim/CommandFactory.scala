package vim

object CommandFactory {
  
  case class Command(val key: String, val help: String, val commandExec: CommandExec)
  
  private val COMMAND_MAP = Map(
      "h" -> new Command("h", "Move Left", (state) => state.copy(position = if(state.position > 0) state.position - 1 else 0))
  )
  
  def stringToCommand(str: String) = {
    COMMAND_MAP.get(str).getOrElse {  throw new IllegalStateException(s"Cant find command for string ${str}") }
  }

}