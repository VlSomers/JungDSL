import java.awt.Color
import java.awt.Rectangle
import java.awt.geom.Ellipse2D
import java.awt.Shape
import java.awt.BasicStroke
import java.awt.Stroke

package object GraphDSL {

  //type Polynomial = polynomial.core.Polynomial
  //final val Polynomial = polynomial.core.Polynomial
  type edge = (Vertex,Vertex,Edge)
  
  final val blue = Color.BLUE
  final val red = Color.RED
  final val black = Color.BLACK
  final val green = Color.GREEN
  final val yellow = Color.YELLOW
  final val pink = Color.PINK
  final val white = Color.WHITE
  final val grey = Color.DARK_GRAY
  final val orange = Color.ORANGE
  
  def DashedStroke(x: Float) : Stroke = new BasicStroke(x, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, Array(10.0f), 2.0f)
  def Stroke(x: Float) : Stroke = new BasicStroke(x)
  
  def Rectangle(x: Int, y: Int) : Shape = new Rectangle(-x/2, -y/2, x, y)
  def Square(x: Int) : Shape = new Rectangle(-x/2, -x/2, x, x)
  def Ellipse(x: Int, y: Int) : Shape = new Ellipse2D.Double(-x/2, -y/2, x, y)
  def Circle(x: Int) : Shape = new Ellipse2D.Double(-x/2, -x/2, x, x)

  trait simpleGraphModel { 
    implicit val model: GraphModel = new SimpleGraphModel() with DirectedGraphModel
  }
    
  implicit class GraphOps(val graph: Graph) {
    def += (vertex: String)(implicit model: GraphModel): Graph = {
      model.addVertex(graph, Vertex(vertex))  
    }
    def += (edge: edge)(implicit model: GraphModel): Graph = {
      model.addEdge(graph, edge)  
    }
    def += (edges: List[edge])(implicit model: GraphModel): Graph = {
      var gr: Graph = null
      for (edge<-edges) {gr = model.addEdge(graph, edge)}
      gr
    }
    def += (vertices: => List[String])(implicit model: GraphModel): Graph = {
      // "=>" to avoid -> error : have same type after erasure
      var gr: Graph = null
      for (vertex<-vertices) {gr = model.addVertex(graph, Vertex(vertex))}
      gr
    }
  }
  
  implicit class VertexGraphOps(val component: String) {
    def to(vertex2: String): (String,String) = {
      (component, vertex2)
    }
    def and(vertex2: String): List[String] = {
      List(component, vertex2)
    }
    def shape(vertex2: String): Unit = {
      List(component, vertex2)
    }
    def color(color: Color): Unit = {
      Vertex(component) = color
      Edge(component) = color
    }
    def shape(shape: Shape): Unit = {
      Vertex(component) = shape
    }
    def stroke(stroke: Stroke): Unit = {
      Edge(component) = stroke
    }
  }
  
  implicit class TupleGraphOps(val vertices: (String, String)) {
    def withLabel(edgeLabel: String): edge = {
      (Vertex(vertices._1), Vertex(vertices._2), Edge(edgeLabel))
    }
  }
  
  implicit class EdgeGraphOps(val edge1: (String, String, String)) {
    def and(edge2: (String, String, String)): List[edge] = {
      List((Vertex(edge1._1), Vertex(edge1._2), Edge(edge1._3)),(Vertex(edge2._1), Vertex(edge2._2), Edge(edge2._3)))
    }
  }
  
  implicit class ListEdgesGraphOps(val edges: List[edge]) {
    def and(edge: (String,String,String)): List[edge] = {
      edges:+(Vertex(edge._1), Vertex(edge._2), Edge(edge._3))
    }
  }
  implicit class ListVerticesGraphOps(val vertices: List[String]) {
    def and(vertex: String): List[String] = {
      vertices:+vertex
    }
  }
}