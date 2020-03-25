object Huffman {
  def main(args: Array[String]): Unit = {
    val test_str = "ABAABACD"
    val a = 'A'
    val koho = test_str.toCharArray.distinct
    val a_rate = appearanceRate(a, test_str)
    koho.foreach(println)
  }

  def appearanceRate(caracter:Char, source: String): Double = {
    return 0.0
  }
}
