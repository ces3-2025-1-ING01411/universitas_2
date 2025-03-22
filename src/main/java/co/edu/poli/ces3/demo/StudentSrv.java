package co.edu.poli.ces3.demo;

import co.edu.poli.ces3.demo.dao.Student;
import co.edu.poli.ces3.demo.utils.RandomBigIntegerGenerator;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.*;
import java.util.*;

@WebServlet(name = "studentServlet", value = "/student")
public class StudentSrv extends HttpServlet {

    private Vector<Integer> numbers;

    private ArrayList<Student> students;

    private static final int LENGTH_ID_STUDENT = 10;

    public void init() throws ServletException {
        System.out.println("Init StudentServlet!!!!");

        this.numbers = new Vector();
        this.students = new ArrayList();

        for (int i = 0; i < 500; i++) {
            //numbers[i] = random.nextInt(15) + 1;
            numbers.add((int)(Math.random() * 10));
        }

        Student d1 = new Student(
                "Yuri",
                "Monroy",
                new Date(),
                "bangtan@gmail.com",
                5,
                true
        );
        d1.setId(Math.abs(RandomBigIntegerGenerator.generateUniqueBigInteger(LENGTH_ID_STUDENT).intValue()));
        this.students.add(d1);

        this.students.add(new Student(
                Math.abs(RandomBigIntegerGenerator.generateUniqueBigInteger(LENGTH_ID_STUDENT).intValue()),
                "Yen",
                "Vargas",
                new Date(75, 8, 28),
                "yen12@gmail.com",
                9,
                true
        ));
        this.students.add(new Student(
                Math.abs(RandomBigIntegerGenerator.generateUniqueBigInteger(LENGTH_ID_STUDENT).intValue()),
                "Stefany",
                "Bautista",
                new Date(11, 3, 24),
                "stefa45an@gmail.com",
                5,
                true
        ));

        super.init();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json");

        response.setStatus(HttpServletResponse.SC_CREATED);
        PrintWriter out = response.getWriter();

        Collections.sort(numbers);

        Gson gson = new Gson();

        //if (idStudent == null) {
        System.out.println("id: " + request.getParameter("id"));
        if (request.getParameter("id") == null) {
            out.println(gson.toJson(students));
        } else {
            //obtener parametros que se envian en la petición -> viene en request
            Integer idStudent = Integer.parseInt(request.getParameter("id"));
            Student findStudent = null;
            for (Student x: students) {
                if (x.getId().equals(idStudent)) {
                    findStudent = x;
                    break;
                }
            }
            out.println(gson.toJson(findStudent));
        }
        out.flush();
    }


    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException , ServletException{
        //super.doPost(req, resp);

        JsonObject studentJson = this.getParamsFromBody(req);

        Student student = new Student();

        student.setId(Math.abs(RandomBigIntegerGenerator.generateUniqueBigInteger(LENGTH_ID_STUDENT).intValue()));
        student.setName(studentJson.get("name").getAsString());
        student.setLastName(studentJson.get("lastName").getAsString());
        student.setBirthDay(new Date(studentJson.get("birthDay").getAsString()));
        student.setMail(studentJson.get("mail").getAsString());
        student.setLevel(studentJson.get("level").getAsInt());
        student.setIsMarried(studentJson.get("isMarried").getAsBoolean());

        this.students.add(student);

        resp.setContentType("application/json");

        PrintWriter out = resp.getWriter();
        Gson gson = new Gson();
        out.println(gson.toJson(student));
        out.flush();
    }

    private JsonObject getParamsFromBody(HttpServletRequest request) throws IOException {
        //parseo de lo que nos llega en el body para que podamos manejarlo con java
        BufferedReader reader = request.getReader();
        StringBuilder sb = new StringBuilder();
        String line = reader.readLine();
        while (line != null) {
            sb.append(line + "\n");
            line = reader.readLine();
        }
        reader.close();
        return JsonParser.parseString(sb.toString()).getAsJsonObject();
    }

    public void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");

        //buscar id
        //obtener body
        //actualizar datos
        //retornar datos actualizados
    }

    //hacer patch

    //hacer delete

    public void destroy() {
    }
}