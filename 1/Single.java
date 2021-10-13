// Java program to illustrate the
// concept of single inheritance
import java.io.*;
import java.lang.*;
import java.util.*;

class one {
	public void print_yeah()
	{
		System.out.println("Yeah");
	}
}

class two extends one {
	public void print_for() { System.out.println("for"); }
}
// Driver class
public class Single {
	public static void main(String[] args)
	{
		two g = new two();
		g.print_yeah();
		g.print_for();
		g.print_yeah();
	}
}
