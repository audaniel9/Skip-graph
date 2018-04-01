import scala.util.Random
import scala.util.Sorting

class SkipList[A](maxLvl : Int) {
  var size : Int = 0
  var header : Array[Node[A]] = new Array[Node[A]](maxLvl)
  header.map(_ => null)

  // compare two generics
  def compare[A <% Ordered[A]] (x:A, y:A):Boolean = x > y

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
      while (cur != null && compare(num, cur.getVal())) {
        prev = cur
        cur = cur.getNext(lvl)
      }

      if(cur.getVal() == num){
        return false

      }
      else if(cur == null){
        val node: Node[A]  = new Node[A](num, lvl)
        prev.addNode(node,lvl)
        node.addNode(null,lvl)
        lvl-=1
        cur = prev
        prev = null

      }
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
    var lvl : Int = maxLvl
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


