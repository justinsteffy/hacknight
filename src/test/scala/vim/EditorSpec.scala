package vim

import org.scalatest.FunSpec
import org.scalatest.matchers.ShouldMatchers
import org.scalatest.BeforeAndAfter

class EditorSpec extends FunSpec with ShouldMatchers with BeforeAndAfter {

  var editor: Editor = _
  
  before {
    editor = new Editor
  }
  
  describe("editor") {
    describe("handles positions") {
      it("starts at position 0") {
        editor.position should be(0)
      }
    }
    
    describe("insert test") {
      var text: String = "my text"
      
      it("adds text to content") {
        editor.insertText(text)
        editor.content.toString should be(text)
      }
      
      it("advances the position") {
        editor.insertText(text)
        editor.position should be(text.length - 1)
      }
      
      it("inserts at the current position") {
        editor = new Editor(EditorState("abc", 0))
        
        editor.insertText(text)
        editor.content.toString should be(text + "abc")
      }
      
    }
    
    describe("execute command") {
    	it("moves left using h") {
    	  editor = new Editor(EditorState("abc", 2))
    	  val state = editor.executeCommand("h")
    	  state.position should be(1)
    	}
    	
    	it("doesn't move left past the beginning") {
    	  val state = editor.executeCommand("h")
    	  state.position should be(0)
    	}
    }
  }
  
  
}