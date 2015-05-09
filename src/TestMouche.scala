import GraphDSL._

/**
 * @author Vladar
 */

object TestMouche extends App{
  print("lol")
  /*
  val graph = Graph("my graph")
  
  // vertices
  graph += "Square"
  graph += "Rectangle"
  graph += "Circle"
  
  // edges  
  graph += "Square" to "Rectangle" withLabel "Edge1"
  graph += "Square" to "Circle" withLabel "Edge2"
  graph += "Circle" to "Square" withLabel "Edge3"
  */
  /*
  "Square".shape = Square(20)
  "Circle".shape = Circle(20)
  "Rectangle".shape = Rectangle(20, 40)
  val graphFrame = GraphFrame(graph)
  */
}

/*
(all letters) dont +=
|
^
&
< >
= !
:
+ -
* / %
(all other special characters)
*/


/*
   val graph = new DirectedSparseGraph[String, String]
  graph.addVertex("Square")
  graph.addVertex("Rectangle")
  graph.addVertex("Circle")
  graph.addEdge("Edge1", "Square", "Rectangle")
  graph.addEdge("Edge2", "Square", "Circle")
  graph.addEdge("Edge3", "Circle", "Square")
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

*/