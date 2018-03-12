import java.util._

// Node class
// the arraylist should be organized from closest to farthest nodes
class Node[A](var value : A){
	var nodes : ArrayList[Node[A]] = new ArrayList[Node[A]]()

	def getVal() : A = {
		return value
	}

	def addNode(node : Node[A]): Unit = {
		nodes.add(node)
	}

	def getNodes(): ArrayList[Node[A]] = {
		return nodes
	}
}

