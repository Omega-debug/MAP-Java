# MAP-Java

1) Proiect Auto - O aplicatie Java cu interfata grafica care administreaza o retea de masini inchiriate stocata intr-o baza de date si care ofera diverse functionalitati precum masinile inchiriate pentru cel mai mult timp, etc.




2) Proiect Radio - Este o aplicatie Java cu interfata grafica implementata in JavaFX pentru administrarea pieselor muzicale redate la un post radio. Fiecare piesa are un ID unic, o formatie, un titlu, un gen muzical si o durata (format: minute:secunde, exemplu: 03:45 )
   Piesele sunt stocate intr-o baza de date care este accesata prin JDBC

Un exemplu de piesa este: id:100, formatie: Coldplay, titlu: A Head Full of Dreams, gen Muzical: Alternative, durata: 03:43 

Aplicatia furnizeaza urmatoarele functionalitati:
1. La pornirea aplicatiei, lista de piese va fi incarcata din baza de date. Baza de date contine informatii pentru minim 5 piese. Piesele vor fi afisate intr-o lista din fereastra interfetei grafice, ordonate crescator, dupa valoarea campului formatie. Piesele aceleasi formatii vor fi sortate dupa titlu.
2. Filtrarea listei de piese. Utilizatorul va introduce textul dorit intr-o casuta editabila, iar aplicatia va filtra piesele afisate in interfata grafica astfel ca textul introdus sa se regaseasca in cel putin unul din campurile piesei. De exemplu pentru piesa de mai sus, textul "03:" precum si "full" vor duce la afisarea ei (cautarea se face ignorand diferenta dintre litere mici/mari). Utilizatorul are la dispozitie un buton de Resetare care atunci cand este apasat va goli casutele editabile de cautare si va arata din nou toate piesele. 



3) Proiect Quizz - Este o aplicatie Java cu interfata grafica implementata in JavaFX pentru administrarea unor teste grila cu raspunsuri multiple. Fiecare intrebare are un id unic, un text, trei raspunsuri posibile(sub forma de text), un raspuns corect si un punctaj asociat.

Un exemplu de intrebare este: Din ce fel de nuca se pregateste martipanul? RaspunsA:alune, RaspunsB:migdale, RaspunsC:caju, RaspunsCorect: migdale, punctaj: 5

Aplicatia furnizeaza urmatoarele functionalitati:
1) La pornirea aplicatiei, lista de intrebari este incarcata din baza de date. Intrebarile vor fi afisate intr-o lista din fereastra interfatei grafice, ordonate crescator dupa valoarea campului id. Pentru fiecare intrebare se afiseaza doar id-ul, textul si punctajul.
2) Adaugarea unui intrebari si semnalarea printr-o alerta in cazul in care unul dintre campuri este necompletat

