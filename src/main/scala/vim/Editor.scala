package vim

class Editor(var state: EditorState = EditorState(Vector(""), (0, 0))) {
  
  def insertText(text: String) = {
     val newLine = new StringBuilder(line).insert(col, text).toString
     val newPosition = (row, col + text.length - 1)
     
     state = EditorState(state.content.updated(row, newLine), newPosition)
     state
   }
  
  def executeCommand(commandStr: String) = {
    val command = CommandFactory.stringToCommand(commandStr)
    state = command.commandExec(state)
    state
  }
  
  def line = state.line
  def row = state.row
  def col = state.col

}