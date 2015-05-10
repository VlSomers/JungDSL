package GraphDSL

import javax.swing.JFrame
import edu.uci.ics.jung.visualization.VisualizationViewer
import edu.uci.ics.jung.algorithms.layout.CircleLayout
import org.apache.commons.collections15.Transformer
import java.awt._
import edu.uci.ics.jung.algorithms.layout.Layout
import edu.uci.ics.jung.visualization.control.DefaultModalGraphMouse
import edu.uci.ics.jung.visualization.control.ModalGraphMouse
import javax.swing.JMenuBar
import edu.uci.ics.jung.visualization.control.EditingModalGraphMouse
import org.apache.commons.collections15.Factory

/**
 * @author Vladar
 */
class GraphFrame(graph: Graph) {
  val frame = new JFrame
  var layout: Layout[Vertex, Edge] = new CircleLayout[Vertex, Edge](graph.graph)
  
  implicit var gr: Graph = graph
  
  var defaultVertexLabel = "vertex"
  var defaultVertexColor = Color.GREEN
  var defaultVertexShape = new Rectangle(-10, -10, 20, 20)
  var defaultEdgeLabel   = "edge"
  var defaultEdgeColor   = Color.BLACK
  var defaultEdgeStroke  = new BasicStroke()
  
  var vertexLabelTSF = new Transformer[Vertex, String] {
      override def transform(vertex: Vertex): String = if(vertex.label!=null) vertex.label else vertex.value.toString
  }
  
  var vertexPaintTSF = new Transformer[Vertex, Paint] {
      override def transform(vertex: Vertex): Paint = if(vertex.color!=null) vertex.color else defaultVertexColor
  }
  
  var vertexShapeTSF = new Transformer[Vertex, Shape] {
      override def transform(vertex: Vertex): Shape = if(vertex.shape!=null) vertex.shape else defaultVertexShape
  }
  
  var edgeLabelTSF = new Transformer[Edge, String] {
      override def transform(edge: Edge): String = if(edge.label!=null) edge.label else edge.value.toString
  }
  
  var edgePaintTSF = new Transformer[Edge, Paint] {
      override def transform(edge: Edge): Paint = if(edge.color!=null) edge.color else defaultEdgeColor
  }
    
  var edgeStrokeTSF = new Transformer[Edge, Stroke] {
      override def transform(edge: Edge): Stroke = if(edge.stroke!=null) edge.stroke else defaultEdgeStroke
  }
  
  
  
  def changeLayout(fct: => Layout[Vertex, Edge]): Unit = layout = fct
  
  def vertexPaintTSF_=(fct: String => Color): Unit = vertexPaintTSF = new Transformer[Vertex, Paint] {
      override def transform(vertex: Vertex): Color = fct(vertex.value)
  }
  
  def vertexPaintValuesTSF(fct: String => (Int, Int, Int)): Unit = vertexPaintTSF = new Transformer[Vertex, Paint] {
      override def transform(vertex: Vertex): Color = {
        val colorValues = fct(vertex.value)
        new Color(colorValues._1, colorValues._2, colorValues._3)
      }
  }

  
  
  def show(): Unit = {
    
    // ref : http://www.grotto-networking.com/JUNG/EditingGraphViewer1.java
    
    val vv = new VisualizationViewer[Vertex, Edge](layout)
    
    // set vertex transformer
    vv.getRenderContext.setVertexLabelTransformer(vertexLabelTSF)
    vv.getRenderContext.setVertexFillPaintTransformer(vertexPaintTSF);
    vv.getRenderContext.setVertexShapeTransformer(vertexShapeTSF);
    
    // set edge transformer
    vv.getRenderContext.setEdgeLabelTransformer(edgeLabelTSF)
    vv.getRenderContext.setEdgeDrawPaintTransformer(edgePaintTSF)
    vv.getRenderContext.setArrowDrawPaintTransformer(edgePaintTSF)
    vv.getRenderContext.setEdgeStrokeTransformer(edgeStrokeTSF)
    vv.getRenderContext.setEdgeArrowStrokeTransformer(edgeStrokeTSF)
    
    
    
    var nodeCount = 0
    var edgeCount = 0
    val vertexFactory = new Factory[Vertex]() { // My vertex factory
      def create(): Vertex = {
        nodeCount = nodeCount+1
        Vertex("V"+nodeCount)
      }
    }
    
    val edgeFactory = new Factory[Edge]() { // My edge factory
      def create(): Edge = {
        edgeCount = edgeCount+1
        Edge("E"+edgeCount)
      }
    }
            
    val gm = new EditingModalGraphMouse(vv.getRenderContext(), vertexFactory, edgeFactory)
    vv.setGraphMouse(gm)

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
    frame.getContentPane().add(vv)
        
    // Let's add a menu for changing mouse modes
    val menuBar = new JMenuBar()
    val modeMenu = gm.getModeMenu()
    modeMenu.setText("Mouse Mode")
    modeMenu.setIcon(null) // I'm using this in a main menu
    modeMenu.setPreferredSize(new Dimension(80,20)) // Change the size so I can see the text
        
    menuBar.add(modeMenu)
    frame.setJMenuBar(menuBar)
    gm.setMode(ModalGraphMouse.Mode.EDITING) // Start off in editing mode
    frame.pack()
    frame.setVisible(true)
    
    /*
    // mouse
    val gm = new DefaultModalGraphMouse()
    gm.setMode(ModalGraphMouse.Mode.TRANSFORMING)
    vv.setGraphMouse(gm)
    vv.addKeyListener(gm.getModeKeyListener())
        
    // create and launch the frame
    frame.getContentPane.add(vv)
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
    frame.pack()
    frame.setVisible(true)
    * */
  }
}

object GraphFrame {
  def apply(graph: SimpleGraph): GraphFrame = {
    new GraphFrame(graph)
  }
}