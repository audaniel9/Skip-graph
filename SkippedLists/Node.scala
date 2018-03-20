import java.util._

// Node class
// the arraylist should be organized from closest to farthest nodes
class Node[A](var value : A){
	var nodes : ArrayList[ArrayList[Node[A]]] = new ArrayList[ArrayList[Node[A]]]()

	def getVal() : A = {
		return value
	}

	def addNode(node : Node[A], lvl: int): Unit = {

		nodes.get(lvl).add(node)
	}

	def getNodes(): ArrayList[ArrayList[Node[A]]] = {
		return nodes
	}

	// if value needs an equals functions to work
	def equals(n : Node[A]): Boolean = {
		return this.value.equals(n.getVal())
	}

	// removes based on the equality of value
	def deleteNode(v : A): Unit = {
		
		for( i <- 0 to nodes.size()){
			for(j <- 0 to  nodes.get(i).size()){
				if(nodes.get(i).get(j).getVal().equals(v)){
					nodes..get(i).remove(j)
				}
			}
		}
	}
}

