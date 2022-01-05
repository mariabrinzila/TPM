  Un punct de liniarizare corespunde statusului "take effect" al unui obiect (de exemplu la o operatie de incrementare, un astfel de punct este reprezentat de momentul 
cand se scrie o noua valoare in registru).

### Punctul a)
Punctul de liniarizare corespunzator adaugarii unui element cu succes in lista este ***lock.unlock();*** deoarece dupa ce se face unlock, practic se adauga elementul in lista
(daca nu se face unlock, atunci inseamna ca pe parcursul incercarii de a adauga elementul, a aparut o eroare si nu s-a ajuns in blocul finally).
<br/>

### Punctul c)
Punctul de liniarizare corespunzator stergerii unui element cu succes din lista este lock.unlock(); deoarece dupa ce se face unlock, practic se sterge elementul in lista 
(daca nu se face unlock, atunci inseamna ca pe parcursul incercarii de a sterge elementul, a aparut o eroare si nu s-a ajuns in blocul finally).
<br/>
