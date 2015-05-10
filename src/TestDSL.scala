import GraphDSL._

/**
 * @author Vladar
 */

object TestDSL extends App with simpleGraphModel {

  print("lol")
  val graph = SimpleGraph("my graph")
  
  // vertices
  graph += "Square"
  graph += "Rectangle"
  graph += "Circle"
  graph += "Node1" and "Node2" and "Node3"
  
  // edges  
  graph += "Square" to "Rectangle" withLabel "Edge1"
  graph += "Square" to "Circle" withLabel "Edge2"
  graph += "Circle" to "Square" withLabel "Edge3"
  graph += ("Triangle", "Rectangle", "Edge4") and ("30", "Triangle", "Edge5") and ("Node3","Node2","pont")
  
  "Circle".color(blue)
  "Square".color(red)
  "mlskqdjflksdjf".color(yellow)
  "Rectangle".color(pink)
  
  "Circle".shape(Circle(50))
  "Square".shape(Square(30))
  "Rectangle".shape(Rectangle(20, 40))
  "Triangle".shape(Ellipse(20,30))
  
  "Edge1".color(pink)
  "Edge2".color(orange)
  
  "Edge1".stroke(DashedStroke(1.0f))
  "Edge2".stroke(Stroke(2.0f))
  
  "Edge1".label("CROUCROUTE")
  "Square".label("CECI EST UN CARRE")
  
  
  /*
  "Square".shape = Square(20)
  "Circle".shape = Circle(20)
  "Rectangle".shape = Rectangle(20, 40)
*/
  val graphFrame = GraphFrame(graph)
  graphFrame.shape(CircleLayout)
  graphFrame.show
  
  val gf = GraphFrame(graph)
  gf.color(x => (20,20,200))
  //gf.shape(SpringLayout)
  gf.show()
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