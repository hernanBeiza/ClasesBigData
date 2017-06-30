package cl.ugm;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import java.io.IOException;

public class MyReducer extends Reducer <Text, Text, Text, Text> {

	public MyReducer(){
		System.out.println("MyReducer INIT");
	}

	@Override
	protected void reduce (Text palabra, Iterable<Text> documentos, Context contexto)
	throws IOException, InterruptedException {

		System.out.println("MyReducer");
		System.out.println(palabra);
		/*
		for (Text documento:documentos) {
			System.out.println(documento+" " +palabra);
			contexto.write(new Text(palabra.toString()),documento);
		}
		*/

		StringBuilder docString = new StringBuilder();
		while(documentos.iterator().hasNext()) {
			Text valor = documentos.iterator().next();
			System.out.println(valor.toString()+ "->" + palabra);
			docString.append(valor.toString());
			if(documentos.iterator().hasNext()){
				docString.append(",");
			}
		}

		contexto.write(new Text(palabra),new Text(docString.toString()));

	}

}