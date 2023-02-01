
package servlets;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Note;

/**
 *
 * @author azriee
 */
public class NoteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String edit = request.getParameter("edit");
        
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        BufferedReader br;
        br = new BufferedReader(new FileReader(new File(path)));
        Note note = new Note();
        note.setTitle(br.readLine());
        String line = br.readLine();
        while(line != null){
             note.setContents(note.getContents()+line+"<br>");
             line = br.readLine();
        }
       
        br.close();
        request.setAttribute("note", note);
        
        if (edit != null){
            note.setContents(note.getContents().replace("<br>", "\n"));
            getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp").forward(request, response);
            return;
        }
        getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Note note = new Note(request.getParameter("title"),request.getParameter("contents"));
        
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        PrintWriter pw; 
        pw = new PrintWriter(new BufferedWriter(new FileWriter(path, false)));
        pw.println(note.getTitle());
        pw.print(note.getContents());
        pw.close();
        
        note.setContents(note.getContents().replace("\n", "<br>"));
        
        request.setAttribute("note", note);
        getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);
    }
}
