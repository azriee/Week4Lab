<%-- 
    Document   : editnote
    Created on : Jan 31, 2023, 7:55:07 PM
    Author     : azriee
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit</title>
    </head>
    <body>
        <h1>Simple Note Keeper</h1>
        <h2>View Note</h2>
        <form method="post" action="note">
            <label for="title"><b>Title:</b></label>
            <input type="text" name="title" value="${note.title}" style="width:300px">
            <br>
            <label for="contents"><b>Contents:</b></label>
            <br>
            <textarea name="contents" rows="10" cols="50">${note.contents}</textarea>
            <br>
            <input type="submit" value="Save">
        </form>
    </body>
</html>
