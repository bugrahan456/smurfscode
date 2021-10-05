import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Main {

    public static final int V = 78;
    public static int yon;
    public static int cevirmatik[][] = new int[][]{
        {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77},
        {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 8, 8, 8, 8, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 10},
        {3, 10, 1, 2, 3, 4, 6, 7, 8, 9, 10, 11, 1, 3, 4, 5, 6, 7, 8, 11, 1, 2, 3, 4, 6, 8, 9, 11, 1, 3, 6, 8, 11, 0, 1, 3, 4, 5, 6, 8, 10, 11, 1, 4, 5, 6, 8, 9, 10, 11, 1, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 1, 3, 9, 10, 11, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 3}};

    public static int[] dijkstra(int matris[][], int kaynak, int hedef) {

        int a = 0;

        int mesafe[] = new int[V];

        int gerekli[] = new int[V];

        int izlenecekYol[] = new int[V];

        Boolean gidildiMi[] = new Boolean[V];

        for (int i = 0; i < V; i++) {
            mesafe[i] = Integer.MAX_VALUE;
            gidildiMi[i] = false;
        }

        mesafe[kaynak] = 0;

        for (int count = 0; count < V - 1; count++) {

            int min_index = -1;

            int min = Integer.MAX_VALUE;

            for (int v = 0; v < V; v++) {
                if (gidildiMi[v] == false && mesafe[v] <= min) {
                    min = mesafe[v];
                    min_index = v;
                }
            }
            int u = min_index;

            gidildiMi[u] = true;

            for (int v = 0; v < V; v++) {
                if (!gidildiMi[v] && matris[u][v] != 0 && mesafe[u] != Integer.MAX_VALUE && mesafe[u] + matris[u][v] < mesafe[v]) {
                    mesafe[v] = mesafe[u] + 1;
                    gerekli[v] = u;
                }
            }
        }

        izlenecekYol[0] = hedef;
        int w = 1;

        do {
            izlenecekYol[w] = gerekli[hedef];
            w++;
            hedef = gerekli[hedef];
            if (hedef == kaynak) {
                a = 10;
            }
        } while (a != 10);

        System.arraycopy(izlenecekYol, 0, gerekli, 0, V);
        int b = 0;
        int g = 0;
        for (int s = 0; s < V; s++) {
            if (b == 1) {
                izlenecekYol[s] = Integer.MAX_VALUE;
                g++;
            }

            if (izlenecekYol[s] == kaynak) {
                b = 1;
                g++;
            }
        }
        int q = 0;
        for (int i = V - g; i >= 0; i--) {
            izlenecekYol[q] = gerekli[i];
            q++;
        }
        return izlenecekYol;
    }

    public static class Mesaj {

        JFrame f;

        Mesaj() {
            f = new JFrame();
            int res = JOptionPane.showOptionDialog(null, "OYUNUMUZ SONA ERMISTIR.CIKIS İCİN 'OK' A BASINIZ...", "TESEKKURLER", JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE, null, null, null);

            if (res == JOptionPane.OK_OPTION) {
                System.exit(0);
            }
        }

    }

    public static void main(String[] args) throws FileNotFoundException, IOException {

        int yol1[] = new int[V];

        int yol2[] = new int[V];

        int matris1[][] = new int[11][13];
        int k;
        File f = new File("src\\harita\\harita .txt");
        try {
            Scanner dosya = new Scanner(f);
            for (int i = 0; i < 11; i++) {
                for (int j = 0; j < 13; j++) {
                    k = dosya.nextInt();
                    matris1[i][j] = k;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Dosya Bulunamadi.");
        }

        int matris2[][] = new int[][]{
            {0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {1, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };

        Dusman gargamel = new Dusman(3, "gargamel", false, 66, "bugrahan", "kral");
        Dusman azman = new Dusman(4, "azman", false, 66, "bugrahan", "kral");

        GozlukluSirin gozluklu = new GozlukluSirin(1, "gözlüklü şirin", true, 66, "bugrahan", "kral", 38,20);
        TembelSirin tembel = new TembelSirin(2, "tembel şirin", true, 66, "bugrahan", "kral", 38, 20);

        gargamel.setLokasyon(77);
        azman.setLokasyon(0);
        gozluklu.setLokasyon(38);
        tembel.setLokasyon(38);

        KeyListener wasd;
        wasd = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                yon = e.getKeyCode();
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        };

        JFrame jFrame = new JFrame();
        jFrame.setResizable(false);
        JPanel jPanel = new JPanel(new GridLayout(11, 13));

        javax.swing.border.Border line = BorderFactory.createLineBorder(Color.black);
        JPanel[][] yerler = new JPanel[11][13];

        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 13; j++) {
                JPanel jPanel1 = new JPanel();
                jPanel1.setBorder(line);
                jPanel.add(jPanel1);
                yerler[i][j] = jPanel1;
            }
        }

        jFrame.setSize(1105, 835);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 13; j++) {
                if (matris1[i][j] == 0) {
                    yerler[i][j].setBackground(Color.pink);
                }
            }
        }
        jPanel.addKeyListener(wasd);
        jPanel.setFocusable(true);
        yerler[5][6].setBackground(Color.blue);
        jFrame.add(jPanel);
        jFrame.setVisible(true);
        System.out.println("\nHangi oyuncuyla oynayacaksınız: \n1:Gözlüklü Sirin\n2:Tembel Sirin");
        Scanner scan = new Scanner(System.in);
        int secim = scan.nextInt();

        ArrayList<Integer> dizi = new ArrayList<>();
        dizi.add(0);
        dizi.add(1);
        dizi.add(33);
        dizi.add(77);
        Collections.shuffle(dizi);

        gargamel.setLokasyon(dizi.get(0));
        azman.setLokasyon(dizi.get(1));

        ArrayList<Integer> dizi1 = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            if(i==0 || i==1 || i==33 || i==77)
                continue;
            dizi1.add(i);
        }

        Collections.shuffle(dizi1);
        int dizi2[] = new int[6];
        dizi2[0] = dizi1.get(0);
        dizi2[1] = dizi1.get(1);
        dizi2[2] = dizi1.get(2);
        dizi2[3] = dizi1.get(3);
        dizi2[4] = dizi1.get(4);
        dizi2[5] = dizi1.get(5);

        if (secim == 1) {
            System.out.println("Gözlüklü sirin secildi...");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }

            for (int i = 0; i < 200; i++) {

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }
                
                if(gozluklu.getSkor()<=0)
                    break;
                
                if (i % 5 == 0) {
                    Collections.shuffle(dizi1);
                    dizi2[0] = dizi1.get(0);
                    dizi2[1] = dizi1.get(1);
                    dizi2[2] = dizi1.get(2);
                    dizi2[3] = dizi1.get(3);
                    dizi2[4] = dizi1.get(4);
                }
                if(i%7 ==0)
                    dizi2[5] = dizi1.get(5);
                
                int a;
                if (dizi2[0] == gozluklu.getLokasyon()) {
                    dizi2[0] = 60;
                    a=gozluklu.getSkor();
                    gozluklu.setSkor(a+5);
                } else if (dizi2[1] == gozluklu.getLokasyon()) {
                    dizi2[1] = 60;
                    a=gozluklu.getSkor();
                    gozluklu.setSkor(a+5);
                } else if (dizi2[2] == gozluklu.getLokasyon()) {
                    dizi2[2] = 60;
                    a=gozluklu.getSkor();
                    gozluklu.setSkor(a+5);
                } else if (dizi2[3] == gozluklu.getLokasyon()) {
                    dizi2[3] = 60;
                    a=gozluklu.getSkor();
                    gozluklu.setSkor(a+5);
                } else if (dizi2[4] == gozluklu.getLokasyon()) {
                    dizi2[4] = 60;
                    a=gozluklu.getSkor();
                    gozluklu.setSkor(a+5);
                } else if (dizi2[5] == gozluklu.getLokasyon()) {
                    dizi2[5] = 60;
                    a=gozluklu.getSkor();
                    gozluklu.setSkor(a+50);
                }

                jPanel = haritaSil(jPanel, yerler, matris1);

                if (gargamel.getLokasyon() == gozluklu.getLokasyon()) {
                    Collections.shuffle(dizi);
                    gargamel.setLokasyon(dizi.get(0));
                    azman.setLokasyon(dizi.get(1));
                    a=gozluklu.getSkor();
                    gozluklu.setSkor(a-15);
                }
                if (azman.getLokasyon() == gozluklu.getLokasyon()) {
                    Collections.shuffle(dizi);
                    gargamel.setLokasyon(dizi.get(0));
                    azman.setLokasyon(dizi.get(1));
                    a=gozluklu.getSkor();
                    gozluklu.setSkor(a-5);
                }

                yol1 = dijkstra(matris2, gargamel.getLokasyon(), gozluklu.getLokasyon());
                yol2 = dijkstra(matris2, azman.getLokasyon(), gozluklu.getLokasyon());

                int git;
                int t = 0;
                int x, y;

                x = cevirmatik[1][gozluklu.getLokasyon()];
                y = cevirmatik[2][gozluklu.getLokasyon()];

                git = yon;
                jPanel = haritaSil(jPanel, yerler, matris1);
                if (git == 40 && matris1[x + 2][y] == 0 && matris1[x + 1][y] == 1) {
                    for (int j = 0; j < 77; j++) {
                        if (cevirmatik[1][j] == x + 1 && cevirmatik[2][j] == y) {
                            break;
                        }
                        t++;
                    }
                } else if (git == 38 && matris1[x - 2][y] == 0 && matris1[x - 1][y] == 1) {
                    for (int j = 0; j < 77; j++) {
                        if (cevirmatik[1][j] == x - 1 && cevirmatik[2][j] == y) {
                            break;
                        }
                        t++;
                    }
                } else if (git == 39 && matris1[x][y + 2] == 0 && matris1[x][y + 1] == 1) {
                    for (int j = 0; j < 77; j++) {
                        if (cevirmatik[1][j] == x && cevirmatik[2][j] == y + 1) {
                            break;
                        }
                        t++;
                    }
                } else if (git == 37 && matris1[x][y - 2] == 0 && matris1[x][y - 1] == 1) {
                    for (int j = 0; j < 77; j++) {
                        if (cevirmatik[1][j] == x && cevirmatik[2][j] == y - 1) {
                            break;
                        }
                        t++;
                    }
                } else if (git == 40 && matris1[x + 2][y] == 1 && matris1[x + 1][y] == 0) {
                    System.out.println("o tarafa gidemezsiniz ...");
                } else if (git == 38 && matris1[x - 2][y] == 1 && matris1[x - 1][y] == 0) {
                    System.out.println("o tarafa gidemezsiniz ...");
                } else if (git == 37 && matris1[x][y - 2] == 1 && matris1[x][y - 1] == 0) {
                    System.out.println("o tarafa gidemezsiniz ...");
                } else if (git == 39 && matris1[x][y + 2] == 1 && matris1[x][y + 1] == 0) {
                    System.out.println("o tarafa gidemezsiniz ...");
                } else if (git == 40 && matris1[x + 2][y] == 1) {
                    for (int j = 0; j < 77; j++) {
                        if (cevirmatik[1][j] == x + 2 && cevirmatik[2][j] == y) {
                            break;
                        }
                        t++;
                    }
                } else if (git == 38 && matris1[x - 2][y] == 1) {
                    for (int j = 0; j < 77; j++) {
                        if (cevirmatik[1][j] == x - 2 && cevirmatik[2][j] == y) {
                            break;
                        }
                        t++;
                    }
                } else if (git == 37 && matris1[x][y - 2] == 1) {
                    for (int j = 0; j < 77; j++) {
                        if (cevirmatik[1][j] == x && cevirmatik[2][j] == y - 2) {
                            break;
                        }
                        t++;
                    }
                } else if (git == 39 && matris1[x][y + 2] == 1) {
                    for (int j = 0; j < 77; j++) {
                        if (cevirmatik[1][j] == x && cevirmatik[2][j] == y + 2) {
                            break;
                        }
                        t++;
                    }
                } else if (git == 40 && matris1[x + 1][y] == 0) {
                    System.out.println("o tarafa gidemezsiniz...");
                } else if (git == 38 && matris1[x - 1][y] == 0) {
                    System.out.println("o tarafa gidemezsiniz...");
                } else if (git == 37 && matris1[x][y - 1] == 0) {
                    System.out.println("o tarafa gidemezsiniz");
                } else if (git == 39 && matris1[x][y + 1] == 0) {
                    System.out.println("o tarafa gidemezsiniz");
                }

                if (t != 0) {
                    gozluklu.setLokasyon(t);
                }

                if (dizi2[0] == gozluklu.getLokasyon()) {
                    dizi2[0] = 60;
                    a=gozluklu.getSkor();
                    gozluklu.setSkor(a+5);
                } else if (dizi2[1] == gozluklu.getLokasyon()) {
                    dizi2[1] = 60;
                    a=gozluklu.getSkor();
                    gozluklu.setSkor(a+5);
                } else if (dizi2[2] == gozluklu.getLokasyon()) {
                    dizi2[2] = 60;
                    a=gozluklu.getSkor();
                    gozluklu.setSkor(a+5);
                } else if (dizi2[3] == gozluklu.getLokasyon()) {
                    dizi2[3] = 60;
                    a=gozluklu.getSkor();
                    gozluklu.setSkor(a+5);
                } else if (dizi2[4] == gozluklu.getLokasyon()) {
                    dizi2[4] = 60;
                    a=gozluklu.getSkor();
                    gozluklu.setSkor(a+5);
                } else if (dizi2[5] == gozluklu.getLokasyon()) {
                    dizi2[5] = 60;
                    a=gozluklu.getSkor();
                    gozluklu.setSkor(a+50);
                }

                if (gozluklu.getLokasyon() == gargamel.getLokasyon()) {
                    Collections.shuffle(dizi);
                    gargamel.setLokasyon(dizi.get(0));
                    azman.setLokasyon(dizi.get(1));
                    a=gozluklu.getSkor();
                    gozluklu.setSkor(a-15);
                }
                if (azman.getLokasyon() == gozluklu.getLokasyon()) {
                    Collections.shuffle(dizi);
                    gargamel.setLokasyon(dizi.get(0));
                    azman.setLokasyon(dizi.get(1));
                    a=gozluklu.getSkor();
                    gozluklu.setSkor(a-5);
                }
                
                if(gozluklu.getSkor()<=0)
                    break;

                if (gozluklu.getLokasyon() == 60) {
                    yol1 = dijkstra(matris2, gargamel.getLokasyon(), gozluklu.getLokasyon());
                    yol2 = dijkstra(matris2, azman.getLokasyon(), gozluklu.getLokasyon());
                    jPanel = haritaSil(jPanel, yerler, matris1);
                    break;
                }

                yol1 = dijkstra(matris2, gargamel.getLokasyon(), gozluklu.getLokasyon());
                yol2 = dijkstra(matris2, azman.getLokasyon(), gozluklu.getLokasyon());

                gargamel.setLokasyon(yol1[2]);
                azman.setLokasyon(yol2[1]);

                if (gozluklu.getLokasyon() == gargamel.getLokasyon()) {
                    gargamel.setLokasyon(dizi.get(0));
                    azman.setLokasyon(dizi.get(1));
                    a=gozluklu.getSkor();
                    gozluklu.setSkor(a-15);
                }
                if (azman.getLokasyon() == gozluklu.getLokasyon()) {
                    gargamel.setLokasyon(dizi.get(0));
                    azman.setLokasyon(dizi.get(1));
                    a=gozluklu.getSkor();
                    gozluklu.setSkor(a-5);
                }
                
                if(gozluklu.getSkor()<=0)
                    break;
                
                
                jPanel = haritaCiz(dizi2, jPanel, yol1, yol2, yerler, gargamel.getLokasyon(), azman.getLokasyon(), gozluklu.getLokasyon(), gozluklu.getOyuncuID());
                System.out.println("");
                System.out.println(gozluklu.getSkor()+" skor");
            }
        } else if (secim == 2) {

            System.out.println("tembel sirin secildi...");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }

            for (int i = 0; i < 200; i++) {

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }
                if (i % 5 == 0) {
                    Collections.shuffle(dizi1);
                    dizi2[0] = dizi1.get(0);
                    dizi2[1] = dizi1.get(1);
                    dizi2[2] = dizi1.get(2);
                    dizi2[3] = dizi1.get(3);
                    dizi2[4] = dizi1.get(4);
                }
                if(i%7 ==0)
                    dizi2[5] = dizi1.get(5);
                
                int a;
                if (dizi2[0] == tembel.getLokasyon()) {
                    dizi2[0] = 60;
                    a=tembel.getSkor();
                    tembel.setSkor(a+5);
                } else if (dizi2[1] == tembel.getLokasyon()) {
                    dizi2[1] = 60;
                    a=tembel.getSkor();
                    tembel.setSkor(a+5);
                } else if (dizi2[2] == tembel.getLokasyon()) {
                    dizi2[2] = 60;
                    a=tembel.getSkor();
                    tembel.setSkor(a+5);
                } else if (dizi2[3] == tembel.getLokasyon()) {
                    dizi2[3] = 60;
                    a=tembel.getSkor();
                    tembel.setSkor(a+5);
                } else if (dizi2[4] == tembel.getLokasyon()) {
                    dizi2[4] = 60;
                    a=tembel.getSkor();
                    tembel.setSkor(a+5);
                } else if (dizi2[5] == tembel.getLokasyon()) {
                    dizi2[5] = 60;
                    a=tembel.getSkor();
                    tembel.setSkor(a+50);
                }

                jPanel = haritaSil(jPanel, yerler, matris1);

                if (gargamel.getLokasyon() == tembel.getLokasyon()) {
                    Collections.shuffle(dizi);
                    gargamel.setLokasyon(dizi.get(0));
                    azman.setLokasyon(dizi.get(1));
                    a=gozluklu.getSkor();
                    gozluklu.setSkor(a-15);
                }
                if (azman.getLokasyon() == tembel.getLokasyon()) {
                    Collections.shuffle(dizi);
                    gargamel.setLokasyon(dizi.get(0));
                    azman.setLokasyon(dizi.get(1));
                    a=gozluklu.getSkor();
                    gozluklu.setSkor(a-5);
                }

                yol1 = dijkstra(matris2, gargamel.getLokasyon(), tembel.getLokasyon());
                yol2 = dijkstra(matris2, azman.getLokasyon(), tembel.getLokasyon());

                int git;
                int t = 0;
                int x, y;

                x = cevirmatik[1][tembel.getLokasyon()];
                y = cevirmatik[2][tembel.getLokasyon()];

                git = yon;
                jPanel = haritaSil(jPanel, yerler, matris1);
                if (git == 40 && matris1[x + 1][y] == 1) {
                    for (int j = 0; j < 77; j++) {
                        if (cevirmatik[1][j] == x + 1 && cevirmatik[2][j] == y) {
                            break;
                        }
                        t++;
                    }
                } else if (git == 38 && matris1[x - 1][y] == 1) {
                    for (int j = 0; j < 77; j++) {
                        if (cevirmatik[1][j] == x - 1 && cevirmatik[2][j] == y) {
                            break;
                        }
                        t++;
                    }
                } else if (git == 37 && matris1[x][y - 1] == 1) {
                    for (int j = 0; j < 77; j++) {
                        if (cevirmatik[1][j] == x && cevirmatik[2][j] == y - 1) {
                            break;
                        }
                        t++;
                    }
                } else if (git == 39 && matris1[x][y + 1] == 1) {
                    for (int j = 0; j < 77; j++) {
                        if (cevirmatik[1][j] == x && cevirmatik[2][j] == y + 1) {
                            break;
                        }
                        t++;
                    }
                } else if (git == 40 && matris1[x + 1][y] == 0) {
                    System.out.println("o tarafa gidemezsiniz...");
                } else if (git == 38 && matris1[x - 1][y] == 0) {
                    System.out.println("o tarafa gidemezsiniz...");
                } else if (git == 37 && matris1[x][y - 1] == 0) {
                    System.out.println("o tarafa gidemezsiniz");
                } else if (git == 39 && matris1[x][y + 1] == 0) {
                    System.out.println("o tarafa gidemezsiniz");
                }
                if (t != 0) {
                    tembel.setLokasyon(t);
                }

                if (dizi2[0] == tembel.getLokasyon()) {
                    dizi2[0] = 60;
                    a=tembel.getSkor();
                    tembel.setSkor(a+5);
                } else if (dizi2[1] == tembel.getLokasyon()) {
                    dizi2[1] = 60;
                    a=tembel.getSkor();
                    tembel.setSkor(a+5);
                } else if (dizi2[2] == tembel.getLokasyon()) {
                    dizi2[2] = 60;
                    a=tembel.getSkor();
                    tembel.setSkor(a+5);
                } else if (dizi2[3] == tembel.getLokasyon()) {
                    dizi2[3] = 60;
                    a=tembel.getSkor();
                    tembel.setSkor(a+5);
                } else if (dizi2[4] == tembel.getLokasyon()) {
                    dizi2[4] = 60;
                    a=tembel.getSkor();
                    tembel.setSkor(a+5);
                } else if (dizi2[5] == tembel.getLokasyon()) {
                    dizi2[5] = 60;
                    a=tembel.getSkor();
                    tembel.setSkor(a+50);
                }

                if (tembel.getLokasyon() == gargamel.getLokasyon()) {
                    Collections.shuffle(dizi);
                    gargamel.setLokasyon(dizi.get(0));
                    azman.setLokasyon(dizi.get(1));
                    a=tembel.getSkor();
                    tembel.setSkor(a-15);
                }
                if (azman.getLokasyon() == tembel.getLokasyon()) {
                    Collections.shuffle(dizi);
                    gargamel.setLokasyon(dizi.get(0));
                    azman.setLokasyon(dizi.get(1));
                    a=tembel.getSkor();
                    tembel.setSkor(a-5);
                }

                if (tembel.getLokasyon() == 60) {
                    yol1 = dijkstra(matris2, gargamel.getLokasyon(), tembel.getLokasyon());
                    yol2 = dijkstra(matris2, azman.getLokasyon(), tembel.getLokasyon());
                    jPanel = haritaSil(jPanel, yerler, matris1);
                    break;
                }

                yol1 = dijkstra(matris2, gargamel.getLokasyon(), tembel.getLokasyon());
                yol2 = dijkstra(matris2, azman.getLokasyon(), tembel.getLokasyon());

                gargamel.setLokasyon(yol1[2]);
                azman.setLokasyon(yol2[1]);

                if (tembel.getLokasyon() == gargamel.getLokasyon()) {
                    gargamel.setLokasyon(dizi.get(0));
                    azman.setLokasyon(dizi.get(1));
                    a=tembel.getSkor();
                    tembel.setSkor(a-15);
                }
                if (azman.getLokasyon() == tembel.getLokasyon()) {
                    gargamel.setLokasyon(dizi.get(0));
                    azman.setLokasyon(dizi.get(1));
                    a=tembel.getSkor();
                    tembel.setSkor(a-5);
                }
                jPanel = haritaCiz(dizi2, jPanel, yol1, yol2, yerler, gargamel.getLokasyon(), azman.getLokasyon(), tembel.getLokasyon(), tembel.getOyuncuID());
                System.out.println("");
                System.out.println(tembel.getSkor()+" skor");
            }

        }
        new Mesaj();

    }

    public static JPanel haritaCiz(int dizi[], JPanel jpanel, int yol1[], int yol2[], JPanel[][] yerler, int gargamel1, int azman1, int ben, int kimim) throws IOException {

        BufferedImage tembel = ImageIO.read(new File("src\\image\\tembel.jpeg"));
        BufferedImage gozluklu = ImageIO.read(new File("src\\image\\gozluklu.jpeg"));
        BufferedImage sirine = ImageIO.read(new File("src\\image\\sirine.jpeg"));
        BufferedImage gargamel = ImageIO.read(new File("src\\image\\gargamel.jpg"));
        BufferedImage azman = ImageIO.read(new File("src\\image\\azman.jpg"));
        BufferedImage mantar = ImageIO.read(new File("src\\image\\mantar.jpg"));
        BufferedImage altin1 = ImageIO.read(new File("src\\image\\altin.png"));
        BufferedImage altin2 = ImageIO.read(new File("src\\image\\altin.png"));
        BufferedImage altin3 = ImageIO.read(new File("src\\image\\altin.png"));
        BufferedImage altin4 = ImageIO.read(new File("src\\image\\altin.png"));
        BufferedImage altin5 = ImageIO.read(new File("src\\image\\altin.png"));

        if (ben != 60) {
            JLabel jLabel3 = new JLabel(new ImageIcon(sirine));
            jLabel3.setSize(85, 75);
            yerler[7][12].setBackground(Color.black);
            yerler[7][12].add(jLabel3);
        }

        JLabel jLabel1 = new JLabel(new ImageIcon(tembel));
        JLabel jLabel2 = new JLabel(new ImageIcon(gozluklu));
        JLabel jLabel4 = new JLabel(new ImageIcon(gargamel));
        JLabel jLabel5 = new JLabel(new ImageIcon(azman));
        JLabel jLabel6 = new JLabel(new ImageIcon(mantar));
        JLabel jLabel7 = new JLabel(new ImageIcon(altin1));
        JLabel jLabel8 = new JLabel(new ImageIcon(altin2));
        JLabel jLabel9 = new JLabel(new ImageIcon(altin3));
        JLabel jLabel10 = new JLabel(new ImageIcon(altin4));
        JLabel jLabel11 = new JLabel(new ImageIcon(altin5));

        jLabel1.setSize(85, 75);
        jLabel2.setSize(85, 75);
        jLabel4.setSize(85, 75);
        jLabel5.setSize(85, 75);
        jLabel6.setSize(85, 75);
        jLabel7.setSize(85, 75);
        jLabel8.setSize(85, 75);
        jLabel9.setSize(85, 75);
        jLabel10.setSize(85, 75);
        jLabel11.setSize(85, 75);

        int x1, x2, y1, y2;
        x1 = cevirmatik[1][gargamel1];
        y1 = cevirmatik[2][gargamel1];
        x2 = cevirmatik[1][azman1];
        y2 = cevirmatik[2][azman1];

        int x3, y3;
        x3 = cevirmatik[1][ben];
        y3 = cevirmatik[2][ben];
        yerler[x3][y3].setBackground(Color.black);
        yerler[x1][y1].setBackground(Color.black);
        yerler[x2][y2].setBackground(Color.black);
        for (int i = 2; i < 20; i++) {
            int x = cevirmatik[1][yol1[i]];
            int y = cevirmatik[2][yol1[i]];
            if (x == x1 && y == y1) {
                continue;
            }
            yerler[x][y].setBackground(Color.red);
            if (yol1[i + 1] == Integer.MAX_VALUE) {
                break;
            }
        }

        for (int i = 2; i < 11; i++) {
            int x = cevirmatik[1][yol2[i]];
            int y = cevirmatik[2][yol2[i]];

            if (x == x2 && y == y2) {
                continue;
            }
            yerler[x][y].setBackground(Color.yellow);
            if (yol2[i + 1] == Integer.MAX_VALUE) {
                break;
            }
            yerler[x1][y1].add(jLabel4);
            yerler[x2][y2].add(jLabel5);
            if (kimim == 1) {
                yerler[x3][y3].add(jLabel2);
            } else if (kimim == 2) {
                yerler[x3][y3].add(jLabel1);
            }

        }

        for (int i = 0; i < 6; i++) {
            int a;
            if (dizi[i] != gargamel1 && dizi[i] != azman1 && dizi[i] != ben) {
                a = dizi[i];
            }

            int xa, ya;
            xa = cevirmatik[1][dizi[i]];
            ya = cevirmatik[2][dizi[i]];
            yerler[xa][ya].setBackground(Color.black);
            if (i == 0) {
                yerler[xa][ya].add(jLabel7);
            }
            if (i == 1) {
                yerler[xa][ya].add(jLabel8);
            }
            if (i == 2) {
                yerler[xa][ya].add(jLabel9);
            }
            if (i == 3) {
                yerler[xa][ya].add(jLabel10);
            }
            if (i == 4) {
                yerler[xa][ya].add(jLabel11);
            }
            if (i == 5) {
                yerler[xa][ya].add(jLabel6);
            }
        }

        return jpanel;
    }

    public static JPanel haritaSil(JPanel jPanel, JPanel[][] yerler, int[][] matris1) {
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 13; j++) {
                if (matris1[i][j] == 1) {
                    yerler[i][j].setBackground(Color.white);
                    yerler[i][j].removeAll();
                }
            }
        }

        return jPanel;
    }

}