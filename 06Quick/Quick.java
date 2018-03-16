import java.util.Random;
public class Quick{
    public static int partition(int[] data, int start, int end){
	Random ran = new Random();
	int pi = ran.nextInt(data.length);
	return pi;
    }

    public static void swap(int[] data, int i, int j){
	int temp=data[i];
	data[i]=data[j];
	data[j]=temp;
    }

}
