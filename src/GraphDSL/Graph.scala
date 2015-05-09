package GraphDSL

import edu.uci.ics.jung.visualization._

/**
 * @author Vladar
 */

abstract class Graph {
  def addVertex(vertex: vertex): Graph
  def addEdge(vertex1: vertex, vertex2: vertex, edgeLabel: String, isDirected: Boolean): Graph
}
