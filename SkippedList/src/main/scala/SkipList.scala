import scala.util.Random

class SkipList[A](maxLvl : Int) {
  var size : Int = 0
  var header : Array[Node[A]] = new Array[Node[A]](maxLvl)
  header.map(x => null)

  //chooses a random lvl for
  def chooseLevel(): Int = {
    val rand = new Random()
    return rand.nextInt(maxLvl)
  }

  def addNode(num : A): Boolean = {
    var lvl: Int = chooseLevel()

    if(header(0) == null){
      val node: Node[A]  = new Node[A](num, lvl)
      for(i <- 0 to lvl){
        header(i) = node
      }
    }else{
      var cur : Node[A] = header(lvl)
      var prev : Node[A] = null
      while(lvl >= 0) {

        while (cur != null && num > cur.getVal()) {
          prev = cur
          cur = cur.getNext(lvl)
        }
        if(cur.getVal() == num){
          return false

        }else if(cur == null){
          val node: Node[A]  = new Node[A](num, lvl)
          prev.addNode(node,lvl)
          node.addNode(null,lvl)
          lvl-=1
          cur = prev
          prev = null

        }else{
          val node: Node[A]  = new Node[A](num, lvl)
          //remove from list
          prev.addNode(node,lvl)
          node.addNode(cur, lvl)

          lvl-=1
          cur = prev
          prev = null
        }
      }
    }
    return true
  }

}
