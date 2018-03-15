import java.util.Random;
public class Quick{
    public static int partition(int[] data, int start, int end){
	int pi=(int)Math.random()*end;
	return pi;
    }

    public static void swap(int[] data, int i, int j){
	int temp=data[i];
	data[i]=data[j];
	data[j]=temp;
    }

}