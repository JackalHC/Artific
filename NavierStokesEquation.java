package java6;
import java.util.InputMismatchException;
import java.util.Scanner;

public class NavierStokesEquation {
    private static Scanner scanner;

	public static void main(String[] args) {
        try {
            scanner = new Scanner(System.in);
            
            System.out.print("�������ٶ� u: ");
            double u = scanner.nextDouble();
            
            System.out.print("�������ٶ� v: ");
            double v = scanner.nextDouble();
            
            System.out.print("�������ܶ� rho: ");
            double rho = scanner.nextDouble();
            
            System.out.print("�����붯��ճ�� mu: ");
            double mu = scanner.nextDouble();
            
            double result = calculateNavierStokesEquation(u, v, rho, mu);
            
            System.out.println("��ά��-˹�п�˹���̵Ľ����: " + result);
            
        } catch (InputMismatchException e) {
            System.out.println("������Ч����ȷ�����������Ч����ֵ��");
        } catch (ArithmeticException e) {
            System.out.println("������Ч������ճ�Ȳ���Ϊ0��");
        } catch (Exception e) {
            System.out.println("������δ֪�Ĵ���");
            e.printStackTrace();
        }
    }
    
    public static double calculateNavierStokesEquation(double u, double v, double rho, double mu) {
        if (mu == 0) {
            throw new ArithmeticException("����ճ�Ȳ���Ϊ0");
        }
        
        return rho * (u * u + v * v) / mu;
    }
}