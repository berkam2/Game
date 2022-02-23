<c:import url="header.jsp"/>



<div class ="container">
<form action="<% request.getContextPath(); %> Joueur" method="post" > 
			 <label>Nom du Joueur <span class="color-red">*</span> </label>
             <div class="row margin-bottom-20">
                 <div class="col-md-6 col-md-offset-0">
                     <input class="form-control" type="text" name="joueur">
                 </div>
             </div>
             
             <label>Mail du joueur <span class="color-red">*</span></label>
            <div class="row margin-bottom-20">
                 <div class="col-md-6 col-md-offset-0">
                     <input class="form-control" type="text" name="mail">
                 </div>
             </div>
             
           
               
             <p>
                 <button type="submit" class="btn btn-primary">Ajouter le joueur</button>
             </p>
		</form>
		</div>
</body>
</html>