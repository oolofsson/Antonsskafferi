<%@page import="com.dhtmlx.planner.controls.DHXLocalization"%>
<%@page import="se.miun.dt142g.util.SessionUtils"%>
<%@page import="se.miun.dt142g.dhtmlx.DatabaseConnection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.servlet.http.HttpServletRequest"%>
<%@page import="se.miun.dt142g.dhtmlx.PublishManager"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>   
<html>
    <head>
        <title>Schema</title>
        <script src="<c:url value="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js " />"></script>
        <script src="<c:url value="resources/js/javacalendar.js" />"></script>
        <link type="text/css" rel="stylesheet" href="<c:url value="resources/css/javacalendar.css" />" />
    </head>
    <body>
        <div>
            <div class="planner" id="planner"><%=getPlanner(request) %>
            <%@page import="com.dhtmlx.planner.*,com.dhtmlx.planner.data.*" %>
            <%!
                String getPlanner(HttpServletRequest request) throws Exception {
                DHXPlanner s = new DHXPlanner("./codebase/", DHXSkin.TERRACE);
                s.localizations.set(DHXLocalization.Swedish );
                s.setWidth(900);
                s.setInitialDate(2013, 0, 21); 
                s.load("events.jsp", DHXDataFormat.JSON);
                s.data.dataprocessor.setURL("events.jsp");
                s.config.setReadonly(true);
                return s.render();
            }
            %>
            </div>
            
            <td>Username: </td>
            <td><input id="session" type="text" value="<%= session.getAttribute("username") %>" /></td>
            
            
            
            
            <div id="create_event">
                <form action="SaveEvent" method="post">
                    Text: (String) <input type="text" name="text" /><br />
                    Start datum: (yyyy-mm-dd hh:mm:ss) <input type="text" name="start_date" />
                    Slut datum: (yyyy-mm-dd hh:mm:ss) <input type="text" name="end_date" />
                    Servitris: (int) <input type="text" name="waiter_id" />
                    Färg: (String, hexvärde) <input type=" text" name="color" />
                    <input type="submit" value="Lägg till event" />
                </form>
            </div>
          
            <div id="change_event">
                <%
                    try{
                        ResultSet resultset1 = null;
                        ResultSet resultset2 = null;
                        //Class.forName("com.mysql.jdbc.Driver").newInstance();
                        
                        Connection connection = DatabaseConnection.getConnection();  //DriverManager.getConnection("jdbc:derby://localhost:1527/sample");

                        Statement statement1 = connection.createStatement();
                        Statement statement2 = connection.createStatement();

                        resultset1 = statement1.executeQuery("select * from waiter_event where waiter_id = 2 order by start_date"); //Inloggad waiter
                        resultset2 = statement2.executeQuery("select * from waiter_event where waiter_id != 2 order by start_date"); //Alla som inte är waiter
                %>
                
                <center>
                    <h1>Byt Pass</h1>
                    <h2>Dina pass</h2>
                    <select class="event1_select">
                        <option selected="true" disabled="true" >Välj ett av dina pass...</option>
                        <%  while(resultset1.next()){ %>
                        <option value="<%= resultset1.getString(1) + "." + resultset1.getString(5) %>" >
                            <%= "Tid: " + resultset1.getString(3) %>
                        </option>
                        <% } %>
                    </select>
                </center>
                <center>
                    <h2>Andra pass</h2>
                    <select class="event2_select">
                        <option selected="true" disabled="true" >Välj ett pass att byta mot...</option>
                        <% while(resultset2.next()){ %>
                        <option value="<%= resultset2.getString(1) + "." + resultset2.getString(5) %>">
                            <%= "Med: " + resultset2.getString(2) + ". Tid: " + resultset2.getString(3) %>
                        </option>
                        <% } %>
                    </select>
                </center>
                <form action="ChangeRequest" method="post">
                    <input class="sender_id_input" type="text" name="sender_id" />
                    <input class="event1_id_input" type="text" name="event1" />
                    <input class="event2_id_input" type="text" name="event2" />
                    <input class="receiver_id_input" type="text" name="receiver_id" />
                    <input type="submit" value="Skicka förfrågan" />
                </form>
                    
                <%

                    }
                    catch(Exception e)
                    {
                         out.println("wrong entry"+e);
                    }
                %>
                
            </div>
            
            
            
                
                
            <div style="clear: both" ></div>
        </div>     
    </body>
</html>
