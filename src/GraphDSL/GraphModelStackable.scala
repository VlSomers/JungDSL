package GraphDSL

/** A property for the model : the edges are implicitly directed */
trait DirectedGraphModel extends GraphModel {
    abstract override def addEdge(graph: Graph, edge: edge, isDirected: Boolean = false): Graph = {
    super.addEdge(graph, edge, true)
  }
}

/** A property for the model : the edges are implicitly undirected */
trait UndirectedGraphModel extends GraphModel { // useless?
    abstract override def addEdge(graph: Graph, edge: edge, isDirected: Boolean = false): Graph = {
    super.addEdge(graph, edge, false)
  }
}
