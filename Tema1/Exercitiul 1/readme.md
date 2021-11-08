A)Linearibilizitate <br />
Secventa istoriei de executie : <br />
R.WRITE(1)(B) -> r=1; <br />
R.READ(1)(C)  ->Succesfull <br />
R.READ(1)(A)  ->Succesfull <br />
R.WRITE(2)(C) -> r=2; <br />
R.READ(2)(B)  ->Succesfull <br />
R.READ(2)(B)  ->Succesfull <br />
R.READ(1)(A)  ->Error <br />

Secventa de executie este corecta pana ce se ajunge la executia thread-ului A a doua oara (R.READ(1)) unde acesta va arunca o eroare , deoarece in r se afla scrisa valoarea 2 nu 1 , asfelt , istoria / secventa de mai sus NU ESTE linearizabilia; <br />
![alt text](https://github.com/mariabrinzila/TPM/blob/main/Tema1/Exercitiul%201/Linearizable.png?raw=true) 
<br />

B)Consistenta Secventiala  <br />
Secventa istoriei de executie :  <br />
R.WRITE(1)(B) -> r=1; <br />
R.READ(1)(A)  ->Succesfull <br />
R.READ(1)(C)  ->Succesfull <br /> 
R.READ(1)(A)  ->Succesfull <br />
R.WRITE(2)(C) -> r=2; <br />
R.READ(2)(B)  ->Succesfull <br />
R.READ(2)(B)  ->Succesfull  <br />

Se muta a doua casuta R.READ(1) din Threadul A cu o casuta mai la stanga si astfel secventa de executie este corecta pe toata perioada de executie.  <br />
Astfel, istoria / secventa de mai jos ESTE consistenta secvential; <br />
![alt text](https://github.com/mariabrinzila/TPM/blob/main/Tema1/Exercitiul%201/Consistenta%20Secventiala.png?raw=true) <br />
