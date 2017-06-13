package cl.ugm;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.util.StringTokenizer;

public class MyMapper extends Mapper <Object, Text, Text, DoubleWritable> {
	
	public MyMapper(){ }

	public void map(Object k, Text linea, Context contexto){
		//System.out.println("Procesando");
		//System.out.println("Key: "+k);
		//System.out.println("Valor: "+linea);
		
		StringTokenizer parser = new StringTokenizer(linea.toString(),";");
		try {
			while(parser.hasMoreTokens()){
				Text key2 = new Text(parser.nextToken());
				//System.out.println("key:"+key);			
				Text key = new Text(parser.nextToken());
				//System.out.println("key2: "+key2);			
				Text key3 = new Text(parser.nextToken());
				//System.out.println("key3: "+key3);			
				Text key4 = new Text(parser.nextToken());
				//System.out.println("key4: "+key4);			
				Text key5 = new Text(parser.nextToken());
				//System.out.println("key5: "+key5);			
				Text key6 = new Text(parser.nextToken());
				//System.out.println("key6: "+key6);			
				Text key7 = new Text(parser.nextToken());
				//System.out.println("key7: "+key7);		
				String key8 = new String(parser.nextToken());
				//System.out.println("key8: "+key8);			
				String key9 = new String(parser.nextToken());
				//System.out.println("key9: "+key9);
				//Double valorMinimo = Double.parseDouble(key8);	
				Double valorMaximo = Double.parseDouble(key9);
				System.out.println("MyMapper.java: key: "+key+" valorMaximo: "+valorMaximo);
				DoubleWritable value = new DoubleWritable(valorMaximo);
				contexto.write(key,value);
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
}