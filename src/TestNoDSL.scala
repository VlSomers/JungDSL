import javax.swing.JFrame
import edu.uci.ics.jung.algorithms.layout.CircleLayout
import edu.uci.ics.jung.graph.DirectedSparseGraph
import edu.uci.ics.jung.visualization._
import org.apache.commons.collections15.Transformer

/**
 * @author Vladar
 */

object TestNoDSL extends App{
  
  
  val graph = new DirectedSparseGraph[String, String]
  //graph.addVertex("Square")
  //graph.addVertex("Square")
  //graph.addVertex("Circle")
  graph.addEdge("Edge1", "Square", "Rectangle")
  graph.addEdge("Edge2", "Square", "Circle")
  graph.addEdge("Edge3", "Circlessss", "Square")
  val layout = new CircleLayout[String, String](graph)
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