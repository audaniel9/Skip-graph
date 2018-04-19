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
    assert(newNode.getNodes === newNode.nodes)
  }
/*
  // Get next node
  test("Node[A].getNext") {
    var newNode : Node[Int] = new Node[Int](2,2)
    var nextNode : Node[Int] = new Node[Int](3,2)

    assert()
  }*/

  // Compare node values
  test("Node[A].equals") {
    var newNode : Node[Int] = new Node[Int](2,2)
    assert(newNode.value === newNode.getVal)
  }

  // Delete a node
  test("Node[A].deleteNode") {
    var newNode : Node[Int]= new Node[Int](2,5)
    for(i <- 0 to 5) {
      newNode.nodes(i) = new Node[Int](i,i)
      println(newNode.nodes(i))
    }
  }
}
