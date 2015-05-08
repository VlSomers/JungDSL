package GraphDSL

/**
 * @author Vladar
 */
class GraphFrame {
  
}


object GraphFrame{
  def apply(): MyGraph = new MyGraph("my graph")
  
  def apply(name: String): MyGraph = new MyGraph(name)
}