<c:import url="header.jsp"/>



<div class ="container">
<form action="<% request.getContextPath(); %> Jeux" method="post" > 
			 <label>Nom du Jeu <span class="color-red">*</span> </label>
             <div class="row margin-bottom-20">
                 <div class="col-md-6 col-md-offset-0">
                     <input class="form-control" type="text" name="jeux">
                 </div>
             </div>
             
             <label>Nombre de joueur min <span class="color-red">*</span></label>
            <div class="row margin-bottom-20">
                 <div class="col-md-6 col-md-offset-0">
                     <input class="form-control" type="text" name="minPlayer">
                 </div>
             </div>
             
             <label>Nombre de joueur max <span class="color-red">*</span></label>
            <div class="row margin-bottom-20">
                 <div class="col-md-6 col-md-offset-0">
                     <input class="form-control" type="text" name="maxPlayer">
                 </div>
             </div>
           
               
             <p>
                 <button type="submit" class="btn btn-primary">Ajouter le jeu</button>
             </p>
		</form>
		</div>
</body>
</html>