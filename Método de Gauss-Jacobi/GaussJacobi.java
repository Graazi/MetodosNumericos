import java.util.Arrays;

public class GaussJacobi {
    public static void main(String[] args) {
        double[][] A = {{4, 1, -1}, {1, 3, 1}, {2, -2, 5}}; // Matriz dos coeficientes
        double[] b = {5, 10, 15}; // Vetor dos termos independentes
        double[] x = {0, 0, 0}; // Vetor inicial das incógnitas
        double[] xPrev = new double[x.length]; // Vetor das estimativas anteriores
        double tol = 1e-6; // Tolerância
        int maxIterations = 100; // Número máximo de iterações

        int iter = 0;
        while (iter < maxIterations) {
            System.arraycopy(x, 0, xPrev, 0, x.length); // Copia as estimativas anteriores

            for (int i = 0; i < A.length; i++) {
                double sum = 0;
                for (int j = 0; j < A.length; j++) {
                    if (j != i) {
                        sum += A[i][j] * xPrev[j];
                    }
                }
                x[i] = (b[i] - sum) / A[i][i];
            }

            double diffNorm = calculateNorm(vectorSubtraction(x, xPrev));
            if (diffNorm < tol) {
                break; // Condição de parada atingida
            }

            iter++;
        }

        System.out.println("Solução encontrada:");
        System.out.println(Arrays.toString(x));
    }

    private static double[] vectorSubtraction(double[] a, double[] b) {
        double[] result = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            result[i] = a[i] - b[i];
        }
        return result;
    }

    private static double calculateNorm(double[] vector) {
        double sum = 0;
        for (double v : vector) {
            sum += v * v;
        }
        return Math.sqrt(sum);
    }
}
