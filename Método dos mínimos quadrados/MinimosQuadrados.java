import java.util.*;

public class MinimosQuadrados {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Quantidade de pontos: ");
        int n = sc.nextInt();

        double[] x = new double[n];
        double[] y = new double[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Digite o valor de x[" + (i+1) + "]: ");
            x[i] = sc.nextDouble();

            System.out.print("Digite o valor de y[" + (i+1) + "]: ");
            y[i] = sc.nextDouble();
        }

        // Cálculo das médias de x e y
        double mediaX = 0;
        double mediaY = 0;

        for (int i = 0; i < n; i++) {
            mediaX += x[i];
            mediaY += y[i];
        }

        mediaX /= n;
        mediaY /= n;

        // Cálculo da covariância e da variância de x
        double cov = 0;
        double varX = 0;

        for (int i = 0; i < n; i++) {
            cov += (x[i] - mediaX) * (y[i] - mediaY);
            varX += Math.pow(x[i] - mediaX, 2);
        }

        cov /= n;
        varX /= n;

        // Cálculo da inclinação e do ponto de intercepção no eixo y
        double m = cov / varX;
        double b = mediaY - m * mediaX;

        System.out.println("Equação da reta: y = " + m + "x + " + b);
    }

}
