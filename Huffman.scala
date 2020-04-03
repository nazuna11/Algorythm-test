object Huffman {
  def main(args: Array[String]): Unit = {
    val test_str = "ABAABACD"
    val koho = test_str.toCharArray.distinct
    val aaa = koho.map(appearanceRate(_, test_str))
    aaa.foreach(println)
  }

  def appearanceRate(caracter:Char, source: String): Double = {
    val charList = source.toCharArray.filter(_ == caracter)
    val rate = charList.length.asInstanceOf[Double] / source.length
    return rate
  }
}
