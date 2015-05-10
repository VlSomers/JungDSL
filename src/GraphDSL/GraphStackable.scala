package GraphDSL

import edu.uci.ics.jung.graph.util.EdgeType

/** 
 * Add the complete graph property to a graph : 
 * When adding a vertex, maintain the complete graph property
 */ 
trait CompleteGraph extends Graph{

  abstract override def addVertex(vertex: Vertex) = {  
    val x : Graph = super.addVertex(vertex)
    for( v <- getVertices()){ 
      if(v!=vertex) super.addEdge(vertex, v,Edge(vertex.value.toString+"-"+v.value.toString) , false)
    }
    this
  }
  abstract override def addEdge(vertex1: Vertex, vertex2: Vertex, edge: Edge, isDirected: Boolean): Graph = {    

    if(isDirected) {graph.addEdge(edge, vertex1, vertex2, EdgeType.DIRECTED)}
    else graph.addEdge(edge, vertex1, vertex2)
    this
  }
}