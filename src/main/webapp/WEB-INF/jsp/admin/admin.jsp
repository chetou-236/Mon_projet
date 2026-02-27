<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>Administration</title>
</head>
<body>

<c:import url="/WEB-INF/jsp/welcome.jsp"/>

<div class="container mt-4">

    <div class="row">

        <!-- 🔹 COLONNE GAUCHE : LISTE DES COMPTES -->
        <div class="col-md-6 col-sm-12">
            <div class="card">
                <div class="card-header">
                    Liste des comptes
                </div>
                <div class="card-body">
                    <table class="table table-striped">
                        <thead>
                        <tr>
                            <th>Email</th>
                            <th>Mot de passe</th>
                            <th colspan="2">Actions</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${accountDtoList}" var="account">
                            <tr>
                                <td>${account.username}</td>
                                <td>${account.password}</td>
                                <td><a href="#">Éditer</a></td>
                                <td><a href="#">Supprimer</a></td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>

        <!-- 🔹 COLONNE DROITE : AJOUT DE COMPTE -->
        <div class="col-md-6 col-sm-12">
            <div class="card">
                <div class="card-header">
                    Ajout de compte
                </div>
                <div class="card-body">
                    <form>
                        <div class="form-group">
                            <label for="email">Email</label>
                            <input class="form-control" id="email" name="email">
                        </div>

                        <div class="form-group">
                            <label for="pwd">Mot de passe</label>
                            <input class="form-control" id="pwd" name="pwd">
                        </div>

                        <div>
                            <input type="submit" class="btn btn-success" name="valider" value="valider">
                            <input type="reset" class="btn btn-danger" name="annuler" value="annuler" style="float: right">
                        </div>
                    </form>
                </div>
            </div>
        </div>

    </div>
</div>

</body>
</html>
