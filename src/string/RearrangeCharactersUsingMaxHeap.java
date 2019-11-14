package string;

import java.util.Arrays;
import java.util.Random;


final class CharFreq implements Comparable<CharFreq>{
	char c;
	int freq;
	public CharFreq(char ch, int count){
		c = ch;
		freq = count;
	}
	@Override
	public int compareTo(CharFreq o) {
		int comp = Double.compare(o.freq,freq);
		if(comp == 0){
			comp = Character.compare(o.c,c);
		}
		
		return comp;
	}
}

public class RearrangeCharactersUsingMaxHeap {
	
	
		public int size;
		public CharFreq [] mH;
		public int position;
		public RearrangeCharactersUsingMaxHeap(int size){
			this.size=size;
			mH = new CharFreq[size+1];
			position = 0;
			mH[0] = new CharFreq('0', 0);
		}
		
		
		
		public void display(){
			for(int i=1;i<mH.length;i++){
				System.out.print(" " + mH[i]);			
			}
			System.out.println("");
		}
		public void insert(CharFreq charFreq){
			if(position==0){
				mH[position+1]=charFreq;
				position = 2;
			}else{
				mH[position++]=charFreq;
				bubbleUp();
			}
		}
		public void bubbleUp(){
			int pos = position-1;
			while(pos>1 && mH[pos/2].freq<mH[pos].freq){
				CharFreq y = mH[pos];
				mH[pos]=mH[pos/2];
				mH[pos/2] = y;
				pos = pos/2;
			}
		}
		public CharFreq extractMax(){
			CharFreq min = mH[1];
			mH[1]=mH[position-1];
			mH[position-1]=null;
			position--;		
			sinkDown(1);
			return min;
		}
		
		public void sinkDown(int k){CharFreq a = mH[k];
			int smallest =k;
			if(2*k<position && mH[smallest].freq<mH[2*k].freq){
				smallest = 2*k;
			}
			if(2*k+1<position && mH[smallest].freq<mH[2*k+1].freq){
				smallest = 2*k+1;
			}
			if(smallest!=k){
				swap(k,smallest);
				sinkDown(smallest);
			}
					
		}
		public void swap(int a, int b){
			//System.out.println("swappinh" + mH[a] + " and " + mH[b]);
			CharFreq temp = mH[a];
			mH[a] = mH[b];
			mH[b] = temp;
		}
		
		public static void main(String args[]){
			int freqHistoGram[] = new int[256];
			String str = "aaabc";
			for(char c : str.toCharArray()){
				freqHistoGram[c]++;
			}
			RearrangeCharactersUsingMaxHeap rearrangeCharactersUsingMaxHeap = new RearrangeCharactersUsingMaxHeap(str.length());
			//build the max heap of histogram
			for(char i  = 0; i < 256; i++){
				if(freqHistoGram[i] > 0)
					rearrangeCharactersUsingMaxHeap.insert(new CharFreq(i, freqHistoGram[i]));
			}
			StringBuilder rearranged = new StringBuilder();
			while(rearranged.length()<str.length()){
				//extract top one and decrease the hstogram by one
				CharFreq first = rearrangeCharactersUsingMaxHeap.extractMax();
				rearranged.append(first.c);
				first.freq--;
				CharFreq second = null;
				//extract second top and decrease the histogram by one
				if(rearranged.length()<str.length()){
					second = rearrangeCharactersUsingMaxHeap.extractMax();
					rearranged.append(second.c);
					second.freq--;
				}
				
				//add back the updated histograms 
				if(first.freq > 0){
					rearrangeCharactersUsingMaxHeap.insert(first);
				}
				if(second != null && second.freq > 0){
					rearrangeCharactersUsingMaxHeap.insert(second);
				}
			}
			
			System.out.println(rearranged);
			
			
		}
		
			
	}
