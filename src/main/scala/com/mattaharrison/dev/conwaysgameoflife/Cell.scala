package com.mattaharrison.dev.conwaysgameoflife

/**
  * A cell is a structure that has neighbours.
  */
trait Cell {
  /**
    * Find the set of neighbours to a given cell.
    *
    * @return set of neighbours.
    */
  def getNeighbours(): Set[Cell]
}
