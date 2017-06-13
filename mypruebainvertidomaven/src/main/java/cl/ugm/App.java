package cl.ugm;

import org.apache.hadoop.conf.*;
import org.apache.hadoop.mapreduce.*;
import org.apache.hadoop.util.*;
import org.apache.hadoop.fs.*;
import org.apache.hadoop.io.*;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.mapreduce.lib.input.*;
import org.apache.hadoop.mapreduce.lib.output.*;

public class App 
{
    public static void main( String[] args ) throws Exception
    {
    	try{
	        System.out.println( "mypruebainvertidomaven" );
	        Configuration conf = new Configuration();
	        String[] opciones = new GenericOptionsParser(conf,args).getRemainingArgs();
	        Job trabajo = Job.getInstance(conf,"mypruebainvertidomaven");
	    
	        trabajo.setJarByClass(App.class);
	        trabajo.setMapperClass(MyMapper.class);
	        trabajo.setCombinerClass(MyReducer.class);
	        trabajo.setReducerClass(MyReducer.class);
	        trabajo.setOutputKeyClass(Text.class);
	        trabajo.setOutputValueClass(IntWritable.class);
			//trabajo.setOutputValueClass(DoubleWritable.class);
	        for(int i = 0;i<opciones.length-1;i++){
	        	FileInputFormat.addInputPath(trabajo,new Path(opciones[i]));        	
	        }
	        FileOutputFormat.setOutputPath(trabajo,new Path(opciones[opciones.length-1]));
	        System.exit(trabajo.waitForCompletion(true)?0:1);

    	} catch (Exception ex){
			ex.printStackTrace();
    	}

        
	}
}
