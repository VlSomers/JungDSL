package GraphDSL

import java.awt._
import scala.collection.mutable.Map

/**
 * @author Vladar
 */
class Vertex(vertex: String) {
  var value: String = vertex
  var label: String = vertex
  var color: Color = null
  var shape: Shape = null
}

object Vertex {  
  val verticesMap: Map[String, Vertex] = Map()
  
  def apply(vertex: String): Vertex = {
    if (!verticesMap.contains(vertex)) {
        val vt = new Vertex(vertex)
        verticesMap(vertex) = vt
        vt
      }
    else {
      verticesMap(vertex)
    }
  }
  
  def update(vertex:String, label:String) = if(verticesMap.contains(vertex)) verticesMap(vertex).label = label
  
  def update(vertex:String, color:Color) = if(verticesMap.contains(vertex)) verticesMap(vertex).color = color
  
  def update(vertex:String, shape:Shape) = if(verticesMap.contains(vertex)) verticesMap(vertex).shape = shape
  
}