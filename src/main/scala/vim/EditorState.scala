package vim

case class EditorState(val content: Seq[String], val position: (Int, Int)) {
    def line = content(row)
  def row = position._1
  def col = position._2
}

