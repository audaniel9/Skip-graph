import org.scalatest.FunSuite

class NodeSpec extends FunSuite {

  // Get value
  test("Node[A].getVal") {
    var newNode : Node[Int] = new Node[Int](2,2)
    assert(newNode.getVal === 2)
  }

  // Node is added
  test("Node[A].addNode") {
    //todo
  }

  // Get nodes
  test("Node[A].getNodes") {
    var newNode : Node[Int] = new Node[Int](1,3)
    assert(newNode.getNodes === Node[Int](4))
  }

  // Get next node
  test("Node[A].getNext") {
    var newNode : Node[Int] = new Node[Int](2,2)
    var nextNode : Node[Int] = new Node[Int](3,2)

    nodes(0) = newNode
    nodes(1) = nextNode

    assert()
  }

  // Compare node values
  /*test("Node[A].equals") {
    var Node[A].value1 = 5;
    var Node[A].value2 = 5;
    assert(Node[A].value1 == Node[A].value2);
    //todo
  }*/

  // Delete a node
  test("Node[A].deleteNode") {
    //todo
  }

  // Delete a node
  test("Node[A].deleteNode") {
    //todo
  }
}
