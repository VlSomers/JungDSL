package GraphDSL

/**
 * @author Vladar
 */
class SimpleGraphModel extends GraphModel {
  def addVertex(graph: Graph, vertex: Vertex): Graph = {
    graph.addVertex(vertex)
  }
  def addEdge(graph: Graph, edge: edge, isDirected: Boolean = false): Graph = {
    graph.addEdge(edge._1, edge._2, edge._3, isDirected)
  }
}

trait DirectedGraphModel extends GraphModel {
    abstract override def addEdge(graph: Graph, edge: edge, isDirected: Boolean = false): Graph = {
    super.addEdge(graph, edge, true)
  }
}

trait UndirectedGraphModel extends GraphModel { // useless?
    abstract override def addEdge(graph: Graph, edge: edge, isDirected: Boolean = false): Graph = {
    super.addEdge(graph, edge, false)
  }
}