import GraphDSL._

/**
 * @author Vladar
 */

object TestDSL extends App with simpleGraphModel {

  print("lol")
  val graph = SimpleGraph("my graph")
  
  
  1.afficher
  "test".afficher
  2.0.afficher
  (2,3,4).afficher
  
  // vertices
  graph += "Square"
  graph += "Rectangle"
  graph += "Circle"
  graph += "Node1" and "Node2" and "Node3"
  
  val t = "Square".test("Rectangle")
  
  // edges  
  graph += ("Square".test("Rectangle")).withLabel("Edge1")
  graph += "Square" test "Circle" withLabel "Edge2"
  graph += "Circle" test "Square" withLabel "Edge3"
  graph += ("Triangle", "Rectangle", "Edge4") and ("30", "Triangle", "Edge5") and ("Node3","Node2","pont")
  
  class Person(var name: String, var age: Int)
  val mouche = new Person("Armand", 20)
  graph += (1, 2, 3) and (mouche, "blabla", (2,3))
  
  mouche.label("Armand Bosquillon")
  
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