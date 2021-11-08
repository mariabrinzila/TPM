A)Linearibilizitate
![alt text](https://github.com/mariabrinzila/TPM/blob/main/Tema1/Exercitiul%201/Linearizable.png?raw=true)

Secventa istoriei de executie : 
R.WRITE(1)(B) -> r=1;
R.READ(1)(A)  ->Succesfull
R.READ(1)(C)  ->Succesfull
R.WRITE(2)(C) -> r=2;
R.READ(2)(B)  ->Succesfull
R.READ(2)(B)  ->Succesfull
R.READ(1)(A)  ->Error

Secventa de executie este corecta pana ce se ajunge la executia thread-ului A a doua oara (R.READ(1)) unde acesta va arunca o eroare , deoarece in r se afla scrisa valoarea 2 nu 1 , asfelt , istoria / secventa de mai sus nu este linearizabilia;

B)Consistenta Secventiala 

![alt text](https://github.com/mariabrinzila/TPM/blob/main/Tema1/Exercitiul%201/Consistenta%20Secventiala.png?raw=true)
