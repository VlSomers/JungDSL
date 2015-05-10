package GraphDSL

import edu.uci.ics.jung.graph.util.EdgeType

trait direct_path extends Graph{

	abstract override def getVertices()  = {
		super.getVertices() 
	} 
	abstract override def addVertex(vertex: Vertex) = {  
		if(vertex.label !=null) println(vertex.label)
    else println(vertex.value.toString)
		val x : Graph = super.addVertex(vertex)
		print("j")
		for( v <- getVertices()){ println("bouncle")
      super.addEdge(vertex, v,Edge(vertex.value.toString+"-"+v.value.toString) , false)
     // if(vertex.label !=null) super.addEdge(vertex, v,Edge(vertex.label+"-"+v.label) , false)
      //else super.addEdge(vertex, v,Edge(vertex.label+"-"+v.label) , false)println(vertex.value.toString)
			
		}
		this
	}
	abstract override def addEdge(vertex1: Vertex, vertex2: Vertex, edge: Edge, isDirected: Boolean): Graph = {    

		if(isDirected) {graph.addEdge(edge, vertex1, vertex2, EdgeType.DIRECTED)}
		else graph.addEdge(edge, vertex1, vertex2)
		this
	}
}