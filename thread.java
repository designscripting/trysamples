// Thread t1 = new Thread(); t1.start();
//
class Animal
{
  public void eat ()
  {
    System.out.println ("I am eating");
  }
}

//A class can extend Thread or implement Runnable interface
class Hello extends Animal implements Runnable
{
  public void run ()
  {
    for (int count = 0; count <= 5; count++)
      {
	System.out.println ("Say Hello");
	try
	{
	  Thread.sleep (1000);
	}
	catch (Exception e)
	{
	}
      }
  }
}

public class Main
{
  public static void main (String[]args) throws Exception
  {

    //Runnable is a fn interface, can be passed as Lambda expr
    Thread t1 = new Thread (()->{
			    for (int i = 0; i <= 5; i++)
			    {
			    System.out.println ("Hi" +
						Thread.currentThread ().
						getPriority ()); try
			    {
			    Thread.sleep (1000);} catch (Exception e)
			    {
			    }
			    }
			    }, "Hi Thread");
	//Thread Priority Low:1, High:10
    t1.setPriority (Thread.MAX_PRIORITY);
    t1.start ();

    //Since Hello extends Runnable interface will not have start method
    Hello h2 = new Hello ();
    Thread t2 = new Thread (h2);
    t2.start ();

    System.out.println ("live start thread" + t1.isAlive ());
    System.out.println (t1.getName ());
    System.out.println (t1.getPriority ());
    System.out.println ("live start thread" + t1.isAlive ());

    t1.join ();
    t2.join ();
    System.out.println ("live end thread" + t1.isAlive ());

    /*
       Thread join
       t1 ---main---  t2
       |       |       |
       |       |       |
       |------Bye------|

     */

    //Bye belong to main thread
    System.out.println ("Bye");

  }
}
