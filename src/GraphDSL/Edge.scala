package GraphDSL

import java.awt._
import scala.collection.mutable.Map

/**
 * @author Vladar
 */
class Edge(edge : Component) {
  var value: Component = edge
  var label: String = null
  var color: Color = null
  var stroke: Stroke = null
}

object Edge {
  // use a hash table which contains all Edges with they value as key
  val edgeMap: Map[Component, Edge] = Map()
  
 /**
  * If an Edge with this value already exists, we return it,
  * otherwise we create a new Edge with this value
  */
  def apply(edge: Component): Edge = {
    if (!edgeMap.contains(edge)) {
        val ed = new Edge(edge)
        edgeMap(edge) = ed
        ed
      }
    else {
      edgeMap(edge)
    }
  }
  
  def update(edge:Component, label:String) = if(edgeMap.contains(edge)) edgeMap(edge).label = label
  
  def update(edge:Component, color:Color) = if(edgeMap.contains(edge)) edgeMap(edge).color = color
  
  def update(edge:Component, stroke:Stroke) = if(edgeMap.contains(edge)) edgeMap(edge).stroke = stroke
  
}