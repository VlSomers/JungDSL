
import scala.collection.immutable.Queue
package object GraphDSL {

  
  implicit class GraphOps(val graph: Int) {
    /*
    def +=(vertex: String)(implicit computer: PolyComputer): Polynomial = {
      computer.add(poly, that)  
    }
    */
  }
  implicit class StringGraphOps(val vertex1: String) {
    def to(vertex2: String): (String,String) = {
      (vertex1, vertex2)
    }
  }
  
  implicit class TupleGraphOps(val vertices: (String,String)) {
    def withLabel(edge: String): (String,String,String) = {
      (vertices._1, vertices._2, edge)
    }
  }
}