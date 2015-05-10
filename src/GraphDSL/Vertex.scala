package GraphDSL

import java.awt._
import scala.collection.mutable.Map

/**
 * @author Vladar
 */
class Vertex(vertex: Component) {
  var value: Component = vertex
  var label: String = null
  var color: Color = null
  var shape: Shape = null
}

object Vertex {
  // use a hash table which contains all Vertices with they value as key
  val verticesMap: Map[Component, Vertex] = Map()
  
  /**
   * If a Vertex with this value already exists, we return it,
   * otherwise we create a new Vertex with this value
   */
  def apply(vertex: Component): Vertex = {
    if (!verticesMap.contains(vertex)) {
        val vt = new Vertex(vertex)
        verticesMap(vertex) = vt
        vt
      }
    else {
      verticesMap(vertex)
    }
  }
  
  def update(vertex:Component, label:String) = if(verticesMap.contains(vertex)) verticesMap(vertex).label = label
  
  def update(vertex:Component, color:Color) = if(verticesMap.contains(vertex)) verticesMap(vertex).color = color
  
  def update(vertex:Component, shape:Shape) = if(verticesMap.contains(vertex)) verticesMap(vertex).shape = shape
  
}