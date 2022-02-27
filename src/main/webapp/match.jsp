<c:import url="header.jsp"></c:import>

<div class="container">

<h1><c:out value="${playerContest.game.title }"/></h1>

<h3><c:out value="${playerContest.startDate }"/></h3>



<table class="table caption-top">
	<caption> Les joueurs du match</caption>
<thead>
	<tr>
	<th scope="col">idJoueur</th>
	<th scope="col">Pseudonyme Joueur</th>
	<th scope="col">Email Joueur</th>
	
	</tr>
</thead>

  <c:forEach items="${listeJoueur}" var="joueur">
<tbody>
	<tr>
	<td><c:out value="${joueur.player.idPlayer}"></c:out></td>
	<td><c:out value="${joueur.player.nickname}"></c:out></td>
	<td><c:out value="${joueur.player.email}"></c:out></td>
	

	<td> <a href="Delete?idPlayerContest=<c:out value='${joueur.idPlayerContest }'/>" class="btn btn-primary"> Supprimer </a></td>
	</tr>
</tbody>
  </c:forEach> 
 	</table>
 	
 	
 	<c:if test="${nContest==playerContest.game.maxPlayers }">
 	Vous avez atteint le nombre joueur maximum
 	</c:if>
 	<c:if test="${nContest>playerContest.game.maxPlayers }">
 	Vous devez diminuer le nombre de joueur, le nombre de joueur est trop important
 	</c:if>
 	<c:if test="${nContest<playerContest.game.minPlayers }">
 	Vous ne disposez pas de suffisament de joueur pour lancer la partie
 	</c:if>
 	
 	<form action="<% request.getContextPath(); %> Details" method="post" > 
			 
                     <input type="hidden" value="${playerContest.idContest }" name="playerContest">
                
             
             <label>Joueur <span class="color-red">*</span></label>
            <div class="row margin-bottom-20">
                 <select name="newPlayer">
             <c:forEach items="${playerBanc}" var="joueur">
                     <option value="<c:out value="${joueur.idPlayer}" />"> <c:out value="${joueur.nickname }"/></option>
                     </c:forEach>
                </select>
             </div>
               
             <p>
                 <button type="submit" class="btn btn-primary">Ajouter le Joueur à la partie</button>
             </p>
		</form>
 	
 	
 	<form action="<% request.getContextPath(); %> Vainqueur" method="post" > 
			 
                     <input type="hidden" name="contest" value="${contest.idContest}">
                
             
             <label>Joueur <span class="color-red">*</span></label>
            <div class="row margin-bottom-20">
                <select name="gagnant">
             <c:forEach items="${listeJoueur}" var="joueur">
                     <option value="<c:out value="${joueur.player.idPlayer}" />"> <c:out value="${joueur.player.nickname }"/></option>
                     </c:forEach>
                </select>
             </div>
               
             <p>
                 <button type="submit" class="btn btn-primary">Déclarer le vainqueur</button>
             </p>
		</form>
 	
</div>