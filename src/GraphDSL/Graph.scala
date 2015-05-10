package GraphDSL

import java.util.Collection

/**
 * Represents a graph. Can be extended for example with a graph using :
 * SparseGraph, DirectedSparseGraph, UnDirectedSparseGraph
 */
abstract class Graph { 
  var _name: String // label of the Frame
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
}
