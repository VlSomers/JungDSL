package GraphDSL

import java.util.Collection

/**
 * @author Vladar
 */


abstract class Graph { 
  var _name: String
  def name: String
  def name_= (newName: String)
  
  val graph: edu.uci.ics.jung.graph.Graph[Vertex, Edge]
  def addVertex(vertex: Vertex): Graph
  def addEdge(vertex1: Vertex, vertex2: Vertex, edge: Edge, isDirected: Boolean): Graph
  
  def getVertices() : List[Vertex]
  def getEdges() : Collection[Edge]
  def getIncidentVertices(e: Edge  ) : List[Vertex]
  def isDirected(e:Edge) : Boolean
  def getSource(e:Edge) : Vertex
  def getDest(e:Edge) : Vertex
  
  //def withFilter(p: Vertex => Boolean): Graph[Vertex]
  //def foreach(b : Vertex => Unit) : Unit
  
}
