package com.example.belajarandroiddasar

import org.junit.Assert
import org.junit.Test


class SayBabyTest {

    @Test
    fun testSayBaby() {
        val result = SayBaby().sayBaby("Mahesa")

        Assert.assertEquals("Baby Mahesa", result)
    }
}