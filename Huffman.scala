// import scala.collection.immutable.ListMap

object Huffman {
  def main(args: Array[String]): Unit = {
    val test_str = "ABAABACD"
    val koho = test_str.toCharArray.distinct
    val rate = koho.map(appearanceRate(_, test_str))

    val charMap = Map() ++ (koho.map(_.toString) zip rate)
    // val charMap = Map("A"->0.35, "B"->0.25, "C"->0.22, "D"->0.18)
    // val sortedMap = ListMap(charMap.toSeq.sortBy(_._1):_*)
    //sortedMap.zipWithIndex.toMap.map(a => (a._1._1 -> a._2.toByte)).foreach(println)
    val newMap = getTree(charMap)
    println(newMap)
  }

  def getTree(charMap:Map[String, Double]): Map[String, Double] = {
    if(charMap.size==1){return charMap}
    implicit val order = Ordering.Double.TotalOrdering
    val minKey = charMap.minBy(_._2)._1
    val delMinMap = charMap.view.filterKeys(_ != minKey).toMap
    val secondMinKey = delMinMap.minBy(_._2)._1
    val del2MinMap = delMinMap.view.filterKeys(_ != secondMinKey).toMap
    val newCharMap = del2MinMap + ((minKey+secondMinKey) -> (charMap (minKey) + charMap (secondMinKey)))
    getTree(newCharMap)
  }

  def appearanceRate(caracter:Char, source: String): Double = {
    val charList = source.toCharArray.filter(_ == caracter)
    val rate = charList.length.asInstanceOf[Double] / source.length
    return rate
  }
}
