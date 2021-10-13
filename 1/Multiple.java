interface Writeable
{
    void writes();
}
interface Readable 
{   
    void reads();

}
class Multiple implements Readable,Writable
{
    public void reads()
    {
    stem.out.print(“Student reads.. ”);
    }
    public void writes()
    {
    System.out.print(“ Student writes..”);
    }

    public static void main(String args[])
    {
    Multiple s = new Multiple();
    s.reads();
    s.writes();
    }
}
