
object Main {
  def main(args: Array[String]): Unit = {
    val skipList = new SkipList[Int](4)


//    skipList.addNode(1)

    skipList.addNode(3)
    skipList.addNode(2)
    skipList.addNode(1)
    skipList.addNode(5)
    skipList.addNode(565)
    skipList.addNode(34)
    skipList.addNode(545)

    skipList.printList()
  }

}
