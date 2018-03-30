import java.util._

// Node class
// the arraylist should be organized from closest to farthest nodes
class Node[A](var value : A, lvl : Int){
  var nodes : ArrayList[Node[A]] = new ArrayList[Node[A]](lvl)

  def getVal() : A = {
    return value
  }

  def addNode(node : Node[A], lvl : Int): Unit = {
    nodes.add(lvl, node)
  }

  def getNodes(): ArrayList[Node[A]] = {
    return nodes
  }

  def getNext(lvl : Int): Node[A] = {
    return nodes.get(lvl)
  }

  // if value needs an equals functions to work
  def equals(n : Node[A]): Boolean = {
    return this.value.equals(n.getVal())
  }

  // removes based on the equality of value
  def deleteNode(v : A): Unit = {

    for( i <- 0 to nodes.size()){
      if(nodes.get(i).getVal().equals(v)){
        nodes.remove(i)
      }
    }
  }
}
