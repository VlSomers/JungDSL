import GraphDSL._

/**
 * @author Vladar
 */

object TestMouche extends App with simpleGraphModel {
 println("looool")
  val graph = SimpleGraph("my graph")
  val graph2 = SimpleGraph("my graph2")
  val graphComplet = new SimpleGraph("my graph2") with direct_path
  
  graphComplet += "Vertex1"
  graphComplet += "Vertex2"
  graphComplet += "Vertex3"
  graphComplet += "Vertex4"
  
  val graphFrame1 = GraphFrame(graphComplet)
  graphFrame1.shape(CircleLayout)
  graphFrame1.show
  
   
  /*
    // vertices
  //graph2 += "Square"
  //graph2 += "Rectangle"
  //graph2 += "Circle"
  //graph2 += "Node1" and "Node2" and "Node3"
  
  
  
  // edges  
  graph2 += "skldfjlskjflksdjf" link "Reslmqkdfjsldkfjsdfctangle" withEdge "smldkjfskljfkjsd"
 // graph2 += "Square" to "Circle" withLabel "Edge2"
 // graph2 += "Circle" to "Square" withLabel "Edge3"
 // graph2 += ("Triangle", "Rectangle", "Edge4") and ("30", "Triangle", "Edge5") and ("Node3","Node2","pont")
  
  println("ici")
  // vertices
  graph += "Square"
  graph += "Rectangle"
  graph += "Circle"
  graph += "Node1" and "Node2" and "Node3"
  
  
  // edges  
  graph += "Square" link "Rectangle" withEdge "Edge1"
  graph += "Square" link "Circle" withEdge "Edge2"
  graph += "Circle" link "Square" withEdge "Edge3"
  graph += ("Triangle", "Rectangle", "Edge4") and ("30", "Triangle", "Edge5") and ("Node3","Node2","pont")
  
  "Circle".color(Blue)
  "Square".color(Red)
  "mlskqdjflksdjf".color(Yellow)
  "Rectangle".color(Pink)
  
  "Circle".shape(Circle(50))
  "Square".shape(Square(30))
  "Rectangle".shape(Rectangle(20, 40))
  "Triangle".shape(Ellipse(20,30))
  
  "Edge1".color(Pink)
  "Edge2".color(Orange)
  
  "Edge1".stroke(DashedStroke(1.0f))
  "Edge2".stroke(Stroke(2.0f))
  
  "Edge1".label("CROUCROUTE")
  "Square".label("CECI EST UN CARRE")
  
  //val result = x
  
  
  println("blabla")
  val result : Graph = graph + graph2
  println("ici")
 
 
 
  /*
  "Square".shape = Square(20)
  "Circle".shape = Circle(20)
  "Rectangle".shape = Rectangle(20, 40)
*/
  val graphFrame1 = GraphFrame(graph)
  graphFrame1.shape(CircleLayout)
  graphFrame1.show
  
  val graphFrame2 = GraphFrame(graph2)
  graphFrame2.shape(CircleLayout)
  graphFrame2.show
  
  
  val graphFrame = GraphFrame(result)
  graphFrame.shape(CircleLayout)
  graphFrame.show */
  
  /*
  val gf = GraphFrame(result)
  gf.color(x => (20,20,200))
  //gf.shape(SpringLayout)
  gf.show()
  * 
  */
}
