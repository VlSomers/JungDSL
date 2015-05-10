package GraphDSL

import edu.uci.ics.jung.graph._
import edu.uci.ics.jung.graph.util.EdgeType

/**
 * @author Vladar
 */

class SimpleGraph(newName: String) extends Graph {
  val graph = new SparseGraph[Vertex, Edge]
  
  override var _name = newName  
 
  def name: String = _name
  def name_=(newName: String) = _name = newName
  
  def addVertex(vertex: Vertex): Graph = {    
    graph.addVertex(vertex)
    this
  }
  
  def addEdge(vertex1: Vertex, vertex2: Vertex, edge: Edge, isDirected: Boolean): Graph = {    
    if(isDirected) graph.addEdge(edge, vertex1, vertex2, EdgeType.DIRECTED)
    else graph.addEdge(edge, vertex1, vertex2)
    this
  }
}

object SimpleGraph {
  def apply(): SimpleGraph = new SimpleGraph("my graph")
  
  def apply(name: String): SimpleGraph = new SimpleGraph(name)
}