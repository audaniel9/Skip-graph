


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
    val node: Node[A]  = new Node[A](num, lvl)
    println("For num: " + num + " at lvl" + lvl)
    // if empty
    if(header(0) == null){
      //val node: Node[A]  = new Node[A](num, lvl)
      for(i <- 0 to lvl){
        header(i) = node
      }
      return true

    }
    // if the lvl is empty
    if(header(lvl) == null){
      //val node: Node[A]  = new Node[A](num, lvl)
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
        //println("For " + num + " first if statement is triggered" + " at lvl " + lvl)
        //val node: Node[A]  = new Node[A](num, lvl)
        header(lvl) = node
        node.addNode(null,lvl)
        if(lvl > 0) {
          cur = header(lvl - 1)
        }


      }
//      //if cur is the last node in list
//      else if(cur == null){
//        println("For " + num + " second if statement is triggered" + "at lvl " + lvl)
//       // val node: Node[A]  = new Node[A](num, lvl)
//        prev.addNode(node,lvl)
//        node.addNode(null,lvl)
//
//        cur = prev
//        prev = null
//
//      }
      // checks if value exists
      else if(cur != null && cur.getVal() == num){
        return false

      }
      else if(header(lvl).getVal() > node.getVal()){
        node.addNode(header(lvl), lvl)
        header(lvl) = node
        if(lvl > 0) {
          cur = header(lvl - 1)
        }
      }
      // all other cases
      else{
        //println("For " + num + " third if statement is triggered"+ "at lvl " + lvl)
       // val node: Node[A]  = new Node[A](num, lvl)

        if(prev != null) {
          prev.addNode(node, lvl)
          //println("the prev node is " + prev.getVal() + " for " + num)
        }
        node.addNode(cur, lvl)


        cur = prev
        //prev = null
      }
      lvl-=1
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





