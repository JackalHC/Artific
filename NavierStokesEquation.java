package java6;
import java.util.InputMismatchException;
import java.util.Scanner;

public class NavierStokesEquation {
    private static Scanner scanner;

	public static void main(String[] args) {
        try {
            scanner = new Scanner(System.in);
            
            System.out.print("请输入速度 u: ");
            double u = scanner.nextDouble();
            
            System.out.print("请输入速度 v: ");
            double v = scanner.nextDouble();
            
            System.out.print("请输入密度 rho: ");
            double rho = scanner.nextDouble();
            
            System.out.print("请输入动力粘度 mu: ");
            double mu = scanner.nextDouble();
            
            double result = calculateNavierStokesEquation(u, v, rho, mu);
            
            System.out.println("纳维尔-斯托克斯方程的结果是: " + result);
            
        } catch (InputMismatchException e) {
            System.out.println("输入无效！请确保输入的是有效的数值。");
        } catch (ArithmeticException e) {
            System.out.println("输入无效！动力粘度不能为0。");
        } catch (Exception e) {
            System.out.println("发生了未知的错误！");
            e.printStackTrace();
        }
    }
    
    public static double calculateNavierStokesEquation(double u, double v, double rho, double mu) {
        if (mu == 0) {
            throw new ArithmeticException("动力粘度不能为0");
        }
        
        return rho * (u * u + v * v) / mu;
    }
}