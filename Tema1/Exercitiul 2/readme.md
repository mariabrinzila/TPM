A)<br />


B)<br />
Secventa de executie a cozii FIFO:<br />
Se verifica valoarea maxima din labels, aceasta fiind 3;<br />
Se cauta cea mai mica valoare din labels , aceasta fiind 0, pe pozitia 1 si 2;<br />
Se alege pozitia cu indicele cel mai mic;<br />
Asfel se executa casuta ce contine 0 , de pe prima pozite , ulterior casuta ce contine 0 de pe pozitia 2<br />
Ulterior se verifica iarasi care e cea mai mica valoare in label , aceasta fiind 1, pe pozitia 3 si 7<br />
Analog ca anterior , se executa prima data casuta cu 1 de pe pozitia 3 si ulterior cea de pe pozitia 7<br />
Se verifica urmatorul label ce contine cea mai mica valoare ,aceasta fiind 2 , pe pozitiile 4 si 6<br />
Se executa casuta ce contine 2 de pe pozita 4 si ulterior cea de pe pozitia 6<br />
Se constata ca valoarea maxima din label coincide cu valoarea aleasa initia , astfel se executa casuta cu valoarea 3 de pe pozitia 5<br />

Importanta compararii indicelui nu doar a label-ului:<br />
Daca valoarea din label este egala , si s-ar face doar verificarea valorii din label , atunci proprietatea de FIRST COME FIRST SERVED  nu ar mai fi respectata , nestiind care din cele 2 thred-uri cu valori identice in label a fost primul sosit ,si astfel putand sa se aleaga thread-ul ce a ajuns ultimul;<br />
Compararea se face atunci cand valoarea din label este egala ,pentru a decide care din cele 2 thread-uri este primul sosit;<br /><br />
![alt text](https://github.com/mariabrinzila/TPM/blob/main/Tema1/Exercitiul%202/Consistenta%20Secventiala.png?raw=true) 
C)<br />
In mod obisnuit, in utilizarea unui lock se prefera ca apelul lock() sa fie executat inainte de blocul try deoarece daca acest apel ar fi in interiorul blocului try, exista posibilitatea sa apara o exceptie care sa conduca la apelul lui unlock(), ceea ce ar fi incorect dat fiind faptul ca lock() practic nu s-a facut si, astfel, incercarea de a face unlock() in acest caz ar cauza aparitia unei alte exceptii.<br />
![alt text](https://github.com/mariabrinzila/TPM/blob/main/Tema1/Exercitiul%202/Exercitiul2c.png?raw=true) 
