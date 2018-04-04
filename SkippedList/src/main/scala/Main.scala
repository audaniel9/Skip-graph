
object Main {
  def main(args: Array[String]): Unit = {
    val skipList = new SkipList[Int](4)

    skipList.addNode(1)
    skipList.addNode(1)
    skipList.addNode(2)
    skipList.addNode(3)
    skipList.printList()
  }

}
