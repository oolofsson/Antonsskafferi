<%@page import="se.miun.dt142g.dhtmlx.event.ChangedEvent"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="se.miun.dt142g.dhtmlx.ChangedEventLog"%>
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
        <meta charset="UTF-8">
        <title>Schema</title>
        <script src="<c:url value="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js " />"></script>
        <script src="<c:url value="resources/js/javacalendar.js" />"></script>
        <script src="<c:url value="https://code.jquery.com/ui/1.12.1/jquery-ui.js" />" ></script>
        <link type="text/css" rel="stylesheet" href="<c:url value="resources/css/normalize.css" />" />
        <link type="text/css" rel="stylesheet" href="<c:url value="resources/css/datepicker.css" />" />
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
                s.setInitialDate(2016, 9, 10); 
                s.load("events.jsp", DHXDataFormat.JSON);
                s.data.dataprocessor.setURL("events.jsp");
                s.config.setFirstHour(9);
                s.config.setLastHour(23);
                s.config.setReadonly(true);
                return s.render();
            }
            %>
            </div>
            <div id="user_info">
                <%
                    Connection conn = DatabaseConnection.getConnection();  //DriverManager.getConnection("jdbc:derby://localhost:1527/sample");
                    if(session.getAttribute("username").toString().length() < 4){

                        //Print out username
                        ResultSet waiters = null;


                        Statement waiterstatement = conn.createStatement();

                        waiters = waiterstatement.executeQuery("SELECT waitername FROM waiter WHERE waiterid = " + session.getAttribute("username").toString()); 
                        while(waiters.next())
                            out.print("<p>Välkommen till ditt schema " + waiters.getString(1) + "</p>");

                %>
            </div>
           
          
            <div id="change_event">
                <%
                    try{
                        ResultSet yourEvents = null;
                        ResultSet otherEvents = null;
                        //Class.forName("com.mysql.jdbc.Driver").newInstance();
                        
                        //Connection conn = DatabaseConnection.getConnection();  //DriverManager.getConnection("jdbc:derby://localhost:1527/sample");

                        Statement statementYourEvents = conn.createStatement();
                        Statement statementOtherEvents = conn.createStatement();

                        String queryYourEvents = "select * from waiter_event where waiter_id = " + session.getAttribute("username").toString() + " order by start_date";
                        String queryOtherEvents = "select * from waiter_event where waiter_id != " + session.getAttribute("username").toString() + " order by start_date";
                        
                        yourEvents = statementYourEvents.executeQuery(queryYourEvents); //Inloggad waiter
                        otherEvents = statementOtherEvents.executeQuery(queryOtherEvents); //Alla som inte är waiter
                %>
                
                <center>
                    <h1>Byt Pass</h1>
                    <h2>Dina pass</h2>
                    <select class="event1_select">
                        <option selected="true" disabled="true" >Välj ett av dina pass...</option>
                        <%  while(yourEvents.next()){ %>
                        <option value="<%= yourEvents.getString(1) + "." + yourEvents.getString(5) %>" >
                            <%= "Tid: " + yourEvents.getString(3) %>
                        </option>
                        <% } %>
                    </select>
                </center>
                <center>
                    <h2>Andra pass</h2>
                    <select class="event2_select">
                        <option selected="true" disabled="true" >Välj ett pass att byta mot...</option>
                        <% while(otherEvents.next()){ %>
                        <option value="<%= otherEvents.getString(1) + "." + otherEvents.getString(5) %>">
                            <%= "Med: " + otherEvents.getString(2) + ". Tid: " + otherEvents.getString(3) %>
                        </option>
                        <% } %>
                    </select>
                </center>
                <form action="ChangeRequest" method="post">
                    <input class="sender_id_input" required="true" type="text" name="sender_id" />
                    <input class="event1_id_input" required="true" type="text" name="event1" />
                    <input class="event2_id_input" required="true" type="text" name="event2" />
                    <input class="receiver_id_input" required="true" type="text" name="receiver_id" />
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
            
            <% //Display change requests
                    ResultSet waiterEvents = null;
                    Statement statementWaiterEvents = conn.createStatement();
                    waiterEvents = statementWaiterEvents.executeQuery("SELECT * FROM waiter_event");

                    ResultSet changeRequests = null;

                    Statement statementChangeRequests = conn.createStatement();

                    changeRequests = statementChangeRequests.executeQuery("SELECT * FROM change_request"); 
                    while(changeRequests.next()){
                        if(changeRequests.getString(5).equals(session.getAttribute("username").toString())){
                            String from = "";
                            String fromTime = "";
                            String toTime = "";
                            while(waiterEvents.next()){
                                if(changeRequests.getString(3).equals(waiterEvents.getString(1))){
                                    from = waiterEvents.getString(2);
                                    fromTime = waiterEvents.getString(3);
                                }else if(changeRequests.getString(4).equals(waiterEvents.getString(1))){
                                    toTime = waiterEvents.getString(3);
                                }
                            }

                            out.print("<div class=\"get_change_requests\">"); //Hämta mer info. Personer, tider mm.
                            out.print("<h3>Du har byte</h3>");
                            out.print(from + " vill byta sitt pass den: " + fromTime + ", mot ditt pass den: " + toTime + ".");
                            out.print("<form class=\"change_form\" action=\"ChangeEvent\" method=\"POST\" >");
                            out.print("<input class=\"get_change_request_input\" type=\"text\" name=\"id\" value=\""
                                    + changeRequests.getString(1) + "\" />");
                            out.print("<input class=\"get_change_request_input\" type=\"text\" name=\"sender_id\" value=\""
                                    + changeRequests.getString(2) + "\" />");
                            out.print("<input class=\"get_change_request_input\" type=\"text\" name=\"event1\" value=\""
                                    + changeRequests.getString(3) + "\" />");
                            out.print("<input class=\"get_change_request_input\" type=\"text\" name=\"event2\" value=\""
                                    + changeRequests.getString(4) + "\" />");
                            out.print("<input class=\"get_change_request_input\" type=\"text\" name=\"receiver_id\" value=\""
                                    + changeRequests.getString(5) + "\" />");
                            out.print("<input type=\"submit\" value=\"Acceptera\" />");
                            
                            out.print("</form>");
                            out.print("<form class=\"change_form\" action=\"DeleteRequest\" method=\"POST\" >");
                            out.print("<input class=\"get_change_request_input\" type=\"text\" name=\"id\" value=\""
                                    + changeRequests.getString(1) + "\" />");
                            out.print("<input type=\"submit\" value=\"Avböj\" />");
                            out.print("</form>");
                            
                            out.print("</div>");
                        }
                    }
                    conn.close();
                } //End of username.lenght < 4, waiter view
            %>
            
            <%
                if(session.getAttribute("username").toString().length() > 4){
                    ResultSet waiters = null;


                    Statement waiterstatement = conn.createStatement();

                    waiters = waiterstatement.executeQuery("SELECT * FROM waiter"); 
                    
            %>
            
            <div id="create_event">
                <h2>Skapa ett nytt pass</h2>
                <center>
                    <select class="waiter_select">
                        <option selected="true" disabled="true" >Välj sevitris...</option>
                        <% while(waiters.next()){ %>
                        <option value="<%= waiters.getString(1) + "." + waiters.getString(2) %>">
                            <%= waiters.getString(2) %>
                        </option>
                        <% } %>
                    </select>
                    
                    <div id="datepicker"></div>
                    
                    <select class="event_time_select">
                        <option selected="true" disabled="true" >Välj tid...</option>
                        <option value="11:00:00.15:00:00">Lunchpass</option>
                        <option value="17:00:00.22:00:00">Middagspass</option>
                    </select>
                </center>

                <form action="SaveEvent" method="post">
                    <input class="event_text_input" required="true" type="text" name="text" /><br />
                    <input class="event_start_date_input" required="true" type="text" name="start_date" />
                    <input class="event_end_date_input" required="true" type="text" name="end_date" />
                    <input class="waiter_id_input" required="true" type="text" name="waiter_id" />
                    <input class="color_input" required="true" type=" text" name="color" />
                    
                    <input class="event_submit" type="submit" value="Lägg till pass" />
                </form>

            </div>
            <div id="change_event_log">        
            <%
                    //Changelogen
                    List changedEvents = ChangedEventLog.getChangedEvents();
                        if(!changedEvents.isEmpty()){
                            out.print("<h2>Följande arbetspassbyten har gjorts</h2>");
                        }
                        out.print("<ul>");
                        for(Iterator<ChangedEvent> i = changedEvents.iterator(); i.hasNext(); ) { //Increment all earlier changedevents id
                            ChangedEvent ch = i.next();
                            out.print("<li>" + ch.getMessage() + "</li>");
                            
                        }
                        out.print("</ul>");
            %>    
            </div>
            <div id="control_panel">
                <button id="adminknapp">Tillbaka till administrationssidan</button>
            </div>
            <%    
                } //username.lenght > 4, admin view
            %>
                
            <div style="clear: both" ></div>
        </div>     
    </body>
</html>
