import scala.collection.immutable.ListMap

object Huffman {
  def main(args: Array[String]): Unit = {
    val test_str = "ABAABACD"
    val koho = test_str.toCharArray.distinct
    val aaa = koho.map(appearanceRate(_, test_str))

    val charMap = Map() ++ (koho zip aaa)
    val sortedMap = ListMap(charMap.toSeq.sortBy(_._1):_*)
    sortedMap.zipWithIndex.toMap.map(a => (a._1._1 -> a._2.toByte)).foreach(println)
  }

  def appearanceRate(caracter:Char, source: String): Double = {
    val charList = source.toCharArray.filter(_ == caracter)
    val rate = charList.length.asInstanceOf[Double] / source.length
    return rate
  }
}
