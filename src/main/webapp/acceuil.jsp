<c:import url="header.jsp"></c:import>

<div class="container d-flex flex-wrap">
  
  <table class="table caption-top">
	<caption> Les Joueurs </caption>
<thead>
	<tr>
	<th scope="col">id Joueur</th>
	<th scope="col">Nom Joueur</th>
	<th scope="col">Mail Joueur</th>
	</tr>
</thead>

  <c:forEach items="${listeJoueur}" var="joueur">
<tbody>
	<tr>
	<td><c:out value="${joueur.idPlayer}"></c:out></td>
	<td><c:out value="${joueur.email}"></c:out></td>
	<td><c:out value="${joueur.nickname}"></c:out></td>

	
	</tr>
</tbody>
  </c:forEach> 
 	</table>
 	
 	<table class="table caption-top">
	<caption> Les Jeux </caption>
<thead>
	<tr>
	<th scope="col">id Jeux</th>
	<th scope="col">Nom du Jeux</th>
	<th scope="col">Min Joueur</th>
	<th scope="col">Max Joueur</th>
	</tr>
</thead>

  <c:forEach items="${listeJeux}" var="jeux">
<tbody>
	<tr>
	<td><c:out value="${jeux.idGame}"></c:out></td>
	<td><c:out value="${jeux.title}"></c:out></td>
	<td><c:out value="${jeux.minPlayers}"></c:out></td>
	<td><c:out value="${jeux.maxPlayers}"></c:out></td>
	
	
	</tr>
</tbody>
  </c:forEach> 
 	</table>
 	
 	<table class="table caption-top">
	<caption> Les Match </caption>
<thead>
	<tr>
	<th scope="col">Nom du Jeu</th>
	<th scope="col">Nombre de joueurs enregistrés</th>
	<th scope="col">Date de démarrage</th>
	<th scope="col">Pseudonyme du gagnant du match</th>
	</tr>
</thead>

  <c:forEach items="${listeContest}" var="contest">
<tbody>
	<tr>
	<td><c:out value="${contest.game.title}"></c:out></td>
	<td><c:out value="${contest.game.maxPlayers}"></c:out></td>
	<td><c:out value="${contest.startDate}"></c:out></td>
	<td><c:out value="${contest.joueur.idPlayer}"></c:out></td>

	<td> <a href="Details?idContest=<c:out value='${contest.idContest }'/>" class="btn btn-primary"> Détails </a></td>
	
	
	
	</tr>
</tbody>
  </c:forEach> 
 	</table>
 	
 	</div>