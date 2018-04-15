import org.scalatest._

class NodeSpec extends BaseTestClass {

  // Get value
  test("Node[A].getVal") {
    Node[A].value = 2
    assert(Node[A].getVal() === 2)
  }

  // Node is added
  test("Node[A].addNode") {
    //todo
  }

  // Get nodes
  test("Node[A].getNodes") {
    //todo
  }

  // Get next node
  test("Node[A].getNext") {
    //todo
  }

  // Compare node values
  test("Node[A].equals") {
    //todo
  }

  // Delete a node
  test("Node[A].deleteNode") {
    //todo
  }
}
