package cz.educanet.tranformations;

import kotlin.NotImplementedError;

import java.util.Arrays;

public class Matrix implements IMatrix {

    private final double[][] rawArray;

    public Matrix(double[][] rawArray) {
        this.rawArray = rawArray;
    }

    @Override
    public int getRows() {
        return rawArray.length;
    }

    @Override
    public int getColumns() {
        if (getRows() > 0)
            return rawArray[0].length;

        return 0;
    }

    @Override
    public IMatrix times(IMatrix matrix) {
        throw new NotImplementedError(); // TODO:
    }

    @Override
    public IMatrix times(Number scalar) {
        double[][] arr = new double [getRows()][getColumns()];
        for (int y = 0; y < getColumns(); y++) {
            for (int x = 0; x < getRows(); x++) {
                arr[x][y] *= scalar.doubleValue();
            }
        }
        return MatrixFactory.create(arr);
    }

    @Override
    public IMatrix add(IMatrix matrix) {
        double[][] arr = new double [getRows()][getColumns()];
        for (int y = 0; y < getColumns(); y++) {
            for (int x = 0; x < getRows(); x++) {
                arr[x][y] += get(x, y);
            }
        }
        return MatrixFactory.create(arr);
    }

    @Override
    public IMatrix subtract(IMatrix matrix) {
        double[][] arr = new double [getRows()][getColumns()];
        for (int y = 0; y < getColumns(); y++) {
            for (int x = 0; x < getRows(); x++) {
                arr[x][y] -= get(x, y);
            }
        }
        return MatrixFactory.create(arr);
    }

    @Override
    public double get(int n, int m) {
        return this.rawArray[n][m];
    }

    //region Optional
    @Override
    public IMatrix transpose() {
        return null;
    }

    @Override
    public double determinant() {
        return 0;
    }
    //endregion
    //region Generated
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Matrix matrix = (Matrix) o;

        for (int i = 0; i < rawArray.length; i++) {
            if(!Arrays.equals(rawArray[i], matrix.rawArray[i]))
                return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(rawArray);
    }
    //endregion
}
