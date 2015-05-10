package GraphDSL

import edu.uci.ics.jung.graph._
import edu.uci.ics.jung.graph.util.EdgeType
import java.util.Collection
import scala.collection.JavaConversions._
/**
 * @author Vladar
 */

class SimpleGraph(newName: String) extends Graph {
  val graph = new SparseGraph[Vertex, Edge]
  
  override var _name = newName  
 
  def name: String = _name
  def name_=(newName: String) = _name = newName
  
  def addVertex(vertex: Vertex): Graph = {    
    graph.addVertex(vertex)
    this
  }
  
  def addEdge(vertex1: Vertex, vertex2: Vertex, edge: Edge, isDirected: Boolean): Graph = {    
    if(isDirected) graph.addEdge(edge, vertex1, vertex2, EdgeType.DIRECTED)
    else graph.addEdge(edge, vertex1, vertex2)
    this
  }
  
  def getVertices() : List[Vertex] = {
    graph.getVertices.toList
  }
  
  def getEdges() : Collection[Edge] = {
    graph.getEdges
  }
  
  def getIncidentVertices(e : Edge) : List[Vertex] = {
   val vertices : Collection[Vertex] = graph.getIncidentVertices(e)
    vertices.toList
  }
  def isDirected(e:Edge) : Boolean = {
        graph.getEdgeType(e) == EdgeType.DIRECTED     
  }
  def getSource(e:Edge) : Vertex = {
    graph.getSource(e)
  }
  def getDest(e:Edge) : Vertex = {
    graph.getDest(e)
  }
  
 /* def withFilter(p: Vertex => Boolean): List[Vertex] =  {
    val l = graph.getVertices.toList
    l.withFilter(p)
  }
  def foreach(b : Vertex => Unit) : Unit {
    
  }*/
  
}

object SimpleGraph {
  def apply(): SimpleGraph = new SimpleGraph("my graph")
  
  def apply(name: String): SimpleGraph = new SimpleGraph(name)
}