package GraphDSL

import java.awt._
import scala.collection.mutable.Map

/**
 * @author Vladar
 */
class Edge(edge : String) {
  var value: String = edge
  var label: String = edge
  var color: Color = null
  var stroke: Stroke = null
}

object Edge {
  val edgeMap: Map[String, Edge] = Map()
  
  def apply(edge: String): Edge = {
    if (!edgeMap.contains(edge)) {
        val ed = new Edge(edge)
        edgeMap(edge) = ed
        ed
      }
    else {
      edgeMap(edge)
    }
  }
  
  def update(edge:String, label:String) = if(edgeMap.contains(edge)) edgeMap(edge).label = label
  
  def update(edge:String, color:Color) = if(edgeMap.contains(edge)) edgeMap(edge).color = color
  
  def update(edge:String, stroke:Stroke) = if(edgeMap.contains(edge)) edgeMap(edge).stroke = stroke
  
}