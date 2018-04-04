


import scala.util.Random

class SkipList[A<% Ordered[A]](maxLvl : Int){
  var size : Int = 0
  var header : Array[Node[A]] = new Array[Node[A]](maxLvl)
  header.map(_ => null)

  // compare two generics

// def compare[A](a1: A, a2: A): Boolean = {
//   a1 > a2
// }


  //chooses a random lvl for
  def chooseLevel(): Int = {
    val rand = new Random()
    return rand.nextInt(maxLvl)
  }

  def addNode(num : A): Boolean = {
    var lvl: Int = chooseLevel()
    // if empty
    if(header(0) == null){
      val node: Node[A]  = new Node[A](num, lvl)
      for(i <- 0 to lvl){
        header(i) = node
      }
      return true

    }
    // if the lvl is empty
    if(header(lvl) == null){
      val node: Node[A]  = new Node[A](num, lvl)
      header(lvl) = node
      lvl -= 1
    }

    var cur : Node[A] = header(lvl)
    var prev : Node[A] = null
    // loop to find where to insert at every lvl
    while(lvl >= 0) {
      // finds the pos at a each lvl
      while (cur != null && num > cur.getVal()) {
        prev = cur
        cur = cur.getNext(lvl)
      }
      if(prev == null && cur == null){
        val node: Node[A]  = new Node[A](num, lvl)
        header(lvl) = node
        node.addNode(null,lvl)
        lvl-=1
      }
      //if cur is the last node in list
      else if(cur == null){
        val node: Node[A]  = new Node[A](num, lvl)
        prev.addNode(node,lvl)
        node.addNode(null,lvl)
        lvl-=1
        cur = prev
        prev = null

      }
      // checks if value exists
      else if(cur.getVal() == num){
        return false

      }
      // all other cases
      else{
        val node: Node[A]  = new Node[A](num, lvl)
        //remove from list
        prev.addNode(node,lvl)
        node.addNode(cur, lvl)

        lvl-=1
        cur = prev
        prev = null
      }
    }

    return true
  }

  def printList(): Unit = {
    var lvl : Int = maxLvl - 1
    while(lvl >= 0){
      var cur = header(lvl)
      println("level: " + lvl)
      while(cur != null){
        print(cur.getVal() + ", ")
        cur = cur.getNext(lvl)
      }
      print("\n")
      lvl-=1
    }

  }

}





