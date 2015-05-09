package GraphDSL

/**
 * @author Vladar
 */
abstract class GraphModel {
  def addVertex(graph: Graph, vertex: vertex): Graph
  def addEdge(graph: Graph, edge: edge, isDirected: Boolean = false): Graph
}