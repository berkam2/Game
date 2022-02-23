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
	<td><c:out value="${action.idActionnariat}"></c:out></td>
	<td><c:out value="${action.utilisateur.idUser}"></c:out></td>
	<td><c:out value="${action.utilisateur.nom}"></c:out></td>

	<td> <a href="Edit?idActionnariat=<c:out value='${action.idActionnariat }'/>" class="btn btn-primary"> Modifier </a></td>
	<td> <a href="Delete?idActionnariat=<c:out value='${action.idActionnariat }'/>" class="btn btn-primary"> Supprimer </a></td>
	
	
	</tr>
</tbody>
  </c:forEach> 
 	</table>
 	
 	</div>