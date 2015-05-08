package GraphDSL

import edu.uci.ics.jung.graph.DirectedSparseGraph
import scala.collection.mutable.Queue

/**
 * @author Vladar
 */
class MyGraph(newName: String) {
  val graph = new DirectedSparseGraph[String, String]
  val vertexQueue = new Queue[String]
  
  private var _name = newName  
  def name: String = _name
  def name_=(newName: String) = _name = newName
  
  def +=(vertex: String): MyGraph = {    
    graph.addVertex(vertex)
    vertexQueue += (vertex)
    this
  }
  /*
  def +=(vertex: (String, String)): MyGraph = {    
    vertexQueue += vertex._1 
    vertexQueue += vertex._2
    this
  }
  */
  
  def >(vertex: String): MyGraph = {    
    vertexQueue += (vertex)
    this
  }
  
  
  def withLabel(edge: String): MyGraph = {    
    graph.addEdge(edge, vertexQueue.dequeue, vertexQueue.dequeue)
    this
  }
  
  // graph += "Square" ­­> "Rectangle" withLabel "Edge1"
  // graph.+=("Square").>("Rectangle").withLabel("Edge1")
}