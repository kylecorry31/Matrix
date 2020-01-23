package com.kylecorry.matrix

import java.lang.IllegalArgumentException

class Matrix : Cloneable {

    private val values: Array<Array<Double>>

    val rows: Int
        get() = values.size

    val columns: Int
        get() = values[0].size

    constructor(rows: Int, cols: Int, defaultValue: Double = 0.0){
        values = Array(rows) {
            Array(cols){
                defaultValue
            }
        }
    }

    constructor(values: Array<Array<Double>>) {
        this.values = values
    }

    /**
     * Compute the dot product between two matrices
     */
    fun dot(other: Matrix): Matrix {
        val out = Matrix(rows, other.columns)

        for (r in 0 until rows){
            for (otherC in 0 until other.columns){
                var sum = 0.0
                for (c in 0 until columns){
                    sum += get(r, c) * other[c, otherC]
                }
                out[r, otherC] = sum
            }
        }

        return out
    }

    /**
     * Compute the transpose of the matrix
     */
    fun transpose(): Matrix {
        val out = Matrix(columns, rows)

        for (r in 0 until rows){
            for (c in 0 until columns){
                out.set(c, r, get(r, c))
            }
        }

        return out
    }

    /**
     * Element wise addition of two matrices
     */
    operator fun plus(other: Matrix): Matrix {
        if (rows != other.rows || columns != other.columns) throw IllegalArgumentException("Addition error: both matrices must have the same dimensions")
        val out = Matrix(rows, columns)

        for (r in 0 until rows){
            for (c in 0 until columns){
                out[r, c] = get(r, c) + other[r, c]
            }
        }

        return out
    }

    /**
     * Element wise subtraction of two matrices
     */
    operator fun minus(other: Matrix): Matrix {
        if (rows != other.rows || columns != other.columns) throw IllegalArgumentException("Addition error: both matrices must have the same dimensions")
        val out = Matrix(rows, columns)

        for (r in 0 until rows){
            for (c in 0 until columns){
                out[r, c] = get(r, c) - other[r, c]
            }
        }

        return out
    }

    /**
     * Element wise multiplication of two matrices
     */
    operator fun times(other: Matrix): Matrix {
        if (rows != other.rows || columns != other.columns) throw IllegalArgumentException("Addition error: both matrices must have the same dimensions")
        val out = Matrix(rows, columns)

        for (r in 0 until rows){
            for (c in 0 until columns){
                out[r, c] = get(r, c) * other[r, c]
            }
        }

        return out
    }

    /**
     * Scalar multiplication of a matrix
     */
    operator fun times(scalar: Double): Matrix {
        val out = Matrix(rows, columns)

        for (r in 0 until rows){
            for (c in 0 until columns){
                out[r, c] = get(r, c) * scalar
            }
        }

        return out
    }

    /**
     * Scalar division of a matrix
     */
    operator fun div(scalar: Double): Matrix {
        val out = Matrix(rows, columns)

        for (r in 0 until rows){
            for (c in 0 until columns){
                out[r, c] = get(r, c) / scalar
            }
        }

        return out
    }

    /**
     * Element wise division of two matrices
     */
    operator fun div(other: Matrix): Matrix {
        if (rows != other.rows || columns != other.columns) throw IllegalArgumentException("Addition error: both matrices must have the same dimensions")
        val out = Matrix(rows, columns)

        for (r in 0 until rows){
            for (c in 0 until columns){
                out[r, c] = get(r, c) / other[r, c]
            }
        }

        return out
    }

    /**
     * Set an item in the matrix
     */
    operator fun set(row: Int, col: Int, value: Double){
        values[row][col] = value
    }

    /**
     * Get an item from the matrix
     */
    operator fun get(row: Int, col: Int): Double {
        return values[row][col]
    }

    /**
     * Clones the matrix
     */
    public override fun clone(): Matrix {
        val out = Matrix(rows, columns)

        for (r in 0 until rows){
            for (c in 0 until columns){
                out[r, c] = get(r, c)
            }
        }

        return out
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Matrix

        if (!values.contentDeepEquals(other.values)) return false

        return true
    }

    override fun hashCode(): Int {
        return values.contentDeepHashCode()
    }

    companion object {

        /**
         * Creates an identity matrix
         */
        fun identity(size: Int): Matrix {
            val out = Matrix(size, size)
            for (i in 0 until size){
                out[i, i] = 1.0
            }

            return out
        }

        /**
         * Creates a column matrix
         */
        fun column(vararg values: Double): Matrix {
            val out = Matrix(values.size, 1)
            for (i in values.indices){
                out[i, 0] = values[i]
            }
            return out
        }

        /**
         * Creates a row matrix
         */
        fun row(vararg values: Double): Matrix {
            val out = Matrix(1, values.size)
            for (i in values.indices){
                out[0, i] = values[i]
            }
            return out
        }
    }

}