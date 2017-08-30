package cl.ugm;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

// Si necesito expulsar otro tipo de dato debo editar acá
public class MyReducer extends Reducer <Text, Text, Text, Text> {

	public MyReducer(){
		System.out.println("MyReducer INIT");
	}

	// Si necesito expulsar otro tipo de dato debo editar acá también en función de lo extendido
	// y de lo recibido desde el mapper

	@Override
	protected void reduce (Text palabra, Iterable<Text> documentos, Context contexto)
	throws IOException, InterruptedException {

		System.out.println("MyReducer");
		System.out.println(palabra);

		StringBuilder docString = new StringBuilder();
		/*
		for (Text documento:documentos) {
			System.out.println(documento+" " +palabra);
			docString.append(documento.toString());
			docString.append(",");
		}
		*/

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