package cl.ugm;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import java.io.IOException;

import java.util.StringTokenizer;

public class MyReducer extends Reducer <Text, IntWritable, Text, IntWritable> {
	
	public MyReducer(){}

	@Override
	protected void reduce (Text palabra, Iterable<IntWritable> valores, Context contexto) 
	throws IOException, InterruptedException {
		IntWritable total = new IntWritable(0);
		for (IntWritable valor: valores){
			total.set(total.get()+valor.get());
		}
		contexto.write(palabra,total);
	}

}