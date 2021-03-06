
public class Stack {
	//IMPLEMENTAZIONE DELLA PILA ATTRAVERSO UN ARRAY
	/*DEFINIZIONE:La pila � un struttura dati che segue un sistema LIFO(LAST IN FIRST OUT) in cui inserimento ed estrazione avvengo in cima .
	 L'implemetazione da noi studiata prevede un contenuto di tipo primitivo int degli elementi*/

	private static int b = 5;//dimensione base della pila
	private int top = 0;//posizione libera per inserimento
	private int[] Q;//array che conterr� gli elementi della struttura dati
	private int k = 1;//indica il numero di volte in cui si � aumentata la dimensione base dell'array per isufficienza di spazio
	
	public Stack() {//costruttore
		Q = new int[b];//crea inizialmente array di dimensione base b
	}
	
	public int size() {//RESTITUISCE IL NUMERO DI ELEMENTI NELLA PILA
		return top;
	}
	
	public boolean empty() {//INDICA SE LA PILA � VUOTA
		if(top==0) return true;
		else return false;
	}
	
	public void push(int x) {//METODO DI INSERIMENTO DI UN ELEMENTO DI CONTENUTO X
		if (top >= k*b) {//se l'array � pieno
			k++;//si incrementa la dimensione dell'array
			/*es: se k=2 si raddopia dimensione base, se k=3 si triplica dimensione base etc....*/
			int[] Q1 = new int[k*b];//si crea un array con dimensione pi� grande
			for (int i = 0; i<top; i++) //con tale ciclo si scandiscono i due array quello vecchio che � pieno e quello nuovo appena creato che � vuota e va popolato
				Q1[i] = Q[i];//si copiano elementi del vettore pieno nel nuovo vettore pi� grande nella medesima poszione
			Q = Q1;//dopo copiatura si aggiorna la pila dicendo che � la nuova struttura dati creata 
		}
		//se array non � pieno o comunque dopo copiatura elementi
		Q[top++] = x;//si inserisce elemento nella prima posizione libera (top+1) del nuovo vettore incrementato 
	}
	
	public int pop() {//METODO DI ESTRAZIONE DI UN ELEMENTO DI CONTENUTO X DALL'ULTIMA POSIZIONE
		if (top == 0) {//se la pila � vuota
			System.out.println("ERRORE: Pila vuota");
			return 0;
		}
		//altrimenti
		int x = Q[--top];//si salva ultimo elemento in posizione top-1
		if (top < (k-1)*b) {//tale condizione indica che c'� un numero di caselle libere tale da poter decrementare il fattore k
			k--;//si dmunuisce k di una unit�
			int[] Q1 = new int[k*b];//si modifica dimensione del vettore creando uno pi� piccolo
			for (int i = 0; i<top; i++) //con tale ciclo si copiano elementi dal vettore pi� grande Q a quello nuovo pi� piccolo Q1
				Q1[i] = Q[i];
			Q = Q1;//si impone che la nuova struttura dati sia quella del vettore pi� piccolo
		}
		return x;//si restituisce elemento estratto essendo che il metodo pop deve restituire un intero
		
	}
	
	public void stampa() {//METODO DI STAMPA DEGLI ELEMENTI DELLA PILA
		System.out.print("[");
		for (int i=0; i<top-1; i++)// si scandisce vettore fino a posizone contenente ultimo elemento ovvero top-1
			System.out.print(Q[i] + ", ");
		if (top > 0) //se la pila contine almeno un elemento
			System.out.print(Q[top-1]);//si stampa ultimo elemento inserito che sar� il primo ad essere estratto con una eventuale pop
		System.out.println("]");
	}
	
	public String toString() {
		String s = "[";
		for (int i=0; i<top-1; i++)
			s = s + Q[i] + ", ";
		if (top > 0)
			s = s + Q[top-1];
		s = s + "]";
		return s;
	}

/*IMPLEMENTAZIONE DI METODI AUSILIARI UTILI PER LA PILA*/

     public boolean isFull(){// METODO CHE CI DICE SE LA PILA � PIENA
	     if (top >= k*b) 
		      return true;
	     else 
		      return false;
}
     public int TopElement(){//restitusce il valore dell'elemento in cima alla pila
	     if(empty())//se la pila � vuota
		      return 0;
	     else
		      return Q=[top-1];

}
      public boolean isReducible(){//ci dice se c'� un numero di poszione libere tali da poter diminuire la dimensione del vettore decrementando k di una unit�
    	  if(top<k*b)
    		  return true;
    	  else
    		  return false;
    	  
      }

}