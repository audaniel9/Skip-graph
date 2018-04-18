

import java.util._

// Node class
// the arraylist should be organized from closest to farthest nodes
class Node[A](var value : A, lvl : Int){
  // next nodes
  var nodes : Array[Node[A]] = new Array[Node[A]](lvl + 1)

  for(i <- 0 to lvl){
    nodes(i) = null
  }

  def getVal() : A = {
    return value
  }

  def addNode(node : Node[A], lvl : Int): Unit = {
//    if(node != null){
//      println("adds node for " + value + " node is " + node.getVal())
//    }

    nodes(lvl) = node

  }

  def getNodes(): Array[Node[A]] = {
    return nodes
  }

  def getNext(lvl : Int): Node[A] = {
    return nodes(lvl)
  }

  // if value needs an equals functions to work
  def equals(n : Node[A]): Boolean = {
    return this.value.equals(n.getVal())
  }

  // removes based on the equality of value
  def deleteNode(v : A): Unit = {

    for( i <- 0 to nodes.length){
      if(nodes(i).getVal().equals(v)){
        nodes(i) = null
      }
    }
  }
}
