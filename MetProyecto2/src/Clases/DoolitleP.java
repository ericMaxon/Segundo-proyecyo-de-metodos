package Clases;
/*
* Clase para realizar todos los procesos necesarios para el calculos
* de los datos en Doolitle
* */
public class DoolitleP{
        private double[][] A;
        private double[][] L;
        private double[][] U;
        private double[] X;
        private double[] Y;
        private double[] B;
        private final int tama = 3;

                DoolitleP(){
                        A = new double[tama][tama];
                        L = new double[tama][tama];
                        U = new double[tama][tama];
                        X = new double[tama];
                        Y = new double[tama];
                        B = new double[tama];
                }
//        Asignacion de datos de una matriz
        public void Asignar(String campo , int f, int c){
                Convertir convertir = new Convertir();
                A[f][c] = convertir.DatosD(campo);
        }
//        Asignacion de datos de un vector
        public void Asignar(String campo, int posi){
        Convertir convertir = new Convertir();
        B[posi]=convertir.DatosD(campo);
        }
//        Este metodo realiza la generacion de los triangulos necesarios para el calculo de Doolitle
        public void CreacionTriangulos(){
        //Aqui se crean el triangulo superior e inferior segun lo ya dado en clase
        double aux=0.0;

        U[0][0]= A[0][0];//Superior 1,1
        L[0][0]=1;//Inferior 1,1

        U[0][1]= A[0][1];//Superior 1, 2
        L[0][1]=0;//Inferior 1, 2

        U[0][2]= A[0][2];//Superior 1, 3
        L[0][2]=0;//Inferior 1, 3

        U[1][0]=0;//Superior 2, 1
        aux = A[1][0]/U[0][0];
        L[1][0]=aux;//Inferior 2, 1

        L[1][1]=1;//Inferior 2, 2
        aux = A[1][1] - L[1][0]*U[0][1];
        U[1][1]=aux;//Superior 2, 2

        L[1][2]=0;//Inferior 2, 3
        aux = A[1][2] - L[1][0]*U[0][2];
        U[1][2]=aux;//Superior 2, 3

        U[2][0]=0;//Superior 3, 1
        aux=A[2][0]/U[0][0];
        L[2][0]=aux;//Inferior 3, 1

        U[2][1]=0;//Superior 3, 2
        aux=(A[2][1] - (L[2][0] * U[0][1]))/U[1][1];
        L[2][1]=aux;//Inferior 3, 2

        L[2][2]=1;//Inferior 3, 3
        aux= A[2][2] - (L[2][0] * U[0][2]) - (L[2][1]*U[1][2]);
        U[2][2]=aux;//Superior 3, 3
        }
//        Se calcula el vector y
        public void calcularY(){
                Y[0]= B[0]/L[0][0];
                Y[1]=(B[1] - (L[1][0]*Y[0]))/L[1][1];
                Y[2]=(B[2] - (L[2][0]*Y[0]) - (L[2][1]*Y[1]))/L[2][2];
        }
//        Se calcula el vector X
        public void calcularX(){
                X[2] = Y[2]/U[2][2];
                X[1] = (Y[1] - (U[1][2]*X[2]))/U[1][1];
                X[0] = (Y[0] - (U[0][2]*X[2]) - (U[0][1]*X[1]))/U[0][0];
        }
        public double TraerA(int f, int c){
        return A[f][c];
        }
        public double TraerU(int f, int c){
        return U[f][c];
        }
        public double TraerL(int f, int c){
        return L[f][c];
        }
        public double TraerB(int f){
        return B[f];
        }
        public double TraerX(int f){
        return X[f];
        }
        public double TraerY(int f){
        return Y[f];
        }
}
