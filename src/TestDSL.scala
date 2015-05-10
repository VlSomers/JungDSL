import GraphDSL._

/**
 * @author Vladar
 */

object TestDSL extends App with simpleGraphModel {

  val graph = SimpleGraph("my graph")
  graph.name = "ALLLLLERRRRR"

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
  
  class Person(var name: String, var age: Int)
  val mouche = new Person("Armand", 20)
  graph += (1, 2, 3) and (mouche, "blabla", (2,3))
  
  mouche.label("Armand Bosquillon")
  
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
  

  graph.show
  
  val graphFrame = GraphFrame(graph)
  graphFrame.shape(StaticLayout)
  graphFrame.show
  
  val gf = GraphFrame(graph)
  
  def f(v: Any) = v match {
    case x: Int    => (x%256,x%256,x%256)
    case default   => { val color =  Math.abs(v.hashCode())
      ( (Math.abs(color*10)%256), (Math.abs(color*34)%256), (Math.abs(color*2)%256) )}
  }
  
  def rand : (Int, Int, Int) = {
    val rnd = new scala.util.Random
    (rnd.nextInt(255), rnd.nextInt(255), rnd.nextInt(255))
  }
  
  gf.color(f)
  
  gf.paint(rand)
  //gf.shape(SpringLayout)
  gf.show()
}