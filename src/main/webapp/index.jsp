<%@ page import="java.util.Date"%>
<html>
<head>
<title>Hello IPR</title>
</head>
<body>
	<h1>Page de d�mo</h1>

	<p>Cette page est g�n�r�e par la jsp : src/main/webapp/index.jsp</p>

	<p>Vous trouverez d'autres exemples ici :
	<ul>
		<li><a href="hello?nom=Georgette">Servlet simple
				/pr.tp.web/src/main/java/pr/tp/web/example/HelloServlet.java</a></li>
		<li><a href="params">Servlet
				/pr.tp.web/src/main/java/pr/tp/web/example/ServletAvecParam.java</a> qui
			d�montre la lecture de param�tres du fichier web.xml dans la console
			(cette servlet redirige sur la page /index.jsp)</li>
	</ul>

	<p>Vous �tes libre de modifier ces pages ou de les effacer si vous
		le souhaitez. M�me chose pour le fichier web.xml</p>

	<h2>Hello World!</h2>
	<p>
		Il est
		<%=new Date()%>
	</p>

<pre>

La balise pre

permet de conserver les retours � la ligne.

</pre>

</body>
</html>
