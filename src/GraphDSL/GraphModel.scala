package GraphDSL

/**
 * @author Vladar
 */
abstract class GraphModel {
  def addVertex(graph: Graph, vertex: Vertex): Graph
  def addEdge(graph: Graph, edge: edge, isDirected: Boolean = false): Graph
  
  def add(graph : Graph, Graph : Graph) : Graph
  
  //def multiply(graph : Graph, Graph : Graph) : Graph
}