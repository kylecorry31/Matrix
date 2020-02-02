# Matrix
[![Release](https://img.shields.io/github/release/kylecorry31/Matrix.svg?style=flat)](https://jitpack.io/#kylecorry31/Matrix)
![](https://github.com/kylecorry31/Matrix/workflows/Java%20CI/badge.svg)

 A simple matrix library for Kotlin / Java

```java
Matrix m = new Matrix(new double[]{
    new double[]{ 1.0, 2.0 },
    new double[]{ 4.0, 3.0 }
});

Matrix i = Matrix.identity(2);

Matrix a = m.dot(i);

Matrix b = m.transpose();

Matrix c = m.plus(b);

```
