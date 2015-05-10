package GraphDSL
import scala.collection.JavaConversions._

class SimpleGraphModel extends GraphModel {
  
  def addVertex(graph: Graph, vertex: Vertex): Graph = {
    graph.addVertex(vertex)
  }
  def addEdge(graph: Graph, edge: edge, isDirected: Boolean = false): Graph = {
    graph.addEdge(edge._1, edge._2, edge._3, isDirected)
  }
  
  
  /** Create a new graph as the mix of two other graphs :
   *  We add the vertices and edges of graph1 AND graph2 in graph3
   */
  def add(graph1 : Graph, graph2 : Graph) : Graph ={
    
    val dest = SimpleGraph()
    
    for(v <- graph1.getVertices()) {
      dest.addVertex(v)
    }
    for(v <- graph2.getVertices()) {
      dest.addVertex(v)
    }
    
    for (e <- graph1.getEdges()){
      if(graph1.isDirected(e)){        
        addEdge(dest, (graph1.getSource(e) , graph1.getDest(e) , e),true)
      }
      else {
        val vertices : List[Vertex] = graph1.getIncidentVertices(e)
        dest.addEdge(vertices(0) , vertices(1) , e ,false)
      } 
    }
    
    for (e <- graph2.getEdges()){
      if(graph2.isDirected(e)){        
        dest.addEdge(graph2.getSource(e) , graph2.getDest(e) , e , true)
      }
      else {
        val vertices : List[Vertex] = graph2.getIncidentVertices(e)
        dest.addEdge(vertices(0) , vertices(1) , e ,false)
      } 
    }
    dest
  }
}

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


