
public class Queue {
	//IMPLEMENTAZIONE DELLA CODA ATTRAVERSO UN ARRAY
		/*DEFINIZIONE:La coda � un struttura dati che segue un sistema FIFO(FIRST IN FIRST OUT) in cui inserimento avviene in cima ed estrazione in testa .
		 L'implemetazione da noi studiata prevede un contenuto di tipo primitivo int degli elementi*/
	private static int b = 5;//dimensione base dell'array
	private int in = 0;//posizione dove inserire elemento
	private int out = 0;//posizione dove estrarre elemento
	private int[] Q;//array contenente elementi
	private int k = 1;//indica il numero di volte in cui si � aumentata la dimensione base dell'array per isufficienza di spazio
	
	
	public Queue() {//costruttore
		Q = new int[b];//crea inizialmente array di dimensione base b
	}
	
	public int size() {//RESTITUISCE IL NUMERO DI ELEMENTI NELLA CODA
		return (in-out);
	}
	
	public void push(int x) {//METODO DI INSERIMENTO IN CIMA DI UN ELEMENTO NELLA CODA
		if (in >= k*b) {//se la coda � piena
			k++;// si incremneta k di una unit� 
			int[] Q1 = new int[k*b];//si crea un nuovo array pi� grande 
			for (int i = 0; i<in-out; i++) //con tale ciclo si scandiscono entrambi i vettori e si copiano elementi da array pi� piccolo Q a quello pi� grande Q1
				Q1[i] = Q[i+out];
			Q = Q1; //dopo copiatura si aggiorna la coda dicendo che � la nuova struttura dati creata 
			in = in-out;// si aggiorna la prima posizione di ingresso dopo copiatura 
			out = 0; // si dice che la posizione di estrazione del nuovo array pi� grande � quella iniziale
		}
		//se array non � pieno o comunque dopo copiatura elementi
		Q[in++] = x;//si inserisce elemento nella prima posizione libera (in+1) del nuovo vettore incrementato 
	}
	
	public boolean empty() {// METODO CHE CI DICE SE LA CODA � VUOTA
		if(in==out)
			return true;
		else
			return false;
	}
	
	public int pop() {//METODO DI ESTRAZIONE DALLA CODA DEL PRIMO ELEMENTO
		if (in == out) {//se la coda � vuota estrazione non effettuabile
			System.out.println("ERRORE: Coda vuota");
			return 0;
		}
		//altrimenti se la coda contiene almeno un elemento
		int x = Q[out];//si salva elemento da estrarre in poszione out
		out++;         //si aggiorna la poszione di estrazione incrementandola di 1
		if (out >= b) {// indica la condizione in cui si sono estratti tutti elementi e la dimensione dell'array � riducibile
			k--;        // si decrementa k di una unit�
			int[] Q1 = new int[k*b]; // si crea un nuovo array pi� piccolo
			for (int i = 0; i<in-out; i++) ////con tale ciclo si copiano elementi dal vettore pi� grande Q a quello nuovo pi� piccolo Q1
				Q1[i] = Q[i+out];
			Q = Q1;//si impone che la nuova struttura dati sia quella del vettore pi� piccolo
			in = in-out;// si aggiorna la prima posizione di ingresso dopo copiatura 
			out = 0;// si dice che la posizione di estrazione del nuovo array pi� piccolo � quella iniziale
		}
		return x; // si restituisce elemento estratta 
	}
	
	public void stampa() {//METODO DI STAMPA DEGLI ELEMENTI DELLA CODA
		if (out < in) {// se la poszione di estrazione � minore di quella dove si pu� inserire allora ci sono elementi da stampare
			System.out.print("[");
			for (int i=out; i<in-1; i++)//si scandisce il vettore dalla posizione di estrazione out fino a quella contenete ultimo elemento ovvero n-1
				System.out.print(Q[i] + ", ");
			System.out.println(Q[in-1] + "]");
		}
	}
	/*IMPLEMENTAZIONE DI METODI AUSILIARI UTILI PER LA CODA*/
	public int FirstElement(){//restitusce il valore dell'elemento in testa alla coda 
	     if(empty())//se la coda � vuota
		      return 0;
	     else
		      return Q=[out];
}
    public void ClearQueue(){//METODO CHE CANCELLA TUTTI GLI ELEMENTI DALLA CODA
    	in=0;
    	out=0;
    	in=out;
    	}
    public boolean isFull(){// METODO CHE CI DICE SE LA CODA � PIENA
	     if (in= k*b)// 
		      return true;
	     else 
		      return false;
}
    

    }