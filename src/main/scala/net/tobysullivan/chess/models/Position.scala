package net.tobysullivan.chess.models

/** *
  * Position on the board. x is letter-axis and y is numeric axis.
  * Examples:
  * a1 = (1, 1)
  * e2 = (5, 2)
  * b6 = (2, 6)
  * h8 = (8, 8)
  * @param x Position on the letter scale. Must be between 1 and 8 inclusive.
  * @param y Position on the number scale. Must be between 1 and 8 inclusive.
  */
case class Position(x: Int, y: Int) {
  def isOnBoard: Boolean = (x >= 1) && (x <= 8) && (y >= 1) && (y <= 8)

  def +(difference: Position): Position = Position(x + difference.x, y + difference.y)

  def -(difference: Position): Position = this.+(Position(0 - difference.x, 0 - difference.y))

  override def toString: String = {
    if (isOnBoard)
      Seq('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h')(x - 1) + y.toString
    else
      s"InvalidPosition($x, $y)"
  }
}
