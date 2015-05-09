package GraphDSL

import javax.swing.JFrame
import edu.uci.ics.jung.visualization.VisualizationViewer
import edu.uci.ics.jung.algorithms.layout.CircleLayout
import org.apache.commons.collections15.Transformer
import java.awt._

/**
 * @author Vladar
 */
class GraphFrame(graph: SimpleGraph) {
  val frame = new JFrame
  val layout = new CircleLayout[Vertex, Edge](graph.graph)
  val vv = new VisualizationViewer[Vertex, Edge](layout)
  
  var defaultVertexLabel = "vertex"
  var defaultVertexColor = Color.GREEN
  var defaultVertexShape = new Rectangle(10, 10, 20, 20) //Point2D center = layout.transform(vertex) // new Rectangle((int)center.getX()-10, (int)center.getY()-10, 20, 20);
  var defaultEdgeLabel   = "edge"
  var defaultEdgeColor   = Color.BLACK
  var defaultEdgeStroke  = new BasicStroke(1.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, Array(10.0f), 0.0f)
    
  var vertexLabelTSF = new Transformer[Vertex, String] {
      override def transform(vertex: Vertex): String = if(vertex.label!=null) vertex.label else defaultVertexLabel
  }
  
  var vertexPaintTSF = new Transformer[Vertex, Paint] {
      override def transform(vertex: Vertex): Paint = if(vertex.color!=null) vertex.color else defaultVertexColor
  }
  
  var vertexShapeTSF = new Transformer[Vertex, Shape] {
      override def transform(vertex: Vertex): Shape = if(vertex.shape!=null) vertex.shape else defaultVertexShape
  }
  
  var edgeLabelTSF = new Transformer[Edge, String] {
      override def transform(edge: Edge): String = if(edge.label!=null) edge.label else defaultEdgeLabel
  }
  
  var edgePaintTSF = new Transformer[Edge, Paint] {
      override def transform(edge: Edge): Paint = if(edge.color!=null) edge.color else defaultEdgeColor
  }
    
  var edgeStrokeTSF = new Transformer[Edge, Stroke] {
      override def transform(edge: Edge): Stroke = if(edge.stroke!=null) edge.stroke else defaultEdgeStroke
  }
  

  
  def vertexPaintTSF_=(fct: String => Color): Unit = vertexPaintTSF = new Transformer[Vertex, Paint] {
      override def transform(vertex: Vertex): Color = fct(vertex.value)
  }
  
  def vertexPaintValuesTSF_=(fct: String => (Int, Int, Int)): Unit = vertexPaintTSF = new Transformer[Vertex, Paint] {
      override def transform(vertex: Vertex): Color = {
        val colorValues = fct(vertex.value)
        new Color(colorValues._1, colorValues._2, colorValues._3)
      }
  }

  
  
  def show(): Unit = {
    // set vertex transformer
    vv.getRenderContext.setVertexLabelTransformer(vertexLabelTSF)
    vv.getRenderContext.setVertexFillPaintTransformer(vertexPaintTSF);
    vv.getRenderContext.setVertexShapeTransformer(vertexShapeTSF);
    
    // set edge transformer
    vv.getRenderContext.setEdgeLabelTransformer(edgeLabelTSF)
    //vv.getRenderContext.setEdgeFillPaintTransformer(edgePaintTSF)
    vv.getRenderContext.setEdgeStrokeTransformer(edgeStrokeTSF);
    
    // create and launch the frame
    val frame = new JFrame
    frame.getContentPane.add(vv)
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
    frame.pack()
    frame.setVisible(true)
  }
}

object GraphFrame {
  def apply(graph: SimpleGraph): GraphFrame = {
    new GraphFrame(graph)
  }
}