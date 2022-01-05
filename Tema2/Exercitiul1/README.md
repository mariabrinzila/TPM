  Un punct de liniarizare corespunde statusului ***take effect*** al unui obiect (de exemplu la o operatie de incrementare, un astfel de punct este reprezentat de momentul 
cand se scrie o noua valoare in registru).
<br/> <br/>

### Punctul a)
Punctul de liniarizare corespunzator adaugarii unui element cu succes in lista este ***lock.unlock();*** deoarece dupa ce se face unlock, practic se adauga elementul in lista
(daca nu se face unlock, atunci inseamna ca pe parcursul incercarii de a adauga elementul, a aparut o eroare si nu s-a ajuns in blocul finally).
<br/> <br/>

### Punctul b)
Punctul de liniarizare corespunzator esecului la adaugarea unui element in lista este ***return false;*** deoarece un element nu va fi adaugat in cazul in care exista deja in lista si acest esec la adaugare se va realiza atata timp cat lock-ul este tinut (unlock-ul se intampla).

### Punctul c)
Punctul de liniarizare corespunzator stergerii unui element cu succes din lista este ***lock.unlock();*** deoarece dupa ce se face unlock, practic se sterge elementul in lista 
(daca nu se face unlock, atunci inseamna ca pe parcursul incercarii de a sterge elementul, a aparut o eroare si nu s-a ajuns in blocul finally).
<br/> <br/>

### Punctul d) 
Punctul de liniarizare corespunzator esecului la stergerea unui element din lista este ***return false;*** deoarece un element nu va fi sters in cazul in acesta nu exista in lista (nu avem ce sa stergem) si acest esec la adaugare se va realiza atata timp cat lock-ul este tinut (unlock-ul se intampla).
