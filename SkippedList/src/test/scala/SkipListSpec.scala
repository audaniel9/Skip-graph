import org.scalatest.FunSuite

class SkipListSpec extends FunSuite {

  test("add node"){
    val newList : SkipList[Int] =  new SkipList[Int](4)
    newList.addNode(1)
    assert(newList.getSize() == 1)
  }
  test("add duplicate node"){
    val newList : SkipList[Int] =  new SkipList[Int](4)
    newList.addNode(1)
    newList.addNode(1)
    assert(newList.getSize() == 1)
  }

  test("search for node"){
    val newList : SkipList[Int] =  new SkipList[Int](4)
    newList.addNode(1)
    newList.addNode(5)
    newList.addNode(3)
    newList.addNode(13)
    newList.addNode(343)
    newList.addNode(65756)
    assert(newList.search(5) == true)
    assert(newList.search(65756) == true)
  }

  test("search for node not in list"){
    val newList : SkipList[Int] =  new SkipList[Int](4)
    newList.addNode(1)
    newList.addNode(5)
    newList.addNode(3)
    newList.addNode(13)
    newList.addNode(343)
    newList.addNode(65756)
    assert(newList.search(-3423) == false)

  }

  test("delete node"){
    val newList : SkipList[Int] =  new SkipList[Int](4)
    newList.addNode(1)
    newList.addNode(5)
    newList.addNode(3)
    newList.addNode(13)
    newList.addNode(343)
    newList.addNode(65756)
    newList.delete(343)
    assert(newList.getSize() == 5)

  }
  test("delete node not in list"){
    val newList : SkipList[Int] =  new SkipList[Int](4)
    newList.addNode(1)
    newList.addNode(5)
    newList.addNode(3)
    newList.addNode(13)
    newList.addNode(343)
    newList.addNode(65756)
    newList.delete(34234234)
    assert(newList.getSize() == 6)

  }
}
