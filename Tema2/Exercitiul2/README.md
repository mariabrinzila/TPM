### Punctul a) 
Nu mai este necesar sa folosim : size.getAndDecrement() deoarece size este de tip atomicInteger si una din proprieatile acestui tip de data este ca poate fi folosita ca si counter pentru mai multe thread-uri in mod concurent . Aceasta va executa operatia data doar daca valoarea din variabila atomicInteger este egala cu o valoare asteptata si va returna False daca aceasta nu este egala (adica daca a fost modificata de un alt thread inaine). Deci , nu este necesara verificarea continutului lui size pentru a face Deq.
<br/> <br/>

### Punctul b) 
Se cunoaste faptul ca nodelock este de tipul ReetrandLock. Tipul ReetrantLock este un tip de semafor specializat , deci acesta se poate folosi in loc de ENQ sau DEQ. Caracterul FIFO al cozii este pastrat daca ReetrantLock-ul este de tip fair , asfel el servind procesul ce a asteptat cel mai mult in coada (adica primul ajuns) , dar exista riscul de a nu se respecta caracterul FIFO daca ReetrantLock-ul este de tip Unfair. Deoarece ReetrantLock-ul este de tip Unfair in mod implicit , si in cod nu se observa ca acesta ar fi de tip Fair , se poate face presupunerea ca acesta este Unfair , deci astfel , caracterul FIFO poate sa nu fie respectat.
<br/> <br/>

### Punctul c)
Daca in loc de utilizarea conditiilor notFullCondition, notEmptyCondition si a flagurilor mustWakeDequers, mustWakeEnqueuers pentru notificarile dintre threaduri, metodele enq si deq vor folosi o operatie de spinning, algoritmul pentru coada nu va mai functiona corect deoarece mustWakeDequeuers nu va mai fi schimbat si, astfel, daca coada este goala, acestia nu vor fi treziti, de unde rezulta posibile erori sau exceptii.
Daca cele 2 abordari ar fi amestecate in modul dat, atunci coada tot nu ar functiona corect deoarece la metoda deq, dupa ce folosim notFullCondition pentru a astepta daca coada este plina, facem si spinning, adica practic facem acelasi lucru de 2 ori in 2 moduri diferite.
<br/> <br/>

### Punctul d)
Verificarea pentru coada nevida din metoda deq() trebuie sa fie neaparat plasata ***in sectiunea protejata prin lock*** deoarece prin definitie un lock se realizeaza inainte de a intra intr-o sectiune critica si de a accesa o resursa partajata si, astfel, tot procesul de scoatere al unui element din queue va fi dupa lock, inclusiv procesul de verificare ca avem ce scoate, adica faptul ca acesta coada nu este vida.
