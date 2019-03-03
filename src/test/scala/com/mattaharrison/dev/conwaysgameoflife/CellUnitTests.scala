package com.mattaharrison.dev.conwaysgameoflife

import com.mattaharrison.dev.conwaysgameoflife.conwaysgameoflife.Cell

import org.scalatest.{FlatSpec, Matchers}

class CellUnitTests extends FlatSpec with Matchers {
  "Getting neighbours of a cell in the middle of the board" should "return all surrounding cells." in {
    val cell = Cell(2, 2)

    val neighbours = Cell.getNeighbours(limitX = 4, limitY = 4)(cell)

    neighbours should contain (Cell(1, 1))
    neighbours should contain (Cell(2, 1))
    neighbours should contain (Cell(3, 1))
    neighbours should contain (Cell(1, 2))
    neighbours should contain (Cell(3, 2))
    neighbours should contain (Cell(1, 3))
    neighbours should contain (Cell(2, 3))
    neighbours should contain (Cell(3, 3))
  }

  it should "return 8 surrounding cells." in {
    val cell = Cell(2, 2)

    val neighbours = Cell.getNeighbours(limitX = 4, limitY = 4)(cell)

    neighbours.size should be (8)
  }

  "Getting neighbours of a cell on the left boundary of the board" should "return all surrounding cells on the board." in {
    val cell = Cell(0, 2)

    val neighbours = Cell.getNeighbours(limitX = 4, limitY = 4)(cell)

    neighbours should contain (Cell(0, 1))
    neighbours should contain (Cell(0, 3))
    neighbours should contain (Cell(1, 1))
    neighbours should contain (Cell(1, 2))
    neighbours should contain (Cell(1, 3))
  }

  it should "return 5 surrounding cells." in {
    val cell = Cell(0, 2)

    val neighbours = Cell.getNeighbours(limitX = 4, limitY = 4)(cell)

    neighbours.size should be (5)
  }

  "Getting neighbours of a cell on the bottom boundary of the board" should "return all surrounding cells on the board." in {
    val cell = Cell(2, 4)

    val neighbours = Cell.getNeighbours(limitX = 4, limitY = 4)(cell)

    neighbours should contain (Cell(1, 3))
    neighbours should contain (Cell(2, 3))
    neighbours should contain (Cell(3, 3))
    neighbours should contain (Cell(1, 4))
    neighbours should contain (Cell(3, 4))
  }

  it should "return 5 surrounding cells." in {
    val cell = Cell(2, 4)

    val neighbours = Cell.getNeighbours(limitX = 4, limitY = 4)(cell)

    neighbours.size should be (5)
  }

  "Getting neighbours of a cell on the right boundary of the board" should "return all surrounding cells on the board." in {
    val cell = Cell(4, 2)

    val neighbours = Cell.getNeighbours(limitX = 4, limitY = 4)(cell)

    neighbours should contain (Cell(3, 1))
    neighbours should contain (Cell(3, 2))
    neighbours should contain (Cell(3, 3))
    neighbours should contain (Cell(4, 1))
    neighbours should contain (Cell(4, 3))
  }

  it should "return 5 surrounding cells." in {
    val cell = Cell(4, 2)

    val neighbours = Cell.getNeighbours(limitX = 4, limitY = 4)(cell)

    neighbours.size should be (5)
  }

  "Getting neighbours of a cell on the top boundary of the board" should "return all surrounding cells on the board." in {
    val cell = Cell(2, 0)

    val neighbours = Cell.getNeighbours(limitX = 4, limitY = 4)(cell)

    neighbours should contain (Cell(1, 0))
    neighbours should contain (Cell(3, 0))
    neighbours should contain (Cell(1, 1))
    neighbours should contain (Cell(2, 1))
    neighbours should contain (Cell(3, 1))
  }

  it should "return 5 surrounding cells." in {
    val cell = Cell(2, 0)

    val neighbours = Cell.getNeighbours(limitX = 4, limitY = 4)(cell)

    neighbours.size should be (5)
  }

  "Getting neighbours of a cell in the top left corner of the board" should "return all surrounding cells on the board." in {
    val cell = Cell(0, 0)

    val neighbours = Cell.getNeighbours(limitX = 4, limitY = 4)(cell)

    neighbours should contain (Cell(1, 0))
    neighbours should contain (Cell(0, 1))
    neighbours should contain (Cell(1, 1))
  }

  it should "return 3 surrounding cells." in {
    val cell = Cell(0, 0)

    val neighbours = Cell.getNeighbours(limitX = 4, limitY = 4)(cell)

    neighbours.size should be (3)
  }

  "Getting neighbours of a cell in the bottom left corner of the board" should "return all surrounding cells on the board." in {
    val cell = Cell(0, 4)

    val neighbours = Cell.getNeighbours(limitX = 4, limitY = 4)(cell)

    neighbours should contain (Cell(0, 3))
    neighbours should contain (Cell(1, 3))
    neighbours should contain (Cell(1, 4))
  }

  it should "return 3 surrounding cells." in {
    val cell = Cell(0, 4)

    val neighbours = Cell.getNeighbours(limitX = 4, limitY = 4)(cell)

    neighbours.size should be (3)
  }

  "Getting neighbours of a cell in the bottom right corner of the board" should "return all surrounding cells on the board." in {
    val cell = Cell(4, 4)

    val neighbours = Cell.getNeighbours(limitX = 4, limitY = 4)(cell)

    neighbours should contain (Cell(3, 3))
    neighbours should contain (Cell(4, 3))
    neighbours should contain (Cell(3, 4))
  }

  it should "return 3 surrounding cells." in {
    val cell = Cell(4, 4)

    val neighbours = Cell.getNeighbours(limitX = 4, limitY = 4)(cell)

    neighbours.size should be (3)
  }

  "Getting neighbours of a cell in the top right corner of the board" should "return all surrounding cells on the board." in {
    val cell = Cell(4, 0)

    val neighbours = Cell.getNeighbours(limitX = 4, limitY = 4)(cell)

    neighbours should contain (Cell(3, 0))
    neighbours should contain (Cell(3, 1))
    neighbours should contain (Cell(4, 1))
  }

  it should "return 3 surrounding cells." in {
    val cell = Cell(4, 0)

    val neighbours = Cell.getNeighbours(limitX = 4, limitY = 4)(cell)

    neighbours.size should be (3)
  }
}
