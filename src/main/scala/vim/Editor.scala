package vim

class Editor(val content: StringBuilder = new StringBuilder) {
  
   var position: Int = 0
  
  def insertText(text: String) = {
     content.insert(position, text)
     position += text.length - 1
   }
  
  

}