<%-- 
    Document   : viewnote
    Created on : Jan 31, 2023, 7:54:29 PM
    Author     : azriee
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Simple Note Keeper</title>
    </head>
    <body>
        <h1>Simple Note Keeper</h1>
        <h2>View Note</h2>
        <p><b>Title: </b>${note.title}</p>
        <p><b>Contents: </b><br>${note.contents}</p>
        <a href="note?edit">Edit</a>
    </body>
</html>
