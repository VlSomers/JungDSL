

package object GraphDSL {

  //type Polynomial = polynomial.core.Polynomial
  //final val Polynomial = polynomial.core.Polynomial
  type edge = (String,String,String)
  type vertex = String
  
  trait simpleGraphModel { 
    implicit val model: GraphModel = new SimpleGraphModel() with DirectedGraphModel
  }
    
  implicit class GraphOps(val graph: Graph) {
    def += (vertex: vertex)(implicit model: GraphModel): Graph = {
      model.addVertex(graph, vertex)  
    }
    def += (edge: edge)(implicit model: GraphModel): Graph = {
      model.addEdge(graph, edge)  
    }
    def += (edges: List[edge])(implicit model: GraphModel): Graph = {
      var gr: Graph = null
      for (edge<-edges) {gr = model.addEdge(graph, edge)}
      gr
    }
    def += (vertices: => List[vertex])(implicit model: GraphModel): Graph = {
      // "=>" to avoid -> error : have same type after erasure
      var gr: Graph = null
      for (vertex<-vertices) {gr = model.addVertex(graph, vertex)}
      gr
    }
  }
  
  implicit class VertexGraphOps(val vertex1: vertex) {
    def to(vertex2: vertex): (vertex,vertex) = {
      (vertex1, vertex2)
    }
    def and(vertex2: vertex): List[vertex] = {
      List(vertex1, vertex2)
    }
    def shape(vertex2: vertex): Unit = {
      List(vertex1, vertex2)
    }
  }
  
  implicit class TupleGraphOps(val vertices: (vertex,vertex)) {
    def withLabel(edgeLabel: String): edge = {
      (vertices._1, vertices._2, edgeLabel)
    }
  }
  
  implicit class EdgeGraphOps(val edge1: edge) {
    def and(edge2: edge): List[edge] = {
      List(edge1,edge2)
    }
  }
  
  implicit class ListEdgesGraphOps(val edges: List[edge]) {
    def and(edge: edge): List[edge] = {
      edges:+edge
    }
  }
  implicit class ListVerticesGraphOps(val vertices: List[vertex]) {
    def and(vertex: vertex): List[vertex] = {
      vertices:+vertex
    }
  }
}