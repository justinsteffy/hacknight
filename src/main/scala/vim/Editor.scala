package vim

class Editor(var state: EditorState = EditorState("", 0)) {
  
  def insertText(text: String) = {
    val content = new StringBuilder(state.content)
    var position = state.position
     content.insert(position, text)
     position += text.length - 1
     
     state = EditorState(content.toString, position)
     state
   }
  
  def executeCommand(commandStr: String) = {
    val command = CommandFactory.stringToCommand(commandStr)
    state = command.commandExec(state)
    state
  }
  
  def content = state.content
  def position = state.position

}