package com.mattaharrison.dev.conwaysgameoflife.conwaysgameoflife

/**
  * A board is a structure that tracks live cells and can be iterated to a new generation.
  */
trait Board {
  /**
    * Cells that are alive in the current generation of the board.
    */
  val liveCells: Iterable[Cell]

  /**
    * Iterates the current generation of the board to a new generation.
    *
    * @return next generation of the board.
    */
  def iterate(): Board
}

