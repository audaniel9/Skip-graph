


import scala.util.Random

class SkipList[A<% Ordered[A]](maxLvl : Int){
  var size : Int = 0
  var header : Array[Node[A]] = new Array[Node[A]](maxLvl)
  header.map(_ => null)


  //chooses a random lvl for
  def chooseLevel(): Int = {
    val rand = new Random()
    return rand.nextInt(maxLvl)
  }

  def addNode(num : A): Boolean = {
    var lvl: Int = chooseLevel()
    val node: Node[A]  = new Node[A](num, lvl)
    //println("For num: " + num + " at lvl" + lvl)

    // if empty
    if(header(0) == null){
      for(i <- 0 to lvl){
        header(i) = node
      }
      size+=1
      return true

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
        header(lvl) = node
        node.addNode(null,lvl)
        if(lvl > 0) {
          cur = header(lvl - 1)
        }
      }

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

        if(prev != null) {
          prev.addNode(node, lvl)
        }
        node.addNode(cur, lvl)

        cur = prev
      }
      lvl-=1
    }
    size +=1
    return true
  }
  // search for node based on value
  def search(key: A): Boolean = {
    var lvl : Int = maxLvl -1


    var cur : Node[A] = header(lvl)
    var prev : Node[A] = null
    while(lvl >= 0){

      while(cur != null && key > cur.getVal()){
        prev = cur
        cur = cur.getNext(lvl)
      }

      if(cur != null && cur.getVal() == key){
        return true
      }

      lvl -= 1
      if(prev == null && lvl >0){
        cur = header(lvl)
      }
      else{
        cur = prev

      }

    }
    return false
  }

  def delete(key: A): Unit = {
    var lvl : Int = maxLvl - 1
    var found : Boolean = false
    while(lvl >= 0){
      var cur : Node[A] = header(lvl)
      var prev : Node[A] = null

      while (cur != null && key > cur.getVal()) {
        prev = cur
        cur = cur.getNext(lvl)
      }
      if(cur != null && key == cur.getVal()) {
        found = true
        if (prev == null) {
          header(lvl) = cur.getNext(lvl)

        } else {
          prev.addNode(cur.getNext(lvl), lvl)
        }
      }
      lvl -= 1
    }
    if(found){
      size -= 1
    }
  }

  def getSize(): Int = size

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





