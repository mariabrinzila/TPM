Punctul A: <br> <br>
  Vom reprezenta oala ca o clasa singleton care contine 2 elemente: numarul total de portii (N, care este specific de utilizator la inceputul programului) si numarul de portii
ramase (pentru a avea posibilitatea de a sti cand oala a ramas goala si cu cate portii trebuie sa o umplem in acest caz, adica cu numarul de portii totale). <br>
  Oamenii din trib vor fi reprezentati de clasa Person, unde fiecare persoana are un anumit index si un nume. Aceasta clasa implementeaza Runnable, adica in aceasta clasa vom 
avea metoda run() in cadrul careia vom realiza procesul de servire al oamenilor din trib (vom servi fiecare thread si, prin variabila booleana done, vom sti daca i-am dat de
mancare omului care este la rand sau nu). Metoda isServed() este apelata in run() si realizeaza procesul de servire, si anume daca numarul de portii ramase in oala este nenul, atunci servim omul care este la rand (numarul de portii ramase scade cu 1), iar daca numarul de portii ramase este 0 (adica oala este goala), atunci omul care este la rand va
trebui sa astepte pana cand oala este plina din nou (resetam numarul de portii ramase cu numarul de portii totale si, dupa aceea, scadem 1 din cele ramase, adica servim omul). <br> 
  Tribul este modelat sub forma unei clase, si anume clasa Tribe, care contine o lista de obiecte de tip Person (adica lista de oameni apartinand tribului efectiv) si oala de unde sunt serviti oamenii tribului. Aceasta clasa extinde clasa Thread deoarece in metoda feedTheTribe(), cream un nou Thread pentru fiecare om din trib si pornim threadul respectiv. <br>
  Pentru ca atunci cand afisam ce oameni din trib sunt serviti si cand oala este goala sa fie in ordine, atunci cand dam start() la fiecare thread, ii vom da si wait, iar in metoda run() dupa ce terminam de servit omul aflat la rand, vom da notify() pentru ca threadul urmator sa astepte ca cel precedent sa termine executia (servirea omului). De asemenea, metodele run() si feedTheTribe() sunt synchronized cu acelasi scop ca mai sus. <br>
  Calculam in variabila time_a timpul de executie al programul si il scriem in fisierul execution.txt.
<br> <br> <br> <br>
