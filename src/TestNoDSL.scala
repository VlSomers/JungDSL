import javax.swing.JFrame
import edu.uci.ics.jung.algorithms.layout._
import edu.uci.ics.jung.graph._
import edu.uci.ics.jung.visualization._
import org.apache.commons.collections15.Transformer
import edu.uci.ics.jung.graph.util.EdgeType
import edu.uci.ics.jung.visualization.decorators.ToStringLabeller
import java.awt.Dimension
import java.awt.Paint
import java.awt.Stroke
import java.awt.Color
import java.awt.BasicStroke

/**
 * @author Vladar
 */

object TestNoDSL extends App{
  
  
  //val graph = new DirectedSparseGraph[String, String]
    val graph = new SparseGraph[String, String]

  graph.addVertex("Square")
  graph.addVertex("Square")
  graph.addVertex("Circle")
  graph.addEdge("Edge1", "Square", "Rectangle", EdgeType.DIRECTED)
  graph.addEdge("Edge2", "Square", "Circle")
  graph.addEdge("Edge3", "Circle", "Square")
  //val layout = new CircleLayout[String, String](graph)
  val layout = new CircleLayout[String, String](graph)
  val vv = new VisualizationViewer[String, String](layout)
  val transformer = new Transformer[String, String] {
    override def transform(label: String): String = label
  }
  vv.getRenderContext.setVertexLabelTransformer(transformer)
  vv.getRenderContext.setEdgeLabelTransformer(transformer)
  
  //////////////////////////////////////////////////////////
  
  vv.setPreferredSize(new Dimension(3500,3500))
  // Setup up a new vertex to paint transformer...
  
  val test = Color.GREEN
  val vertexPaint = new Transformer[String, Paint]() {
    override def transform(label: String): Color = Color.GREEN
  }
  
  // Set up a new stroke Transformer for the edges
  val dash = Array(10.0f)
  val edgeStroke = new BasicStroke(1.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, dash, 0.0f)
  val edgeStrokeTransformer = new Transformer[String, Stroke]() {
      override def transform(label: String) : Stroke = edgeStroke 
    }
  vv.getRenderContext().setVertexFillPaintTransformer(vertexPaint);
  vv.getRenderContext().setEdgeStrokeTransformer(edgeStrokeTransformer);
  vv.getRenderContext().setVertexLabelTransformer(new ToStringLabeller());
  vv.getRenderContext().setEdgeLabelTransformer(new ToStringLabeller());
  //vv.getRenderer().getVertexLabelRenderer().setPosition(Position.CNTR);

  /////////////////////////////////////////////////////////////
        
  val frame = new JFrame
  frame.getContentPane.add(vv)
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
  frame.pack()
  frame.setVisible(true)
}