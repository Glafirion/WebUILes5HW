package org.example.HomeWork4;

public class TriangleArea {
    public static double calculatedAreaT(double sideA, double sideB, double sideC) throws Exception {
        if (sideA <=0 || sideB <=0 || sideC <= 0) {
            throw new Exception("UNDER ZERO");
        }
        double halfPerimeter = (sideA + sideB + sideC)/2;
        return Math.sqrt(halfPerimeter * (halfPerimeter - sideA) * (halfPerimeter - sideB) * (halfPerimeter - sideC));


    }
}
