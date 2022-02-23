<c:import url="header.jsp"/>



<div class ="container">
<form action="<% request.getContextPath(); %> Contest" method="post" > 
			 <label>Nom du Jeu <span class="color-red">*</span> </label>
             <div class="row margin-bottom-20">
                <select name="jeux" class="form-control">
                
                <c:forEach items="${games}" var="game">
                <option value="<c:out value="${game.idGame}"/>"> <c:out value="${game.title}"/></option>
                </c:forEach>
                
                </select>
             </div>
             
             <label>Date du jeu <span class="color-red">*</span></label>
            <div class="row margin-bottom-20">
                 <div class="col-md-6 col-md-offset-0">
                     <input class="form-control" type="date" name="dateJeu">
                 </div>
             </div>
             
             <label>Nom du gagnant <span class="color-red">*</span></label>
            <div class="row margin-bottom-20">
                  <select name="gagnant" class="form-control">
                
                <c:forEach items="${joueurs}" var="joueur">
                <option value="<c:out value="${joueur.idPlayer}"/>"> <c:out value="${joueur.nickname}"/></option>
                </c:forEach>
                
                </select>
             </div>
           
               
             <p>
                 <button type="submit" class="btn btn-primary">Ajouter le Match</button>
             </p>
		</form>
		</div>
</body>
</html>