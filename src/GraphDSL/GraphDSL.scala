
import scala.collection.immutable.Queue
package object GraphDSL {

  
  implicit class GraphOps(val graph: Int) {
    /*
    def +=(vertex: String)(implicit computer: PolyComputer): Polynomial = {
      computer.add(poly, that)  
    }
    */
  }
  implicit class StringPolyOps(val vertex1: String) {
    
    def >(vertex2: String): MyGraph = {
      add(vertex2)
    }
    
    def to(vertex2: String): (String,String) = (vertex1, vertex2) 
    
  }
}