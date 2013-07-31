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
        editor.col should be(0)
      }
    }
    
    describe("insert test") {
      var text: String = "my text"
      
      it("adds text to content") {
        editor.insertText(text)
        editor.line should be(text)
      }
      
      it("advances the position") {
        editor.insertText(text)
        editor.col should be(text.length - 1)
      }
      
      it("inserts at the current position") {
        editor = new Editor(EditorState(Vector("abc"), (0,0)))
        
        editor.insertText(text)
        editor.line should be(text + "abc")
      }
      
    }
    
    describe("execute command") {
    	it("moves left using h") {
    	  editor = new Editor(EditorState(Vector("abc"), (0, 2)))
    	  editor.executeCommand("h")
    	  editor.col should be(1)
    	}
    	
    	it("doesn't move left past the beginning") {
    	  editor.executeCommand("h")
    	  editor.col should be(0)
    	}
    }
  }
  
  
}