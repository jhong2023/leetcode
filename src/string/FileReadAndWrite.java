package string;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class FileReadAndWrite {

	static List<String> read(String file) throws IOException{
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String line;
		List<String> lines = new ArrayList<String>();
		while((line = reader.readLine()) != null){
			lines.add(line);
		}
		reader.close();
		return lines;
	}
	
	static void write(String file, List<String> lines) throws IOException{
		BufferedWriter writer = new BufferedWriter(new FileWriter(file));
		for(String line : lines){
			System.out.println(line);
			writer.write(line);
			writer.newLine();
		}
		writer.close();
	}
	
	static String readFile(String file) throws IOException{
		byte[] buffer = new byte[512];
		FileInputStream is = new FileInputStream(file);
		StringBuffer buf = new StringBuffer();
		while(is.read(buffer) != -1){
			buf.append(new String(buffer));
		}
		is.close();
		return buf.toString();
	}
	
	static void writeFile(String file, String str) throws IOException{
		byte[] buffer = new byte[512];
		FileOutputStream os = new FileOutputStream(file);
		StringBuffer buf = new StringBuffer();
		os.write(str.getBytes());
		os.close();
	}
	
	
	
	
	public static void main(String[] args) {
		try {
			new FileWriter("").write("");
			writeFile("/tmp/newwrite.tex", readFile("/tmp/writetest.txt"));
//			write("/tmp/writetest.txt", read("/Users/hj/workspace/leetcode/src/string/FileReadAndWrite.java"));
//			for(String str : read("/Users/hj/workspace/leetcode/src/string/FileReadAndWrite.java")){
//				System.out.println(str);
//			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
