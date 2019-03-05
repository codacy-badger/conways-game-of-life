package com.mattaharrison.dev.conwaysgameoflife

/**
  * A board is a structure that tracks live cells and can be iterated to a new generation.
  */
trait Board[T <: Cell] {
  /**
    * Cells that are alive in the current generation of the board.
    */
  def liveCells: Set[T]

  /**
    * Iterates the current generation of the board to a new generation.
    *
    * @return next generation of the board.
    */
  def iterate(): Board[T]
}

