<%@page import="se.miun.dt142g.dhtmlx.PublishManager"%>
<%@page contentType="application/json" %>
<%= getEvents(request) %>
<%@page import="com.dhtmlx.planner.*,se.miun.dt142g.dhtmlx.*" %>
<%!
    String getEvents(HttpServletRequest request) throws Exception{
        PublishManager evs = new PublishManager(request); //make new argument for filtering events?
        return evs.run();
    }
    
%>