/*package GraphDSL

trait direct_path extends Graph{
  abstract override def addEdge(vertex1: Vertex, vertex2: Vertex, edge: Edge, isDirected: Boolean): Graph = {    
    if(isDirected) graph.addEdge(edge, vertex1, vertex2, EdgeType.DIRECTED)
    else graph.addEdge(edge, vertex1, vertex2)
    this
  }
}*/