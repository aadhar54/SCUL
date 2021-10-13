// Java program to illustrate the
// concept of Multilevel inheritance
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

class three extends two {
	public void print_yeah()
	{
		System.out.println("Yeah");
	}
}

// Drived class
public class Multilevel {
	public static void main(String[] args)
	{
		three g = new three();
		g.print_yeah();
		g.print_for();
		g.print_yeah();
	}
}
