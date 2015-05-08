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
  
  def +=(verticesAndEdge: (String,String,String)): MyGraph = {    
    graph.addEdge(verticesAndEdge._3, verticesAndEdge._1, verticesAndEdge._2)
    this
  }
}