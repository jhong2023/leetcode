package hack;

public class RandomRead {

	int read1024(byte buffer[]){
		return 0;
	}
	
	byte[] buffer = new byte[1024];
	int bufStart = 0;
	int bufSize = 0;
	int randomRead(byte output[], int size){
		int i = 0;
		while(i < size){
			if(bufStart == bufSize){
				bufSize = read1024(buffer);
				bufStart = 0;
				if(bufSize == 0) break;
			}
			for(int j = bufStart; j < bufSize && i < size; j++, i++){
				output[i] = buffer[j];
			}
		}
		
		return i;
	}

}
