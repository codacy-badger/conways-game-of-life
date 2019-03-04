package com.mattaharrison.dev.conwaysgameoflife.conwaysgameoflife

import scala.collection.immutable.{HashMap, HashSet}

/**
  * Board structures track live cells and upper boundaries on X and Y axis.
  *
  * @param liveCells cells that are alive in the current generation of the board.
  * @param limitX    maximum x-coordinate on board.
  * @param limitY    maximum y-coordinate on board.
  */
class FiniteGridBoard(val liveCells: Set[Cell], val limitX: Int, val limitY: Int) extends Board {
  /**
    * Iterates the current generation of the board to a new generation.
    *
    * @return next generation of the board.
    */
  def iterate(): Board = {
    val liveNeighbourCount = countLiveNeighbours

    val nextGenerationLiveCells =
      findNextGeneration(this.liveCells, liveNeighbourCount)

    new FiniteGridBoard(nextGenerationLiveCells, this.limitX, this.limitY)
  }

  private def countLiveNeighbours(): Map[Cell, Int] =
    this.liveCells.foldLeft(HashMap[Cell, Int]())(
      (liveNeighbourCount, liveCell) =>
        Cell
          .getNeighbours(this.limitX, this.limitY)(liveCell)
          .foldLeft(liveNeighbourCount)((liveNeighbourCountAcc, cell) => {
            if (liveNeighbourCount.contains(cell))
              liveNeighbourCount.updated(cell, liveNeighbourCount(cell) + 1)
            else
              liveNeighbourCount.updated(cell, 1)
          }))

  private def findNextGeneration(currentGenerationLiveCells: Set[Cell],
                                 liveNeighbourCount: Map[Cell, Int]): Set[Cell] =
    liveNeighbourCount.foldLeft(HashSet[Cell]())(
      (nextGenerationLiveCells, liveCellNeighbour) => {
        if (liveCellNeighbour._2 == 3)
          nextGenerationLiveCells + liveCellNeighbour._1
        else if (liveCellNeighbour._2 == 2 && currentGenerationLiveCells.contains(
          liveCellNeighbour._1))
          nextGenerationLiveCells + liveCellNeighbour._1
        else
          nextGenerationLiveCells
      })
}
