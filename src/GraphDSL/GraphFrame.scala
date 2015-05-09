package GraphDSL

import javax.swing.JFrame
import edu.uci.ics.jung.visualization.VisualizationViewer
import edu.uci.ics.jung.algorithms.layout.CircleLayout
import org.apache.commons.collections15.Transformer

/**
 * @author Vladar
 */
class GraphFrame {
  val frame = new JFrame
  
  def apply(graph: SimpleGraph): Unit = {    
    val layout = new CircleLayout[String, String](graph.graph)
    val vv = new VisualizationViewer[String, String](layout)
    val transformer = new Transformer[String, String] {
      override def transform(label: String): String = label
    }
    vv.getRenderContext.setVertexLabelTransformer(transformer)
    vv.getRenderContext.setEdgeLabelTransformer(transformer)
  
    val frame = new JFrame
    frame.getContentPane.add(vv)
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
    frame.pack()
    frame.setVisible(true)
  }
}

object GraphFrame {
  def apply(graph: SimpleGraph): GraphFrame = {
    val frame = new GraphFrame()
    frame(graph)
    frame
  }
}