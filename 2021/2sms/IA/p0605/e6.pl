arco(a,b).
arco(b,a).
arco(a,c).
arco(c,a).
arco(a,d).
arco(d,a).
arco(a,e).
arco(e,a).
arco(a,f).
arco(f,a).
arco(f,e).
arco(e,f).
arco(e,c).
arco(c,e).
arco(c,d).
arco(d,c).
arco(b,c).
arco(c,b).

-- Exercicio 6a)
remove([X|R],X,R).
remove([Y|R],X,[Y,Rf]):-remove(R,X,Rf).

camHam([F],F,F):-!.
camHam(Verts,I,F):- arco(I,N),
remove(Verts,I,VertsI),
camHam(VertsI,N,F).

--6b)
remove([X|R],X,R).
remove([Y|R],X,[Y,Rf]):-remove(R,X,Rf).

camHam([F],F,F,[F]):-!.
camHam(Verts,I,F,[I|RPath]):-
  arco(I,N),
  remove(Verts,I,VertsI),
	camHam(VertsI,N,F,RPath).

-- ou
camHam([F],F,F,[F]):-!.
camHam(Verts,I,F,[I|RPath]):-
    remove(Verts,I,VertsI),
    remove(VertsI,N,_),
    arco(I,N),
	remove(Verts,I,VertsI),
	camHam(VertsI,N,F,RPath).
