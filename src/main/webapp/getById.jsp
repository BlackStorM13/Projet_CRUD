<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Information Client</title>
</head>
<body>
<h1>Informations du client par son ID</h1>
id : ${param.id}
<p>id = ${client.id}</p>
<p>nom = ${client.nom}</p>
<p>prenom = ${client.prenom}</p>
<p>email = ${client.email}</p>
<p>tel = ${client.tel}</p>
</body>
</html>
