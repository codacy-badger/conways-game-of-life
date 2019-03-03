package com.mattaharrison.dev.conwaysgameoflife.conwaysgameoflife

import scala.collection.immutable.{HashMap, HashSet}

/**
  * Board structures track live cells and upper boundaries on X and Y axis.
  *
  * @param LiveCells live cells in current iteration.
  * @param LimitX    maximum x-coordinate on board.
  * @param LimitY    maximum y-coordinate on board.
  */
case class Board(LiveCells: HashSet[Cell], LimitX: Int, LimitY: Int)

/**
  * Companion object for boards to contain helper logic.
  */
object Board {
  /**
    * Maps a board generation onto its next generation.
    *
    * @param currentGeneration current generation of the board to be mapped.
    *
    * @return the next generation of the board.
    */
  def iterate(currentGeneration: Board): Board = {
    val liveNeighbourCount =
      countLiveNeighbours(currentGeneration)

    val nextGenerationLiveCells =
      findNextGeneration(currentGeneration.LiveCells, liveNeighbourCount)

    Board(nextGenerationLiveCells,
          currentGeneration.LimitX,
          currentGeneration.LimitY)
  }

  private def countLiveNeighbours(currentGeneration: Board): Map[Cell, Int] =
    currentGeneration.LiveCells.foldLeft(HashMap[Cell, Int]())(
      (liveNeighbourCount, liveCell) =>
        Cell
          .getNeighbours(currentGeneration.LimitX, currentGeneration.LimitY)(
            liveCell)
          .foldLeft(liveNeighbourCount)((liveNeighbourCountAcc, cell) => {
            if (liveNeighbourCount.contains(cell))
              liveNeighbourCount.updated(cell, liveNeighbourCount(cell) + 1)
            else
              liveNeighbourCount.updated(cell, 1)
          }))

  private def findNextGeneration(
      currentGenerationLiveCells: HashSet[Cell],
      liveNeighbourCount: Map[Cell, Int]): HashSet[Cell] =
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
