package com.mattaharrison.dev.conwaysgameoflife.conwaysgameoflife

trait Cell {
  def getNeighbours(): Set[Cell]
}
