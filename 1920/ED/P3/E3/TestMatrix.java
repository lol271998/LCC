import java.util.Scanner;

class TestMatrix {
    public static void main(String[] args) {
	Scanner stdin = new Scanner(System.in);

	System.out.println("Matrix m2");
	Matrix m2 = new Matrix(stdin.nextInt(), stdin.nextInt());
	m2.read(stdin);
	System.out.println(m2.magic());

    }
}
