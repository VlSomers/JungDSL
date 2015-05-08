package GraphDSL

import edu.uci.ics.jung.visualization._

/**
 * @author Vladar
 */

trait Graph {

}

object Graph {
  def apply(): MyGraph = new MyGraph("my graph")
  
  def apply(name: String): MyGraph = new MyGraph(name)
}