package com.example.belajarandroiddasar

import org.junit.Assert
import org.junit.Test

class GameTest {

    @Test
    fun testPickRandomOption() {
        val options = listOf("ROCK", "PAPER", "SCISSORS")
        Assert.assertTrue(options.contains(Game.pickRandomOption()))
        Assert.assertTrue(options.contains(Game.pickRandomOption()))
        Assert.assertTrue(options.contains(Game.pickRandomOption()))
    }

    @Test
    fun testPickDrawable() {
        val options = listOf("ROCK", "PAPER", "SCISSORS")

        Assert.assertEquals(R.drawable.rock, Game.pickDrawable(options[0]))
        Assert.assertEquals(R.drawable.paper, Game.pickDrawable(options[1]))
        Assert.assertEquals(R.drawable.scissors, Game.pickDrawable(options[2]))
    }

    @Test
    fun testIsDraw() {
        Assert.assertTrue(Game.isDraw("ROCK", "ROCK"))
        Assert.assertTrue(Game.isDraw("PAPER", "PAPER"))
        Assert.assertTrue(Game.isDraw("SCISSORS", "SCISSORS"))
    }

    @Test
    fun testIsWin() {
        Assert.assertTrue(Game.isWin("ROCK", "SCISSORS"))
        Assert.assertTrue(Game.isWin("PAPER", "ROCK"))
        Assert.assertTrue(Game.isWin("SCISSORS", "PAPER"))
    }
}