import java.awt.Color
import java.awt.Rectangle
import java.awt.geom.Ellipse2D
import java.awt.Shape
import java.awt.BasicStroke
import java.awt.Stroke
import edu.uci.ics.jung.algorithms.layout.Layout
import edu.uci.ics.jung.algorithms.layout.CircleLayout
import edu.uci.ics.jung.algorithms.layout.StaticLayout
import edu.uci.ics.jung.algorithms.layout.KKLayout
import edu.uci.ics.jung.algorithms.layout.SpringLayout

package object GraphDSL {

  type edge = (Vertex,Vertex,Edge)
  type Component = Any
  
  //////////////////////////////
  //        DSL ELEMENTS      //
  //////////////////////////////
  
  // Colors
  final val Blue = Color.BLUE
  final val Red = Color.RED
  final val Black = Color.BLACK
  final val Green = Color.GREEN
  final val Yellow = Color.YELLOW
  final val Pink = Color.PINK
  final val White = Color.WHITE
  final val Grey = Color.DARK_GRAY
  final val Orange = Color.ORANGE
  
  // Strokes
  def DashedStroke(x: Float) : Stroke = new BasicStroke(x, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, Array(10.0f), 2.0f)
  def Stroke(x: Float) : Stroke = new BasicStroke(x)
  
  // Shapes
  def Rectangle(x: Int, y: Int) : Shape = new Rectangle(-x/2, -y/2, x, y)
  def Square(x: Int) : Shape = new Rectangle(-x/2, -x/2, x, x)
  def Ellipse(x: Int, y: Int) : Shape = new Ellipse2D.Double(-x/2, -y/2, x, y)
  def Circle(x: Int) : Shape = new Ellipse2D.Double(-x/2, -x/2, x, x)
  
  // Layouts
  def CircleLayout(graph: Graph) : Layout[Vertex, Edge] = new CircleLayout[Vertex, Edge](graph.graph)
  def StaticLayout(graph: Graph) : Layout[Vertex, Edge] = new StaticLayout[Vertex, Edge](graph.graph)
  def KKLayout(graph: Graph) : Layout[Vertex, Edge] = new KKLayout[Vertex, Edge](graph.graph)
  def SpringLayout(graph: Graph) : Layout[Vertex, Edge] = new SpringLayout[Vertex, Edge](graph.graph)
 
  //////////////////////////////
  //     IMPLICIT MODELS      //
  //////////////////////////////

  trait SimpleDirectedGraphModel { 
    implicit val model: GraphModel = new SimpleGraphModel() with DirectedGraphModel
  }
  
  trait SimpleUnDirectedGraphModel { 
    implicit val model: GraphModel = new SimpleGraphModel() with UndirectedGraphModel
  }
  
  //////////////////////////////
  //   IMPLICIT OPERATIONS    //
  //////////////////////////////
  
  /** Operations on Graph objects */ 
  implicit class GraphOps(val graph: Graph) {
    def += (vertex: Component)(implicit model: GraphModel): Graph = {
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
    def += (vertices: => List[Component])(implicit model: GraphModel): Graph = {
      // "=>" to avoid -> error : have same type after erasure
      var gr: Graph = null
      for (vertex<-vertices) {gr = model.addVertex(graph, Vertex(vertex))}
      gr
    }
    def show(): Unit = {
        val graphFrame = GraphFrame(graph)
        graphFrame.show
    }    
    def + (graph2 : Graph)(implicit model: GraphModel) : Graph = {
      model.add(graph,graph2)
    }
  }
  
  /** Operations on elements which represents vertices and edges */ 
  implicit class VertexAndEdgeGraphOps(val component: Component) {
    def link(vertex2: Component): (Component, Component) = {
      (component, vertex2)
    }
    def and(vertex2: Component): List[Component] = {
      List(component, vertex2)
    }
    def shape(vertex2: Component): Unit = {
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
    def label(label: String): Unit = {
      Edge(component) = label
      Vertex(component) = label
    }
  }
  
  /** Operations on tuple of two vertices */ 
  implicit class TupleGraphOps(val vertices: (Component, Component)) {
    def withEdge(edgeLabel: Component): edge = {
      (Vertex(vertices._1), Vertex(vertices._2), Edge(edgeLabel))
    }
  }
  
  /** Operations on tuple of tree elements which represents two vertices and an edge */ 
  implicit class EdgeGraphOps(val edge1: (Component, Component, Component)) {
    def and(edge2: (Component, Component, Component)): List[edge] = {
      List((Vertex(edge1._1), Vertex(edge1._2), Edge(edge1._3)),(Vertex(edge2._1), Vertex(edge2._2), Edge(edge2._3)))
    }
  }
  
  /** Operations on list of edges for the "graph = (v,v,e) + (v,v,e) + ..." operation */ 
  implicit class ListEdgesGraphOps(val edges: List[edge]) {
    def and(edge: (Component,Component,Component)): List[edge] = {
      edges:+(Vertex(edge._1), Vertex(edge._2), Edge(edge._3))
    }
  }
  
  /** Operations on list of vertices for the "graph = v + v + ..." operation */ 
  implicit class ListVerticesGraphOps(val vertices: List[Component]) {
    def and(vertex: Component): List[Component] = {
      vertices:+vertex
    }
  }
  
  /** Operations on the graphFrame object */ 
  implicit class GraphFrameOps(val graphFrame: GraphFrame) {
    def color(fct: Component => (Int, Int, Int)): Unit = {
      graphFrame.vertexPaintValuesTSF(fct)
    }
    
    def paint(fct: => (Int, Int, Int)): Unit = {
      graphFrame.vertexPaintValuesTSF(fct)
    }
    
    def shape(f: Graph => Layout[Vertex, Edge]): Unit = {
      graphFrame.changeLayout(
        f(graphFrame.gr)
      )
    }
    def show(): Unit = {
      graphFrame.show
    }
  }
}