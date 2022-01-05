Punctul a)
	Nu mai este necesar sa folosim : size.getAndDecrement() deoarece size este de tip atomicInteger si una din proprieatile acestui tip de data este ca poate fi folosita ca si counter pentru mai multe thread-uri in mod concurent . Aceasta va executa operatia data doar daca valoarea din variabila atomicInteger este egala cu o valoare asteptata si va returna False daca aceasta nu este egala (adica daca a fost modificata de un alt thread inaine). Deci , nu este necesara verificarea continutului lui size pentru a face Deq;


Punctul b)
	e cunoaste faptul ca nodelock este de tipul ReetrandLock. Tipul ReetrantLock este un tip de semafor specializat , deci acesta se poate folosi in loc de ENQ sau DEQ. Caracterul FIFO al cozii este pastrat daca ReetrantLock-ul este de tip fair , asfel el servind procesul ce a asteptat cel mai mult in coada (adica primul ajuns) , dar exista riscul de a nu se respecta caracterul FIFO daca ReetrantLock-ul este de tip Unfair. Deoarece ReetrantLock-ul este de tip Unfair in mod implicit , si in cod nu se observa ca acesta ar fi de tip Fair , se poate face presupunerea ca acesta este Unfair , deci astfel , caracterul FIFO poate sa nu fie respectat.