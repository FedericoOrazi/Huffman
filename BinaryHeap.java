package tesina;
import java.util.PriorityQueue;



public class BinaryHeap {
	
	
	public BinaryHeap(int[] A, int n) {
		this.makeHeap(n);
		this.buildMaxHeap(A);
	}
	
	/* Dato un array crea uno heap */
	public void buildMaxHeap(int[] A) {
		for(int i=A.length-1;i>=0;i--)
			maxHeapify(A,i,A.length);
	}
	
	public void scambia(int[] A, int i, int j){
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}
	
	/*public void sort(int[] A) {
		buildMaxHeap(A);
		int heapSize = A.length;
		for(int i=A.length-1;i>=1;i--){
		scambia(A,0,i);
		heapSize--;
		maxHeapify(A,0,heapSize);
		}
	}*/
	
	/* restituisce il padre del nodo */
	public int Parent(int i) {
		return i/2;
	};

	/* restituisce il figlio sinistro del nodo */
	public int Left(int i) {
		return 2*i;
	};

	/* restituisce il figlio destro del nodo */
	public int Right(int i) {
		return 2*i+1;
	};

	
	
	/* Procedura ausiliaria per la gestione di uno heap */
	public void maxHeapify(int[] A, int i, int heapSize){
		int l = Left(i);
		int r = Right(i);
		int max = i;
		if(l<=heapSize && A[l]>A[max])
			max=l;
		if(r<=heapSize && A[r]>A[max])
			max=r;
		if(max!=i){
			scambia(A,i,max);
			maxHeapify(A,max,heapSize);
		}
	}
	
	public void minHeapify(int[] A, int i, int heapSize){
		int l = Left(i);
		int r = Right(i);
		int min = i;
		if(l<=heapSize && A[l]<A[i])
			min=l;
		if(r<=heapSize && A[r]<A[min])
			min=r;
		if(min!=i){
			scambia(A,A[i],A[min]);
			minHeapify(A,min,heapSize);
		}
	}
	
	
	public int[] makeHeap(int heapSize) {
		int n = heapSize;
		int[] A = new int[n];
		return A;
	}
	
	public void insert(int[] A, int freq, int heapSize) {
		// TODO Auto-generated method stub
		heapSize = A.length;
		heapSize = heapSize+1;
		A[heapSize] = freq;
		int i = heapSize;
	    while(i>1 && A[Parent(i)]<A[i]) {
	    	scambia(A, A[i],Parent(i));
	    	i=Parent(i);
       }
	}


	public int minimum(int[] A) {
		return A[1];	
	}

	public int extract_Min(int[] A, int heapSize) {
		// TODO Auto-generated method stub
		int min = A[1];
		 A[1]=A[heapSize];
		 heapSize = heapSize - 1;
		 minHeapify(A,1, heapSize);
		 return min;		
	}
}
