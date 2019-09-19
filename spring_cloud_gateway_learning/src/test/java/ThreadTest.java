import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadTest {
    public static  void main(String[] args)  {
        //ThreadTest tt=new ThreadTest();
        FutureTask<Integer> task=new FutureTask<Integer>((Callable<Integer>)()->{
            int i=0;
            for (;i<10;i++){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
            return i;
        });


        try{
            for (int i=0;i<100;i++){
                if (i%20==0){
                    System.out.println(Thread.currentThread().getName()+"的循环变量i="+i);
                    new Thread(task).start();
                    //task.get();
                    //System.out.println("县城开始执行》》》》》》》》》");
                    //System.out.println("子线程获取的返回值："+task.get());
                }
            }
            System.out.println("县城开始执行》》》》》》》》》");
            System.out.println("子线程获取的返回值："+task.get());
            //task.get();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
