import org.scalatest.FunSuite

class NodeSpec extends FunSuite {

  // Get value
  test("Node[A].getVal") {
    var newNode: Node[Int] = new Node[Int](2, 2)
    assert(newNode.getVal === 2)
  }

  // Node is added
  test("Node[A].addNode") {
    var newNode: Node[Int] = new Node[Int](2, 2)
    var newNode2: Node[Int] = new Node[Int](34, 2)
    newNode.addNode(newNode2, 1)

    assert(newNode.nodes(1).getVal() == newNode2.getVal())
  }

  test("Node[A].getNodes") {
    var newNode: Node[Int] = new Node[Int](2, 2)
    var newNode2: Node[Int] = new Node[Int](34, 2)
    var newNode3: Node[Int] = new Node[Int](3423, 2)
    newNode.addNode(newNode2, 1)
    newNode.addNode(newNode3, 0)
    var nodes: Array[Node[Int]] = newNode.getNodes()

    assert(nodes(0).getVal() == newNode3.getVal())
    assert(nodes(1).getVal() == newNode2.getVal())
  }

  test("Node[A].equals") {
    var newNode: Node[Int] = new Node[Int](2, 2)
    var newNode2: Node[Int] = new Node[Int](2, 2)

    assert(newNode.equals(newNode2) == true)
  }


  test("Node[A].getNext") {
    var newNode: Node[Int] = new Node[Int](2, 2)
    var newNode2: Node[Int] = new Node[Int](34534, 2)

    newNode.addNode(newNode2,0)


    assert(newNode.getNext(0).getVal() == newNode2.getVal())
  }

  test("Node[A].deleteNode") {
    var newNode: Node[Int] = new Node[Int](2, 2)
    var newNode2: Node[Int] = new Node[Int](34534, 2)
    var newNode3: Node[Int] = new Node[Int](3423, 2)
    newNode.addNode(newNode2,0)
    newNode.addNode(newNode3,1)
    newNode.deleteNode(newNode2.getVal())

    assert(newNode.getNext(0) == null)
  }


}

