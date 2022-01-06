  Un punct de liniarizare corespunde statusului ***take effect*** al unui obiect (de exemplu la o operatie de incrementare, un astfel de punct este reprezentat de momentul 
cand se scrie o noua valoare in registru).
<br/> <br/>

### Punctul a)
Punctul de liniarizare corespunzator adaugarii unui element cu succes in lista este ***pred.next = node;*** deoarece in acest moment practic se adauga elementul in lista (practic instructiunea spune faptul ca urmatorul dupa pred va fi acum nodul pe care vrem sa-l inseram si daca nu se ajunge in acest punct, inseamna ca elementul nu a putut fi adaugat, adica s-a intrat pe ***return false;***).
<br/> <br/>

### Punctul b)
Punctul de liniarizare corespunzator esecului la adaugarea unui element in lista este ***return false;*** deoarece un element nu va fi adaugat in cazul in care exista deja in lista si acest esec la adaugare se va realiza atata timp cat lock-ul este tinut (unlock-ul se intampla).

### Punctul c)
Punctul de liniarizare corespunzator stergerii unui element cu succes din lista este ***pred.next = current.next;*** deoarece dupa acest moment practic se sterge elementul in lista (aceasta instructiune practic spune ca urmatorul dupa pred nu va mai fi elementul pe care dorim sa-l stergem, ci urmatorul dupa el si daca nu se ajunge in acest punct, inseamna ca elementul nu a putut fi adaugat, adica s-a intrat pe ***return false;***).
<br/> <br/>

### Punctul d) 
Punctul de liniarizare corespunzator esecului la stergerea unui element din lista este ***return false;*** deoarece un element nu va fi sters in cazul in acesta nu exista in lista (nu avem ce sa stergem) si acest esec la adaugare se va realiza atata timp cat lock-ul este tinut (unlock-ul se intampla).
