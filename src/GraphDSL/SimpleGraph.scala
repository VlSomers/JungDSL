package GraphDSL

import edu.uci.ics.jung.graph._
import edu.uci.ics.jung.graph.util.EdgeType

/**
 * @author Vladar
 */

class SimpleGraph(newName: String) extends Graph {
  val graph = new SparseGraph[String, String]
  
  private var _name = newName  
  def name: String = _name
  def name_=(newName: String) = _name = newName
  
  def addVertex(vertex: vertex): Graph = {    
    graph.addVertex(vertex)
    this
  }
  
  def addEdge(vertex1: vertex, vertex2: vertex, edgeLabel: String, isDirected: Boolean): Graph = {    
    if(isDirected) graph.addEdge(vertex1, vertex2, edgeLabel, EdgeType.DIRECTED)
    else graph.addEdge(vertex1, vertex2, edgeLabel)
    this
  }
}

object SimpleGraph {
  def apply(): SimpleGraph = new SimpleGraph("my graph")
  
  def apply(name: String): SimpleGraph = new SimpleGraph(name)
}