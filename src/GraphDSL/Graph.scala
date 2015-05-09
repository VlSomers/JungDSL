package GraphDSL

/**
 * @author Vladar
 */

abstract class Graph {
  def addVertex(vertex: Vertex): Graph
  def addEdge(vertex1: Vertex, vertex2: Vertex, edge: Edge, isDirected: Boolean): Graph
}
