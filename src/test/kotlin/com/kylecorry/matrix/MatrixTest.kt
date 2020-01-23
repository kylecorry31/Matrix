package com.kylecorry.matrix

import org.junit.Assert.*
import org.junit.Test

internal class MatrixTest {

    @Test
    fun canDotMatrices(){
        val a = Matrix(arrayOf(
            arrayOf(1.0, 2.0),
            arrayOf(3.0, 4.0),
            arrayOf(5.0, 6.0)
        ))

        val b = Matrix(arrayOf(
            arrayOf(1.0, 2.0, 3.0),
            arrayOf(4.0, 5.0, 6.0)
        ))

        val expected = Matrix(arrayOf(
            arrayOf(9.0, 12.0, 15.0),
            arrayOf(19.0, 26.0, 33.0),
            arrayOf(29.0, 40.0, 51.0)
        ))

        val c = a.dot(b)

        assertEquals(expected, c)
    }

    @Test
    fun canDetectEquality(){
        val a = Matrix(arrayOf(
            arrayOf(1.0, 4.0, 3.0),
            arrayOf(4.0, 5.0, 6.0)
        ))

        val b = Matrix(arrayOf(
            arrayOf(1.0, 2.0, 3.0),
            arrayOf(4.0, 5.0, 6.0)
        ))

        val c = Matrix(arrayOf(
            arrayOf(1.0, 2.0, 3.0),
            arrayOf(4.0, 5.0, 6.0)
        ))

        assertEquals(b, b)
        assertEquals(b, c)
        assertNotEquals(a, b)
    }

    @Test
    fun canTranspose(){
        val a = Matrix(arrayOf(
            arrayOf(1.0, 2.0, 3.0),
            arrayOf(4.0, 5.0, 6.0)
        ))

        val expected = Matrix(arrayOf(
            arrayOf(1.0, 4.0),
            arrayOf(2.0, 5.0),
            arrayOf(3.0, 6.0)
        ))

        assertEquals(expected, a.transpose())
    }

    @Test
    fun canAdd(){
        val a = Matrix(arrayOf(
            arrayOf(1.0, 2.0, 3.0),
            arrayOf(4.0, 5.0, 6.0)
        ))
        val b = Matrix(arrayOf(
            arrayOf(1.0, 2.0, 3.0),
            arrayOf(4.0, 4.0, 6.0)
        ))

        val expected = Matrix(arrayOf(
            arrayOf(2.0, 4.0, 6.0),
            arrayOf(8.0, 9.0, 12.0)
        ))

        assertEquals(expected, a + b)
    }

    @Test
    fun canSubtract(){
        val a = Matrix(arrayOf(
            arrayOf(1.0, 2.0, 3.0),
            arrayOf(4.0, 5.0, 6.0)
        ))
        val b = Matrix(arrayOf(
            arrayOf(1.0, 2.0, 3.0),
            arrayOf(4.0, 4.0, 6.0)
        ))

        val expected = Matrix(arrayOf(
            arrayOf(0.0, 0.0, 0.0),
            arrayOf(0.0, 1.0, 0.0)
        ))

        assertEquals(expected, a - b)
    }

    @Test
    fun canElementWiseMultiply(){
        val a = Matrix(arrayOf(
            arrayOf(1.0, 2.0, 3.0),
            arrayOf(4.0, 5.0, 6.0)
        ))
        val b = Matrix(arrayOf(
            arrayOf(1.0, 2.0, 3.0),
            arrayOf(4.0, 4.0, 6.0)
        ))

        val expected = Matrix(arrayOf(
            arrayOf(1.0, 4.0, 9.0),
            arrayOf(16.0, 20.0, 36.0)
        ))

        assertEquals(expected, a * b)
    }

    @Test
    fun canScalarMultiply(){
        val a = Matrix(arrayOf(
            arrayOf(1.0, 2.0, 3.0),
            arrayOf(4.0, 5.0, 6.0)
        ))

        val expected = Matrix(arrayOf(
            arrayOf(3.0, 6.0, 9.0),
            arrayOf(12.0, 15.0, 18.0)
        ))

        assertEquals(expected, a * 3.0)
    }

    @Test
    fun canElementWiseDivide(){
        val a = Matrix(arrayOf(
            arrayOf(1.0, 2.0, 3.0),
            arrayOf(4.0, 5.0, 6.0)
        ))
        val b = Matrix(arrayOf(
            arrayOf(1.0, 2.0, 3.0),
            arrayOf(4.0, 4.0, 6.0)
        ))

        val expected = Matrix(arrayOf(
            arrayOf(1.0, 1.0, 1.0),
            arrayOf(1.0, 1.25, 1.0)
        ))

        assertEquals(expected, a / b)
    }

    @Test
    fun canScalarDivide(){
        val a = Matrix(arrayOf(
            arrayOf(1.0, 2.0, 3.0),
            arrayOf(4.0, 5.0, 6.0)
        ))

        val expected = Matrix(arrayOf(
            arrayOf(0.5, 1.0, 1.5),
            arrayOf(2.0, 2.5, 3.0)
        ))

        assertEquals(expected, a / 2.0)
    }

    @Test
    fun canSetAndGet(){
        val a = Matrix(arrayOf(
            arrayOf(1.0, 2.0, 3.0),
            arrayOf(4.0, 5.0, 6.0)
        ))

        assertEquals(2.0, a[0, 1], 0.001)
        assertEquals(4.0, a[1, 0], 0.001)

        a[0, 1] = 5.0

        assertEquals(5.0, a[0, 1], 0.001)
    }

    @Test
    fun canClone(){
        val a = Matrix(arrayOf(
            arrayOf(1.0, 2.0, 3.0),
            arrayOf(4.0, 5.0, 6.0)
        ))

        assertEquals(a, a.clone())
        assertFalse(a === a.clone())

        val b = a.clone()

        a[0, 0] = 5.0

        assertEquals(1.0, b[0, 0], 0.001)

        b[0, 1] = 5.0
        assertEquals(2.0, a[0, 1], 0.001)
    }
}